package sv.edu.ues.igf115.clave02.negocio;

import sv.edu.ues.igf115.clave02.dao.BoletaPagoDAO;
import sv.edu.ues.igf115.clave02.dominio.BoletaPago;

public class CtrlBoletaPago {

	BoletaPagoDAO daoBoletaPago = new BoletaPagoDAO();
	
	public boolean crearBoletaPago(BoletaPago boleta){
		if (daoBoletaPago.daBoletaPagoById(boleta.getId())== null) {
			
			daoBoletaPago.guardaActualiza(boleta);
			return true;
		}else 
			return false;
		
	}
	}

