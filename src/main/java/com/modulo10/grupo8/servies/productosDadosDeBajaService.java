package com.modulo10.grupo8.servies;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modulo10.grupo8.RecordNotFoundException;
import com.modulo10.grupo8.entities.productosDadosDeBaja;
import com.modulo10.grupo8.repository.productosDadosDdeBajaRepository;

@Service
public class productosDadosDeBajaService {
	@Autowired
	productosDadosDdeBajaRepository repository;
	
	public List<productosDadosDeBaja> getAll(){
		List<productosDadosDeBaja> prestamosList = repository.findAll();
		if(prestamosList.size() > 0) {
			return prestamosList; 
		} else { 
			return new ArrayList<productosDadosDeBaja>();
		}
	}
	public productosDadosDeBaja findById(String id) throws RecordNotFoundException{
		Optional<productosDadosDeBaja> usuarioServicio = repository.findByIdProductoDadoDeBaja(id);
		if(usuarioServicio.isPresent()) {
			return usuarioServicio.get();
		} else {
			throw new RecordNotFoundException("Prestamo no encontrado");
		}
	}
	public productosDadosDeBaja createProductosBaja(productosDadosDeBaja prestamos)throws RecordNotFoundException{
		Optional<productosDadosDeBaja> prestamosTemp = repository.findByIdProductoDadoDeBaja(prestamos.getIdProductoDadoDeBaja());
		
		if(prestamosTemp.isPresent()){
			throw new RecordNotFoundException("Id del prestamo repetido");
		}else {
			return repository.save(prestamos);
		}
	}
	
	public productosDadosDeBaja updateProductosBaja(productosDadosDeBaja prestamos) throws RecordNotFoundException {
		Optional<productosDadosDeBaja> prestamosTemp = repository.findByIdProductoDadoDeBaja(prestamos.getIdProductoDadoDeBaja());
		
		if(prestamosTemp.isPresent()){
			return repository.save(prestamos);
		} else {
			throw new RecordNotFoundException("Prestamo no encontrado");
		}
	}
	public void deleteProductosBajaById(String id) throws RecordNotFoundException{
		Optional<productosDadosDeBaja> prestamos = repository.findByIdProductoDadoDeBaja(id);
		if(prestamos.isPresent()) {
			repository.deleteByIdProductoDadoDeBaja(id);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
	}	
	
	public List<productosDadosDeBaja> findByFechaOperacion(String valor){
		
       return repository.findByfechaProductoDadoDeBaja(valor);
	}
	public productosDadosDeBaja darDeBaja(String idP,String idU) {
		Optional<productosDadosDeBaja> prestamosTemp = repository.findByIdProductoDadoDeBaja(idP);
		
		if(prestamosTemp.isPresent()) {
			productosDadosDeBaja producto = prestamosTemp.get();
			repository.deleteByIdProductoDadoDeBaja(idP);	
			producto.setFkCiUsuario(idU);
			producto.setCiUsuario(idU);
			producto.setEstadoP(false);
			producto.setAccion("De baja");
			//generar fecha actual de operacion
			Calendar fecha = new GregorianCalendar();
			int año = fecha.get(Calendar.YEAR);
	        int mes = fecha.get(Calendar.MONTH);
	        int dia = fecha.get(Calendar.DAY_OF_MONTH);
	        int hora = fecha.get(Calendar.HOUR_OF_DAY);
	        int minuto = fecha.get(Calendar.MINUTE);
	        int segundo = fecha.get(Calendar.SECOND);
	        
	        String fechaOp = "" + dia + "/" + (mes+1) + "/" + año+" : "+hora+":"+minuto+":"+segundo;
			producto.setFechaProductoDadoDeBaja(fechaOp);
			return repository.save(producto);
		} else {
			throw new RecordNotFoundException("Record does not exist for the given Id");
		}
		
	}
}
