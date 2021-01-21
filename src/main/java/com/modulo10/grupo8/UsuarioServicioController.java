
package com.modulo10.grupo8;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class UsuarioServicioController {

	
	@GetMapping("/pruebaU")
	public String pruebaU() {
		return "hola";
	}

}				
