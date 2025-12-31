package hundirlaflota;

import java.util.ArrayList;
import java.util.Scanner;

public class Juego {
	public ArrayList<Barco> flota;
	private String[][] tablero = new String[10][10];
	private String linea1 = "  0 1 2 3 4 5 6 7 8 9 ";
	private String linea = " ---------------------";

	public Juego() {
		this.flota = new ArrayList<Barco>();
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				this.tablero[i][j] = " ";
			}
		}

	}

	public void añadirBarcos(Barco barco) {
		flota.add(barco);
	}

	public ArrayList<Barco> getFlota() {
		return flota;
	}

	public void setFlota(ArrayList<Barco> flota) {
		this.flota = flota;
	}

	// Metodo donde creamos la flota, se llama a un submetodo para comprobar que los
	// barcos no esten superpuestos o pegados
	public void crearFlota() {

		for (int i = 2; i < 6; i++) {
			Barco b = new Barco();
			boolean posicionado = true;
			while (posicionado) {
				b.clear();
				b.coordenadas(i);
				posicionado = comprobarPosicion(b);
			}
			añadirBarcos(b);
		}
	}

	// Metodo donde se imprime el tablero
	public void imprimirTablero() {
		System.out.println(linea1);
		for (int i = 0; i < 10; i++) {
			System.out.println(linea);
			System.out.print(Integer.toString(i) + "|");
			for (int j = 0; j < 10; j++)
				System.out.print(tablero[i][j] + "|");
			System.out.println();
		}
		System.out.println(linea);
	}
	// Metodo donde se administra la jugada

	public void jugar() {
		Scanner entrada = new Scanner(System.in);
		boolean jugadaAceptada = true;
		while (jugadaAceptada) {
			System.out.println("Turno jugador :");
			String jugada = entrada.nextLine();
			jugadaAceptada = comprobarEntrada(jugada);
		}
	}

	/**
	 * Se comprueba si la jugada es correcta, en caso de ser asi se modifica las
	 * jugadas a imprimir en el tablero
	 */
	private boolean comprobarEntrada(String jugada) {
		try {
			if (!(jugada.length() == 2))
				return true;
			int f = Integer.valueOf(jugada.charAt(0) - '0');
			int c = Integer.valueOf(jugada.charAt(1) - '0');
			Coordenadas jugadas = new Coordenadas(f, c);
			if (tablero[f][c].equals(" ")) {
				tablero[f][c] = "O";
				for (int i = 0; i < flota.size(); i++) {
					if (flota.get(i).getBarco().contains(jugadas)) {
						flota.get(i).getBarco().remove(jugadas);
						if (flota.get(i).getBarco().isEmpty()) {
							System.out.println("Barco hundido");
							flota.remove(i);
						}
						this.tablero[f][c] = "X";
					}
				}
				return false;
			}
		} catch (Exception e) {
			return true;
		}
		return true;
	}

	// Metodo donde se comprueba que al crear un barco este en una buena posición,
	// no superpuesto ni pegado
	private boolean comprobarPosicion(Barco b) {
		if (flota.size() > 0) {
			for (Coordenadas c : b.getBarco()) {
				for (int i = Math.max(0, c.getX() - 1); i <= Math.min(9, c.getX() + 1); i++)
					for (int j = Math.max(0, c.getY() - 1); j <= Math.min(9, c.getY() + 1); j++) {
						Coordenadas jugada = new Coordenadas(i, j);
						for (int k = 0; k < flota.size(); k++) {
							if (flota.get(k).getBarco().contains(jugada))
								return true;
						}
					}
			}
			return false;

		}
		return false;
	}
}
