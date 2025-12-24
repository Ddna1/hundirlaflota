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
	public void eliminarCoordenada (Coordenadas coordenada) {
		barco.remove(coordenada);
	}

	
	

	
	//Creo un barco de numero posiciones 
	public Barco coordenadas(int numero) {
		Barco barco=new Barco();
		int posicion = (int) (Math.random() * 2);
		if (posicion < 1) {
			int fila = (int) (Math.random() * (10 - numero));
			int columna = (int) (Math.random() * (10));
			for (int i = 0; i < numero; i++)

				barco.addCoordenada(new Coordenadas(fila+i, columna));
		} else {
			int fila = (int) (Math.random() * (10));
			int columna = (int) (Math.random() * (10 - numero));
			for (int i = 0; i < numero; i++)

				barco.addCoordenada(new Coordenadas(fila, columna+i));

		}
		return barco;

	}

	// Método para mostrar todas las coordenadas
		public void mostrarCoordenadas() {
			System.out.println("Barco de largo " );
			for (Coordenadas c : barco) {
				System.out.println(c.toString());
			}
		}
	
	
	
}
