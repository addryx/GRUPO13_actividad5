package com.tienda.modelo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.modelo.entities.Producto;
import com.tienda.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{

	@Autowired
	private ProductoRepository prepo;
	
	@Override
	public Producto insertarProducto(Producto producto) {
		if (buscarUno(producto.getIdProducto()) == null)
			return prepo.save(producto);
		return null;
	}

	@Override
	public Producto buscarUno(int idProducto) {
		return prepo.findById(idProducto).orElse(null);
	}

	@Override
	public List<Producto> buscarTodos() {
		return prepo.findAll();
	}

	@Override
	public boolean borrarProducto(int idProducto) {
		if (buscarUno(idProducto) != null) {
			prepo.deleteById(idProducto);
			return true;
		}
		return false;
	}

	@Override
	public Producto modificarProducto(Producto producto) {
		if (buscarUno(producto.getIdProducto()) != null)
			return prepo.save(producto);
		return null;
	}

}
