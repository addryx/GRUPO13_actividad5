package com.tienda.microservicios.modelo.services;

import java.math.BigDecimal;
import java.util.List;

import com.tienda.microservicios.modelo.entities.Producto;

public interface IntProductoServices {

	// Creamos un método que devuelve el precio de un producto
	
	BigDecimal consultaPrecio(int idProducto);
	
	/** Metodo que devuelve un listado de productos de un tipo determinado
	
	List<Producto> tipoProducto(NO HAY TIPO);
	*/
}
