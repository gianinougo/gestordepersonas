package com.ugo.GestionDePersonas;

import java.util.Date;

import org.joda.time.DateTime;

import java.time.LocalDate;

public class Cliente extends  Persona{
	
	
	String nroCuenta;
	String estado;
	String tipoCliente;
	
	





	public Cliente(String nombre, String apellido, String direccion, int telefono, int dia, int mes, int anyo,
			String nroCuenta, String estado, String tipoCliente) {
		super(nombre, apellido, direccion, telefono, dia, mes, anyo);
		this.nroCuenta = nroCuenta;
		this.estado = estado;
		this.tipoCliente = tipoCliente;
	}





	public String getNroCuenta() {
		return nroCuenta;
	}



	public void setNroCuenta(String nroCuenta) {
		this.nroCuenta = nroCuenta;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public String getTipoCliente() {
		return tipoCliente;
	}



	public void setTipoCliente(String tipoCliente) {
		this.tipoCliente = tipoCliente;
	}



	@Override
	public String toString() {
		return "Cliente [nroCuenta=" + nroCuenta + ", estado=" + estado + ", tipoCliente=" + tipoCliente + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


}
