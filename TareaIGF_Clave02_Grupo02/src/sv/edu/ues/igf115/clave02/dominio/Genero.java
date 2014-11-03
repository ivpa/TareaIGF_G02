package sv.edu.ues.igf115.clave02.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "genero",catalog = "clave2",schema = "")
public class Genero implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_sexo")
	@Basic(optional = false)
	private String id;
	@Column(name="d_sexo")
	@Basic(optional = false)
	private String sexo;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Empleado> empleadoList;
	private Genero(){}
	public Genero(String id,String sexo){
		this.id = id;
		this.sexo = sexo;
		
	}
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
	 * @return the sexo
	 */
	public String getSexo() {
		return sexo;
	}
	/**
	 * @param sexo the sexo to set
	 */
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	/**
	 * @return the empleadoList
	 */
	public List<Empleado> getEmpleadoList() {
		return empleadoList;
	}
	/**
	 * @param empleadoList the empleadoList to set
	 */
	public void setEmpleadoList(List<Empleado> empleadoList) {
		this.empleadoList = empleadoList;
	}
}
