package sv.edu.ues.igf115.clave02.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import sv.edu.ues.igf115.clave02.datos.HibernateUtil;
import sv.edu.ues.igf115.clave02.dominio.Genero;


public class GeneroDAO {
	private HibernateUtil hibernateUtil = new HibernateUtil();
	private SessionFactory sessionfactory = hibernateUtil.getSessionFactory();
	private Session sesion;
	private Transaction tx;
	
	
	
	private void iniciaOperacion() throws HibernateException {
		sesion = sessionfactory.openSession();
		tx = sesion.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException{
		tx.rollback();
		throw new HibernateException("Ocurrio un error en la capa DAO",he);
	}
	

	public void guardaActualiza(Genero Genero){
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(Genero);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			// TODO: handle exception
			manejaExcepcion(he);
			throw he;
		}finally{
			sesion.close();
		}
	}
	
	public void actualiza(Genero Genero){
		try {
			iniciaOperacion();
			sesion.update(Genero);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			// TODO: handle exception
			manejaExcepcion(he);
			throw he;
		}finally{
			sesion.close();
		}
	}

	public void eliminar(Genero Genero){
		try {
			iniciaOperacion();
			sesion.delete(Genero);
			tx.commit();
			sesion.flush();
		} catch (HibernateException he) {
			// TODO: handle exception
			manejaExcepcion(he);
			throw he;
		}finally{
			sesion.close();
		}
	}

	public Genero daGeneroById(String id_Genero){
		sesion = sessionfactory.openSession();
		Criteria criteria=sesion.createCriteria(Genero.class)
							.add(Restrictions.idEq(id_Genero));
		Genero id =(Genero)criteria.uniqueResult();
		sesion.close();
		return id;
	}

	public List<Genero> daGeneros(){
		sesion = sessionfactory.openSession();
		Criteria criteria = sesion.createCriteria(Genero.class);
		List<Genero> Generos = criteria.list();
		sesion.close();
		return Generos;
	}

}
