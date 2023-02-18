package com.tienda.modelo.dao;

import com.tienda.modelo.beans.Direccione;

public interface IntDireccioneDao {
	
	int registrarDireccion(Direccione direccione);
	int eliminarDireccion(int idDireccion);

}
