package com.modulo10.grupo8.servies;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modulo10.grupo8.RecordNotFoundException;
import com.modulo10.grupo8.entities.prestamos;
import com.modulo10.grupo8.repository.prestamosRepository;


@Service
public class prestamosService{
	
	 @Autowired
	 prestamosRepository repository;
	
	public List<prestamos> getAll(){
		List<prestamos> prestamosList = repository.findAll();
		if(prestamosList.size() > 0) {
			return prestamosList; 
		} else { 
			return new ArrayList<prestamos>();
		}
	}
	public prestamos findById(String id) throws RecordNotFoundException{
		Optional<prestamos> usuarioServicio = repository.findByIdPrestamo(id);
		if(usuarioServicio.isPresent()) {
			return usuarioServicio.get();
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}
	public prestamos createPrestamo(prestamos prestamos)throws RecordNotFoundException{
		Optional<prestamos> prestamosTemp = repository.findByIdPrestamo(prestamos.getIdPrestamo());
		
		if(prestamosTemp.isPresent()){
			throw new RecordNotFoundException("Id del prestamo repetido");
		}else {
			return repository.save(prestamos);
		}
	}
	
	public prestamos updatePrestamo(prestamos prestamos) throws RecordNotFoundException {
		Optional<prestamos> prestamosTemp = repository.findByIdPrestamo(prestamos.getIdPrestamo());
		
		if(prestamosTemp.isPresent()){
			return repository.save(prestamos);
		} else {
			throw new RecordNotFoundException("Prestamo no encontrado");
		}
	}
	public void deletePrestamoById(String id) throws RecordNotFoundException{
		Optional<prestamos> prestamos = repository.findByIdPrestamo(id);
		if(prestamos.isPresent()) {
			repository.deleteByIdPrestamo(id);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}	
	
	public prestamos findByMontoPrestamoEmpleado(float valor){
		
        return repository.findByMontoPrestamoEmpleado(valor);
	}
}