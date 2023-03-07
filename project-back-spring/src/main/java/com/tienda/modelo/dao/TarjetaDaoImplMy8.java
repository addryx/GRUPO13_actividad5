package com.tienda.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.modelo.beans.Tarjeta;
import com.tienda.repository.TarjetaRepository;

@Service
public class TarjetaDaoImplMy8 implements IntTarjetaDao {
	
	@Autowired
	TarjetaRepository trepo;
	
	@Override
	public List<Tarjeta> buscarTodos() {
		return trepo.findAll();
	}
	
	@Override
	public int registrarTarjeta(Tarjeta tarjeta) {
		int filas = 0;
		try {
			trepo.save(tarjeta);
			filas = 1;
		}
		catch (Exception e) {
			e.printStackTrace();			
		}
		return filas;
	}

	@Override
	public int eliminarTarjeta(int idTarjeta) {
		int filas = 0;
		try {
			trepo.deleteById(idTarjeta);
			filas = 1;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

}
