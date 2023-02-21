package com.tienda.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class PasswordRestController {

	@Autowired
	private PasswordEncoder passwordEncoder;

	/**
	 * Creamos un servicio rest para encriptar las contraseñas que ya existían en la
	 * BBDD.
	 * 
	 * Le paso el passwordEncode al pass que le entra por parámetro, y se le encode.
	 * 
	 * @param password llega por PathVariable la pass.
	 * 
	 * @return devuelve la pass encriptada y se la insertamos al usuario.
	 */
	@GetMapping("/demo-bcrypt/{pass}")
	public String pruebaBcrypt(@PathVariable("pass") String password) {
		// String password = "tomasin";
		String encriptado = passwordEncoder.encode(password);
		// System.out.println("Password encriptado: " + encriptado);
		return encriptado;
	}
}
