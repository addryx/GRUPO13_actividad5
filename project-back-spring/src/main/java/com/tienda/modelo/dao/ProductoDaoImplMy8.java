package com.tienda.modelo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienda.modelo.beans.Producto;
import com.tienda.repository.ProductoRepository;

@Service
public class ProductoDaoImplMy8 implements IntProductoDao{
	
	@Autowired
	ProductoRepository prepo;

	@Override
	public int insertarProducto(Producto producto) {
		int filas =0;
		try {
			prepo.save(producto);
			filas=1;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public Producto buscarUno(int codigo) {
		// TODO Auto-generated method stub
		return prepo.findById(codigo).orElse(null);
	}

	@Override
	public List<Producto> buscarTodos() {
		// TODO Auto-generated method stub
		return prepo.findAll();
	}

	@Override
	public int borrarProducto(int codigo) {
		int filas = 0;
		try {
			prepo.deleteById(codigo);
			filas=1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@SuppressWarnings("deprecation")
	@Override
	public int modificarProducto(Producto producto) {
		int filas = 0;
		Producto p1 = null;
		try {
			p1 = prepo.getOne(producto.getIdProducto());
			p1 = producto;
			prepo.save(p1);
			filas=1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	@Override
	public List<Producto> buscadorProductos(String nombre) {
		return prepo.buscadorProductos(nombre);
	}

	@Override
	public List<Producto> filtroProductos(String valor) {
		return prepo.filtroAlfabetico(valor);
	}

	@Override
	public List<Producto> precioProducto(int idProducto) {
		try {
			return this.prepo.precioProducto(idProducto);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
