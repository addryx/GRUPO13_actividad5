package com.tienda.modelo.dao;

import java.util.List;

import com.tienda.modelo.beans.Tarjeta;

public interface IntTarjetaDao {

	List<Tarjeta> buscarTodos();
	int registrarTarjeta(Tarjeta tarjeta);
	int eliminarTarjeta(int idTarjeta);
}
