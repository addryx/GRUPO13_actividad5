package com.tienda.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tienda.modelo.beans.Producto;
import com.tienda.modelo.service.ProductoService;

@RestController
@RequestMapping("/rest/productos")
public class ProductoRest {

	@Autowired
	ProductoService pserv;
	
	
	@GetMapping("/todos")
	public List<Producto> todos() {
		return pserv.buscarTodos();
	}
	
	@GetMapping("/verUno/{id}")
	public Producto verUno(@PathVariable(name="id_producto") int  idProducto) {
		Producto producto = pserv.buscarUno(idProducto);
		return producto;
	}
	

	@GetMapping("/alta")
	public String enviarFormulario() {

		return "formProducto";
	}
	
	@DeleteMapping("/eliminar/{id}")
	public String eliminar(Model model, @PathVariable(name="id_producto") int  idProducto) {
		
		if (pserv.borrarProducto(idProducto))
			model.addAttribute("mensaje", "producto eliminado");
		else
			model.addAttribute("mensaje", "producto NOOO eliminado");
		
	//	return "redirect:/app/producto/index";
		return "forward:/";
	}
	
	@PostMapping("/alta")
	public String procesarFormulario(Model model,Producto producto ) {
		
		
		System.out.println(producto);
		
		pserv.insertarProducto(producto);
		
		System.out.println(producto);
	 
	 	return "redirect:/";
	}
	
	@GetMapping("/editar/{id}")
	public String enviarFormularioEditar(Model model, @PathVariable(name="id_producto") int idProducto) {
		//model.addAttribute("producto", pserv.buscarUno(idProducto));
		return "formProductoEditar";
	}
	
	@PostMapping("/modificar")
	public String procesarFormularioEditar(Model model,Producto producto ) {
		
		System.out.println(producto);
		
	 	pserv.modificarProducto(producto);
	//	System.out.println(producto);
	  	return "redirect:/"; 
	}
	
	

}
