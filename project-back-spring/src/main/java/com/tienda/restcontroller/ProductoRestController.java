package com.tienda.restcontroller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.modelo.beans.Producto;
import com.tienda.modelo.beans.Usuario;
import com.tienda.modelo.dao.IntProductoDao;
import com.tienda.modelo.dao.IntUsuarioDao;

@RestController
@RequestMapping("/rest/producto")
public class ProductoRestController {

	@Autowired
	private IntProductoDao pdao;
	
	@Autowired
	private IntUsuarioDao udao;
	
	/*
	 * Precio de un producto solicitado.
	 */
	
	@GetMapping("/precio/{id}")
    public BigDecimal verPrecioProducto(@PathVariable("id") int idProducto) {
        return pdao.precioProducto(idProducto);
    }
	
	/*
	 * Prueba para ver que sale como listado de esta query
	 */
	@GetMapping("/prueba/{id}")
    public List<Usuario> prueba(@PathVariable("id") int idUsuario) {
		return udao.datosUsuario(idUsuario);
    }
	
}
