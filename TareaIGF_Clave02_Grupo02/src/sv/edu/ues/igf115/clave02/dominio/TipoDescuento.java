package sv.edu.ues.igf115.clave02.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "tiposdescuentos",catalog = "clave2",schema = "")
public class TipoDescuento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_tiposdescuentos")
	@Basic(optional=false)
	private String id;
	@Column(name="descripcion")
	@Basic(optional = false)
	private String descripcion;
	@Column(name = "porcentaje_descuento")
	@Basic(optional = false)
	private BigDecimal porcentaje_Desc;
	@Column(name = "fecha_ingreso")
	@Basic(optional = false)
	private Date fecha_ing;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	/**
	 * @return the porcentaje_Desc
	 */
	public BigDecimal getPorcentaje_Desc() {
		return porcentaje_Desc;
	}
	/**
	 * @param porcentaje_Desc the porcentaje_Desc to set
	 */
	public void setPorcentaje_Desc(BigDecimal porcentaje_Desc) {
		this.porcentaje_Desc = porcentaje_Desc;
	}
	/**
	 * @return the fecha_ing
	 */
	public Date getFecha_ing() {
		return fecha_ing;
	}
	/**
	 * @param fecha_ing the fecha_ing to set
	 */
	public void setFecha_ing(Date fecha_ing) {
		this.fecha_ing = fecha_ing;
	}
	

}
