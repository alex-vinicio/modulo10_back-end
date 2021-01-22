package com.modulo10.grupo8.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("prestamoEmpleado")
public class prestamos {
	
	public String idPrestamosEmpleados;
  
  public String fkCiEmpleado;
  public String fkEmpleadoPrestamo;
  public String fechaInicioPrestamo;
  public String fechaFinPrestamo;
  public Boolean estadoPrestamo;
  public float montoPrestamo;
  public int mesesPago;
  
	
	public String getIdPrestamosEmpleados() {
		return idPrestamosEmpleados;
	}
	public void setIdPrestamosEmpleados(String idPrestamosEmpleados) {
		this.idPrestamosEmpleados = idPrestamosEmpleados;
	}
	public String getFkCiEmpleado() {
		return fkCiEmpleado;
	}
	public void setFkCiEmpleado(String fkCiEmpleado) {
		this.fkCiEmpleado = fkCiEmpleado;
	}
	public String getFkEmpleadoPrestamo() {
		return fkEmpleadoPrestamo;
	}
	public void setFkEmpleadoPrestamo(String fkEmpleadoPrestamo) {
		this.fkEmpleadoPrestamo = fkEmpleadoPrestamo;
	}
	public String getFechaInicioPrestamo() {
		return fechaInicioPrestamo;
	}
	public void setFechaInicioPrestamo(String fechaInicioPrestamo) {
		this.fechaInicioPrestamo = fechaInicioPrestamo;
	}
	public String getFechaFinPrestamo() {
		return fechaFinPrestamo;
	}
	public void setFechaFinPrestamo(String fechaFinPrestamo) {
		this.fechaFinPrestamo = fechaFinPrestamo;
	}
	public Boolean getEstadoPrestamo() {
		return estadoPrestamo;
	}
	public void setEstadoPrestamo(Boolean estadoPrestamo) {
		this.estadoPrestamo = estadoPrestamo;
	}
	public float getMontoPrestamo() {
		return montoPrestamo;
	}
	public void setMontoPrestamo(float montoPrestamo) {
		this.montoPrestamo = montoPrestamo;
	}
	public int getMesesPago() {
		return mesesPago;
	}
	public void setMesesPago(int mesesPago) {
		this.mesesPago = mesesPago;
	}
	  
 
}