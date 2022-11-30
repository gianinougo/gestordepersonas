package com.ugo.GestionDePersonas;

import java.util.Date;

import org.joda.time.DateTime;

public class Persona {
	
	
	String nombre;
	String apellido;
	String direccion;
	int telefono;
	int dia;
	int mes;
	int anyo;
	

	public Persona(String nombre, String apellido, String direccion, int telefono, int dia, int mes, int anyo) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.telefono = telefono;
		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;
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


	public int getTelefono() {
		return telefono;
	}


	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}


	public int getDia() {
		return dia;
	}


	public void setDia(int dia) {
		this.dia = dia;
	}


	public int getMes() {
		return mes;
	}


	public void setMes(int mes) {
		this.mes = mes;
	}


	public int getAnyo() {
		return anyo;
	}


	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}


	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + ", telefono="
				+ telefono + ", dia=" + dia + ", mes=" + mes + ", anyo=" + anyo + "]";
	}

	

	
	
	
	
	
	
	
	
	

}
