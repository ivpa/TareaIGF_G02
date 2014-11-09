package sv.edu.ues.igf115.clave02.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import sv.edu.ues.igf115.clave02.datos.HibernateUtil;
import sv.edu.ues.igf115.clave02.dominio.Oficina;


public class OficinaDAO {
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
	public OficinaDAO ()
	{}
	public void guardaActualiza(Oficina oficina){
		try {
			iniciaOperacion();
			sesion.saveOrUpdate(oficina);
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
	
	public void actualiza(Oficina oficina){
		try {
			iniciaOperacion();
			sesion.update(oficina);
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

	public void eliminar(Oficina oficina){
		try {
			iniciaOperacion();
			sesion.delete(oficina);
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

	public Oficina daOficinaById(int id_oficina){
		sesion = sessionfactory.openSession();
		Criteria criteria=sesion.createCriteria(Oficina.class)
							.add(Restrictions.idEq(id_oficina));
		Oficina id =(Oficina)criteria.uniqueResult();
		sesion.close();
		return id;
	}

	public List<Oficina> daOficina(){
		sesion = sessionfactory.openSession();
		Criteria criteria = sesion.createCriteria(Oficina.class);
		List<Oficina> oficina = criteria.list();
		sesion.close();
		return oficina;
	}


}
