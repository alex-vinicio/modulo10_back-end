package com.modulo10.grupo8.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "productosDadosDeBaja")
public class productosDadosDeBaja {


	  public String idProductoDadoDeBaja;
	  
	  public String fkCiUsuario;
	  public String nombreProductoDadoDeBaja;
	  public String fechaProductoDadoDeBaja;
	  public String accion;
	  public boolean estadoP;
	  
	public String getFkCiUsuario() {
		return fkCiUsuario;
	}
	public void setFkCiUsuario(String fkCiUsuario) {
		this.fkCiUsuario = fkCiUsuario;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	public boolean isEstadoP() {
		return estadoP;
	}
	public void setEstadoP(boolean estadoP) {
		this.estadoP = estadoP;
	}
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