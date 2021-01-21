	package com.modulo10.grupo8.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.modulo10.grupo8.entities.prestamos;


@Repository //RestResource(collectionResourceRel = "prestamoEmpleado", path = "prestamoEmpleado")
public interface prestamosRepository extends MongoRepository<prestamos, String> {

  public Optional<prestamos> findByIdPrestamo(@Param("idPrestamosEmpleados") String id);
  public prestamos findByMontoPrestamoEmpleado(@Param("montoPrestamo") float montoPrestamoEmpleado);
  
  @Transactional
  void deleteByIdPrestamo(@Param("idPrestamosEmpleados") String id);
}