package hundirlaflota;

import java.util.ArrayList;
//Clase anidada Coordenadas con solo el método constructor

public class Barco {
	private ArrayList<Coordenadas> barco;

	public Barco() {

		this.barco = new ArrayList<>();
	}

	public ArrayList<Coordenadas> getBarco() {
		return barco;
	}

	// Método para añadir una coordenada
	public void addCoordenada(Coordenadas coordenada) {
		barco.add(coordenada);
	}

	public void eliminarCoordenada(Coordenadas coordenada) {
		barco.remove(coordenada);
	}

	// Eliminar todas las coordenada de un barco (inicializar)
	public void clear() {
		barco.clear();
	}

	// Creo un barco de numero posiciones indicado por argumento
	public Barco coordenadas(int numero) {
		int fila, columna;

		// Elegimos posición horizontal o vertical
		int posicion = (int) (Math.random() * 2);
		// Posición horizontal
		if (posicion < 1) {
			fila = (int) (Math.random() * (10 - numero));
			columna = (int) (Math.random() * (10));
			for (int i = 0; i < numero; i++)
				this.addCoordenada(new Coordenadas(fila + i, columna));
		} else {
			// Posición vertical
			fila = (int) (Math.random() * (10));
			columna = (int) (Math.random() * (10 - numero));
			for (int i = 0; i < numero; i++)
				this.addCoordenada(new Coordenadas(fila, columna + i));

		}
		return this;

	}

	// Método para mostrar todas las coordenadas
	public void mostrarCoordenadas() {
		System.out.println("Barco:");
		for (Coordenadas c : barco) {
			System.out.println(c.toString());
		}
	}

}
