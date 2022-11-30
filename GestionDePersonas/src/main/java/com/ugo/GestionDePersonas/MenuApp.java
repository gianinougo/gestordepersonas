package com.ugo.GestionDePersonas;

import java.math.BigInteger;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class MenuApp {
	
	static List<Persona> personas = new ArrayList<>();
	static List<Cliente> cliente = new ArrayList<>();
	static List<Funcionario> funcionarios = new ArrayList<>();
	
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

			List<Persona> personas = menuPersona();
			//System.out.println(personas);
			
			
			for (Persona p : personas) {
				
				String sqlInsert = "insert into personas " +
						"(nombres, apellidos, direccion, telefono, fecha_nacim) " +
						"values ('" + p.getNombre() + "', '" + p.getApellido() + "', '" +
						p.getDireccion() + "', " + p.getTelefono()
						+ ", date('" + p.getAnyo() + "-" + p.getMes() + "-" 
						+ p.getDia() + "'));";
					
				//System.out.println(sqlInsert);
				manejador.update(sqlInsert);
			}

		}

	private static void addCliente(ManejadorBaseDatos manejador) 
		throws ClassNotFoundException, SQLException, ParseException 
	{
		List<Cliente> clientes = menuCliente();
		
		
		for (Cliente c : clientes) {
			
			String sqlInsert = "insert into clientes " +
					"(nombres, apellidos, direccion, telefono, fecha_nacim, nro_cuenta, " +
					"estado, tipo_cliente) values ('" +
					c.getNombre() + "', '" + c.getApellido() + "', '" +
					c.getDireccion() + "', " + c.getTelefono() + ", date('" +
					c.getAnyo() + "-" + c.getMes() + "-" + c.getDia() + "'), '" + 
					c.getNroCuenta()+ "', '" + c.getEstado() + "', '" + c.getTipoCliente() + "');";
					
			manejador.update(sqlInsert);
			
		}
	}
	
	private static void addFuncionario(ManejadorBaseDatos manejador) 
		throws ClassNotFoundException, SQLException, ParseException 
	{
		menuFuncionario();
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
		String sqlSelect = "select * from only personas";
		ResultSet rs = manejador.select(sqlSelect);
		
		if(rs.isBeforeFirst())
		{
			System.out.println(String.format("%-15s", "Nombre") +
					String.format("%-20s", "Apellidos") +
					String.format("%-20s", "Dirección") +
					String.format("%-11s", "Teléfono") +
					String.format("%-12s", "Nacimiento") +
					"Número");
			for(int i = 0; i < 84; i++)
				System.out.print("-");
			System.out.println();
			while(rs.next())
			{
				String nombre = rs.getString("nombres").length() <= 13 ?
						rs.getString("nombres") :
							rs.getString("nombres").substring(0, 12);
				String apellidos = rs.getString("apellidos").length() <= 18 ?
						rs.getString("apellidos") :
							rs.getString("apellidos").substring(0, 17);
				String direccion = rs.getString("direccion").length() <= 18 ?
						rs.getString("direccion") :
							rs.getString("direccion").substring(0, 17);
				LocalDate nacim = rs.getDate("fecha_nacim").toLocalDate();
				System.out.println(
						String.format("%-15s", nombre) +
						String.format("%-20s", apellidos) +
						String.format("%-20s", direccion) +
						String.format("%-11s", rs.getInt("telefono")) +
						String.format("%-12s", nacim.getDayOfMonth() + "/" +
						nacim.getMonthValue() +
						"/" + nacim.getYear()) + rs.getInt("numero"));
			}
		}
		else
		{
			System.out.println("No hay registros");
		}
	}
	
	private static void showClientes(ManejadorBaseDatos manejador) 
		throws ClassNotFoundException, SQLException 
	{
		String sqlSelect = "select * from clientes";
		ResultSet rs = manejador.select(sqlSelect);
		
		if(rs.isBeforeFirst())
		{
			System.out.println(String.format("%-10s", "Nombre") +
					String.format("%-16s", "Apellidos") +
					String.format("%-16s", "Dirección") +
					String.format("%-11s", "Teléfono") +
					String.format("%-12s", "Nacimiento") +
					String.format("%-22s", "Número de cuenta") +
					String.format("%-11s", "Estado") +
					String.format("%-9s", "Tipo") + "Número");
			for(int i = 0; i < 113; i++)
				System.out.print("-");
			System.out.println();
			while(rs.next())
			{
				String nombre = rs.getString("nombres").length() <= 8 ?
						rs.getString("nombres") :
							rs.getString("nombres").substring(0, 7);
				String apellidos = rs.getString("apellidos").length() <= 14 ?
						rs.getString("apellidos") :
							rs.getString("apellidos").substring(0, 13);
				String direccion = rs.getString("direccion").length() <= 14 ?
						rs.getString("direccion") :
							rs.getString("direccion").substring(0, 13);
				LocalDate nacim = rs.getDate("fecha_nacim").toLocalDate();
				
				System.out.println(
						String.format("%-10s", nombre) +
						String.format("%-16s", apellidos) +
						String.format("%-16s", direccion) +
						String.format("%-11s", rs.getInt("telefono")) +
						String.format("%-12s", nacim.getDayOfMonth() + "/" +
						nacim.getMonthValue() +
						"/" + nacim.getYear()) +
						String.format("%-22s", rs.getString("nro_cuenta")) +
						String.format("%-11s", rs.getString("estado")) +
						String.format("%-9s", rs.getString("tipo_cliente")) +
						rs.getInt("numero"));
			}
		}
		else
		{
			System.out.println("No hay registros");
		}
	}
	
	private static void showFuncionarios(ManejadorBaseDatos manejador) 
		throws ClassNotFoundException, SQLException 
	{
		String sqlSelect = "select * from funcionarios";
		ResultSet rs = manejador.select(sqlSelect);
		
		if(rs.isBeforeFirst())
		{
			System.out.println(String.format("%-15s", "Nombre") +
					String.format("%-16s", "Apellidos") +
					String.format("%-16s", "Dirección") +
					String.format("%-11s", "Teléfono") +
					String.format("%-12s", "Nacimiento") +
					String.format("%-12s", "Cargo") +
					String.format("%-14s", "Departamento") +
					String.format("%-12s", "Ingreso") + "Número");
			for(int i = 0; i < 114; i++)
				System.out.print("-");
			System.out.println();
			while(rs.next())
			{
				String nombre = rs.getString("nombres").length() <= 13 ?
						rs.getString("nombres") :
							rs.getString("nombres").substring(0, 12);
				String apellidos = rs.getString("apellidos").length() <= 16 ?
						rs.getString("apellidos") :
							rs.getString("apellidos").substring(0, 15);
				String direccion = rs.getString("direccion").length() <= 16 ?
						rs.getString("direccion") :
							rs.getString("direccion").substring(0, 15);
				String departamento = rs.getString("departamento").length() <= 12 ?
						rs.getString("departamento") :
							rs.getString("departamento").substring(0, 10);
				LocalDate nacim = rs.getDate("fecha_nacim").toLocalDate();
				LocalDate ingreso = rs.getDate("fecha_ingreso").toLocalDate();
				System.out.println(
						String.format("%-15s", nombre) +
						String.format("%-16s", apellidos) +
						String.format("%-16s", direccion) +
						String.format("%-11s", rs.getInt("telefono")) +
						String.format("%-12s", nacim.getDayOfMonth() + "/" +
								nacim.getMonthValue() +
								"/" + nacim.getYear()) +
						String.format("%-12s", rs.getString("cargo")) +
						String.format("%-14s", departamento) +
						String.format("%-12s", ingreso.getDayOfMonth() + "/" +
								ingreso.getMonthValue() +
								"/" + ingreso.getYear()) +
						rs.getInt("numero"));
			}
		}
		else
		{
			System.out.println("No hay registros");
		}

	}
	
	
	private static List<Persona> menuPersona() throws ParseException{
		
		
		
		System.out.print("Nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Apellido: ");
		String apellido = sc.nextLine();
		System.out.print("Direccion: ");
		String direccion = sc.nextLine();
		System.out.print("Telefono: ");
		int telefono = sc.nextInt();
		while(telefono < 100000000 || telefono > 999999999) {
			
			System.out.println("Teléfono incorrecto");
			System.out.print("Teléfono: ");
			telefono = sc.nextInt();
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
		
		
		personas.add(new Persona(nombre, apellido,
				direccion, telefono, dia, mes, anyo));
		
		
		return personas;
		
	}
	
	private static List<Cliente> menuCliente() throws ParseException{
		
		menuPersona();
		
		
		
		System.out.print("Num cuenta bancaria: ");
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
		
		String tipoCliente = "";
		tipoCliente(tipoCliente);
		
		if(tipoCliente.equals("premium")) {
			tipoCliente = "premium";
		} else {
			tipoCliente = "normal";
		}
		
		cliente.add(new Cliente(personas.get(0).getNombre(), personas.get(0).getApellido(),
				personas.get(0).getDireccion(), personas.get(0).getTelefono(), personas.get(0).getAnyo(),
				personas.get(0).getMes(), personas.get(0).getDia() , numCuenta ,estado, tipoCliente));
		
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
	
	
	private static List<Funcionario> menuFuncionario() throws ParseException{
		
		menuCliente();
		
		
		return funcionarios;
		
	}
	
	


}
