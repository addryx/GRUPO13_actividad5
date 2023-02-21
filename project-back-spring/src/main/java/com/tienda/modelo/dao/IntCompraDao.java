package com.tienda.modelo.dao;

import java.util.List;

import com.tienda.modelo.beans.Compra;

public interface IntCompraDao {
	/*
	 * Procesar una compra: pagar y registrarla en la BD.
	 * Cuando quiera comprar, eliminamos las filas de la tabla, y grabamos las que tenga el carrito 
	 * en este momento; el estado del pedido cambiará a “comprado”.
	 */
	
	List<Compra> findAll();//Método que devuelve una lista de todas las compras
	
	Compra findById(int idCompra);//Método que devuelve una compra por su idCompra
	
	//Método para procesar una compra, no sé como plantearlo. 
	Compra procesarCompra(Compra compra);

}
