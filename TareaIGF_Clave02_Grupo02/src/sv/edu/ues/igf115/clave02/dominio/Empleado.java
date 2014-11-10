package sv.edu.ues.igf115.clave02.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "empleado",catalog = "clave2",schema = "")

public class Empleado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_empleado")
	@Basic(optional = false)
	private String id;
	
	@Column(name = "nit")
	@Basic(optional = false)
	private String nit;
	
	@Column(name = "dui")
	@Basic(optional = false)
	private String dui;
	
	@Column(name = "nombres")
	@Basic(optional = false)
	private String nombres;
	
	@Column(name = "apellido_paterno")
	@Basic(optional = false)
	private String apellido_paterno;
	
	@Column(name = "apellido_materno")
	@Basic(optional = false)
	private String apellido_materno;
	
	//importe java.util para Date
	@Column(name = "fecha_nacimiento")
	@Basic(optional = false)
	private String fecha_nacimiento;
	
	@Column(name = "fecha_ingreso")
	@Basic(optional = false)
	private String fecha_ingreso;
	
	@Column(name = "sueldo")
	@Basic(optional = false)
	private BigDecimal sueldo;
	
	@Column(name = "e_mail")
	@Basic(optional = false)
	private String e_mail;
	
	@Column(name = "telefono")
	@Basic(optional = false)
	private String telefono;
	
	@Column(name = "activo")
	@Basic(optional = false)
	private String activo;
	
	@Column(name = "id_puesto")
	@Basic(optional = false)
	private Short id_puesto;
	
	@Column(name = "id_genero")
	@Basic(optional = false)
	private String id_genero;
	
	@Column(name = "id_oficina")
	@Basic(optional = false)
	private String id_oficina;
	
	@Column(name = "id_jefe")
	@Basic(optional = true)
	private String id_jefe;

	
	private Empleado()
	{
		//ocupado por hibernate
	}
	
	

	public Empleado(String id, String nit, String dui, String nombres,
			String apellido_paterno, String apellido_materno,
			String fecha_nacimiento, String fecha_ingreso, BigDecimal sueldo,
			String e_mail, String telefono, String activo, Short id_puesto,
			String id_genero, String id_oficina, String id_jefe) {
		
		this.id = id;
		this.nit = nit;
		this.dui = dui;
		this.nombres = nombres;
		this.apellido_paterno = apellido_paterno;
		this.apellido_materno = apellido_materno;
		this.fecha_nacimiento = fecha_nacimiento;
		this.fecha_ingreso = fecha_ingreso;
		this.sueldo = sueldo;
		this.e_mail = e_mail;
		this.telefono = telefono;
		this.activo = activo;
		this.id_puesto = id_puesto;
		this.id_genero = id_genero;
		this.id_oficina = id_oficina;
		this.id_jefe = id_jefe;
		
		//this.id = "5";
		//this.nit = "1";
		//this.dui = "1";
		//this.nombres = "1";
		//this.apellido_paterno = "1";
		//this.apellido_materno = "1";
		//this.fecha_nacimiento = "2014-01-01";
		//this.fecha_ingreso = "2014-01-01";
		//this.sueldo = new BigDecimal("1");
		//this.e_mail = "1";
		//this.telefono = "1";
		//this.activo = "1";
		//this.id_puesto = new Short("1");
		//this.id_genero = "1";
		//this.id_oficina = "1";
		//this.id_jefe = null;
	}



	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getDui() {
		return dui;
	}

	public void setDui(String dui) {
		this.dui = dui;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellido_paterno() {
		return apellido_paterno;
	}

	public void setApellido_paterno(String apellido_paterno) {
		this.apellido_paterno = apellido_paterno;
	}

	public String getApellido_materno() {
		return apellido_materno;
	}

	public void setApellido_materno(String apellido_materno) {
		this.apellido_materno = apellido_materno;
	}

	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public BigDecimal getSueldo() {
		return sueldo;
	}

	public void setSueldo(BigDecimal sueldo) {
		this.sueldo = sueldo;
	}

	public String getE_mail() {
		return e_mail;
	}

	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public Short getId_puesto() {
		return id_puesto;
	}

	public void setId_puesto(Short id_puesto) {
		this.id_puesto = id_puesto;
	}

	public String getId_genero() {
		return id_genero;
	}

	public void setId_genero(String id_genero) {
		this.id_genero = id_genero;
	}

	public String getId_oficina() {
		return id_oficina;
	}

	public void setId_oficina(String id_oficina) {
		this.id_oficina = id_oficina;
	}
	
	public String getId_jefe() {
		return id_jefe;
	}

	public void setId_jefe(String id_jefe) {
		this.id_jefe = id_jefe;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	
	
	
	
}
