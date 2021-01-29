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
import com.modulo10.grupo8.entities.hojasDeCobro;
import com.modulo10.grupo8.servies.hojasDeCobroService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class hojasCobroController {
	@Autowired
	hojasDeCobroService serviceHojaCobro;
	
	
	@GetMapping("/hojasDeCobros")
	public ResponseEntity<List<hojasDeCobro>> getAll() {
		List<hojasDeCobro> list = serviceHojaCobro.getAll();
		return new ResponseEntity<List<hojasDeCobro>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/hojasDeCobro/{id}")
	public ResponseEntity<hojasDeCobro> getHojaCobroById(@PathVariable("id") String id) throws RecordNotFoundException {
		hojasDeCobro entity = serviceHojaCobro.findById(id);
		return new ResponseEntity<hojasDeCobro>(entity, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/hojasDeCobro/{fkCiUsuario}")
	
	public ResponseEntity<hojasDeCobro> getComprobacionId(@PathVariable("fkCiUsuario") String fkCiUsuario) throws RecordNotFoundException {
			hojasDeCobro entity = serviceHojaCobro.findById(fkCiUsuario);
			return new ResponseEntity<hojasDeCobro>(entity, new HttpHeaders(), HttpStatus.OK);
	
	}

	@PostMapping("/hojasDeCobro/create")
	public ResponseEntity<hojasDeCobro> createHojaDeCobro(@RequestParam("productosDadosDeBaja") String s) throws JsonMappingException, JsonProcessingException, RecordNotFoundException{
		
		ObjectMapper om = new ObjectMapper();
		hojasDeCobro usuarioServicio=om.readValue(s, hojasDeCobro[].class)[0];
		
		serviceHojaCobro.createHojaDeCobro(usuarioServicio);
		return new ResponseEntity<hojasDeCobro>(usuarioServicio, new HttpHeaders(), HttpStatus.OK);
		
	}
	

	@PutMapping("/hojasDeCobro/update")
	public ResponseEntity<hojasDeCobro> updateHojaDeCobro(@RequestParam("productosDadosDeBaja") String s) throws RecordNotFoundException, JsonMappingException, JsonProcessingException{
		
		ObjectMapper om = new ObjectMapper();
		hojasDeCobro prestamosService=om.readValue(s, hojasDeCobro[].class)[0];
		
		serviceHojaCobro.updateHojaDeCobro(prestamosService);
		return new ResponseEntity<hojasDeCobro>(prestamosService, new HttpHeaders(), HttpStatus.OK);
	}

	@DeleteMapping("/hojasDeCobro/delete/{id}")
	public HttpStatus deleteHojaDeCobroById(@PathVariable("id") String id) throws RecordNotFoundException {
		serviceHojaCobro.deleteHojaDeCobroById(id);
		return HttpStatus.OK;
	}
	
	
}
