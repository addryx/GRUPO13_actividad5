package com.tienda.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.modelo.beans.Usuario;
import com.tienda.modelo.dao.IntUsuarioDao;

@Controller
@RequestMapping("/app/usuario")
public class UsuarioController {
	@Autowired
	IntUsuarioDao udao;
	
	@GetMapping("/alta")
	public String enviarFormAltaCliente () {
		return "registrarClientes";
	}
	
	@PostMapping("/alta")
	public String procesarFormulario(Model model, Usuario usuario) {
		
		System.out.println(usuario);
		udao.altaUsuario(usuario);
		System.out.println(usuario);
		return "redirect:/";
	}
	
	@GetMapping("/eliminar/{id}")
	public String eliminarUsuario(Model model, @PathVariable(name = "id") int idUsuario) {
		
		if (udao.bajaUsuario(idUsuario) == 1)
			model.addAttribute("mensaje", "Usuario dado de baja correctamente.");
		else
			model.addAttribute("mensaje", "El usuario no se ha podido eliminar.");
		return "forward:/";
	}
	
	@GetMapping("/verTodos")
	public String verUsuarios(Model model) {
		model.addAttribute("mensaje", "Listado de usuarios.");
		return "listadoUsuarios";
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(
	            dateFormat, false));
	}
	
}
