package sv.edu.ues.igf115.clave02.negocio;


import java.util.List;

import sv.edu.ues.igf115.clave02.dao.MunicipioDAO;
import sv.edu.ues.igf115.clave02.dominio.Municipio;



public class CtrlMunicipio {
MunicipioDAO daoMunicipio = new MunicipioDAO();
	
	public boolean crearMunicipio(Municipio Municipio){
		if (daoMunicipio.daMunicipioById(Municipio.getId())==null) {
			
			daoMunicipio.guardaActualiza(Municipio);
			return true;
		}else 
			return false;
		
	}
	
	public List<Municipio> listaMunicipios(){
		return daoMunicipio.daMunicipios();
	}
	public Municipio daMunicipioById(Integer id){
		return daoMunicipio.daMunicipioById(id);
	}
	
public boolean actualizaMunicipio(Municipio Municipio){
		
			if(daoMunicipio.daMunicipioById(Municipio.getId())!=null){
			daoMunicipio.actualiza(Municipio);
			return true;
			}else
				return false;
		
		
	}
public boolean eliminarMunicipio(Integer id){
	
	if (daoMunicipio.daMunicipioById(id)!=null) {
		daoMunicipio.eliminar(daoMunicipio.daMunicipioById(id));
		return true;
	}
	else
		return false;
}
}
