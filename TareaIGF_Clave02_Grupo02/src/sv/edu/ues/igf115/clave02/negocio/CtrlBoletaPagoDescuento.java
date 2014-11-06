package sv.edu.ues.igf115.clave02.negocio;


import java.util.List;

import sv.edu.ues.igf115.clave02.dao.BoletaPagoDescuentoDAO;
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
	
	public List<BoletaPagoDescuento> listaBoletaPagoDescuentos(){
		return daoBoletaPagoDescuento.daBoletaPagoDescuentos();
	}
	public BoletaPagoDescuento daBoletaPagoDescuentoById(Integer id){
		return daoBoletaPagoDescuento.daBoletaPagoDescuentoById(id);
	}
	
public boolean actualizaBoletaPagoDescuento(BoletaPagoDescuento BoletaPagoDescuento){
		
			if(daoBoletaPagoDescuento.daBoletaPagoDescuentoById(BoletaPagoDescuento.getId())!=null){
			daoBoletaPagoDescuento.actualiza(BoletaPagoDescuento);
			return true;
			}else
				return false;
		
		
	}
public boolean eliminarBoletaPagoDescuento(Integer id){
	
	if (daoBoletaPagoDescuento.daBoletaPagoDescuentoById(id)!=null) {
		daoBoletaPagoDescuento.eliminar(daoBoletaPagoDescuento.daBoletaPagoDescuentoById(id));
		return true;
	}
	else
		return false;
}
}
