package com.tienda.modelo.dao;

import com.tienda.modelo.beans.Tarjeta;

public interface IntTarjetaDao {

	int registrarTarjeta(Tarjeta tarjeta);
	int eliminarTarjeta(int idTarjeta);
}
