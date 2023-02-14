package com.tienda.modelo.beans;

import java.io.Serializable;
import jakarta.persistence.*;

/**
 * The primary key class for the productos_compra database table.
 * 
 */
@Embeddable
public class ProductosCompraPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_compra", insertable=false, updatable=false)
	private int idCompra;

	@Column(name="id_producto", insertable=false, updatable=false)
	private int idProducto;

	public ProductosCompraPK() {
	}
	public int getIdCompra() {
		return this.idCompra;
	}
	public void setIdCompra(int idCompra) {
		this.idCompra = idCompra;
	}
	public int getIdProducto() {
		return this.idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductosCompraPK)) {
			return false;
		}
		ProductosCompraPK castOther = (ProductosCompraPK)other;
		return 
			(this.idCompra == castOther.idCompra)
			&& (this.idProducto == castOther.idProducto);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idCompra;
		hash = hash * prime + this.idProducto;
		
		return hash;
	}
}