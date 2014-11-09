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
@Table(name="oficina",catalog="clave2",schema="")
public class Oficina implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "id_oficina")
	int id_oficina;
	@Column(name="nomb_oficina")
	@Basic(optional=false)
	private String nomb_oficina;
	@Column(name="domicilio")
	@Basic(optional=false)
	private String domicilio;
	@Column(name="id_municipio")
	@Basic(optional=false)
	private String id_municipio;
	@Column(name="id_depto")
	@Basic(optional=false)
	private String id_depto;
	public Oficina()
	{}
	public Oficina(String nombre,String domicilio,String id_municipio,String id_depto)
	{
		this.nomb_oficina=nombre;
		this.domicilio=domicilio;
		this.id_municipio=id_municipio;
		this.id_depto=id_depto;
	}
	public Oficina(int id ,String nombre,String domicilio,String id_municipio,String id_depto)
	{
		this.id_oficina=id;
		this.nomb_oficina=nombre;
		this.domicilio=domicilio;
		this.id_municipio=id_municipio;
		this.id_depto=id_depto;
	}
	public int getId_Oficina()
	{
		return id_oficina;
	}
	public void setId_Oficina(int id_oficina)
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
	public String getId_Municipio()
	{
		return id_municipio;
	}
	public void setId_Municipio(String id_municipio)
	{
		this.id_municipio=id_municipio;
	}
	public String getId_Depto()
	{
		return id_depto;
	}
	public void setId_Depto(String id_depto)
	{
		this.id_depto=id_depto;
	}
}


