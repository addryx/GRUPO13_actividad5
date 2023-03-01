package com.tienda.microservicios.modelo.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.microservicios.modelo.entities.Producto;
import com.tienda.microservicios.repository.ProductoRepository;

@Service
public class ProductoServicesImpl implements IntProductoServices{
	
	@Autowired
	private ProductoRepository urepo;

	@Override
	public BigDecimal consultaPrecio(int idProducto) {
		Producto producto = urepo.findById(idProducto).orElseThrow();
		return producto.getPrecio();
	}
}
