package com.modulo10.grupo8.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.modulo10.grupo8.entities.hojasDeCobro;

@Repository
public interface hojasDeCobroRepository extends MongoRepository<hojasDeCobro, String> {

  public hojasDeCobro findByIdHojaDeCobro(String idHojaDeCobro);
  public List<hojasDeCobro> findBySector(String sector);
  
  @Transactional
  void deleteByIdHojaDeCobro(String id);
}