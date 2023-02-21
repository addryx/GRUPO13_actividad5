package com.tienda.modelo.dao;

import java.util.List;

import com.tienda.modelo.beans.Usuario;

public interface IntUsuarioDao {

	Usuario buscarUno(int idUsuario);
	List<Usuario> buscarTodos();
	int altaUsuario(Usuario usuario);
	int bajaUsuario (int idUsuario);
	int modificarUsuario(Usuario usuario);
	
}
