package com.tienda.modelo.dao;

import com.tienda.modelo.entities.Direccione;

public interface IntDireccioneDao {
	
	int registrarDireccion(Direccione direccione);
	int eliminarDireccion(int idDireccion);

}
