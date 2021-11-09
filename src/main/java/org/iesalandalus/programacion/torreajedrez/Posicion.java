package org.iesalandalus.programacion.torreajedrez;

public class Posicion {
	
	//Atributos
	
	public int fila;
	public char columna;
	
	//Metodos
	
	public Posicion (int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	}
	
	public Posicion (Posicion posicion) {
		if(posicion == null) {
			throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
		}
		this.fila = posicion.getFila();
		this.columna = posicion.getColumna();
	}
	
	public int getFila() {
		return fila;
	}
	
	public void setFila(int fila) {
		if (fila < 1 || fila > 8)
		{
			throw new IllegalArgumentException("ERROR: Fila no válida.");
		}
		this.fila = fila;
	}
	
	public char getColumna() {
		return columna;
	}
	
	public void setColumna(char columna) {
		if (columna != 'a' || columna != 'b' || columna != 'c' || columna != 'd' || columna != 'e' || columna != 'f' || columna != 'g' || columna != 'h' ) 
		{
			throw new IllegalArgumentException("ERROR: Columna no válida");
		}
		this.columna = columna;
	}
	
}

