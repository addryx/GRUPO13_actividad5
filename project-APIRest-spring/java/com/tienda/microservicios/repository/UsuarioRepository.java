package com.tienda.microservicios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.tienda.microservicios.modelo.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
	/**
	@Query( "select * from usuario where id_usuario in" + "(select id_usuario from usuarios_direcciones where id_direccion)", nativeQuery = true )
	List<Usuario> listaLocalidadUsuario();
	*/
}
