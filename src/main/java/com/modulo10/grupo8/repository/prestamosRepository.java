	package com.modulo10.grupo8.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.modulo10.grupo8.entities.prestamos;


@Repository //RestResource(collectionResourceRel = "prestamoEmpleado", path = "prestamoEmpleado")
public interface prestamosRepository extends MongoRepository<prestamos, String> {

	public Optional<prestamos> findByIdPrestamosEmpleados(@Param("idPrestamosEmpleados") String idPrestamosEmpleados);
	  public prestamos findByMontoPrestamo(@Param("montoPrestamo") float montoPrestamoEmpleado);
	  
	  public List<prestamos> findByFkEmpleadoPrestamo(@Param("FkEmpleadoPrestamo") String idUP);
	  
	  @Transactional
	  void deleteByIdPrestamosEmpleados(@Param("idPrestamosEmpleados") String id);
}