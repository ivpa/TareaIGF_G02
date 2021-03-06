package sv.edu.ues.igf115.clave02.negocio;

import java.util.List;

import sv.edu.ues.igf115.clave02.dao.EmpleadoDAO;
import sv.edu.ues.igf115.clave02.dao.PuestoDAO;
import sv.edu.ues.igf115.clave02.dominio.Puesto;
import java.lang.*;
public class CtrlPuesto {

	private PuestoDAO daoPuesto = new PuestoDAO();
	
	public boolean crearPuesto(Puesto puesto){
		
		if(daoPuesto.daPuestoById(puesto.getId())==null){
			daoPuesto.guardaActualiza(puesto);
			return true;
		}
		else{
			return false;
		}
	}
	
	public List<Puesto> listaPuestos(){
		return daoPuesto.daPuestos();
	}
	public Puesto daPuestoById(Short id){
		return daoPuesto.daPuestoById(id);
	}
	
public boolean actualizaPuesto(Puesto puesto){
		
			if(daoPuesto.daPuestoById(puesto.getId())!=null){
			daoPuesto.guardaActualiza(puesto);
			return true;
			}else
				return false;
		
		
	}
public boolean eliminarPuesto(Short id){
	boolean retornar = false;
	if (daoPuesto.daPuestoById(id)!=null) {
		if(new EmpleadoDAO().daEmpleadoByPuesto(daoPuesto.daPuestoById(id))==0){
		daoPuesto.eliminar(daoPuesto.daPuestoById(id));
		retornar = true;}
		return retornar;
	}
	else
		return false;
}

}
