package com.ugo.GestionDePersonas;

import java.util.Date;

import org.joda.time.DateTime;

public class Persona {
	
	
	String nombre;
	String apellido;
	String direccion;
	long telefono;
	DateTime fechaNacimiento;
	
	
	
	
	public Persona( String nombre, String apellido, String direccion, long telefono,
			DateTime dateTime) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fechaNacimiento = dateTime;
	}
	
	

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public long getTelefono() {
		return telefono;
	}
	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}
	public DateTime getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(DateTime fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", direccion="
				+ direccion + ", telefono=" + telefono + ", fechaNacimiento=" + fechaNacimiento + "]";
	}
	

	
	
	
	
	
	
	
	
	

}
