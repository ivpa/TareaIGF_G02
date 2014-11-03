package sv.edu.ues.igf115.clave02.dominio;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuario", catalog = "clave2")
public class Usuario {
	
	@Id
	@Column(name = "idusuario",unique = true,
	nullable = false, length = 10)
	private String idusuario;
	@Column(name = "nombres")
	@Basic(optional = false)
	private String nombre;
	@Column(name = "apellidos")
	@Basic(optional = false)
	private String apellido;
	@Column(name = "contrasenia")
	@Basic(optional = false)
	private String password;
	@Column(name = "activo")
	@Basic(optional = false)
	private boolean activo;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy ="usuario")
	private Set<Rol> userRole=new HashSet<>(0);
	
	public Usuario(){}
	
	public Usuario(String idusuario,String nombre,String apellido,
			String password,boolean activo){
		
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.password = password;
		this.activo = activo;	
	}

	/**
	 * @return the idusuario
	 */
	public String getIdusuario() {
		return idusuario;
	}

	/**
	 * @param idusuario the idusuario to set
	 */
	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
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
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the activo
	 */
	public boolean isActivo() {
		return activo;
	}

	/**
	 * @param activo the activo to set
	 */
	public void setActivo(boolean activo) {
		this.activo = activo;
	}

	/**
	 * @return the userRole
	 */
	public Set<Rol> getUserRole() {
		return userRole;
	}

	/**
	 * @param userRole the userRole to set
	 */
	public void setUserRole(Set<Rol> userRole) {
		this.userRole = userRole;
	}

}
