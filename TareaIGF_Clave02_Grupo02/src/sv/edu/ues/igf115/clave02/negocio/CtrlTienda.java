package sv.edu.ues.igf115.clave02.negocio;

import java.util.List;

import sv.edu.ues.igf115.clave02.dao.tiendaDAO;
import sv.edu.ues.igf115.clave02.dominio.Tienda;

public class CtrlTienda {
	tiendaDAO daoTienda = new tiendaDAO();
	boolean retonar=false;
	public boolean guardar(Integer id,String nombre,String ciudad){
		if(daoTienda.daTiendaByCriteria(id)==null){
		Tienda ti = new Tienda(nombre,ciudad);
		daoTienda.guardaActualiza(ti);
		return true;
		}else
		
		return false;
			}
	public List<Tienda> mostrarTiendas(){
		return daoTienda.daTiendas();
		
	}
}
