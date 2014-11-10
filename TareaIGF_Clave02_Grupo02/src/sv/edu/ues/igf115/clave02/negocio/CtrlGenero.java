package sv.edu.ues.igf115.clave02.negocio;

import java.util.List;

import sv.edu.ues.igf115.clave02.dao.GeneroDAO;
import sv.edu.ues.igf115.clave02.dominio.Genero;

public class CtrlGenero {
private GeneroDAO daoGenero = new GeneroDAO();
	
	public boolean crearGenero(Genero Genero){
		
		if(daoGenero.daGeneroById(Genero.getId())==null){
			daoGenero.guardaActualiza(Genero);
			return true;
		}
		else{
			return false;
		}
	}
	
	public List<Genero> listaGeneros(){
		return daoGenero.daGeneros();
	}
	public Genero daGeneroById(String id){
		return daoGenero.daGeneroById(id);
	}
	
public boolean actualizaGenero(Genero Genero){
		
			if(daoGenero.daGeneroById(Genero.getId())!=null){
			daoGenero.guardaActualiza(Genero);
			return true;
			}else
				return false;
		
		
	}
public boolean eliminarGenero(String id){
	
	if (daoGenero.daGeneroById(id)!=null) {
		daoGenero.eliminar(daoGenero.daGeneroById(id));
		return true;
	}
	else
		return false;
}
}
