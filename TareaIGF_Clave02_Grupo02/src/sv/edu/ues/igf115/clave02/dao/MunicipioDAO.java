package sv.edu.ues.igf115.clave02.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import sv.edu.ues.igf115.clave02.datos.HibernateUtil;
import sv.edu.ues.igf115.clave02.dominio.Municipio;

public class MunicipioDAO {


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


public void guardaActualiza(Municipio Municipio){
	try {
		iniciaOperacion();
		sesion.saveOrUpdate(Municipio);
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

public void eliminar(Municipio Municipio){
	try {
		iniciaOperacion();
		sesion.delete(Municipio);
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

public Municipio daMunicipioById(Integer id){
	sesion = sessionfactory.openSession();
	Criteria criteria=sesion.createCriteria(Municipio.class)
						.add(Restrictions.idEq(id));
	Municipio idMun =(Municipio)criteria.uniqueResult();
	sesion.close();
	return idMun;
}

public List<Municipio> daMunicipios(){
	sesion = sessionfactory.openSession();
	Criteria criteria = sesion.createCriteria(Municipio.class);
	List<Municipio> Municipios = criteria.list();
	sesion.close();
	return Municipios;
}

public void actualiza(Municipio Municipio){
	try {
		iniciaOperacion();
		sesion.update(Municipio);
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
}
