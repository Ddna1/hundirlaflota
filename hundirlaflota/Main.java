package hundirlaflota;

public class Main {
	public static void main(String[] args) {
		boolean partida=true;
		Barco b=new Barco();
		Juego barcos = new Juego();
		for (int i=2;i<6;i++) {
		barcos.flota.add(b.coordenadas(i));}
		System.out.println(barcos.flota.size());
		barcos.imprimirTablero();
//for (Barco barco : barcos.getFlota()) 
	//barco.mostrarCoordenadas();
while(partida) {
	barcos.jugar();
	barcos.imprimirTablero();
	System.out.println("Quedan " + barcos.flota.size()+ " barcos");
	if (barcos.flota.size()==0) partida=false;
}	
		
		
		
		
		
		
		
		
		
		
	}

}
