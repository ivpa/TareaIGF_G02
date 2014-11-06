package sv.edu.ues.igf115.clave02.negocio;

import java.util.List;

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
	

	public List<BoletaPago> listaBoletaPagos(){
		return daoBoletaPago.daBoletaPagos();
	}
	public BoletaPago daBoletaPagoById(Short id){
		return daoBoletaPago.daBoletaPagoById(id);
	}
	
public boolean actualizaBoletaPago(BoletaPago boletaPago){
		
			if(daoBoletaPago.daBoletaPagoById(boletaPago.getId())!=null){
			daoBoletaPago.guardaActualiza(boletaPago);
			return true;
			}else
				return false;
		
		
	}
public boolean eliminarBoletaPago(Short id){
	
	if (daoBoletaPago.daBoletaPagoById(id)!=null) {
		
		daoBoletaPago.eliminar(daoBoletaPago.daBoletaPagoById(id));
		return true;
	}
	else
		return false;
}

	}

