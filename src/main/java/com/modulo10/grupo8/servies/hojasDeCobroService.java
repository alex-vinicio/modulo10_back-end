package com.modulo10.grupo8.servies;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modulo10.grupo8.RecordNotFoundException;
import com.modulo10.grupo8.entities.hojasDeCobro;
import com.modulo10.grupo8.repository.hojasDeCobroRepository;
import com.modulo10.grupo8.repository.usuarioRepository;

@Service
public class hojasDeCobroService {
	@Autowired
	hojasDeCobroRepository repository;
	
	@Autowired
	 usuarioRepository repositoryUser;
	
	public List<hojasDeCobro> getAll(){
		List<hojasDeCobro> prestamosList = repository.findAll();
		if(prestamosList.size() > 0) {
			return prestamosList; 
		} else { 
			return new ArrayList<hojasDeCobro>();
		}
	}
	public hojasDeCobro findById(String id) throws RecordNotFoundException{
		Optional<hojasDeCobro> usuarioServicio = repository.findByIdHojaDeCobro(id);
		if(usuarioServicio.isPresent()) {
			return usuarioServicio.get();
		} else {
			throw new RecordNotFoundException("Prestamo no encontrado");
		}
	}
	public hojasDeCobro createHojaDeCobro(hojasDeCobro prestamos)throws RecordNotFoundException{
		Optional<hojasDeCobro> prestamosTemp = repository.findByIdHojaDeCobro(prestamos.getIdHojaDeCobro());
		
		if(prestamosTemp.isPresent()){
			throw new RecordNotFoundException("Id del prestamo repetido");
		}else {
			return repository.save(prestamos);
		}
	}
	
	public hojasDeCobro updateHojaDeCobro(hojasDeCobro prestamos) throws RecordNotFoundException {
		Optional<hojasDeCobro> prestamosTemp = repository.findByIdHojaDeCobro(prestamos.getIdHojaDeCobro());
		
		if(prestamosTemp.isPresent()){
			return repository.save(prestamos);
		} else {
			throw new RecordNotFoundException("Prestamo no encontrado");
		}
	}
	public void deleteHojaDeCobroById(String id) throws RecordNotFoundException{
		Optional<hojasDeCobro> prestamos = repository.findByIdHojaDeCobro(id);
		if(prestamos.isPresent()) {
			repository.deleteByIdHojaDeCobro(id);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}	
	
	public List<hojasDeCobro> findBySector(String valor){
		
       return repository.findBySector(valor);
	}
	
	public void comprobarHojaDeCobroByIdUsuario(String id) throws RecordNotFoundException{
		Optional<hojasDeCobro> prestamos = repository.findByFkCiUsuario(id);
		if(prestamos.isPresent()) {
			throw new RecordNotFoundException("Prestamo ya existente");
		} else {
			throw new RecordNotFoundException("Prestamo no encontrado");
	}	
	
	}
}
