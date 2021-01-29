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
	
	
	@GetMapping("/prestamos")//lista todos los prestamos
	public ResponseEntity<List<prestamos>> getAll() {
		List<prestamos> list = servicePrestamos.getAll();
		return new ResponseEntity<List<prestamos>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/prestamo/{id}") //busca un prestamo segun su id
	public ResponseEntity<prestamos> getPrestamoById(@PathVariable("id") String id) throws RecordNotFoundException {
		prestamos entity = servicePrestamos.findById(id);
		return new ResponseEntity<prestamos>(entity, new HttpHeaders(), HttpStatus.OK);
	}

	@PostMapping("/prestamo/solicitarPrestamo") //
	public ResponseEntity<prestamos> createPrestamo(@RequestParam("prestamos") String s) throws JsonMappingException, JsonProcessingException, RecordNotFoundException{
		
		ObjectMapper om = new ObjectMapper();
		prestamos usuarioServicio=om.readValue(s, prestamos[].class)[0];
		
		servicePrestamos.createPrestamo(usuarioServicio); //envia el objeto prestamo y el idUsuario logeado del front-end
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
	
	
	@PutMapping("/prestamo/aprobacion/{idPrestamo}/{aporbacion}/{idUsuario}")//controller para aprobar un prestamo, este solo es llamado por el usuario admin
	public boolean aprobracionPrestamo(@PathVariable("idPrestamo") String idP, @PathVariable("aprobacion") Boolean check,@PathVariable("idUsuario") String idU) throws RecordNotFoundException, JsonMappingException, JsonProcessingException{
		boolean value = servicePrestamos.aprobacionPrestamo(idP,check,idU);	
		if(value == true) {
				return value;
			}else {
				throw new RecordNotFoundException("Cancele el prestamo acual");
		}
	}

	@GetMapping("/prestamos/pago/{idP}/{cantidad}/{idU}")//
	public ResponseEntity<prestamos> getForUser(@PathVariable("idP") String idP,@PathVariable("cantidad") float cantidad,@PathVariable("idU") String idU) throws RecordNotFoundException {
		prestamos objPrestamo = servicePrestamos.pagoPrestamo(idP,cantidad,idU);
		return new ResponseEntity<prestamos>(objPrestamo, new HttpHeaders(), HttpStatus.OK);
	}
}				
