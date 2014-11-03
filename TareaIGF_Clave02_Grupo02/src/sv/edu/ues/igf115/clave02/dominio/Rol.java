package sv.edu.ues.igf115.clave02.dominio;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "rol",catalog = "clave2",
uniqueConstraints = @UniqueConstraint(
		
		columnNames = {"rol","idusuario"}))
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	private Integer idrol;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idusuario",nullable = false)
	private Usuario usuario;
	@Column(name = "nomb_rol",nullable = false)
	private String nombreRol;
	
	public Rol(){}
	
	public Rol(Usuario user,String nombreRol){
		
		this.usuario = user;
		this.nombreRol = nombreRol;
	}

	/**
	 * @return the idrol
	 */
	public Integer getIdrol() {
		return idrol;
	}

	/**
	 * @param idrol the idrol to set
	 */
	public void setIdrol(Integer idrol) {
		this.idrol = idrol;
	}

	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}

	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/**
	 * @return the nombreRol
	 */
	public String getNombreRol() {
		return nombreRol;
	}

	/**
	 * @param nombreRol the nombreRol to set
	 */
	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}
}
