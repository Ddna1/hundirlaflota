package hundirlaflota;

import java.util.Objects;

public class Coordenadas {
	private int x;
	private int y;

	public Coordenadas(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	// Método imprimir coordenadas
	public String toString() {
		return ("fila: " + x + " Columna:" + y);
	}

	// Sobreescribimos los metodos equals y hashCode para que funcione el metodo
	// contains, sino solo comparamos posiciones de memoria
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o instanceof Coordenadas that) {
			return x == that.x && y == that.y;
		}
		return false;
	}

	@Override
	// Retorna el identificador (posicion de memoria) de cada objeto,,
	public int hashCode() {
		return Objects.hash(x, y);
	}
}
