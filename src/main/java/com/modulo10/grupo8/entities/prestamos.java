package com.modulo10.grupo8.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("prestamoEmpleado")
public class prestamos {

	@Id public String idPrestamosEmpleados;
  
  public String fkCiEmpleado;
  public String fkEmpleadoPrestamo;
  public String fechaInicioPrestamo;
  public String fechaFinPrestamo;
  public Boolean estadoPrestamo;
  public float montoPrestamo;
  
  
  public String getIdPrestamo() {
		return idPrestamosEmpleados;
  }
	
  public void setIdPrestamo(String idPrestamosEmpleados) {
		this.idPrestamosEmpleados = idPrestamosEmpleados;
  }
  
  public String getCiUsuario() {
		return fkCiEmpleado;
  }
	
  public void setCiUsuario(String fkCiEmpleado) {
		this.fkCiEmpleado = fkCiEmpleado;
  }
  
  public String getCiPrestamoEmpleado() {
		return fkEmpleadoPrestamo;
  } 
	 
  public void setCiPrestamoEmpleado(String fkEmpleadoPrestamo) {
		this.fkEmpleadoPrestamo = fkEmpleadoPrestamo;
  }
  
  public String getFechaInicioPrestamoEmpleado() {
		return fechaInicioPrestamo;
  }
	
  public void setFechaInicioPrestamoEmpleado(String fechaInicioPrestamo) {
		this.fechaInicioPrestamo = fechaInicioPrestamo;
  }
  
  public String getFechaFinPrestamoEmpleado() {
		return fechaFinPrestamo;
  }
	
  public void setFechaFinPrestamoEmpleado(String fechaFinPrestamo) {
		this.fechaFinPrestamo = fechaFinPrestamo;
  }

  public float getMontoPrestamoEmpleado() {
		return montoPrestamo;
  }
	
  public void setMontoPrestamoEmpleado(float montoPrestamo) {
		this.montoPrestamo = montoPrestamo;
  }
  public Boolean getEstadoPrestamo() {
		return estadoPrestamo;
  }
	
  public void setEstadoPrestamo(Boolean estadoPrestamo) {
		this.estadoPrestamo = estadoPrestamo;
  }
}