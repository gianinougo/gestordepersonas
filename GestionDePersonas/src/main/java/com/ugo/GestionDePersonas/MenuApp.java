package com.ugo.GestionDePersonas;

import java.math.BigInteger;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class MenuApp {
	
	static List<Persona> persona = new ArrayList<>();
	static List<Cliente> cliente = new ArrayList<>();
	
	public static Scanner sc = new Scanner(System.in);
	
	public static void main (String[] args) throws ClassNotFoundException, SQLException, ParseException{
		ManejadorBaseDatos manejador = new ManejadorBaseDatos();
		
		boolean exit = false;
		
		do
		{
			ShowMenu();
			switch (getOption()) {
			case 1:
				addPersona(manejador);
				break;
			case 2:
				addCliente(manejador);		
				break;
			case 3:
				addFuncionario(manejador);			
				break;
			case 4:
				modifyPersona(manejador);			
				break;
			case 5:
				modifyCliente(manejador);			
				break;
			case 6:
				modifyFuncionario(manejador);			
				break;
			case 7:
				showPersonas(manejador);			
				break;
			case 8:
				showClientes(manejador);			
				break;
			case 9:
				showFuncionarios(manejador);			
				break;
			case 0:
				exit = true;
				break;
			default:
				break;
			}
		}
		while(!exit);
	}
	
	private static int getOption() {
		System.out.println("Option:");
		int option = sc.nextInt();
		sc.nextLine();
		return option;
	}

	private static void ShowMenu()
	{
		System.out.println("1.-Añadir persona");
		System.out.println("2.-Añadir cliente");
		System.out.println("3.-Añadir funcionario");
		System.out.println("4.-Modificar persona");
		System.out.println("5.-Modificar cliente");
		System.out.println("6.-Modificar funcionario");
		System.out.println("7.-Ver personas");
		System.out.println("8.-Ver clientes");
		System.out.println("9.-Ver funcionarios");
		System.out.println("0.-Salir");
	}
	
	
	private static void addPersona(ManejadorBaseDatos manejador) 
			throws ClassNotFoundException, SQLException, ParseException 
		{

			List<Persona> persona = menuPersona();
			
			String sqlInsert = "insert into personas " +
					"(nombres, apellidos, direccion, telefono, fecha_nacim) " +
					"values ('" + persona.get(0).getNombre() + "', '" + persona.get(1).getApellido() + "', '" +
					persona.get(2).getDireccion() + "', " + persona.get(3).getTelefono() + ", date('" + persona.get(4).getFechaNacimiento() + "'));";
					
			manejador.update(sqlInsert);

		}

	private static void addCliente(ManejadorBaseDatos manejador) 
		throws ClassNotFoundException, SQLException, ParseException 
	{
		List<Cliente> cliente = menuCliente();
	}
	
	private static void addFuncionario(ManejadorBaseDatos manejador) 
		throws ClassNotFoundException, SQLException 
	{

	}
	
	private static void modifyPersona(ManejadorBaseDatos manejador) 
		throws ClassNotFoundException, SQLException 
	{

	}
	
	private static void modifyCliente(ManejadorBaseDatos manejador) 
		throws ClassNotFoundException, SQLException 
	{

	}
	
	private static void modifyFuncionario(ManejadorBaseDatos manejador) 
		throws ClassNotFoundException, SQLException 
	{

	}
	
	private static void showPersonas(ManejadorBaseDatos manejador) 
		throws SQLException, ClassNotFoundException 
	{

	}
	
	private static void showClientes(ManejadorBaseDatos manejador) 
		throws ClassNotFoundException, SQLException 
	{

	}
	
	private static void showFuncionarios(ManejadorBaseDatos manejador) 
		throws ClassNotFoundException, SQLException 
	{

	}
	
	
	private static List<Persona> menuPersona() throws ParseException{
		
		
		
		System.out.print("Nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Apellido: ");
		String apellido = sc.nextLine();
		System.out.print("Direccion: ");
		String direccion = sc.nextLine();
		System.out.print("Telefono: ");
		long telefono = sc.nextLong();
		while(telefono < 100000000 || telefono > 999999999) {
			
			System.out.println("Teléfono incorrecto");
			System.out.print("Teléfono: ");
			telefono = sc.nextLong();
		}
		
		System.out.print("Día nacimento: ");
		int dia = sc.nextInt();
		while(dia < 1 || dia > 31) {
			System.out.println("Día incorrecto");
			System.out.print("Día: ");
			dia = sc.nextInt();
		}
		
		System.out.print("Mes nacimento: ");
		int mes = sc.nextInt();
		while(mes < 1 || mes > 312) {
			System.out.println("Mes incorrecto");
			System.out.print("Mes: ");
			mes = sc.nextInt();
		}
		
		System.out.print("Año nacimento: ");
		int anyo = sc.nextInt();
		while(anyo < 1900 || anyo > 2022) {
			System.out.println("Año incorrecto");
			System.out.print("Año: ");
			anyo = sc.nextInt();
		}
		
		DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
		String fecha_nacimiento = Integer.toString(anyo) + "-" + Integer.toString(mes) + "-" + Integer.toString(dia);
		
		DateTime dateTime = DateTime.parse(fecha_nacimiento, formatter);
		
		persona.add(new Persona(nombre, apellido,
				direccion, telefono, dateTime));
		
		
		return persona;
		
	}
	
	private static List<Cliente> menuCliente() throws ParseException{
		
		menuPersona();
		
		String tipo = null;
		tipoCliente(tipo);
		
		System.out.print("Num cuenta bancaria");
		String numCuenta = sc.nextLine();
		
		
		while(numCuenta.length() != 20) {
			
			System.out.println("Numero de cuenta erróneo");
			System.out.print("Numero de cuenta: ");
			numCuenta = sc.nextLine();
			
		}
		
		String estado;
		
		if(!checkIBAN(numCuenta))
		{
			System.out.println("El número de cuenta no ha sido verificado.");
			estado = "pendiente";
		}
		else
		{
			estado = "activo";
			
		}
		
		cliente.add(new Cliente(persona.get(0).getNombre(), persona.get(1).getApellido(),
				persona.get(2).getDireccion(), persona.get(3).getTelefono(), persona.get(4).getFechaNacimiento(), numCuenta , estado, tipo));
		
		System.out.println(cliente);
		
		return cliente;
		
	}
	
	private static boolean checkIBAN(String numCuenta)
	{
		String cuenta = numCuenta.trim();
		
		cuenta = cuenta.substring(4) + cuenta.substring(0, 4);
		
		StringBuilder cuentaNumerica = new StringBuilder();
		for(int i = 0; i < cuenta.length(); i++)
		{
			cuentaNumerica.append(Character.getNumericValue(cuenta.charAt(i)));
		}
		
		BigInteger numIBAN = new BigInteger(cuentaNumerica.toString());
		return numIBAN.mod(new BigInteger("97")).intValue() == 1;
	}
	
	private static String tipoCliente(String tipo) {
		
		String opcion;
		
		do
		{
			System.out.println("Tipo de cliente:");
			System.out.println("1. Normal");
			System.out.println("2. Premium");
			System.out.print("Elige una opción: ");
			opcion = sc.nextLine();
			
			if(opcion.equals("1"))
			{
				tipo = "normal";
			}
			else if(opcion.equals("2"))
			{
				tipo = "premiun";
			}
			else
			{
				System.out.println("Opción incorrecta");
			}
		} while(!opcion.equals("1") && !opcion.equals("2"));
		
		return tipo;
	}
	
	


}
