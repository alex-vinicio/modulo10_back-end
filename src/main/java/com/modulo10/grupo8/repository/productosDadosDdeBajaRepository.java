package com.modulo10.grupo8.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.modulo10.grupo8.entities.productosDadosDeBaja;


@Repository
public interface productosDadosDdeBajaRepository extends MongoRepository<productosDadosDeBaja, String> {

  public productosDadosDeBaja findByIdProductoDadoDeBaja(String id);
  public List<productosDadosDeBaja> findByfechaProductoDadoDeBaja(String fechaCaducidad);
  //repo.findAll()
  @Transactional
  void deleteByIdProductoDadoDeBaja(String id);
}