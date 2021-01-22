package com.modulo10.grupo8.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hojaDeCobro")
public class hojasDeCobro {

	  public String idHojaDeCobro;
	 
	  public String fkCiUsuario;
	  public String cantidadApagar;
	  public String sector;
	  public String tipoDePago;
	  public String fechaTransaccion;
	  
	public String getIdHojaDeCobro() {
		return idHojaDeCobro;
	}
	public void setIdHojaDeCobro(String idHojaDeCobro) {
		this.idHojaDeCobro = idHojaDeCobro;
	}
	public String getCiUsuario() {
		return fkCiUsuario;
	}
	public void setCiUsuario(String ciUsuario) {
		this.fkCiUsuario = ciUsuario;
	}
	public String getCantidadApagar() {
		return cantidadApagar;
	}
	public void setCantidadApagar(String cantidadApagar) {
		this.cantidadApagar = cantidadApagar;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getTipoDePago() {
		return tipoDePago;
	}
	public void setTipoDePago(String tipoDePago) {
		this.tipoDePago = tipoDePago;
	}
	public String getFechaTransaccion() {
		return fechaTransaccion;
	}
	public void setFechaTransaccion(String fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}
	  
	  

}