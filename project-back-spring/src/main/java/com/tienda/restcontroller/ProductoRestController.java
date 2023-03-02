package com.tienda.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.modelo.beans.Producto;
import com.tienda.modelo.dao.IntProductoDao;

@RestController
@RequestMapping("/rest/producto")
public class ProductoRestController {

	@Autowired
	private IntProductoDao pdao;
	
	@GetMapping("/todos")
    public List<Producto> todos() {
        return pdao.buscarTodos();
    }
	
	/*
	 * Precio de un producto solicitado.
	 */
	
	/*
	 * Listado de productos de un tipo determinado.
	 */
	
	
	/*
	 * Listado de cuantos clientes de cada provincia tenemos en nuestra BBDD de clientes.
	 */
	
}
