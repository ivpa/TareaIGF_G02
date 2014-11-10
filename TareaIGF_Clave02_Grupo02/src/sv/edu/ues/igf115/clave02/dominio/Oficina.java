package sv.edu.ues.igf115.clave02.dominio;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="oficina",catalog="clave2",schema="")
public class Oficina implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	
	@Basic(optional = false)
	@Column(name = "id_oficina")
	String id_oficina;
	@Column(name="nomb_oficina")
	@Basic(optional=false)
	private String nomb_oficina;
	@Column(name="domicilio")
	@Basic(optional=false)
	private String domicilio;
	@ManyToOne(fetch= FetchType.EAGER,cascade =CascadeType.ALL)
	@JoinColumn(name = "id_municipio")
	private Municipio id_municipio;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="id_depto")
	private Departamento id_depto;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id_oficina")
	List<Empleado> listEmp;
	public Oficina()
	{}
	public Oficina(String nombre,String domicilio,Municipio id_municipio,Departamento id_depto)
	{
		this.nomb_oficina=nombre;
		this.domicilio=domicilio;
		this.id_municipio=id_municipio;
		this.id_depto=id_depto;
	}
	public Oficina(String id ,String nombre,String domicilio,Municipio id_municipio,Departamento id_depto)
	{
		this.id_oficina=id;
		this.nomb_oficina=nombre;
		this.domicilio=domicilio;
		this.id_municipio=id_municipio;
		this.id_depto=id_depto;
	}
	public String getId_Oficina()
	{
		return id_oficina;
	}
	public void setId_Oficina(String id_oficina)
	{
		this.id_oficina=id_oficina;
	}
	public String getNomb_Oficina()
	{
		return nomb_oficina;
	}
	public void setNomb_Oficina(String nombre)
	{
		this.nomb_oficina=nombre;
	}
	public String getDomicilio()
	{
		return domicilio;
	}
	public void setDomicilio(String domicilio)
	{
		this.domicilio=domicilio;
	}
	public Municipio getId_Municipio()
	{
		return id_municipio;
	}
	public void setId_Municipio(Municipio id_municipio)
	{
		this.id_municipio=id_municipio;
	}
	public Departamento getId_Depto()
	{
		return id_depto;
	}
	public void setId_Depto(Departamento id_depto)
	{
		this.id_depto=id_depto;
	}
	/**
	 * @return the listEmp
	 */
	public List<Empleado> getListEmp() {
		return listEmp;
	}
	/**
	 * @param listEmp the listEmp to set
	 */
	public void setListEmp(List<Empleado> listEmp) {
		this.listEmp = listEmp;
	}
}


