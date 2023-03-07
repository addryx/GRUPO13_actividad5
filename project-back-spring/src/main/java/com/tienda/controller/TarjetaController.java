package com.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.modelo.beans.Tarjeta;
import com.tienda.modelo.dao.IntTarjetaDao;
import com.tienda.repository.UsuarioRepository;

@Controller
@RequestMapping("/tarjetas")
public class TarjetaController {

	@Autowired
	IntTarjetaDao tdao;
	
	@Autowired
	UsuarioRepository urepo;
	
	@GetMapping("/todos")
	public String verTarjetas(Model model, @AuthenticationPrincipal UserDetails userDetails, Authentication aut) {
		List<Tarjeta> lista = urepo.tarjetaUsuario(userDetails.getUsername());
		model.addAttribute("listaTodasTarjetas", lista);
		return "tarjetas";
	}
	
}
