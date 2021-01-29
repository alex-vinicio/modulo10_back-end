package com.modulo10.grupo8.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("prestamoEmpleado")
public class usuario {
	
	public String idUsuario;
	public String nombreUsuario;
	public float sueldo;
	
	public float getSueldo() {
		return sueldo;
	}
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	public int rol;
	
	public String getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(String idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
	
	
}
