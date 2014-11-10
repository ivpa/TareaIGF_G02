package sv.edu.ues.igf115.clave02.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="puesto",catalog="clave2",schema="")
public class Puesto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_puesto")
	@Basic(optional=false)
	private Short id;
	@Column(name="nombre_puesto")
	@Basic(optional=false)
	private String nombrePuesto;
	@Column(name="perfil_puesto")
	@Basic(optional=false)
	private String perfilPuesto;
	@Column(name="fecha_ing")
	@Basic(optional=false)
	private Date fechaIng;
	@Column(name="sueldo_min")
	@Basic(optional=false)
	private BigDecimal sueldoMin;
	@Column(name="sueldo_max")
	@Basic(optional=false)
	private BigDecimal sueldoMax;
	@OneToMany(cascade=CascadeType.ALL,mappedBy="id_puesto")
	private List<Empleado> empleadoList;
	
	
	//Constructor que usara Hibertante
	private Puesto(){}
	
	public Puesto(Short id,String nombrePuesto,String perfilPuesto,Date fechaIng,
			BigDecimal sueldoMin,BigDecimal sueldoMax){
		this.id= id;
		this.nombrePuesto = nombrePuesto;
		this.perfilPuesto = perfilPuesto;
		this.fechaIng = fechaIng;
		this.sueldoMin = sueldoMin;
		this.sueldoMax = sueldoMax;
	}

	/**
	 * @return the id
	 */
	public Short getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Short id) {
		this.id = id;
	}

	/**
	 * @return the nombrePuesto
	 */
	public String getNombrePuesto() {
		return nombrePuesto;
	}

	/**
	 * @param nombrePuesto the nombrePuesto to set
	 */
	public void setNombrePuesto(String nombrePuesto) {
		this.nombrePuesto = nombrePuesto;
	}

	/**
	 * @return the perfilPuesto
	 */
	public String getPerfilPuesto() {
		return perfilPuesto;
	}

	/**
	 * @param perfilPuesto the perfilPuesto to set
	 */
	public void setPerfilPuesto(String perfilPuesto) {
		this.perfilPuesto = perfilPuesto;
	}

	/**
	 * @return the fechaIng
	 */
	public Date getFechaIng() {
		return fechaIng;
	}

	/**
	 * @param fechaIng the fechaIng to set
	 */
	public void setFechaIng(Date fechaIng) {
		this.fechaIng = fechaIng;
	}

	/**
	 * @return the sueldoMin
	 */
	public BigDecimal getSueldoMin() {
		return sueldoMin;
	}

	/**
	 * @param sueldoMin the sueldoMin to set
	 */
	public void setSueldoMin(BigDecimal sueldoMin) {
		this.sueldoMin = sueldoMin;
	}

	/**
	 * @return the sueldoMax
	 */
	public BigDecimal getSueldoMax() {
		return sueldoMax;
	}

	/**
	 * @param sueldoMax the sueldoMax to set
	 */
	public void setSueldoMax(BigDecimal sueldoMax) {
		this.sueldoMax = sueldoMax;
	}

//	public List<Empleado> getEmpleadoList() {
//		return empleadoList;
//	}
//
//	public void setEmpleadoList(List<Empleado> empleadoList) {
//		this.empleadoList = empleadoList;
//	}

}
