package sv.edu.ues.igf115.clave02.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import sv.edu.ues.igf115.clave02.datos.HibernateUtil;
import sv.edu.ues.igf115.clave02.dominio.BoletaPagoDescuento;

public class BoletaPagoDescuentoDAO {


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


public void guardaActualiza(BoletaPagoDescuento boletaPagoDescuento){
	try {
		iniciaOperacion();
		sesion.saveOrUpdate(boletaPagoDescuento);
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

public void eliminar(BoletaPagoDescuento boletaPagoDescuento){
	try {
		iniciaOperacion();
		sesion.delete(boletaPagoDescuento);
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

public BoletaPagoDescuento daBoletaPagoDescuentoById(Integer idDep){
	sesion = sessionfactory.openSession();
	Criteria criteria=sesion.createCriteria(BoletaPagoDescuento.class)
						.add(Restrictions.idEq(idDep));
	BoletaPagoDescuento id =(BoletaPagoDescuento)criteria.uniqueResult();
	//BoletaPagoDescuento id = (BoletaPagoDescuento) sesion.get(BoletaPagoDescuento.class, new Short(idDep));
	sesion.close();
	return id;
}

public List<BoletaPagoDescuento> daBoletaPagoDescuentos(){
	sesion = sessionfactory.openSession();
//	Query query = sesion.getNamedQuery("BoletaPagoDescuentos.findAll");
//	List<BoletaPagoDescuento> BoletaPagoDescuentos = query.list();
	Criteria criteria = sesion.createCriteria(BoletaPagoDescuento.class);
	List<BoletaPagoDescuento> boletaPagoDescuentos = criteria.list();
	sesion.close();
	return boletaPagoDescuentos;
}
}
