package org.iesalandalus.programacion.torreajedrez;

public class Torre {
	
	//Atributos
	
	private Color color;
	private Posicion posicion;

	//Métodos
	
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
	
	//Constructor por defecto para crear una torre negra en '8h'
	public Torre(Color color) {
		color = Color.NEGRO;
		posicion = new Posicion(8,'h');
		
	}
}
