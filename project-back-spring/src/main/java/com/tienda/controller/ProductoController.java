package com.tienda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.modelo.beans.Producto;
import com.tienda.modelo.dao.IntProductoDao;

@Controller
@RequestMapping("/app/producto")
public class ProductoController {
	@Autowired
	IntProductoDao pdao;
	
	@GetMapping("/verUno/{id}")
	public String verUno(Model model, @PathVariable(name="id") int  idProducto) {
		
		Producto producto = pdao.buscarUno(idProducto);
		model.addAttribute("producto", producto);
		
		return "verUnProducto";
	}
	
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(Model model, @PathVariable(name="id") int  codigo) {
		
		if (pdao.borrarProducto(codigo) == 1)
			model.addAttribute("mensaje", "producto eliminado");
		else
			model.addAttribute("mensaje", "producto NOOO eliminado");
		
	//	return "redirect:/app/producto/index";
		return "forward:/";
		 
		
	}
	
	@GetMapping("/alta")
	public String enviarFormulario() {
		
		
		return "formProducto";
		 
		
	}
	@PostMapping("/alta")
	public String procesarFormulario(Model model,Producto producto ) {
		
		
		System.out.println(producto);
		
		pdao.insertarProducto(producto);
		
		System.out.println(producto);
	 
		
	 	return "redirect:/";
		 
		
	}
	
	@GetMapping("/editar/{id}")
	public String enviarFormularioEditar(Model model, @PathVariable(name="id") int codigo) {
		
		 
		
		model.addAttribute("producto", pdao.buscarUno(codigo));
		return "formProductoEditar";
		 
		
	}
	@PostMapping("/modificar")
	public String procesarFormularioEditar(Model model,Producto producto ) {
		
		
		System.out.println(producto);
		
	 	pdao.modificarProducto(producto);
		
	//	System.out.println(producto);
	  	return "redirect:/";
		 
		 
	}
	
	@GetMapping("/ver")
	public String verUsuarios(Model model) {
		model.addAttribute("mensaje", "Listado de usuarios");
		return "pruebas";
	}
	
	

}