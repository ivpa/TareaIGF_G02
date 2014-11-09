package sv.edu.ues.igf115.clave02.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import sv.edu.ues.igf115.clave02.datos.HibernateUtil;
import sv.edu.ues.igf115.clave02.dominio.Departamento;

public class DepartamentoDAO {

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


public void guardaActualiza(Departamento Departamento){
	try {
		iniciaOperacion();
		sesion.saveOrUpdate(Departamento);
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

public void eliminar(Departamento Departamento){
	try {
		iniciaOperacion();
		sesion.delete(Departamento);
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

public Departamento daDepartamentoById(Short id){
	sesion = sessionfactory.openSession();
	Criteria criteria=sesion.createCriteria(Departamento.class)
						.add(Restrictions.idEq(id));
	Departamento idDep =(Departamento)criteria.uniqueResult();
	sesion.close();
	return idDep;
}

public List<Departamento> daDepartamentos(){
	sesion = sessionfactory.openSession();
	Criteria criteria = sesion.createCriteria(Departamento.class);
	List<Departamento> departamentos = criteria.list();
	sesion.close();
	return departamentos;
}
}
