package com.modulo10.grupo8.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.modulo10.grupo8.entities.hojasDeCobro;

@Repository
public interface hojasDeCobroRepository extends MongoRepository<hojasDeCobro, String> {

  public Optional<hojasDeCobro> findByIdHojaDeCobro(@Param("idHojaDeCobro") String idHojaDeCobro);
  public List<hojasDeCobro> findBySector(@Param("sector") String sector);
  
  @Transactional
  void deleteByIdHojaDeCobro(@Param("idHojaDeCobro") String id);
}