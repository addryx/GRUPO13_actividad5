package com.tienda.modelo.entities;

import java.io.Serializable;
import jakarta.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * The persistent class for the tarjetas database table.
 * 
 */
@Entity
@Table(name="tarjetas")
@NamedQuery(name="Tarjeta.findAll", query="SELECT t FROM Tarjeta t")
public class Tarjeta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_tarjeta")
	private int idTarjeta;

	@Column(name="numero_tarjeta")
	private String numeroTarjeta;
	
	@Column(name="nombre_titular")
	private String nombreTitular;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_caducidad")
	private Date fechaCaducidad;
	
	private int cvv;

	//bi-directional many-to-one association to Compra
	@OneToMany(mappedBy="tarjeta")
	private List<Compra> compras;

	//bi-directional many-to-many association to Usuario
	@ManyToMany(mappedBy="tarjetas")
	private List<Usuario> usuarios;
	
	public Tarjeta(int idTarjeta, String numeroTarjeta, String nombreTitular, Date fechaCaducidad, int cvv,
			List<Compra> compras, List<Usuario> usuarios) {
		super();
		this.idTarjeta = idTarjeta;
		this.numeroTarjeta = numeroTarjeta;
		this.nombreTitular = nombreTitular;
		this.fechaCaducidad = fechaCaducidad;
		this.cvv = cvv;
		this.compras = compras;
		this.usuarios = usuarios;
	}

	public Tarjeta() {
	}

	public int getIdTarjeta() {
		return this.idTarjeta;
	}

	public void setIdTarjeta(int idTarjeta) {
		this.idTarjeta = idTarjeta;
	}

	public int getCvv() {
		return this.cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public Date getFechaCaducidad() {
		return this.fechaCaducidad;
	}

	public void setFechaCaducidad(Date fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public String getNombreTitular() {
		return this.nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public String getNumeroTarjeta() {
		return this.numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public List<Compra> getCompras() {
		return this.compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

	public Compra addCompra(Compra compra) {
		getCompras().add(compra);
		compra.setTarjeta(this);

		return compra;
	}

	public Compra removeCompra(Compra compra) {
		getCompras().remove(compra);
		compra.setTarjeta(null);

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
		return "Tarjeta [idTarjeta=" + idTarjeta + ", numeroTarjeta=" + numeroTarjeta + ", nombreTitular="
				+ nombreTitular + ", fechaCaducidad=" + fechaCaducidad + ", cvv=" + cvv + ", compras=" + compras
				+ ", usuarios=" + usuarios + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idTarjeta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarjeta other = (Tarjeta) obj;
		return idTarjeta == other.idTarjeta;
	}
	
}