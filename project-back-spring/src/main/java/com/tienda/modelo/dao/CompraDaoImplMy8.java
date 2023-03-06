package com.tienda.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.modelo.beans.Compra;
import com.tienda.repository.CompraRepository;

@Service
public class CompraDaoImplMy8 implements IntCompraDao  {
	
	@Autowired
	private CompraRepository coRepo;
	
	
	 //Método que devuelve un listado de todas las compras
	@Override
	public List<Compra> findAll(){
		return coRepo.findAll();
	}
	//Método que devuelve una compra pasando el idCompra
	@Override
	public Compra findById(int idCompra) {
		Compra compra = new Compra();
		compra.setIdCompra(idCompra);
		int pos = coRepo.findAll().indexOf(compra);
		if (pos == -1) {
			return null;
		} else {
			return coRepo.findById(idCompra).orElse(null);
		}
	}

	//Método que procesa una compra, no sé como desarrollarlo. 
	@Override
	public Compra procesarCompra(Compra compra) {
		return null;
	}
	
	
}
