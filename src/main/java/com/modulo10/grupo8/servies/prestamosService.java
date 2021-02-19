package com.modulo10.grupo8.servies;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.modulo10.grupo8.RecordNotFoundException;
import com.modulo10.grupo8.entities.prestamos;
import com.modulo10.grupo8.entities.usuario;
import com.modulo10.grupo8.repository.prestamosRepository;
import com.modulo10.grupo8.repository.productosRepository;
import com.modulo10.grupo8.repository.usuarioRepository;


@Service
public class prestamosService{
	
	 @Autowired
	 prestamosRepository repository;
	 
	 @Autowired
	 usuarioRepository repositoryUser;
	 
	 @Autowired
	 productosRepository repositoryProduct; //Importamos el repository de producto y user
	
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
		boolean aux=false;
		Optional<prestamos> findPrestamo = repository.findByIdPrestamosEmpleados(prestamos.getIdPrestamosEmpleados());
		
		if(findPrestamo.isPresent()) {
			System.out.println("idRepetido");
			throw new RecordNotFoundException("Id repetido");
		}
		
		List<prestamos> prestamosTemp = repository.findByFkEmpleadoPrestamo(prestamos.getFkEmpleadoPrestamo());
		
		Optional<usuario> userEmpleado = repositoryUser.findByIdUsuario(prestamos.getFkEmpleadoPrestamo()); //buscar al usuario que envio los datos del front-end
		
		if(userEmpleado.isPresent() ) {//comparo si existe el usuario solicitante
			usuario dateUser = userEmpleado.get();
			if(dateUser.getRol() == 2) {//el rol=2 hace referencia al empleado
				for(prestamos p:prestamosTemp) {
					if((p.getEstadoPrestamo() == true) ) {//comprobando un prestamo activ y si el prestamo no supera al sueldo
						aux=true;
						System.out.println(aux);
					}
				}
				if(aux == false){
					if(prestamos.getMontoPrestamo() <= (dateUser.getSueldo())) {
						System.out.println("guardado");
						return repository.save(prestamos);
					}else {
						System.out.println("el sueldo es menor al prestamo");
						throw new RecordNotFoundException("Su sueldo es menor al valor del prestamo!");
					}
				}else {
					System.out.println("pagar prestamo existente");
					throw new RecordNotFoundException("page su ultimo prestamo!");
				}
			}else {
					System.out.println("tipo de usuario no correcto");
					throw new RecordNotFoundException("Tipo de usuario no valido");
				}
		}else {
			System.out.println("no existe usuario");
			throw new RecordNotFoundException("No existe el usuario o prestamo activo ");
		}
	}
	
	public prestamos updatePrestamo(prestamos prestamos) throws RecordNotFoundException {
		Optional<prestamos> prestamosTemp = repository.findByIdPrestamosEmpleados(prestamos.getIdPrestamosEmpleados());
		if(prestamosTemp.isPresent()){
			prestamos objetcP = prestamosTemp.get();
			if(prestamos.getEstadoPrestamo() == false) {
				prestamos.setEstadoPrestamo(false);
				repository.deleteByIdPrestamosEmpleados(objetcP.getIdPrestamosEmpleados());
				return repository.save(prestamos);
			}else {
				System.out.println("Prestamo ya por cobrar");
				throw new RecordNotFoundException("Prestamo ya en ejecucion");
			}
		}else {
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
	
	public prestamos pagoPrestamo(String idP,float cantidad, String idU) throws RecordNotFoundException {
		
		Optional<prestamos> objP = repository.findByIdPrestamosEmpleados(idP);
		prestamos prestamo = objP.get();
		
		Optional<usuario> objU = repositoryUser.findByIdUsuario(idU);
		usuario user = objU.get();
		if(prestamo != null && user != null) {
			if(cantidad == prestamo.getMontoPrestamo()) {
				prestamo.setMontoPrestamo(prestamo.getMontoPrestamo()-cantidad);//disminuyo la deuda al pagar
				prestamo.setEstadoPrestamo(false);
				prestamo.setSituacionPrestamo("Cancelado");
				
			}else {
				if(cantidad < prestamo.getMontoPrestamo()) {
					prestamo.setMontoPrestamo(prestamo.getMontoPrestamo()-cantidad);//disminuyo la deuda al pagar
					prestamo.setEstadoPrestamo(true);
					prestamo.setSituacionPrestamo("Pagando");
				}else {
					throw new RecordNotFoundException("Valor ingresado mayor al de cancelar");
				}
			}
			return repository.save(prestamo);//guarda los camvios segun valor ingresado
		}else {
			throw new RecordNotFoundException("prestamo no encontrado");
		}
		
	}
	
	public Boolean aprobacionPrestamo(String idP,boolean check,String idU) throws RecordNotFoundException {
		boolean aux=false;
		if(check == true) {
			Optional<usuario> userAdmin = repositoryUser.findByIdUsuario(idU);
			usuario objeto =  userAdmin.get();
			if(objeto == null) {
				throw new RecordNotFoundException("El usuario es incorrecto");
			}
			
			if(objeto.getRol() == 1) {//si el objeto esta vacio o no es admin
				Optional<prestamos> aprobacionP = repository.findByIdPrestamosEmpleados(idP);
				prestamos objetcP = aprobacionP.get();
				
				List<prestamos> listaP = repository.findByFkEmpleadoPrestamo(objetcP.getFkEmpleadoPrestamo());
				
				for(prestamos p:listaP) {
					if(p.getEstadoPrestamo() == true)  {//comprobando si algun prestamo del solicitante esta activo
						aux=true;
					}
				}
				if(aux == false) {
					objetcP.setEstadoPrestamo(true);
					objetcP.setFkCiEmpleadoAdmin(idU);
					objetcP.setSituacionPrestamo("por cobrar");
					repository.deleteByIdPrestamosEmpleados(objetcP.getIdPrestamosEmpleados());
					repository.save(objetcP);
					return true;	
				}else {
					System.out.println("El usuario aun tiene prestamo activo");
					throw new RecordNotFoundException("El usuario aun tiene prestamo activo");
				}
			}else {
				System.out.println("Usuario no permitido");
				throw new RecordNotFoundException("Usuario no permitido");
			}
		}else {
			System.out.println("Prestamos cancelado");
			throw new RecordNotFoundException("Prestamos cancelado");
		}	
	}
}