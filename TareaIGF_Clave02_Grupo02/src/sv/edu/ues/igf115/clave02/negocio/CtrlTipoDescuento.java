package sv.edu.ues.igf115.clave02.negocio;

import sv.edu.ues.igf115.clave02.dao.*;

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
	}
