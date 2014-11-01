package sv.edu.ues.igf115.clave02.dominio;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="tienda", catalog="tienda",schema="")
public class Tienda implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Basic(optional = false)
@Column(name = "IdTienda")

private int id;

@Column(name="NombreTienda")
private String nombreTienda;
@Column(name="Ciudad")
private String ciudad;

private Tienda(){}

public Tienda(String nombreTienda,String ciudad){
	this.nombreTienda = nombreTienda;
	this.ciudad = ciudad;
}

/**
 * @return the id
 */
public int getId() {
	return id;
}

/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}

/**
 * @return the nombreTienda
 */
public String getNombreTienda() {
	return nombreTienda;
}

/**
 * @param nombreTienda the nombreTienda to set
 */
public void setNombreTienda(String nombreTienda) {
	this.nombreTienda = nombreTienda;
}

/**
 * @return the ciudad
 */
public String getCiudad() {
	return ciudad;
}

/**
 * @param ciudad the ciudad to set
 */
public void setCiudad(String ciudad) {
	this.ciudad = ciudad;
}


}
