package sv.edu.ues.igf115.clave02.negocio;



import sv.edu.ues.igf115.clave02.dao.PuestoDAO;
import sv.edu.ues.igf115.clave02.dominio.Puesto;


public class CtrlPuesto {
PuestoDAO daoPuesto = new PuestoDAO();

public boolean crearPuesto(Puesto puesto){
	
	if (daoPuesto.daPuestoById(puesto.getId())== null) {
		
		daoPuesto.guardaActualiza(puesto);
		return true;
	}else 
		return false;
	
}

}
