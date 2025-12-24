package hundirlaflota;


import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Juego {
	public  ArrayList<Barco> flota;
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
	public boolean comprobarEntrada(String jugada) {
		try {
			if (!(jugada.length() == 2))
				return true;
			int f=Integer.valueOf(jugada.charAt(0) - '0');
			int c=Integer.valueOf(jugada.charAt(1) - '0');
			Coordenadas jugadas = new Coordenadas(f,c);					
			if (tablero[f][c].equals(" ")) {
				tablero[f][c]="O";			
				for (int i=0;i<flota.size();i++){					
				if (flota.get(i).getBarco().contains(jugadas)) {
					flota.get(i).getBarco().remove(jugadas);
					if(flota.get(i).getBarco().isEmpty()) {
						System.out.println("Barco hundido");
						flota.remove(i);
					}
					this.tablero[f][c]="X";				
				}
				}
				return false;
			}
		} catch (Exception e) {
			return true;
		}
		return true;
	}

}
