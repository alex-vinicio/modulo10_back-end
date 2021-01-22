package com.modulo10.grupo8.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.modulo10.grupo8.entities.productosDadosDeBaja;


@Repository
public interface productosDadosDdeBajaRepository extends MongoRepository<productosDadosDeBaja, String> {

  public Optional<productosDadosDeBaja> findByIdProductoDadoDeBaja(@Param("idProductoDadoDeBaja") String idProductoDadoDeBaja);
  public List<productosDadosDeBaja> findByfechaProductoDadoDeBaja(@Param("fechaProductoDadoDeBaja") String fechaProductoDadoDeBaja);
  //repo.findAll()
  @Transactional
  void deleteByIdProductoDadoDeBaja(@Param("idProductoDadoDeBaja") String id);
}