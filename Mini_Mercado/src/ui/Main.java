package ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import model.Person;
import model.Document;
import exceptions.First_Exception;
import exceptions.Second_Exception;


public class Main {
	
	private BufferedReader buffer;
	private List<Person> pEntered; 
	
	
	public Main() {
		
		buffer = new BufferedReader(new InputStreamReader(System.in));
		pEntered = new ArrayList<Person>();
	}

	public static void main(String[]juank) {
		
		Main principal = new Main();
		
		System.out.println("///////////////////////////////////////");
		System.out.println("Bienvenid@ a Mi Barrio te Quiere :D\n");
		
		
		int personas = 0;
		int option = -1;
		do {
			String line = "";
			
			do {
				System.out.print(principal.Menu());
				
				try {
					line = principal.readALine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} while(line.equals(" "));
			
			option = Integer.parseInt(line);
			
			switch(option) {
			case 1:
				principal.signInUser();
				personas++;
				break;
			case 2:
				System.out.println("En este momento hay "+personas+" personas en el MiniMarket :)");
				break;
			case 3:
				option = 0;
				System.out.println("Gracias por venir, sabes que este es tu MiniMarket de confianza ;), Vuelve pronto ;))");
				break;
			}
			
		} while(option != 0);
		
	}
	
	public String Menu() {
		
		return "///////////////////////////////////////////////"
				+ "\nEscribe el numero de lo que deseas hacer:\n"
				+ "\n1. Registrar una Persona/Usuario\n"
				+ "2. Mostrar el numero de Personas ingresadas\n"
				+ "3. Salir\n";			
	}
	
	public void signInUser(){
		
		System.out.println("\nEscoge el tipo de documento porfa :  :)\n"
				+ "1. Tarjeta de Identidad\n"
				+ "2. Cedula de Ciudadania\n"
				+ "3. Pasaporte\n"
				+ "4. Cedula de Extranjeria");
		
		String line = "";
		
		do {
			try {
				line = readALine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while(line.equals(""));
		
		int o = Integer.parseInt(line);
		Document type = null;
		
		switch(o) {
		case 1:
			type = Document.Tarjeta_Identidad;
			break;
		case 2:
			type = Document.Cedula_Ciudadania;
			break;
		case 3:
			type = Document.Pasaporte;
			break;
		case 4:
			type = Document.Cedula_Extranjeria;
			break;
		}
		
		
		String identification = "";
		do {
			System.out.println("\nCual es el Numero del documento?: ");
			
			try {
				identification = readALine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} while(identification.equals(""));
		
		Person person = null;
		try {
			person = new Person(type, identification);
		} catch(Second_Exception e) {
			System.out.println("Elegiste Tarjetad de Identidad como documento, debes cambiarla debido a que no se permiten menores de edad");
		}
		
		if(person != null) {
			try {
				person.Login();
				pEntered.add(person);
				System.out.println("Se ingreso correctamente, Bienvenido :D");
			} catch(First_Exception e) {
				System.out.println("A esta persona no le toca ingresar el dia de hoy :(");
			}
		}	
	}
	
	public String readALine() throws IOException {
		
		String line = buffer.readLine();
		return line;
	}
}