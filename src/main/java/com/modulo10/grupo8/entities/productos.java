package com.modulo10.grupo8.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("prestamoEmpleado")
public class productos {
	public String idProducto;
	public String nombreProducto;
	public String estadoProducto; //puede ser activo, caducado
	public String tipoProducto;// puede ser perecibles y no perecibles
	public int idBOdega;
	
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public String getNombreProducto() {
		return nombreProducto;
	}
	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}
	public String getEstadoProducto() {
		return estadoProducto;
	}
	public void setEstadoProducto(String estadoProducto) {
		this.estadoProducto = estadoProducto;
	}
	public String getTipoProducto() {
		return tipoProducto;
	}
	public void setTipoProducto(String tipoProducto) {
		this.tipoProducto = tipoProducto;
	}
	public int getIdBOdega() {
		return idBOdega;
	}
	public void setIdBOdega(int idBOdega) {
		this.idBOdega = idBOdega;
	}
	
}
