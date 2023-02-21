package com.tienda.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.modelo.beans.Role;
import com.tienda.repository.RoleRepository;

@Service
public class RoleDaoImplMy8 implements IntRoleDao{

	@Autowired
	private RoleRepository rrepo;
	
	@Override
	public Role buscarRole(int idRole) {
		Role role = new Role();
		role.setIdRol(idRole);
		int pos = rrepo.findAll().indexOf(role);
		if (pos == -1) {
			return null;
		} else {
			return rrepo.findById(idRole).orElse(null);
		}
	}

	@Override
	public List<Role> buscarTodos() {
		return rrepo.findAll();
	}

	@Override
	public int altaRole(Role role) {
		int filas =0;
		try {
			rrepo.save(role);
			filas=1;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int bajaRole(int idRole) {
		int filas = 0;
		try {
			rrepo.deleteById(idRole);
			filas=1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int modificarRole(Role role) {
		int filas = 0;
		Role u1 = null;
		try {
			u1 = rrepo.getOne(role.getIdRol());
			u1 = role;
			rrepo.save(u1);
			filas=1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

}
