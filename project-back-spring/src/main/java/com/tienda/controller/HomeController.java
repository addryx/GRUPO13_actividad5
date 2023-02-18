package com.tienda.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tienda.modelo.beans.Usuario;
import com.tienda.modelo.dao.IntProductoDao;
import com.tienda.modelo.dao.IntRoleDao;
import com.tienda.modelo.dao.IntUsuarioDao;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	IntProductoDao pdao;
	@Autowired
	IntUsuarioDao udao;
	@Autowired
	IntRoleDao rdao;
	// @Autowired
	// private PasswordEncoder passwordEncoder;

	/**
	 * Aquí puede entrar cualquier usuario sin autenticarse.
	 * 
	 * @param model
	 * @param aut
	 * @return
	 */
	@GetMapping("/")
	public String verHome(Model model, Authentication aut) {
		return "home";
	}

	@GetMapping("/registro")
	public String registrar(Model model) {
		// model.addAttribute("mensaje", "registrando");
		return "registro";
	}

	/**
	 * Hay que crear un objeto con @Autowired de PasswordEncoder. Y cuando el
	 * usuario meta un password, se le encripta con el encode.
	 * 
	 * @param model
	 * @param usuario
	 * @param ratt
	 * @return
	 */
	@PostMapping("/registro")
	public String proregistrar(Model model, Usuario usuario, RedirectAttributes ratt) {

		usuario.setIdUsuario(usuario.getIdUsuario());
		usuario.setNombre(usuario.getNombre());
		usuario.setApellidos(usuario.getApellidos());
		usuario.setFechaNacimiento(usuario.getFechaNacimiento());
		usuario.setEmail(usuario.getEmail());
		usuario.setContrasena(usuario.getContrasena());
		// usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
		usuario.setEnabled(1);
		usuario.addRole(rdao.buscarRole(1));

		if (udao.altaUsuario(usuario)==0) {
			ratt.addFlashAttribute("mensaje", "alta realizada");
			return "redirect:/login";
		} else {
			model.addAttribute("mensaje", "ya existe como usuario");
			return "/registro";
		}
	}
}
