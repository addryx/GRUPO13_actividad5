package com.tienda.modelo.service;

import java.util.List;

import com.tienda.modelo.entities.Producto;

public interface ProductoService {

	Producto insertarProducto(Producto producto);
	Producto buscarUno(int idProducto);
	List<Producto> buscarTodos();
	boolean borrarProducto(int idProducto);
	Producto modificarProducto(Producto producto);
	
}
