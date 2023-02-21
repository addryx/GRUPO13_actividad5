package com.tienda.modelo.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 * The persistent class for the compras database table.
 * 
 */
@Entity
@Table(name = "compras")
@NamedQuery(name = "Compra.findAll", query = "SELECT c FROM Compra c")
public class Compra implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_compra")
	private int idCompra;

	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;

	private String estado;

	// bi-directional many-to-one association to Direccion
	@ManyToOne
	@JoinColumn(name = "id_direccion")
	private Direccione direccione;

	// bi-directional many-to-one association to Tarjeta
	@ManyToOne
	@JoinColumn(name = "id_tarjeta")
	private Tarjeta tarjeta;

	// bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name = "id_usuario")
	private Usuario usuario;

	// bi-directional many-to-one association to ProductosCompra
	@OneToMany(mappedBy = "compra")
	private List<ProductosCompra> productosCompras;
	
	public Compra(int idCompra, Date fecha, String estado, Direccione direccione, Tarjeta tarjeta, Usuario usuario,
			List<ProductosCompra> productosCompras) {
		super();
		this.idCompra = idCompra;
		this.fecha = fecha;
		this.estado = estado;
		this.direccione = direccione;
		this.tarjeta = tarjeta;
		this.usuario = usuario;
		this.productosCompras = productosCompras;
	}

	public Compra() {
	}

	public int getIdCompra() {
		return this.idCompra;
	}

	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Direccione getDireccione() {
		return this.direccione;
	}

	public void setDireccione(Direccione direccione) {
		this.direccione = direccione;
	}

	public Tarjeta getTarjeta() {
		return this.tarjeta;
	}

	public void setTarjeta(Tarjeta tarjeta) {
		this.tarjeta = tarjeta;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public List<ProductosCompra> getProductosCompras() {
		return this.productosCompras;
	}

	public void setProductosCompras(List<ProductosCompra> productosCompras) {
		this.productosCompras = productosCompras;
	}

	public ProductosCompra addProductosCompra(ProductosCompra productosCompra) {
		getProductosCompras().add(productosCompra);
		productosCompra.setCompra(this);

		return productosCompra;
	}

	public ProductosCompra removeProductosCompra(ProductosCompra productosCompra) {
		getProductosCompras().remove(productosCompra);
		productosCompra.setCompra(null);

		return productosCompra;
	}

	@Override
	public String toString() {
		return "Compra [idCompra=" + idCompra + ", fecha=" + fecha + ", estado=" + estado + ", direccione=" + direccione
				+ ", tarjeta=" + tarjeta + ", usuario=" + usuario + ", productosCompras=" + productosCompras + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCompra);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compra other = (Compra) obj;
		return idCompra == other.idCompra;
	}

}