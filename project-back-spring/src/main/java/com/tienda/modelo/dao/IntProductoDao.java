package com.tienda.modelo.dao;

import java.util.List;

import com.tienda.modelo.beans.Producto;

public interface IntProductoDao {
	
	int insertarProducto(Producto producto);
	Producto buscarUno(int idProducto);
	List<Producto> buscarTodos();
	int borrarProducto(int idProducto);
	int modificarProducto(Producto producto);

}