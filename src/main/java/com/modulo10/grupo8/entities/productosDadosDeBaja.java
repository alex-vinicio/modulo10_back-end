package com.modulo10.grupo8.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productosDadosDeBaja")
public class productosDadosDeBaja {


	  public String idProductoDadoDeBaja;
	  
	  public String fkCiUsuario;
	  public String nombreProductoDadoDeBaja;
	  public String fechaProductoDadoDeBaja;
	  
	public String getIdProductoDadoDeBaja() {
		return idProductoDadoDeBaja;
	}
	public void setIdProductoDadoDeBaja(String idProductoDadoDeBaja) {
		this.idProductoDadoDeBaja = idProductoDadoDeBaja;
	}
	public String getCiUsuario() {
		return fkCiUsuario;
	}
	public void setCiUsuario(String ciUsuario) {
		this.fkCiUsuario = ciUsuario;
	}
	public String getNombreProductoDadoDeBaja() {
		return nombreProductoDadoDeBaja;
	}
	public void setNombreProductoDadoDeBaja(String nombreProductoDadoDeBaja) {
		this.nombreProductoDadoDeBaja = nombreProductoDadoDeBaja;
	}
	public String getFechaProductoDadoDeBaja() {
		return fechaProductoDadoDeBaja;
	}
	public void setFechaProductoDadoDeBaja(String fechaProductoDadoDeBaja) {
		this.fechaProductoDadoDeBaja = fechaProductoDadoDeBaja;
	}
	 
	  
}