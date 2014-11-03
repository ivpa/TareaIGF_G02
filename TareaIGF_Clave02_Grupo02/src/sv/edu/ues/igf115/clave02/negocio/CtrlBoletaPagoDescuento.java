package sv.edu.ues.igf115.clave02.negocio;


import sv.edu.ues.igf115.clave02.dao.BoletaPagoDescuentoDAO;
import sv.edu.ues.igf115.clave02.dominio.BoletaPago;
import sv.edu.ues.igf115.clave02.dominio.BoletaPagoDescuento;

public class CtrlBoletaPagoDescuento {
BoletaPagoDescuentoDAO daoBoletaPagoDescuento = new BoletaPagoDescuentoDAO();
	
	public boolean crearBoletaPagoDescuento(BoletaPagoDescuento boleta){
		//daoBoletaPagoDescuento.daBoletaPagoDescuentoById(boleta.getId())==null
		if (daoBoletaPagoDescuento.daBoletaPagoDescuentoById(boleta.getId())==null) {
			
			daoBoletaPagoDescuento.guardaActualiza(boleta);
			return true;
		}else 
			return false;
		
	}
}
