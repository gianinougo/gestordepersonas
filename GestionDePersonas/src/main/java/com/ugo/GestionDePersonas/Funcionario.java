package com.ugo.GestionDePersonas;

import java.util.Date;

import org.joda.time.DateTime;

import java.time.LocalDate;

public class Funcionario extends Persona{
	
	
	String cargo;
	String departamento;
	LocalDate fechaIngreso;
	
	

	public Funcionario(String nombre, String apellido, String direccion, long telefono, DateTime fechaNacimiento,
			String cargo, String departamento, LocalDate fechaIngreso) {
		super(nombre, apellido, direccion, telefono, fechaNacimiento);
		this.cargo = cargo;
		this.departamento = departamento;
		this.fechaIngreso = fechaIngreso;
	}


	public String getCargo() {
		return cargo;
	}


	public void setCargo(String cargo) {
		this.cargo = cargo;
	}


	public String getDepartamento() {
		return departamento;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}


	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}


	@Override
	public String toString() {
		return "Funcionario [cargo=" + cargo + ", departamento=" + departamento + ", fechaIngreso=" + fechaIngreso
				+ "]";
	}
	
	
	
	
	

}
