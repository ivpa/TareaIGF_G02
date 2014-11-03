package sv.edu.ues.igf115.clave02.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "boletapago",catalog = "clave2",schema = "")
public class BoletaPago implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_boletapago")
	@Basic(optional = false)
	private Short id;
	@Column(name = "periodo_pago")
	@Basic(optional = false)
	private String periodoPago;
	@Column(name = "sueldo_neto")
	@Basic(optional = false)
	private BigDecimal sueldoNeto;
	@Column(name = "id_empleado")
	@Basic(optional = false)
	private Empleado idEmpleado;
	
	
	private List<Empleado> empList;


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
	 * @return the periodoPago
	 */
	public String getPeriodoPago() {
		return periodoPago;
	}


	/**
	 * @param periodoPago the periodoPago to set
	 */
	public void setPeriodoPago(String periodoPago) {
		this.periodoPago = periodoPago;
	}


	/**
	 * @return the sueldoNeto
	 */
	public BigDecimal getSueldoNeto() {
		return sueldoNeto;
	}


	/**
	 * @param sueldoNeto the sueldoNeto to set
	 */
	public void setSueldoNeto(BigDecimal sueldoNeto) {
		this.sueldoNeto = sueldoNeto;
	}


	/**
	 * @return the idEmpleado
	 */
	public Empleado getIdEmpleado() {
		return idEmpleado;
	}


	/**
	 * @param idEmpleado the idEmpleado to set
	 */
	public void setIdEmpleado(Empleado idEmpleado) {
		this.idEmpleado = idEmpleado;
	}
	
	

}
