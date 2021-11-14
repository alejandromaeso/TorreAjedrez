package org.iesalandalus.programacion.torreajedrez;
import java.util.Objects;

//Importamos el siguiente paquete para poder utilizar la excepción "OperationNotSupportedException" en el método movimiento
import javax.naming.OperationNotSupportedException;


public class Torre {

	// Atributos

	private Color color;
	private Posicion posicion;

	// Métodos

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		if (color == null) {
			throw new NullPointerException("ERROR: No se puede asignar un color nulo.");
			}
		this.color = color;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		if (posicion == null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
			}
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
		setColor(color);
		if (color.equals(Color.BLANCO)) {
			posicion = new Posicion(1, 'h');
		}else {
			posicion = new Posicion(8, 'h');
		}
	}

	// Constructor que acepte como parámetros el color y la columna inicial, 
	// Crea la torre en "1-A" si es blanca y en "8-N" si es negra

	public Torre(Color color, char columna) {
		setColor(color);
		if (columna == 'a' || columna == 'h'|| columna == 'A' || columna == 'H') {
			if (color.equals(Color.BLANCO)) {
				setPosicion(new Posicion(1, columna));
			} else {
				setPosicion(new Posicion(8, columna));
			}
		} else {
			throw new IllegalArgumentException("ERROR: Columna no válida.");
		}
	}
	
	//Método mover que acepta como parámetro una DIrección y la cantidad de pasos a mover en dicha dirección. 
		
	public void mover (Direccion direccion, int pasos) throws OperationNotSupportedException {
		if (pasos < 1)
		{
			throw new IllegalArgumentException("ERROR: El número de pasos debe ser positivo.");
		} else if (direccion == null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}
		switch(direccion) {
			case ARRIBA:
				if (color == Color.NEGRO) {
					try {
						setPosicion(new Posicion(posicion.getFila() - pasos, posicion.getColumna()));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				} else {
					try {
						setPosicion(new Posicion(posicion.getFila() + pasos, posicion.getColumna()));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				}
			break;	
			case ABAJO:
				if (color == Color.NEGRO) {
					try {
						setPosicion(new Posicion(posicion.getFila() + pasos, posicion.getColumna()));
					} catch(IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				} else {
					try {
						setPosicion(new Posicion(posicion.getFila() - pasos, posicion.getColumna()));
					} catch (IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				}
			break;
			case IZQUIERDA:
				if (color == Color.NEGRO) {
					try {
						setPosicion(new Posicion(posicion.getFila(), (char)(posicion.getColumna() + pasos)));
					} catch(IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				} else {
					try {
						setPosicion(new Posicion(posicion.getFila(), (char)(posicion.getColumna() - pasos)));
					} catch(IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				}
			break;
			case DERECHA:
				if (color == Color.NEGRO) {
					try {
						setPosicion(new Posicion(posicion.getFila(), (char)(posicion.getColumna() - pasos)));
					} catch(IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				} else {
					try {
						setPosicion(new Posicion(posicion.getFila(), (char)(posicion.getColumna() + pasos)));
					} catch(IllegalArgumentException e) {
						throw new OperationNotSupportedException("ERROR: Movimiento no válido (se sale del tablero).");
					}
				}
			break;
			default:
				throw new NullPointerException("ERROR: La dirección no puede ser nula");
			}
		}
	
	//Metodo enrocar que acepte como parámetro una Dirección válida para enrocar
	
	public void enrocar (Direccion direccion) throws OperationNotSupportedException {
		if (direccion == null) {
			throw new NullPointerException("ERROR: La dirección no puede ser nula.");
		}
		switch (direccion) {
		case ENROQUE_CORTO:
			if (posicion.getColumna() == 'h' && (posicion.getFila() == 1 || posicion.getFila() == 8)) {
				setPosicion(new Posicion(posicion.getFila(), 'f'));
			} else {
				throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
			}
			break;
		case ENROQUE_LARGO:
			if (posicion.getColumna() == 'a' && (posicion.getFila() == 1 || posicion.getFila() == 8)) {
				setPosicion(new Posicion(posicion.getFila(), 'd'));
			} else {
				throw new OperationNotSupportedException("ERROR: Movimiento de enroque no válido.");
			}
			break;
		default:
			break;
		}
	}

	//Métodos equals y hashCode
	
	@Override
	public int hashCode() {
		return Objects.hash(color, posicion);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Torre other = (Torre) obj;
		return color == other.color && Objects.equals(posicion, other.posicion);
	}

	@Override
	public String toString() {
		return "fila=" + posicion.getFila() + ", columna=" + posicion.getColumna() + ", color=" + color;
	}

	
	
		

	
	
		
		
	}

