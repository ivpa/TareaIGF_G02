package sv.edu.ues.igf115.clave02.negocio; 

import java.util.List;

import sv.edu.ues.igf115.clave02.dao.DepartamentoDAO;
import sv.edu.ues.igf115.clave02.dao.MunicipioDAO;
import sv.edu.ues.igf115.clave02.dominio.Departamento;





public class CtrlDepartamento {
private DepartamentoDAO daoDepto = new DepartamentoDAO();
private MunicipioDAO daoMun = new MunicipioDAO();

public boolean crearDepartamento(String nombreDepto, String zona) {
	if (daoDepto.daDepartamentoByNombre(nombreDepto) == null) {
		Departamento departamento = new Departamento(nombreDepto, zona);
		daoDepto.guardaActualiza(departamento);
		return true;
	} else
		return false;
}

public boolean eliminarDepartamento(Short id)
{
	boolean retornar = false;
	if (daoDepto.daDepartamentoById(id) != null) {
		Departamento departamento = daoDepto.daDepartamentoById(id);
		if(daoMun.daMunicipioByIdDep(id)==false ){
		
		daoDepto.eliminar(departamento);
		retornar = true;}
	}else 
		retornar = false;
return retornar;	
}

public boolean modificarDepartamento(String nombreDepto, String zona){
	if (daoDepto.daDepartamentoByNombre(nombreDepto) != null) {
		Departamento departamento = daoDepto.daDepartamentoByNombre(nombreDepto);
		departamento.setZona(zona);
		daoDepto.guardaActualiza(departamento);
		return true;
	}else
		return false;
}

public List<Departamento> daDepartamentos(){
	return daoDepto.daDepartamentos();
}

public Departamento daDepartamentoById(short idDepto){
	return daoDepto.daDepartamentoById(idDepto);
}

public Departamento daDepartamentoByNombre(String nombre){
	return daoDepto.daDepartamentoByNombre(nombre);
}
}
