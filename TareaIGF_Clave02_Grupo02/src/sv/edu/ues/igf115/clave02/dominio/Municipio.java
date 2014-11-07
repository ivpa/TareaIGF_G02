package sv.edu.ues.igf115.clave02.dominio;

import java.io.Serializable;  

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "municipio",catalog = "clave02", schema = "")

public class Municipio implements Serializable{
private static final long serialVersionUID = 1L;
private Short idMun;
private String nombreMun;
private Departamento departamento;

private Municipio(){}

public Municipio(String nombreMun, Departamento departamento){
	this.nombreMun = nombreMun;
	this.departamento = departamento;
}

/**
 * @return the idMun
 */
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Basic(optional = false)
@Column(name = "id_municipio")
public Short getidMun() {
	return idMun;
}

/**
 * @param idMun the idMun to set
 */
public void setidMun(Short idMun) {
	this.idMun = idMun;
}

/**
 * @return the nombreMun
 */
@Column(name = "nomb_municipio")
public String getNombreMun() {
	return nombreMun;
}
/**
 * @param nombreMun the nombreMun to set
 */
public void setNombreMun(String nombreMun) {
	this.nombreMun = nombreMun;
}

/**
 * @return the departamento
 */
@JoinColumn(name = "IdDep", referencedColumnName = "IdDep")
@ManyToOne(optional = false)
public Departamento getDepartamento() {
	return departamento;
}
/**
 * @param departamento the departamento to set
 */
public void setDepartamento(Departamento departamento) {
	this.departamento = departamento;
}

}
