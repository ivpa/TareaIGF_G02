package sv.edu.ues.igf115.clave02.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import sv.edu.ues.igf115.clave02.datos.HibernateUtil;
import sv.edu.ues.igf115.clave02.dominio.Empleado;

public class EmpleadoDAO {
	
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
	
	
	public void guardaActualiza(Empleado empleado){
		try {
			iniciaOperacion();
			sesion.save(empleado);
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
	
	public void actualiza(Empleado empleado){
		try {
			iniciaOperacion();
			sesion.update(empleado);
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

	public void eliminar(Empleado empleado){
		try {
			iniciaOperacion();
			sesion.delete(empleado);
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

	public Empleado daEmpleadoById(String id_empleado){
		sesion = sessionfactory.openSession();
		Criteria criteria=sesion.createCriteria(Empleado.class)
							.add(Restrictions.idEq(id_empleado));
		Empleado id =(Empleado)criteria.uniqueResult();
		sesion.close();
		return id;
	}

	public List<Empleado> daEmpleados(){
		sesion = sessionfactory.openSession();
		Criteria criteria = sesion.createCriteria(Empleado.class);
		List<Empleado> empleados = criteria.list();
		sesion.close();
		return empleados;
	}
	

}


