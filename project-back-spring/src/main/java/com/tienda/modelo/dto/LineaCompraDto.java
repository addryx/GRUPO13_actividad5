package com.tienda.modelo.dto;

import java.io.Serializable;

public class LineaCompraDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int idProducto;
	private int cantidad;
	private double precioVenta;
	
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}
	@Override
	public String toString() {
		return "LineaCompraDto [idProducto=" + idProducto + ", cantidad=" + cantidad + ", precioVenta=" + precioVenta
				+ "]";
	}
	
}
