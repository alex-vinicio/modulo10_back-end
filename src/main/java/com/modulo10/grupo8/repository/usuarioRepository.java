package com.modulo10.grupo8.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.modulo10.grupo8.entities.prestamos;
import com.modulo10.grupo8.entities.usuario;

@Repository
public interface usuarioRepository extends MongoRepository<usuario, String>{
	public Optional<usuario> findByIdUsuario(@Param("idUsuario") String id);
}
