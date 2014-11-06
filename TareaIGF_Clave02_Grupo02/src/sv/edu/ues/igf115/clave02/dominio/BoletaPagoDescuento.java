package sv.edu.ues.igf115.clave02.dominio;

import java.io.Serializable;
import java.math.BigDecimal;


import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "boletapagodescuento",catalog = "clave2",schema = "")
public class BoletaPagoDescuento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_boletapagodescuento")
	@Basic(optional = false)
	private Integer id;
	@Column(name = "monto_descuento")
	@Basic(optional = false)
	private BigDecimal montoDescuento;
	
	@ManyToOne
	@JoinColumn(name="id_tipodescuentos")//debe ser el nombre de la base
	
	private TipoDescuento tipoDescuento;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_boletapago")//debe ser el nombre de la base
	private BoletaPago boletaPago;
	
	
	private BoletaPagoDescuento(){}
	
	public BoletaPagoDescuento(Integer id,BigDecimal monto,BoletaPago bp,TipoDescuento tpd){
		this.id = id;
		this.boletaPago = bp;
		this.tipoDescuento = tpd;
		this.montoDescuento = monto;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BigDecimal getMontoDescuento() {
		return montoDescuento;
	}
	public void setMontoDescuento(BigDecimal montoDescuento) {
		this.montoDescuento = montoDescuento;
	}
	public TipoDescuento getTipoDescuento() {
		return tipoDescuento;
	}
	public void setTipoDescuento( TipoDescuento tipoDescuento) {
		this.tipoDescuento = tipoDescuento;
	}
	public BoletaPago getBoletaPago() {
		return boletaPago;
	}
	public void setBoletaPagoList(BoletaPago boletaPago) {
		this.boletaPago = boletaPago;
	}

}
