package com.modulo10.grupo8.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.modulo10.grupo8.RecordNotFoundException;
import com.modulo10.grupo8.entities.prestamos;
import com.modulo10.grupo8.entities.productosDadosDeBaja;
import com.modulo10.grupo8.servies.productosDadosDeBajaService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class productosDadosDeBajaController {
	
	@Autowired
	productosDadosDeBajaService servicePrestamos;
	
	
	@GetMapping("/productosBaja")
	public ResponseEntity<List<productosDadosDeBaja>> getAll() {
		List<productosDadosDeBaja> list = servicePrestamos.getAll();
		return new ResponseEntity<List<productosDadosDeBaja>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/productoBaja/{id}")
	public ResponseEntity<productosDadosDeBaja> getProductoBajaById(@PathVariable("id") String id) throws RecordNotFoundException {
		productosDadosDeBaja entity = servicePrestamos.findById(id);
		return new ResponseEntity<productosDadosDeBaja>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/productoBaja/create")
	public ResponseEntity<productosDadosDeBaja> createProductosBaja(@RequestParam("productosDadosDeBaja") String s) throws JsonMappingException, JsonProcessingException, RecordNotFoundException{
		
		ObjectMapper om = new ObjectMapper();
		productosDadosDeBaja usuarioServicio=om.readValue(s, productosDadosDeBaja[].class)[0];
		
		servicePrestamos.createProductosBaja(usuarioServicio);
		return new ResponseEntity<productosDadosDeBaja>(usuarioServicio, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/productoBaja/update")
	public ResponseEntity<productosDadosDeBaja> updateProductosBaja(@RequestParam("productosDadosDeBaja") String s) throws RecordNotFoundException, JsonMappingException, JsonProcessingException{
		
		ObjectMapper om = new ObjectMapper();
		productosDadosDeBaja prestamosService=om.readValue(s, productosDadosDeBaja[].class)[0];
		
		servicePrestamos.updateProductosBaja(prestamosService);
		return new ResponseEntity<productosDadosDeBaja>(prestamosService, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/productoBaja/delete/{id}")
	public HttpStatus deleteProductosBajaById(@PathVariable("id") String id) throws RecordNotFoundException {
		servicePrestamos.deleteProductosBajaById(id);
		return HttpStatus.OK;
	}
	
	@PutMapping("/productoBaja/deBaja/{idP}/{idU}")
	public ResponseEntity<productosDadosDeBaja> getForUser(@PathVariable("idP") String idP,@PathVariable("idU") String idU) throws RecordNotFoundException {
		productosDadosDeBaja objPrestamo = servicePrestamos.darDeBaja(idP,idU);
		return new ResponseEntity<productosDadosDeBaja>(objPrestamo, new HttpHeaders(), HttpStatus.OK);
	}
	
}
