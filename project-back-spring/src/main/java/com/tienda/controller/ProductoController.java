package com.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.modelo.beans.Producto;
import com.tienda.modelo.dao.IntProductoDao;

@Controller
@RequestMapping("/producto")
public class ProductoController {

	@Autowired
	IntProductoDao pdao;
	
	@GetMapping("/verDetalle/{id}")
	public String verUno(Model model, @PathVariable(name="id") int  idProducto) {
		Producto producto = pdao.buscarUno(idProducto);
		model.addAttribute("producto", producto);
		return "detalleProducto";
	}
	
	@GetMapping("/alta")
	public String enviarFormularioAlta(Model model) {
		return "formAltaProducto";
	}
	
	@PostMapping("/alta")
	public String altaProducto(Model model, Producto producto){
		pdao.insertarProducto(producto);
		return "redirect:/catalogo";
	}
	
	@GetMapping("/editar/{id}")
	public String enviarFormularioEditar(Model model, @PathVariable(name="id") int idProducto) {
		model.addAttribute("producto", pdao.buscarUno(idProducto));
		return "formEditarProducto";
	}
	
	@PostMapping("/editar")
	public String editarProducto(Model model, Producto producto){
		pdao.modificarProducto(producto);
		return "redirect:/catalogo";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminar(Model model, @PathVariable(name="id") int  idProducto) {
		if (pdao.borrarProducto(idProducto) == 1) {
			model.addAttribute("mensaje", "Producto eliminado correctamente.");
		}else {
			model.addAttribute("mensaje", "El producto no ha podido ser eliminado.");
		}
		return "redirect:/catalogo";
	}
	
	@PostMapping("/busqueda")
	public String busquedaProducto(Model model, @Param("nombre") String nombre){
		List<Producto> lista = pdao.buscadorProductos(nombre);
		model.addAttribute("listaCatalogoBusqueda", lista);
		return "/catalogoBusqueda";
	}
}
