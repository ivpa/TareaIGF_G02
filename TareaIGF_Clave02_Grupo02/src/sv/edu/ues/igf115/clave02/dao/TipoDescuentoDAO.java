package sv.edu.ues.igf115.clave02.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import sv.edu.ues.igf115.clave02.datos.HibernateUtil;
import sv.edu.ues.igf115.clave02.dominio.TipoDescuento;

public class TipoDescuentoDAO {
	

private HibernateUtil hibernateUtil = new HibernateUtil();
private SessionFactory sessionfactory = hibernateUtil.getSessionFactory();
private Session sesion;
private Transaction tx;

private void iniciaOperacion() throws HibernateException {
	sesion = sessionfactory.openSession();
	tx = sesion.beginTransaction();
}

private void manejaExcepcion(HibernateException he) throws
HibernateException{
	tx.rollback();
	throw new HibernateException("Ocurrio un error en la capa DAO",he);
}


public void guardaActualiza(TipoDescuento TipoDescuento){
	try {
		iniciaOperacion();
		sesion.saveOrUpdate(TipoDescuento);
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

public void eliminar(TipoDescuento tipoDescuento){
	try {
		iniciaOperacion();
		sesion.delete(tipoDescuento);
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

public TipoDescuento daTipoDescuentoById(String idDep){
	sesion = sessionfactory.openSession();
	Criteria criteria=sesion.createCriteria(TipoDescuento.class)
						.add(Restrictions.idEq(idDep));
	TipoDescuento id =(TipoDescuento)criteria.uniqueResult();
	//quite un comentario abajo
	//TipoDescuento id = (TipoDescuento) sesion.get(TipoDescuento.class, new Short(idDep));
	sesion.close();
	return id;
}

public List<TipoDescuento> daTipoDescuentos(){
	sesion = sessionfactory.openSession();
//	Query query = sesion.getNamedQuery("TipoDescuentos.findAll");
//	List<TipoDescuento> TipoDescuentos = query.list();
	Criteria criteria = sesion.createCriteria(TipoDescuento.class);
	List<TipoDescuento> tipoDescuentos = criteria.list();
	sesion.close();
	return tipoDescuentos;
}
}
