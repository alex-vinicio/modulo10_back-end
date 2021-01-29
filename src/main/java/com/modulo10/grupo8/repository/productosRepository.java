package com.modulo10.grupo8.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.modulo10.grupo8.entities.prestamos;
import com.modulo10.grupo8.entities.productos;

@Repository
public interface productosRepository extends MongoRepository<productos, String>{
	public Optional<productos> findByIdProducto(@Param("idPrestamosEmpleados") String id);
}
