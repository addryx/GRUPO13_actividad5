package com.tienda.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.modelo.beans.Direccione;
import com.tienda.modelo.beans.Producto;
import com.tienda.modelo.dao.IntDireccioneDao;

@RestController
@RequestMapping("/rest/direccion")
public class DireccionRestController {

	@Autowired
	private IntDireccioneDao ddao;
	
	/*
	 * Listado de cuantos clientes de cada provincia tenemos en nuestra BBDD de clientes.
	 */
	
	@GetMapping("/cantidad")
    public List<Direccione> verClientesPorLocalidad() {
        return ddao.clientesPorLocalidad();
    }
}
