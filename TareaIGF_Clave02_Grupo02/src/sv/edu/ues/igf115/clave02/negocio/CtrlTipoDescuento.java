
package sv.edu.ues.igf115.clave02.negocio;

import sv.edu.ues.igf115.clave02.dao.*;

import sv.edu.ues.igf115.clave02.dominio.Empleado;
import sv.edu.ues.igf115.clave02.dominio.TipoDescuento;



public class CtrlTipoDescuento {
	TipoDescuentoDAO daoTipoDescuento = new TipoDescuentoDAO();

	public boolean crearTipoDescuento(TipoDescuento tipodescuento){
		
		if (daoTipoDescuento.daTipoDescuentoById(tipodescuento.getId())== null)  {
			
			daoTipoDescuento.guardaActualiza(tipodescuento);
			return true;
		}else 
			return false;
		

}
	public boolean eliminarTipoDescuento(String id)
	{
		
       if (daoTipoDescuento.daTipoDescuentoById(id) != null) {
    	   TipoDescuento tipodescuento = daoTipoDescuento.daTipoDescuentoById(id);
		   daoTipoDescuento.eliminar(tipodescuento);
			return true; //borrar
		} else
			return false; // no existe
		
	}
	public TipoDescuento consultarTipoDescuento(String id){
		TipoDescuento aux = null;
		
		if(daoTipoDescuento.daTipoDescuentoById(id) != null){
			aux = daTipoDescuentoById(id);
		}
		
		return aux;
	}
	public TipoDescuento daTipoDescuentoById(String id){
		return daoTipoDescuento.daTipoDescuentoById(id);
	}
	
	public boolean actualizarTipoDescuento(TipoDescuento tipo){
		if (daoTipoDescuento.daTipoDescuentoById(tipo.getId())!=null) {
			
			daoTipoDescuento.guardaActualiza(tipo);
			return true;
		}else{return false;}
	}
	}
	