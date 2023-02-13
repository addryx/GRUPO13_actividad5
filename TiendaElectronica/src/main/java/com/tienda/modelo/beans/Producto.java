package com.tienda.modelo.beans;

import jakarta.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the productos database table.
 * 
 */
@Entity
@Table(name="productos")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")
public class Producto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_producto")
	private int idProducto;

	private String descripcion;

	private String nombre;

	private BigDecimal precio;

	private int stock;

	//bi-directional many-to-one association to ProductosCompra
	@OneToMany(mappedBy="producto")
	private List<ProductosCompra> productosCompras;

	public Producto() {
	}

	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecio() {
		return this.precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public int getStock() {
		return this.stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public List<ProductosCompra> getProductosCompras() {
		return this.productosCompras;
	}

	public void setProductosCompras(List<ProductosCompra> productosCompras) {
		this.productosCompras = productosCompras;
	}

	public ProductosCompra addProductosCompra(ProductosCompra productosCompra) {
		getProductosCompras().add(productosCompra);
		productosCompra.setProducto(this);

		return productosCompra;
	}

	public ProductosCompra removeProductosCompra(ProductosCompra productosCompra) {
		getProductosCompras().remove(productosCompra);
		productosCompra.setProducto(null);

		return productosCompra;
	}

}