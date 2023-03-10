package com.tienda.modelo.beans;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name = "usuarios")
@NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int idUsuario;

	private String nombre;
	
	private String apellidos;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;
	
	private String email;
	
	private String contrasena;

	private int enabled;

	// bi-directional many-to-one association to Compra
	@OneToMany(mappedBy = "usuario")
	private List<Compra> compras;

	// bi-directional many-to-many association to Role
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "usuario_roles", joinColumns = { @JoinColumn(name = "id_usuario") }, inverseJoinColumns = {
			@JoinColumn(name = "id_rol") })
	private List<Role> roles;

	// bi-directional many-to-many association to Direccione
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "usuarios_direcciones", joinColumns = { @JoinColumn(name = "id_usuario") }, inverseJoinColumns = {
			@JoinColumn(name = "id_direccion") })
	private List<Direccione> direcciones;

	// bi-directional many-to-many association to Tarjeta
	@ManyToMany(cascade={CascadeType.PERSIST, CascadeType.MERGE})
	@JoinTable(name = "usuarios_tarjetas", joinColumns = { @JoinColumn(name = "id_usuario") }, inverseJoinColumns = {
			@JoinColumn(name = "id_tarjeta") })
	private List<Tarjeta> tarjetas;
	
	public Usuario(int idUsuario, String nombre, String apellidos, Date fechaNacimiento, String email,
			String contrasena, int enabled, List<Compra> compras, List<Role> roles, List<Direccione> direcciones,
			List<Tarjeta> tarjetas) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
		this.contrasena = contrasena;
		this.enabled = enabled;
		this.compras = compras;
		this.roles = roles;
		this.direcciones = direcciones;
		this.tarjetas = tarjetas;
	}

	public Usuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getContrasena() {
		return this.contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEnabled() {
		return this.enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	public Date getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public Compra addCompra(Compra compra) {
		getCompras().add(compra);
		compra.setUsuario(this);

		return compra;
	}

	public Compra removeCompra(Compra compra) {
		getCompras().remove(compra);
		compra.setUsuario(null);

		return compra;
	}

	public List<Role> getRoles() {
		return this.roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<Direccione> getDirecciones() {
		return this.direcciones;
	}

	public void setDirecciones(List<Direccione> direcciones) {
		this.direcciones = direcciones;
	}

	public List<Tarjeta> getTarjetas() {
		return this.tarjetas;
	}

	public void setTarjetas(List<Tarjeta> tarjetas) {
		this.tarjetas = tarjetas;
	}
	
	public void addRole(Role role) {
        if (roles == null) {
            roles = new ArrayList<>();
        	roles.add(role);
        }
    }
	//Esto se ha a??adido para las tarjetas
	public void addTarjeta(Tarjeta tarjeta) {
		if(tarjetas == null)
			tarjetas =  new ArrayList<>();
		tarjetas.add(tarjeta);
	}
	
	public void removeTarjeta(Tarjeta tarjeta) {
		if (tarjetas == null)
			tarjetas = new ArrayList<>();
		tarjetas.remove(tarjeta);
	}
	//Esto se ha a??adido para las direcciones
	public void addDireccion(Direccione direccion) {
		if (direcciones == null)
			direcciones = new ArrayList<>();
		direcciones.add(direccion);
	}
	
	public void removeDireccion(Direccione direccion) {
		if (direcciones == null)
			direcciones = new ArrayList<>();
		direcciones.remove(direccion);
	}
	
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", fechaNacimiento=" + fechaNacimiento + ", email=" + email + ", contrasena=" + contrasena
				+ ", enabled=" + enabled + ", compras=" + compras + ", roles=" + roles + ", direcciones=" + direcciones
				+ ", tarjetas=" + tarjetas + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return idUsuario == other.idUsuario;
	}

}