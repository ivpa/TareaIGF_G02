package sv.edu.ues.igf115.clave02.dominio;

import java.io.Serializable;



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
@Table(name = "municipio",catalog = "clave2",schema = "")
public class Municipio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_municipio")
	@Basic(optional = false)
	private String id;
	@Column(name = "nomb_municipio")
	@Basic(optional = false)
	private String nombre;
	@ManyToOne(fetch = FetchType.EAGER,cascade =CascadeType.ALL)
	@JoinColumn(name = "id_depto")
	private Departamento departamento;
	
	
	private Municipio(){}
	
	public Municipio(String id, String nombre,Departamento Departamento){
		this.id = id;
		this.nombre = nombre;
		this.departamento = Departamento;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento Departamento) {
		this.departamento = Departamento;
	}

}
