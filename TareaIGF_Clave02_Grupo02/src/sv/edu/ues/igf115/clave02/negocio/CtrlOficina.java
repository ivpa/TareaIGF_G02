package sv.edu.ues.igf115.clave02.negocio;

import java.util.List;

import sv.edu.ues.igf115.clave02.dao.OficinaDAO;

import sv.edu.ues.igf115.clave02.dominio.Oficina;



public class CtrlOficina {
private OficinaDAO daoOficina = new OficinaDAO();

public CtrlOficina()
{}
	
	public boolean crearOficina(Oficina oficina){
		
		if(daoOficina.daOficinaById(oficina.getId_Oficina())==null){
			
			
			daoOficina.guardaActualiza(oficina);
			return true;
		}
		else{
			return false;
		}
	}
	public List<Oficina> listaOficina(){
		return daoOficina.daOficina();
	}
	public Oficina daOficinaById_Oficina(String id_oficina){
		return daoOficina.daOficinaById(id_oficina);
	}
	public boolean actualizaOficina(Oficina oficina){
		
		if(daoOficina.daOficinaById(oficina.getId_Oficina())!=null){
			daoOficina.guardaActualiza(oficina);
		return true;
		}else
			return false;
}
public boolean eliminarOficina(String id_oficina){

if (daoOficina.daOficinaById(id_oficina)!=null) {
	daoOficina.eliminar(daoOficina.daOficinaById(id_oficina));
	return true;
}
else
	return false;
}

}
