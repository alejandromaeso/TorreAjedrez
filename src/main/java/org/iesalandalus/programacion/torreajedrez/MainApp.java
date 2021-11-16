package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.utilidades.Entrada;


public class MainApp {
	private static Torre torre;

	public static void main(String[] args) {
		
		System.out.println("------------------------------------");
		System.out.println("Ajedrez by: Alejandro Maeso Castillo");
		System.out.println("------------------------------------");
		
	}
		
	//Métodos
	private static void mostrarTorre() {
		try {
			System.out.println(torre.toString());
		} catch (NullPointerException e){
			System.out.println("ERROR: La torre no está creada.");
		}
	}
	
	private static void mostrarMenu() {
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Si quiere crear una torre por defecto pulse: 1");
		System.out.println("Si quiere crear una torre eligiendo el color pulse: 2");
		System.out.println("Si quiere crear una torre elegiendo el color y la posición inicial pulse: 3");
		System.out.println("Si quiere mover la torre pulse: 4");
		System.out.println("Para SALIR pulse: 5");
		System.out.println("----------------------------------------------------------------------------");
	}
	
	private static int elegirOpcion() {
		int opcion;
		
		do {
			System.out.println("Por favor, elija una opción.");
			opcion = Entrada.entero();
		} while (opcion < 1 || opcion > 5);
		return opcion;
	}
	
	
	
}
		
		
		


		

