package sv.edu.ues.igf115.clave02.dominio;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "tiposdescuentos",catalog = "clave2",schema = "")
public class TipoDescuento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	
	@Column(name="id_tipodescuentos")
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoDescuento")
	private List<BoletaPagoDescuento> listBoletaPagoDescuento;
	private TipoDescuento(){}
	/**
	 * @return the id
	 */
	public TipoDescuento(String id, String descripcion,
			BigDecimal porcentaje_Desc, Date fecha_ing) {
		this.id = id;
		this.descripcion = descripcion;
		this.porcentaje_Desc = porcentaje_Desc;
		this.fecha_ing = fecha_ing;
		
	}
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
	public List<BoletaPagoDescuento> getListBoletaPagoDescuento() {
		return listBoletaPagoDescuento;
	}
	public void setListBoletaPagoDescuento(List<BoletaPagoDescuento> listBoletaPagoDescuento) {
		this.listBoletaPagoDescuento = listBoletaPagoDescuento;
	}
	

}
