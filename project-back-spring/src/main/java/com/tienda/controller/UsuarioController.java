package com.tienda.controller;

import java.net.UnknownServiceException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tienda.modelo.beans.Direccione;
import com.tienda.modelo.beans.Tarjeta;
import com.tienda.modelo.beans.Usuario;
import com.tienda.modelo.dao.IntRoleDao;
import com.tienda.modelo.dao.IntUsuarioDao;
import com.tienda.modelo.dao.UsuarioDaoImplMy8;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	/**
	 * @Autowired Usuario user;
	 */

	@Autowired
	IntUsuarioDao udao;

	@Autowired
	IntRoleDao rdao;

	@Autowired
	UsuarioDaoImplMy8 urepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping("/alta")
	public String enviarFormAltaUsuario() {
		return "formAltaUsuario";
	}

	@PostMapping("/alta")
	public String proregistrar(Model model, Usuario usuario, @RequestParam("fechaNacimiento") String fechaNacimiento,
			RedirectAttributes ratt) {

		usuario.addRole(rdao.buscarRole(2));
		usuario.setNombre(usuario.getNombre());
		usuario.setApellidos(usuario.getApellidos());
		usuario.setFechaNacimiento(usuario.getFechaNacimiento());
		usuario.setEmail(usuario.getEmail());
		usuario.setContrasena(passwordEncoder.encode(usuario.getContrasena()));
		usuario.setEnabled(1);

		if (udao.altaUsuario(usuario) == 0) {
			ratt.addFlashAttribute("mensaje", "Alta realizada correctamente.");
			return "redirect:/usuarios";
		} else {
			model.addAttribute("mensaje", "Ya existe este usuario.");
			return "redirect:/alta";
		}
	}

	@GetMapping("/ver/{id}")
	public String verDatosUsuario(Model model, @PathVariable(name = "id") int idUsuario) {
		Usuario usuario = udao.buscarUno(idUsuario);
		model.addAttribute("usuario", usuario);
		List<Usuario> lista = udao.datosUsuario(idUsuario);
		model.addAttribute("datosUsuario", lista);
		return "datosUsuario";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarUsuario(Model model, @PathVariable(name = "id") int idUsuario) {
		udao.bajaUsuario(idUsuario);
		return "redirect:/usuarios";
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

	// Añadir tarjetas
	@GetMapping("/darAltaTarjeta")
	public String altaTarjeta() {
		return "insertarTarjeta";
	}

	@PostMapping("/darAltaTarjeta")
	public void altaTarjeta(Model model, Tarjeta tarjeta, HttpSession sesion,
			@RequestParam("idUsuario") int idUsuario) {
		Usuario usuario = urepo.buscarUno(idUsuario);
		usuario.addTarjeta(tarjeta);
		urepo.save(usuario);
	}

	// Añadir direcciones
	@GetMapping("/darAltaDireccion")
	public String altaDireccion() {
		return "insertarDireccion";
	}

	@PostMapping("/darAltaDireccion")
	public void altaDireccion(Model model, Direccione direccion, HttpSession sesion,
			@RequestParam("idUsuario") int idUsuario) {
		Usuario usuario = urepo.buscarUno(idUsuario);
		usuario.addDireccion(direccion);
		urepo.save(usuario);
	}
}
