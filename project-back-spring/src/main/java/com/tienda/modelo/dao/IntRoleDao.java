package com.tienda.modelo.dao;

import java.util.List;

import com.tienda.modelo.beans.Role;

public interface IntRoleDao {

	Role buscarRole(int idRole);
	List<Role> buscarTodos();
	int altaRole(Role role);
	int bajaRole (int idRole);
	int modificarRole(Role role);
	
}