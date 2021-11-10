package org.iesalandalus.programacion.torreajedrez;

public class Torre {

	// Atributos

	private Color color;
	private Posicion posicion;

	// Métodos

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	// Constructor por defecto para crear una torre negra en '8h'
	public Torre() {
		color = Color.NEGRO;
		posicion = new Posicion(8, 'h');
	}

	// Constructor para la clase que acepte como parámetro el color y que creará una
	// torre de dicho color '1h' blanca // '8h' negra

	public Torre(Color color) {
		this.color = color;
		if (color == Color.BLANCO) {
			posicion = new Posicion(1, 'h');
		}
		if (color == Color.NEGRO) {
			posicion = new Posicion(8, 'h');
		}
		if (color == null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		}
	}

	// Constructor que acepte como parámetros el color y la columna inicial, 
	// Crea la torre en "1-A" si es blanca y en "8-N" si es negra

	public Torre(Color color, char columna) {
		this.color = color;
		if (columna == 'a' || columna == 'h') {
			if (this.color == Color.BLANCO) {
				posicion = new Posicion(1, columna);
			} else {
				posicion = new Posicion(8, columna);
			}
		} else {
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}
		if (this.color == null) {
			throw new IllegalArgumentException("ERROR: No se puede asignar un color nulo.");
		}
	}

}
