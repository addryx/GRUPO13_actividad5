package com.tienda.microservicios.modelo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.microservicios.modelo.entities.Usuario;
import com.tienda.microservicios.repository.UsuarioRepository;

@Service
public class UsuarioServicesImpl implements IntUsuarioServices {
	
	@Autowired
	private UsuarioRepository urepo;
	
	@Override
	public List<Usuario> porLocalidad(String localidad) {

		return null;
	}

}
