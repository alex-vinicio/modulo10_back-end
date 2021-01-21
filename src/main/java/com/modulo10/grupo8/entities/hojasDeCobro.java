package com.modulo10.grupo8.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hojaDeCobro")
public class hojasDeCobro {
	 @Id
	  public String idHojaDeCobro;
	 
	  public String ciUsuario;
	  public String cantidadApagar;
	  public String sector;
	  public String tipoDePago;
	  public String fechaTransaccion;
	  
	  
	  public hojasDeCobro() {}

	  public hojasDeCobro(String idHojaDeCobro, String ciUsuario,String cantidadApagar,String sector,String tipoDePago,String fechaTransaccion) {
	    this.idHojaDeCobro = idHojaDeCobro;
	    this.ciUsuario = ciUsuario;
	    this.cantidadApagar = cantidadApagar;
	    this.sector = sector;
	    this.tipoDePago = tipoDePago;
	    this.fechaTransaccion = fechaTransaccion;
	    
	    
	  }

//	  @Override
//	  public String toString() {
//	    return String.format(
//	        "hojaDeCobro[idHojaDeCobro=%s, ciUsuario='%s', cantidadApagara='%s',sector='%s',tipoDePago='%s',fechaTransaccion='%s']",
//	        idHojaDeCobro, ciUsuario, cantidadApagar,sector,tipoDePago,fechaTransaccion);
//	  }
	

}