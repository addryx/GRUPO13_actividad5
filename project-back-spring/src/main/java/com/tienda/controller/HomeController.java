package com.tienda.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tienda.modelo.beans.Producto;
import com.tienda.modelo.beans.Usuario;
import com.tienda.modelo.dao.IntProductoDao;
import com.tienda.modelo.dao.IntRoleDao;
import com.tienda.modelo.dao.IntUsuarioDao;

@Controller
public class HomeController {

	@Autowired
	IntProductoDao pdao;
	@Autowired
	IntUsuarioDao udao;
	@Autowired
	IntRoleDao rdao;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/")
	public String verHome(Model model, Authentication aut) {
		return "home";
	}

	@GetMapping("/catalogo")
	public String verCatalogo(Model model, Authentication aut) {
		List<Producto> lista = pdao.buscarTodos();
		model.addAttribute("listaTodosProductos", lista);
		return "catalogo";
	}
	
	@GetMapping("/usuarios")
	public String verUsuarios(Model model, Authentication aut) {
		List<Usuario> lista = udao.buscarTodos();
		model.addAttribute("listaTodosUsuarios", lista);
		return "usuarios";
	}

	@GetMapping("/login")
	public String procesarLogin(Authentication aut, Model model, HttpSession misesion) {
		return null;
	}

	@GetMapping("/registro")
	public String registrar(Model model) {
		return "formRegistro";
	}

	@PostMapping("/registro")
	public String proregistrar(Model model, Usuario usuario, @RequestParam("fechaNacimiento") String fechaNacimiento, RedirectAttributes ratt) {

		usuario.setNombre(usuario.getNombre());
		usuario.setApellidos(usuario.getApellidos());
		usuario.setFechaNacimiento(usuario.getFechaNacimiento());
		usuario.setEmail(usuario.getEmail());
		usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
		usuario.setEnabled(1);
		usuario.addRole(rdao.buscarRole(1));

		if (udao.altaUsuario(usuario) == 0) {
			ratt.addFlashAttribute("mensaje", "Alta realizada correctamente.");
			return "redirect:/login";
		} else {
			model.addAttribute("mensaje", "Ya existe este usuario.");
			return "redirect:/registro";
		}
	}
	
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(
	            dateFormat, false));
	}

}
