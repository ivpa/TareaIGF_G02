package sv.edu.ues.igf115.clave02.dominio;

import java.io.Serializable;  
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departamento",catalog="clave2",schema = "")

public class Departamento implements Serializable{
private static final long serialVersionUID = 1L;
private Short idDep;
private String nombreDep;
private String zona;
private List<Municipio> municipioList;

private Departamento(){
	
}

public Departamento(String nombreDep, String zona){
	this.nombreDep = nombreDep;
	this.zona = zona;
}

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Basic(optional = false)
@Column(name = "id_depto")
public Short getIdDep(){
	return idDep;
}

public void setIdDep(Short idDep){
	this.idDep = idDep;
}

/**
 * @return the nombreDep
 */
@Basic(optional = false)
@Column(name = "nombre_depto")
public String getNombreDep() {
	return nombreDep;
}

/**
 * @param nombreDep the nombreDep to set
 */
public void setNombreDep(String nombreDep) {
	this.nombreDep = nombreDep;
}

/**
 * @return the zona
 */
@Basic(optional = false)
@Column(name = "zona_geografica")
public String getZona() {
	return zona;
}

/**
 * @param zona the zona to set
 */
public void setZona(String zona) {
	this.zona = zona;
}

/**
 * @return the municipioList
 */
@OneToMany(cascade = CascadeType.ALL, mappedBy = "departamento")
public List<Municipio> getMunicipioList() {
	return municipioList;
}

/**
 * @param municipioList the municipioList to set
 */
public void setMunicipioList(List<Municipio> municipioList) {
	this.municipioList = municipioList;
}


}

