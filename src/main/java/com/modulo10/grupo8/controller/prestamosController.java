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
import com.modulo10.grupo8.servies.prestamosService;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class prestamosController {
	@Autowired
	prestamosService servicePrestamos;
	
	
	@GetMapping("/prestamos")
	public ResponseEntity<List<prestamos>> getAll() {
		List<prestamos> list = servicePrestamos.getAll();
		return new ResponseEntity<List<prestamos>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	@GetMapping("/prueba")
	public String getPrueba() {
		return "hola esto es una prueba!";
	}
	@GetMapping("/prestamo/{id}")
	public ResponseEntity<prestamos> getPrestamoById(@PathVariable("id") String id) throws RecordNotFoundException {
		prestamos entity = servicePrestamos.findById(id);
		return new ResponseEntity<prestamos>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/prestamo/create")
	public ResponseEntity<prestamos> createPrestamo(@RequestParam("prestamos") String s) throws JsonMappingException, JsonProcessingException, RecordNotFoundException{
		
		ObjectMapper om = new ObjectMapper();
		prestamos usuarioServicio=om.readValue(s, prestamos[].class)[0];
		
		servicePrestamos.createPrestamo(usuarioServicio);
		return new ResponseEntity<prestamos>(usuarioServicio, new HttpHeaders(), HttpStatus.OK);
	}

	@PutMapping("/prestamo/update")
	public ResponseEntity<prestamos> updatePrestamo(@RequestParam("prestamoEmpleado") String s) throws RecordNotFoundException, JsonMappingException, JsonProcessingException{
		
		ObjectMapper om = new ObjectMapper();
		prestamos prestamosService=om.readValue(s, prestamos[].class)[0];
		
		servicePrestamos.updatePrestamo(prestamosService);
		return new ResponseEntity<prestamos>(prestamosService, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/prestamo/delete/{id}")
	public HttpStatus deletePrestamoById(@PathVariable("id") String id) throws RecordNotFoundException {
		servicePrestamos.deletePrestamoById(id);
		return HttpStatus.OK;
	}
	
	
	@PutMapping("/prestamo/aprobacion/{id}/{aporbacion}")
	public ResponseEntity<Boolean> aprobracionPrestamo(@PathVariable("id") String id, @PathVariable("aprobacion") Boolean check) throws RecordNotFoundException, JsonMappingException, JsonProcessingException{
		
		prestamos entity = servicePrestamos.findById(id);
		if(entity == null){
			throw new RecordNotFoundException("Id del prestamo repetido");
		}else {
			if(entity.getEstadoPrestamo() == true) {
			Boolean value = servicePrestamos.aprobacionPrestamo(entity,check);
			return new ResponseEntity<Boolean>(value, new HttpHeaders(), HttpStatus.OK);
			}else {
				throw new RecordNotFoundException("Cancele el prestamo acual");
			}
		}
	}
	@GetMapping("/prestamosPorUsuario/{id}")
	public ResponseEntity<List<prestamos>> getForUser(@PathVariable("id") String id) {
		List<prestamos> list = servicePrestamos.findByUsuario(id);
		return new ResponseEntity<List<prestamos>>(list, new HttpHeaders(), HttpStatus.OK);
	}
}				
