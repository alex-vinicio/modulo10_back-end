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
	 
//	 @Autowired
//	 usuarioRepository repositoryUser;
	
	public List<prestamos> getAll(){
		List<prestamos> prestamosList = repository.findAll();
		if(prestamosList.size() > 0) {
			return prestamosList; 
		} else { 
			return new ArrayList<prestamos>();
		}
	}
	public prestamos findById(String id) throws RecordNotFoundException{
		Optional<prestamos> usuarioServicio = repository.findByIdPrestamosEmpleados(id);
		if(usuarioServicio.isPresent()) {
			return usuarioServicio.get();
		} else {
			throw new RecordNotFoundException("Prestamo no encontrado");
		}
	}
	public prestamos createPrestamo(prestamos prestamos)throws RecordNotFoundException{
		Optional<prestamos> prestamosTemp = repository.findByIdPrestamosEmpleados(prestamos.getIdPrestamosEmpleados());
		
		//usuario userEmpleado = repositoryUser.findById(idUE)
		//usuario userRecursosHumanos = repositoryUser.findById(idURH)
//		if(userEmpleado.getTipoUsuario() == 2 || userRecursosHumanos.getTipoUsuario() == 1 || prestamos.get) {
//			
//		}else {
//			throw new RecordNotFoundException("usuario no valido");
//		}
//		
		if(prestamosTemp.isPresent()){
			throw new RecordNotFoundException("Id del prestamo repetido");
		}else {
			if(prestamos.getMontoPrestamo() <= 400 /*userEmpleado.getValorSueldo() */) {
				return repository.save(prestamos);
			}else {
				throw new RecordNotFoundException("Monto excedido a su sueldo!");
			}
			
		}
	}
	
	public prestamos updatePrestamo(prestamos prestamos) throws RecordNotFoundException {
		Optional<prestamos> prestamosTemp = repository.findByIdPrestamosEmpleados(prestamos.getIdPrestamosEmpleados());
		//usuario userEmpleado = repositoryUser.findById(idUE)
		//usuario userRecursosHumanos = repositoryUser.findById(idURH)
//		if(userEmpleado.getTipoUsuario() == 2) {
//					
//		}else {
//			throw new RecordNotFoundException("usuario no valido");
//		}
		if(prestamosTemp.isPresent()){
			return repository.save(prestamos);
		} else {
			throw new RecordNotFoundException("Prestamo no encontrado");
		}
	}
	public void deletePrestamoById(String id) throws RecordNotFoundException{
		Optional<prestamos> prestamos = repository.findByIdPrestamosEmpleados(id);
		if(prestamos.isPresent()) {
			repository.deleteByIdPrestamosEmpleados(id);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}	
	
	public List<prestamos> findByUsuario(String idU){
		
        return repository.findByFkEmpleadoPrestamo(idU);
	}
	
	public prestamos findByMontoPrestamoEmpleado(float valor){
		
        return repository.findByMontoPrestamo(valor);
	}
	
	public Boolean aprobacionPrestamo(prestamos prestamo,Boolean check) {
		
		prestamo.setEstadoPrestamo(check);
		repository.save(prestamo);
		
		return true;
	}
}