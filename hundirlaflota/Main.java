package hundirlaflota;

public class Main {
	public static void main(String[] args) {
		System.out.println("Bienvenido al hundir la flota, tienes que hundir 4 barcos ( 5,4,3 y 2 posiciones)\nNo pueden estar pegados entre ellos \nTiene máximo de 50 tiradas.\nSuerte");
		boolean partida = true;
		int tiradas = 0;
		Juego barcos = new Juego();
		barcos.crearFlota();
		barcos.imprimirTablero();
		while (partida) {
			System.out.println("Tirada: " + (tiradas+1));
			barcos.jugar();
			barcos.imprimirTablero();
			System.out.println("Quedan " + barcos.flota.size() + " barcos");
			tiradas++;
			if (barcos.flota.size() == 0 || tiradas == 50)
				partida = false;
		}
		if (barcos.flota.size() == 0)
			System.out.println("Ganaste");
		else {
			System.out.println("Tiradas acabadas, faltan estos objetivos");
			for (Barco barco : barcos.getFlota())
				barco.mostrarCoordenadas();
		}

	}

}
