package sv.edu.ues.igf115.clave02.negocio;

import java.util.List;

import sv.edu.ues.igf115.clave02.dao.DepartamentoDAO;
import sv.edu.ues.igf115.clave02.dominio.Departamento;


public class CtrlDepartamento {

	DepartamentoDAO daoDepartamento = new DepartamentoDAO();
	
	public boolean crearDepartamento(Departamento Departamento){
		if (daoDepartamento.daDepartamentoById(Departamento.getId())== null) {
			
			daoDepartamento.guardaActualiza(Departamento);
			return true;
		}else 
			return false;
		
	}
	

	public List<Departamento> listaDepartamentos(){
		return daoDepartamento.daDepartamentos();
	}
	public Departamento daDepartamentoById(String id){
		return daoDepartamento.daDepartamentoById(id);
	}
	
public boolean actualizaDepartamento(Departamento Departamento){
		
			if(daoDepartamento.daDepartamentoById(Departamento.getId())!=null){
			daoDepartamento.guardaActualiza(Departamento);
			return true;
			}else
				return false;
		
		
	}
public boolean eliminarDepartamento(String id){
	
	if (daoDepartamento.daDepartamentoById(id)!=null) {
		
		daoDepartamento.eliminar(daoDepartamento.daDepartamentoById(id));
		return true;
	}
	else
		return false;
}

	}
