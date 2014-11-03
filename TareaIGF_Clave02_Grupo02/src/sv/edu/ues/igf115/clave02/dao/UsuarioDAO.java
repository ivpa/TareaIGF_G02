package sv.edu.ues.igf115.clave02.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sv.edu.ues.igf115.clave02.dominio.Usuario;
import sv.edu.ues.igf115.clave02.negocio.CtrlUsuario;

@Repository
public class UsuarioDAO implements CtrlUsuario{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public Usuario findByUsuario(String idusuario) {
		// TODO Auto-generated method stub
		
		List<Usuario> users = new ArrayList<Usuario>();
		
		users =  sessionFactory.getCurrentSession()
				.createQuery("from Usuario where idusuario=?")
				.setParameter(0, idusuario)
				.list();
		
		if (users.size() > 0) {
			return users.get(0);
			
		}else
			return null;
	}

}
