package com.tienda.microservicios.modelo.entities;

import java.io.Serializable;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the roles database table.
 * 
 */
@Entity
@Table(name="roles")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_rol")
	private int idRol;

	@Column(name="nombre_rol")
	private String nombreRol;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="roles")
	private List<Usuario> usuarios1;
	
	public Role(int idRol, String nombreRol, List<Usuario> usuarios1) {
		super();
		this.idRol = idRol;
		this.nombreRol = nombreRol;
		this.usuarios1 = usuarios1;
	}

	public Role() {
	}

	public int getIdRol() {
		return this.idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public String getNombreRol() {
		return this.nombreRol;
	}

	public void setNombreRol(String nombreRol) {
		this.nombreRol = nombreRol;
	}

	public List<Usuario> getUsuarios1() {
		return this.usuarios1;
	}

	public void setUsuarios1(List<Usuario> usuarios1) {
		this.usuarios1 = usuarios1;
	}

	@Override
	public String toString() {
		return "Role [idRol=" + idRol + ", nombreRol=" + nombreRol + ", usuarios1=" + usuarios1 + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idRol);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Role other = (Role) obj;
		return idRol == other.idRol;
	}
	
}