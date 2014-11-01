package sv.edu.ues.igf115.clave02.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import sv.edu.ues.igf115.clave02.datos.HibernateUtil;
import sv.edu.ues.igf115.clave02.dominio.Tienda;



public class tiendaDAO {
	private HibernateUtil hibernateUtil = new HibernateUtil() ;
	private SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
	private Session sesion;
	private Transaction tx;
	
	private void iniciaOperacion() throws HibernateException {
		sesion = sessionFactory.openSession() ;
		tx = sesion.beginTransaction() ;
	}
	
	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Ocurrió un error en la capa DAO", he);
	}
	
	public void guardaActualiza(Tienda tienda) {
		try {
			iniciaOperacion() ;
			sesion.saveOrUpdate(tienda) ;
			tx.commit() ;
			sesion.flush() ;
		} catch (HibernateException he) {
			manejaExcepcion(he) ;
			throw he ;
		} finally {
			sesion.close() ;
		}
	}
	
	public Tienda daTiendaById(int ids){
		sesion = sessionFactory.openSession() ;
		// Retorna la instancia persistente de la clase por medio del atributo identidad
		Tienda id = (Tienda) sesion.get(Tienda.class, new Integer(ids));
		sesion.close() ;
		return id ;
	}
	
	public Tienda daTiendaByCriteria(int id){
		sesion = sessionFactory.openSession();
		Criteria cri = sesion.createCriteria(Tienda.class).add(Restrictions.idEq(new Integer(id)));
		Tienda ti =(Tienda) cri.uniqueResult();
		sesion.close();
		return ti;
	}
	
	public List<Tienda> daTiendas(){
		sesion = sessionFactory.openSession();
		Criteria cri = sesion.createCriteria(Tienda.class);
		List<Tienda> tiendas = cri.list();
		sesion.close();
		return tiendas;
	}
}
