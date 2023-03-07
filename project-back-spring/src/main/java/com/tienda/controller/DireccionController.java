package com.tienda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tienda.modelo.beans.Direccione;
import com.tienda.modelo.dao.IntDireccioneDao;

@Controller
@RequestMapping("/direcciones")
public class DireccionController {

	@Autowired
	IntDireccioneDao ddao;
	
	@GetMapping("/todos")
	public String verDirecciones(Model model, Authentication aut) {
		List<Direccione> lista = ddao.buscarTodos();
		model.addAttribute("listaTodasDirecciones", lista);
		return "";
	}
	
}
