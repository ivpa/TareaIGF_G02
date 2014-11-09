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

public void guardaActualiza(Departamento departamento){
	try {
		iniciaOperacion();
		sesion.saveOrUpdate(departamento);
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


public void eliminar(Departamento departamento){
	try {
		iniciaOperacion();
		sesion.delete(departamento);
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

public Departamento daDepartamentoById(Short idDep){
	sesion = sessionfactory.openSession();
	Criteria criteria=sesion.createCriteria(Departamento.class)
						.add(Restrictions.idEq(idDep));
	Departamento id =(Departamento)criteria.uniqueResult();
	sesion.close();
	return id;
}

public List<Departamento> daDepartamentos(){
	sesion = sessionfactory.openSession();
	Criteria criteria = sesion.createCriteria(Departamento.class);
	List<Departamento> departamentos = criteria.list();
	sesion.close();
	return departamentos;
}

public Departamento daDepartamentoByNombre(String nombre){
	sesion = sessionfactory.openSession();
	Criteria criteria = sesion.createCriteria(Departamento.class)
			.add(Restrictions.eqProperty("nombreDep", nombre));
	Departamento depto = (Departamento)criteria.uniqueResult();
	sesion.close();
	return depto;
}
}
