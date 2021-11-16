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
		System.out.println("Si quiere crear una torre por defecto, pulse: 1");
		System.out.println("Si quiere crear una torre eligiendo el color, pulse: 2");
		System.out.println("Si quiere crear una torre elegiendo el color y la posición inicial, pulse: 3");
		System.out.println("Si quiere mover la torre, pulse: 4");
		System.out.println("Para SALIR, pulse: 5");
		System.out.println("----------------------------------------------------------------------------");
	}
	
	private static int elegirOpcion() {
		int opcionMenu;
		
		do {
			System.out.println("Por favor, elija una opción.");
			opcionMenu = Entrada.entero();
		} while (opcionMenu < 1 || opcionMenu > 5);
		
		return opcionMenu;
	}
	
	private static Color elegirColor() {
		Color color = null;
		int colorTorre = 0;
		
		do {
			System.out.println("---------------------------");
			System.out.println("Por favor, elija un color: ");
			System.out.println("Color BLANCO: 1");
			System.out.println("Color NEGRO: 2");
			System.out.println("---------------------------");
			colorTorre = Entrada.entero();
		} while (colorTorre != 1 && colorTorre != 2);
		
		switch (colorTorre) {
	
		case 1:
			color=color.BLANCO;
		break;
		case 2:
			color = color.NEGRO;	
		}
		
		return color;		
	}
	
	private static char elegirColumnaInicial() {
		char columnaInicial = 0;
		
		do {
			System.out.println("¿En qué columna quiere iniciar la partida?");
			System.out.println("Introduzca 'A' o 'H'. por favor.");
			columnaInicial = Entrada.caracter();
		} while (columnaInicial != 'a' && columnaInicial != 'h' && columnaInicial != 'A' && columnaInicial != 'H');
		
		return columnaInicial;
	}
	
	private static void mostrarMenuDirecciones() {
		System.out.println("-----------------------------------");
		System.out.println("Para mover ARRIBA, pulse: 1");
		System.out.println("Para mover ABAJO, pulse: 2");
		System.out.println("Para mover IZQUIERDA, pulse: 3");
		System.out.println("Para mover DERECHA, pulse: 4");
		System.out.println("Para hacer ENROQUE_CORTO, pulse: 5");
		System.out.println("Para hacer ENROQUE_LARGO, pulse: 6");
		System.out.println("-----------------------------------");
	}
	
	private static Direccion elegirDireccion() {
		Direccion direccion = null;
		int opcionDireccion = 0;
		
		do {
			System.out.println("---------------------------");
			System.out.println("Por favor, elija un movimiento.");
			opcionDireccion = Entrada.entero();
			System.out.println("---------------------------");
		} while (opcionDireccion < 1 || opcionDireccion > 6);
		
		switch (opcionDireccion) {
		
		case 1:
			direccion = Direccion.ARRIBA;
		break;
		case 2:
			direccion = Direccion.ABAJO;
		break;
		case 3:
			direccion = Direccion.IZQUIERDA;
		break;
		case 4:
			direccion = Direccion.DERECHA;
		break;
		case 5:
			direccion = Direccion.ENROQUE_CORTO;
		break;
		case 6:
			direccion = Direccion.ENROQUE_LARGO;
		break;
		}
		return direccion;
	}
	
}
		
		
		


		

