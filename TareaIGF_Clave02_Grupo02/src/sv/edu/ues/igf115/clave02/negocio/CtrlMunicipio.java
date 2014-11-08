package sv.edu.ues.igf115.clave02.negocio;  

import java.util.List;

import sv.edu.ues.igf115.clave02.dao.MunicipioDAO;
import sv.edu.ues.igf115.clave02.dominio.Departamento;
import sv.edu.ues.igf115.clave02.dominio.Municipio;



public class CtrlMunicipio {
	private MunicipioDAO daoMun = new MunicipioDAO() ;
	public boolean crearMunicipio(String nombreMun, Departamento departamento) {
	if (daoMun.daMunicipioByNombre(nombreMun) == null ) {
	if (departamento != null) {
	Municipio municipio = new Municipio(nombreMun, departamento) ;
	daoMun.guardaActualiza(municipio) ;
	return true ;
	}
	else
	return false ;
	}
	else
	return false ;
	}
	
	public boolean borrarMunicipio(String nombreMun) {
	if (daoMun.daMunicipioByNombre(nombreMun) != null ) {
	Municipio municipio = daoMun.daMunicipioByNombre(nombreMun) ;
	daoMun.eliminar(municipio) ;
	return true ;
	}
	else
	return false ;
	}
	public List<Municipio> daMunicipios(){
	return daoMun.daMunicipios() ;
	}
	public List<?> daMunicipiosByDepto(short idDepto) {
	return daoMun.daMunicipiosByDepto(idDepto) ;
	}
	public Municipio daMunicipioById(short idMun){
	return daoMun.daMunicipioById(idMun) ;
	}
	
	
}
