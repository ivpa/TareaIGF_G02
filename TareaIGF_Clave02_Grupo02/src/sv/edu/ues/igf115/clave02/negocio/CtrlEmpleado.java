package sv.edu.ues.igf115.clave02.negocio;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;

import sv.edu.ues.igf115.clave02.dao.EmpleadoDAO;
import sv.edu.ues.igf115.clave02.dominio.Empleado;

public class CtrlEmpleado {
	
private EmpleadoDAO daoEmpleado = new EmpleadoDAO();
	

/*String id, String nit, String dui, String nombres, String apellido_paterno, String apellido_materno, Date fecha_nacimiento, Date fecha_ingreso, BigDecimal sueldo, String e_mail, String telefono, String activo, Short id_puesto, String id_genero, String id_oficina*/

	public boolean crearEmpleado(String id, String nit, String dui, String nombres, String apellido_paterno, String apellido_materno, Date fecha_nacimiento, Date fecha_ingreso, BigDecimal sueldo, String e_mail, String telefono, String activo, Short id_puesto, String id_genero, String id_oficina) {
		if (daoEmpleado.daEmpleadoById(id) == null) {
			Empleado empleado = new Empleado(id, nit, dui, nombres, apellido_paterno, apellido_materno, fecha_nacimiento, fecha_ingreso, sueldo, e_mail, telefono, activo, id_puesto, id_genero, id_oficina);
			daoEmpleado.guardaActualiza(empleado);
			return true; //es nuevo
		} else
			return false; // es antiguo	
	}

	public boolean eliminarEmpleado(String id)
	{
		boolean retornar = false;
		if (daoEmpleado.daEmpleadoById(id) != null) {
			Empleado empleado = daoEmpleado.daEmpleadoById(id);
			if(daoEmpleado.daEmpleadoById(id) == null ){
			
			daoEmpleado.eliminar(empleado);
			retornar = true;}
		}else 
			retornar = false;
	return retornar;	
	}

	public boolean modificarCatMunicipio(String id, String nit, String dui, String nombres, String apellido_paterno, String apellido_materno, Date fecha_nacimiento, Date fecha_ingreso, BigDecimal sueldo, String e_mail, String telefono, String activo, Short id_puesto, String id_genero, String id_oficina){
		if (daoEmpleado.daEmpleadoById(id) != null) {
			Empleado empleado = daoEmpleado.daEmpleadoById(id);	
			
			empleado.setId(id);
			empleado.setNit(nit);
			empleado.setDui(dui);
			empleado.setNombres(nombres);
			empleado.setApellido_paterno(apellido_paterno);
			empleado.setApellido_materno(apellido_materno);
			empleado.setFecha_nacimiento(fecha_nacimiento);
			empleado.setFecha_ingreso(fecha_ingreso);
			empleado.setSueldo(sueldo);
			empleado.setE_mail(e_mail);
			empleado.setTelefono(telefono);
			empleado.setActivo(activo);
			empleado.setId_puesto(id_puesto);
			empleado.setId_genero(id_genero);
			empleado.setId_oficina(id_oficina);
			
			daoEmpleado.guardaActualiza(empleado);
			return true;
		}else
			return false;
	}

	public List<Empleado> daCatMunicipio(){
		return daoEmpleado.daEmpleados();
	}

	public Empleado daEmpleadoById(String id){
		return daoEmpleado.daEmpleadoById(id);
	}

}
