package com.modulo10.grupo8.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productosDadosDeBaja")
public class productosDadosDeBaja {

	  @Id
	  public String idProductoDadoDeBaja;
	  
	  public String ciUsuario;
	  public String nombreProductoDadoDeBaja;
	  public String fechaProductoDadoDeBaja;
	 
	  
	  
	  public productosDadosDeBaja() {}

	  public productosDadosDeBaja(String idProductoDadoDeBaja, String ciUsuario,String nombreProductoDadoDeBaja, String fechaProductoDadoDeBaja) {
	    this.idProductoDadoDeBaja = idProductoDadoDeBaja;
	    this.ciUsuario = ciUsuario;
	    this.nombreProductoDadoDeBaja = nombreProductoDadoDeBaja;
	    this.fechaProductoDadoDeBaja = fechaProductoDadoDeBaja;
	    
	  }

//	  @Override
//	  public String toString() {
//	    return String.format(
//	        "productosDadosDeBaja[idProductoDadoDeBaja=%s, ciUsuario='%s', nombreProductoDadoDeBaja='%s',fechaProductoDadoDeBaja='%s']",
//	        idProductoDadoDeBaja, ciUsuario,  nombreProductoDadoDeBaja,fechaProductoDadoDeBaja);
//	  }
}