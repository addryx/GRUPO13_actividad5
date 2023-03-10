package com.tienda.modelo.beans;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.*;


/**
 * The persistent class for the productos_compra database table.
 * 
 */
@Entity
@Table(name="productos_compra")
@NamedQuery(name="ProductosCompra.findAll", query="SELECT p FROM ProductosCompra p")
public class ProductosCompra implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductosCompraPK id;

	private BigDecimal precio;

	private int unidades;

	//bi-directional many-to-one association to Compra
	@ManyToOne
	@JoinColumn(name="id_compra", insertable=false, updatable=false)
	private Compra compra;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="id_producto", insertable=false, updatable=false)
	private Producto producto;

	public ProductosCompra() {
	}

	public ProductosCompraPK getId() {
		return this.id;
	}

	public void setId(ProductosCompraPK id) {
		this.id = id;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public int getUnidades() {
		return this.unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public Compra getCompra() {
		return this.compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

}