package com.ugo.GestionDePersonas;

import java.util.Date;

import org.joda.time.DateTime;

import java.time.LocalDate;

public class Funcionario extends Persona{
	
	
	String cargo;
	String codigoCuerpo;
	String departamento;
	int diaIngreso;
	int mesIngreso;
	int anyoIngreso;
	


	public Funcionario(String nombre, String apellido, String direccion, int telefono, int dia, int mes, int anyo,
			String cargo, String codigoCuerpo, String departamento, int diaIngreso, int mesIngreso, int anyoIngreso) {
		super(nombre, apellido, direccion, telefono, dia, mes, anyo);
		this.cargo = cargo;
		this.codigoCuerpo = codigoCuerpo;
		this.departamento = departamento;
		this.diaIngreso = diaIngreso;
		this.mesIngreso = mesIngreso;
		this.anyoIngreso = anyoIngreso;
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


	public int getDiaIngreso() {
		return diaIngreso;
	}


	public void setDiaIngreso(int diaIngreso) {
		this.diaIngreso = diaIngreso;
	}


	public int getMesIngreso() {
		return mesIngreso;
	}


	public void setMesIngreso(int mesIngreso) {
		this.mesIngreso = mesIngreso;
	}


	public int getAnyoIngreso() {
		return anyoIngreso;
	}


	public void setAnyoIngreso(int anyoIngreso) {
		this.anyoIngreso = anyoIngreso;
	}


	public String getCodigoCuerpo() {
		return codigoCuerpo;
	}


	public void setCodigoCuerpo(String codigoCuerpo) {
		this.codigoCuerpo = codigoCuerpo;
	}


	@Override
	public String toString() {
		return "Funcionario [cargo=" + cargo + ", codigoCuerpo=" + codigoCuerpo + ", departamento=" + departamento
				+ ", diaIngreso=" + diaIngreso + ", mesIngreso=" + mesIngreso + ", anyoIngreso=" + anyoIngreso + "]";
	}

	
	
	
	



	
	
	
	
	
	

}
