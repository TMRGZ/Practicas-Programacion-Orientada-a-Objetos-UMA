package prJugadores;


public class PruebaJugador {
	public static void main(String[] args) throws CompeticionException {
		Jugador j1 = new Jugador("Ana Romero", 2,1);
		Jugador j2 = new Jugador("ana romero", 2,0);
		
		j2.increPartidos(1,1);
		System.out.println("Jugador 1 = " + j1);
		System.out.println("Jugador 2 = " + j2);
		if (j1.equals(j2)) {
			System.out.println("Los jugadores son iguales");
		} else {
			System.out.println("Los jugadores son distintos");
		}
		 
	}
}
