package org.iesalandalus.programacion.torreajedrez;

import java.util.Objects;

public class Posicion {
	
	//Atributos
	
	private int fila;
	private char columna;
	
	//Metodos
	
	//Constructor para la posición
	public Posicion (int fila, char columna) {
		setFila(fila);
		setColumna(columna);
	}
	
	//Constructor copia para la posición
	public Posicion (Posicion posicion) {
		if(posicion == null) {
			throw new NullPointerException("ERROR: No es posible copiar una posición nula.");
		} else {
		setFila(posicion.getFila());
		setColumna(posicion.getColumna());
		}
	}
	
	public int getFila() {
		return fila;
	}
	
	//Restricción de fila
	public void setFila(int fila) {
		if (fila < 1 || fila > 8)
		{
			throw new IllegalArgumentException("ERROR: Fila no válida.");
		} else {
		this.fila = fila;
		}
	}
	
	public char getColumna() {
		return columna;
	}
	
	//Restricción de columna
	public void setColumna(char columna) {
		if (columna < 'a' || columna > 'h' ) 
		{
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}
		this.columna = columna;
	}

	@Override
	public int hashCode() {
		return Objects.hash(columna, fila);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		return columna == other.columna && fila == other.fila;
	}

	@Override
	public String toString() {
		return "fila=" + this.fila + ", columna=" + this.columna;
	}
	
	
}

