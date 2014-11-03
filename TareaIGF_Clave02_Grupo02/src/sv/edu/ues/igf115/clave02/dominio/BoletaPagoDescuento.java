package sv.edu.ues.igf115.clave02.dominio;

import java.io.Serializable;
import java.math.BigDecimal;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name = "id_boletapagosdescuento")
	@Basic(optional = false)
	private int id;
	@Column(name = "monto_descuento")
	@Basic(optional = false)
	private BigDecimal montoDescuento;
	
	@JoinColumn(name="id",referencedColumnName="id_tiposdescuentos")
	@ManyToOne(optional = false)
	private TipoDescuento tipoDescuento;
	@JoinColumn(name="id",referencedColumnName="id_boletapago")
	@ManyToOne(optional = false)
	private BoletaPago boletaPago;
	
	
	private BoletaPagoDescuento(){}
	
	public BoletaPagoDescuento(int id,BoletaPago bp,TipoDescuento tpd,BigDecimal monto){
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
	public TipoDescuento getTipoDescuentoList() {
		return tipoDescuento;
	}
	public void setTipoDescuento( TipoDescuento tipoDescuento) {
		this.tipoDescuento = tipoDescuento;
	}
	public BoletaPago getBoletaPagoList() {
		return boletaPago;
	}
	public void setBoletaPagoList(BoletaPago boletaPago) {
		this.boletaPago = boletaPago;
	}

}
