package sv.edu.ues.igf115.clave02.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import sv.edu.ues.igf115.clave02.datos.HibernateUtil;
import sv.edu.ues.igf115.clave02.dominio.BoletaPago;


public class BoletaPagoDAO {

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


public void guardaActualiza(BoletaPago BoletaPago){
	try {
		iniciaOperacion();
		sesion.saveOrUpdate(BoletaPago);
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

public void eliminar(BoletaPago boletaPago){
	try {
		iniciaOperacion();
		sesion.delete(boletaPago);
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

public BoletaPago daBoletaPagoById(Short idDep){
	sesion = sessionfactory.openSession();
	Criteria criteria=sesion.createCriteria(BoletaPago.class)
						.add(Restrictions.idEq(idDep));
	BoletaPago id =(BoletaPago)criteria.uniqueResult();
	//BoletaPago id = (BoletaPago) sesion.get(BoletaPago.class, new Short(idDep));
	sesion.close();
	return id;
}

public List<BoletaPago> daBoletaPagos(){
	sesion = sessionfactory.openSession();
//	Query query = sesion.getNamedQuery("BoletaPagos.findAll");
//	List<BoletaPago> BoletaPagos = query.list();
	Criteria criteria = sesion.createCriteria(BoletaPago.class);
	List<BoletaPago> boletaPagos = criteria.list();
	sesion.close();
	return boletaPagos;
}
}
