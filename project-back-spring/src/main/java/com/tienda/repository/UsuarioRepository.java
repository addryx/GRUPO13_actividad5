package com.tienda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tienda.modelo.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

}
