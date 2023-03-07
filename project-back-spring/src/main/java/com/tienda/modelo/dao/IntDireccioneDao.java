package com.tienda.modelo.dao;

import java.util.List;

import com.tienda.modelo.beans.Direccione;

public interface IntDireccioneDao {
	
	List<Direccione> buscarTodos();
	int registrarDireccion(Direccione direccione);
	int eliminarDireccion(int idDireccion);
	List<Direccione> clientesPorLocalidad();
	
}
