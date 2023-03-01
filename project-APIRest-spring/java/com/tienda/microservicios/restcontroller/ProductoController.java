package com.tienda.microservicios.restcontroller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.microservicios.modelo.entities.Producto;
import com.tienda.microservicios.modelo.services.IntProductoServices;

public class ProductoController {
	
	@RestController
	@RequestMapping("/producto")
	public class productoController {
		
		@Autowired
		private IntProductoServices pservices;
		
		@GetMapping("/precio/{id}")
		public ResponseEntity<BigDecimal> visualizarPrecio(Model model, Producto producto, @RequestParam("id") int idProducto){
			
			BigDecimal precio = pservices.consultaPrecio(idProducto);
			if  (precio == null) {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<>(precio, HttpStatus.OK);
		}
	}
}
