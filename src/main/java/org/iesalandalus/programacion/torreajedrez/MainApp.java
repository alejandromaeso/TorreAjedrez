package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.utilidades.Entrada;


public class MainApp {
	private static Torre torre;

	public static void main(String[] args) {
		
		int contador = 1;
		int boton;
		
		System.out.println("------------------------------------");
		System.out.println("Ajedrez by: Alejandro Maeso Castillo");
		System.out.println("------------------------------------");
		
		do {
			mostrarMenu();
			boton = elegirOpcion();
			ejecutarOpcion(boton);
			
			if (boton != 5) {
				
				mostrarTorre();
			}
						
			if (boton == 5) {
				contador = 0;				
			}
		} while (contador != 0);	
	}
		
	//Métodos:
	
	//Método que mostrará por consola la representación de la torre representado por el atributo de clase torre
	
	private static void mostrarTorre() {
		try {
			System.out.println(torre.toString());
		} catch (NullPointerException e){
			System.out.println("ERROR: La torre no está creada.");
		}
	}
	
	//Metodo que mostrará por consola el menú con las diferentes opciones de nuestro programa.
	
	private static void mostrarMenu() {
		System.out.println("----------------------------------------------------------------------------");
		System.out.println("Si quiere crear una torre por defecto, pulse: 1");
		System.out.println("Si quiere crear una torre eligiendo el color, pulse: 2");
		System.out.println("Si quiere crear una torre elegiendo el color y la posición inicial, pulse: 3");
		System.out.println("Si quiere mover la torre, pulse: 4");
		System.out.println("Para SALIR, pulse: 5");
		System.out.println("----------------------------------------------------------------------------");
	}
	
	//Método que nos mostrará un mensaje para que elijamos una opción del menú anteriormente creado y nos pedirá que introduzcamos por teclado la opción 
	//hasta que ésta sea valida. Devolverá la opción elegida.
	
	private static int elegirOpcion() {
		int opcionMenu;
		
		do {
			System.out.println("Por favor, elija una opción.");
			opcionMenu = Entrada.entero();
		} while (opcionMenu < 1 || opcionMenu > 5);
		
		return opcionMenu;
	}
	
	//Método que nos preguntará que elijamos un color mientras éste no sea válido y dependiendo de la opción elegida devolverá un color u otro.
	
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
			color = Color.BLANCO;
		break;
		case 2:
			color = Color.NEGRO;	
		}
		
		return color;		
	}
	
	//Método que nos preguntará que elijamos la columna inicial mientras ésta no sea válida y devolverá la columna elegida.
	
	private static char elegirColumnaInicial() {
		char columnaInicial = 0;
		
		do {
			System.out.println("¿En qué columna quiere iniciar la partida?");
			System.out.println("Introduzca 'A' o 'H'. por favor.");
			columnaInicial = Entrada.caracter();
		} while (columnaInicial != 'a' && columnaInicial != 'h' && columnaInicial != 'A' && columnaInicial != 'H');
		
		return columnaInicial;
	}
	
	//Método que mostrará por consola un menú con las diferentes direcciones que podemos elegir.
	
	private static void mostrarMenuDirecciones() {
		//System.out.println("-----------------------------------");
		System.out.println("Para mover ARRIBA, pulse: 1");
		System.out.println("Para mover ABAJO, pulse: 2");
		System.out.println("Para mover IZQUIERDA, pulse: 3");
		System.out.println("Para mover DERECHA, pulse: 4");
		System.out.println("Para hacer ENROQUE_CORTO, pulse: 5");
		System.out.println("Para hacer ENROQUE_LARGO, pulse: 6");
		System.out.println("-----------------------------------");
	}
	
	//Nos mostrará un mensaje para que elijamos una opción del menú anteriormente creado y
	//nos pedirá que introduzcamos por teclado la opción hasta que ésta sea valida. Devolverá la dirección elegida.
	
	private static Direccion elegirDireccion() {
		Direccion direccion = null;
		int opcionDireccion = 0;
		
		do {
			System.out.println("---------------------------");
			System.out.println("Por favor, elija un movimiento.");
			System.out.println("---------------------------");
			opcionDireccion = Entrada.entero();
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
	
	//Método que asignará al atributo de clase torre una nueva instancia de una torre creada con el constructor por defecto.
	
	private static void crearTorreDefecto() {
		torre = new Torre();
	}

	//Método que asignará al atributo de clase torre una nueva instancia de una torre creada con el constructor al que le pasamos el color.
	
	private static void crearTorreColor() {
		torre = new Torre(elegirColor());
	}
	
	//Método que asignará al atributo de clase torre una nueva instancia de una torre creada con el constructor al que le pasamos el color y la columna inicial.
	
	private static void crearTorreColorColumna() {
		torre = new Torre(elegirColor(), elegirColumnaInicial());
	}
	
	//Mostrará un menú con las posibles direcciones, nos preguntará por la dirección y la cantidad de pasos a mover y moverá la torre según esos parámetros.
	
	private static void mover() {
		Direccion direccion = null;
		int pasos;
	
		if (torre == null) {
			System.out.println("ERROR: Debe de crear una torre antes de mover.");
		} else {
			mostrarMenuDirecciones();
			direccion = elegirDireccion();
			
			if (direccion.equals(Direccion.ENROQUE_CORTO) || direccion.equals(Direccion.ENROQUE_LARGO)) {
				try {
					torre.enrocar(direccion);
				} catch (OperationNotSupportedException e) {
					System.out.println(e.getMessage());
					}
				} else {
					System.out.println("-----------------------------------");
					System.out.println("¿Cuantos pasos va a mover la torre?");
					pasos = Entrada.entero();
					
					try {
						torre.mover(direccion, pasos);
				}catch(OperationNotSupportedException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
		
	//Método que depediendo de la opción pasada como parámetro, actuará en consecuencia.
	
	private static void ejecutarOpcion(int elegirEjecutarOpcion) {
		switch(elegirEjecutarOpcion) {
		
		case 1:
			crearTorreDefecto();
			break;
		
		case 2:
			crearTorreColor();
			break;
		
		case 3:
			crearTorreColorColumna();
			break;
			
		case 4:
			mover();
			break;
			
		case 5:
			System.out.println("¡Hasta la próxima!");
			break;
		}

	}

}


		
		
		


		

