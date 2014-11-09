package sv.edu.ues.igf115.clave02.dao; 


import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import sv.edu.ues.igf115.clave02.datos.HibernateUtil;
import sv.edu.ues.igf115.clave02.dominio.Municipio;





public class MunicipioDAO {
private HibernateUtil hibernateUtil = new HibernateUtil();
private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
private Transaction tx;
private Session sesion;
private DepartamentoDAO deptoDAO= new DepartamentoDAO();
private void iniciarOperacion() throws HibernateException {
	sesion = sessionFactory.openSession();
	tx = sesion.beginTransaction();
	
}

private void manejaExcepcion(HibernateException he) throws
HibernateException {
	tx.rollback();
	throw new HibernateException("Ocurrio un error en la capa DAO",he);
}

public void guardaActualiza(Municipio municipio){
	try {
		iniciarOperacion();
		sesion.saveOrUpdate(municipio);
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

public void eliminar(Municipio municipio){
	try {
		iniciarOperacion();
		sesion.delete(municipio);
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

public List daMunicipios(){
	sesion = sessionFactory.openSession();
	Criteria criteria = sesion.createCriteria(Municipio.class)
						;
	List municipios = criteria.list();
	sesion.close();
	return municipios;
}

public List daMunicipiosByDepto(short idDepto){
	sesion = sessionFactory.openSession();
	String condicion = "select e from Municipio e join fetch" +
			" e.departamento d where d.idDep = :id_depto";
	Query query = sesion.createQuery(condicion);
	query.setParameter("id_depto", idDepto);
	List listado = query.list();
	sesion.close();
	return listado;
}

public Municipio daMunicipioById(short idMun){
	sesion = sessionFactory.openSession();
	Criteria criteria = sesion.createCriteria(Municipio.class)
						.add(Restrictions.idEq(idMun));
	
	sesion.close();
	return (Municipio)criteria.uniqueResult();
}


public Municipio daMunicipioByNombre(String nombreMun){
	sesion = sessionFactory.openSession();
	Criteria criteria = sesion.createCriteria(Municipio.class)
			.add(Restrictions.eq("nombreMun", nombreMun));
	Municipio mun = (Municipio)criteria.uniqueResult();
	sesion.close();
	return mun;
}


public boolean daMunicipioByIdDep(Short id) {
	
	boolean flag=false;
	if (deptoDAO.daDepartamentoById(id)!=null) {
		flag = true;
	}
	return  flag;
}
}
