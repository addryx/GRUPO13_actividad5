package com.tienda.microservicios.modelo.entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

import org.hibernate.annotations.NamedQuery;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 * The persistent class for the direcciones database table.
 * 
 */
@Entity
@Table(name = "direcciones")
@NamedQuery(name = "Direccione.findAll", query = "SELECT d FROM Direccione d")
public class Direccione implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_direccion")
	private int idDireccion;

	@Column(name = "codigo_postal")
	private String codigoPostal;

	private String localidad;

	private String calle;

	private int numero;

	private int piso;

	private String letra;

	// bi-directional many-to-one association to Compra
	@OneToMany(mappedBy = "direccione")
	private List<Compra> compras;

	// bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy = "direcciones")
	private List<Usuario> usuarios;

	public Direccione(int idDireccion, String codigoPostal, String localidad, String calle, int numero, int piso,
			String letra, List<Compra> compras, List<Usuario> usuarios) {
		super();
		this.idDireccion = idDireccion;
		this.codigoPostal = codigoPostal;
		this.localidad = localidad;
		this.calle = calle;
		this.numero = numero;
		this.piso = piso;
		this.letra = letra;
		this.compras = compras;
		this.usuarios = usuarios;
	}

	public Direccione() {
	}

	public int getIdDireccion() {
		return this.idDireccion;
	}

	public void setIdDireccion(int idDireccion) {
		this.idDireccion = idDireccion;
	}

	public String getCalle() {
		return this.calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCodigoPostal() {
		return this.codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getLetra() {
		return this.letra;
	}

	public void setLetra(String letra) {
		this.letra = letra;
	}

	public String getLocalidad() {
		return this.localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public int getNumero() {
		return this.numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getPiso() {
		return this.piso;
	}

	public void setPiso(int piso) {
		this.piso = piso;
	}

	public List<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public Compra addCompra(Compra compra) {
		getCompras().add(compra);
		compra.setDireccione(this);

		return compra;
	}

	public Compra removeCompra(Compra compra) {
		getCompras().remove(compra);
		compra.setDireccione(null);

		return compra;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	@Override
	public String toString() {
		return "Direccione [idDireccion=" + idDireccion + ", codigoPostal=" + codigoPostal + ", localidad=" + localidad
				+ ", calle=" + calle + ", numero=" + numero + ", piso=" + piso + ", letra=" + letra + ", compras="
				+ compras + ", usuarios=" + usuarios + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idDireccion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Direccione other = (Direccione) obj;
		return idDireccion == other.idDireccion;
	}
	
}