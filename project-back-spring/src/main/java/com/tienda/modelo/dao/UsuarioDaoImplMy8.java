package com.tienda.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.modelo.beans.Usuario;
import com.tienda.repository.UsuarioRepository;

@Service
public class UsuarioDaoImplMy8 implements IntUsuarioDao{

	@Autowired
	private UsuarioRepository urepo;
	
	@Override
	public Usuario buscarUno(int idUsuario) {
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(idUsuario);
		int pos = urepo.findAll().indexOf(usuario);
		if (pos == -1) {
			return null;
		} else {
			return urepo.findById(idUsuario).orElse(null);
		}
	}

	@Override
	public List<Usuario> buscarTodos() {
		return urepo.findAll();
	}

	@Override
	public int altaUsuario(Usuario usuario) {
		int filas =0;
		try {
			urepo.save(usuario);
			filas=1;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int bajaUsuario(int idUsuario) {
		int filas = 0;
		try {
			urepo.deleteById(idUsuario);
			filas=1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public int modificarUsuario(Usuario usuario) {
		int filas = 0;
		Usuario u1 = null;
		try {
			u1 = urepo.getOne(usuario.getIdUsuario());
			u1 = usuario;
			urepo.save(u1);
			filas=1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}
}
