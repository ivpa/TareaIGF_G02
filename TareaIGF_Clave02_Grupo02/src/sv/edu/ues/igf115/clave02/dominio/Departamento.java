package sv.edu.ues.igf115.clave02.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "departamento",catalog = "clave2",schema = "")
public class Departamento implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="id_depto")
	@Basic(optional = false)
	private String id;
	@Column(name = "nombre_depto")
	@Basic(optional = false)
	private String nombre;
	@Column(name = "zona_geografica")
	@Basic(optional = false)
	private String zona;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "departamento")
	private List<Municipio> listMunicipio;
	
	private Departamento(){}
	
	public Departamento(String id,String nombre,String zona){
		
		this.id = id;
		this.nombre = nombre;
		this.zona = zona;

	}

	/**
	 * @return the id
	 */
	public  String getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
	/**
	 * @return the zona
	 */
	public String getZona() {
		return zona;
	}


	/**
	 * @param zona the zona to set
	 */
	public void setZona(String zona) {
		this.zona = zona;
	}


	public List<Municipio> getListMunicipio() {
		return listMunicipio;
	}


	public void setListMunicipio(List<Municipio> listMunicipio) {
		this.listMunicipio = listMunicipio;
	}


}
