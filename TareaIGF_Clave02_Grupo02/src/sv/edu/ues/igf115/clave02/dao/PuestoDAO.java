package sv.edu.ues.igf115.clave02.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import sv.edu.ues.igf115.clave02.datos.HibernateUtil;
import sv.edu.ues.igf115.clave02.dominio.Puesto;


public class PuestoDAO {
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
	

	public void guardaActualiza(Puesto puesto){
		try {
			iniciaOperacion();
			sesion.save(puesto);
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
	
	public void actualiza(Puesto puesto){
		try {
			iniciaOperacion();
			sesion.update(puesto);
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

	public void eliminar(Puesto Puesto){
		try {
			iniciaOperacion();
			sesion.delete(Puesto);
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

	public Puesto daPuestoById(Short id_Puesto){
		sesion = sessionfactory.openSession();
		Criteria criteria=sesion.createCriteria(Puesto.class)
							.add(Restrictions.idEq(id_Puesto));
		Puesto id =(Puesto)criteria.uniqueResult();
		sesion.close();
		return id;
	}

	public List<Puesto> daPuestos(){
		sesion = sessionfactory.openSession();
		Criteria criteria = sesion.createCriteria(Puesto.class);
		List<Puesto> puestos = criteria.list();
		sesion.close();
		return puestos;
	}

	
	
	
}
