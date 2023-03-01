package com.tienda.microservicios.modelo.services;

import java.util.List;

import com.tienda.microservicios.modelo.entities.Usuario;

public interface IntUsuarioServices {
	
	// Creamos un método que devuelva un listado de cuantos usuarios hay en cada localidad
	
	List<Usuario> porLocalidad(String localidad);

}
