import java.io.IOException;
import java.util.SortedSet;

public class Principal {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Eurocopa e = new Eurocopa("equipos.txt");

			// primer equipo ideal
			SortedSet<Jugador> ideal1 = e.formarEquipoIdeal(4, 3, 3);
			Eurocopa.mostrarEquipoIdeal(ideal1);
			Eurocopa.mostrarEquipoIdeal("equipoIdeal1.txt", ideal1);

			// segundo equipo ideal
			SortedSet<Jugador> ideal2 = e.formarEquipoIdeal(4, 4, 2);
			Eurocopa.mostrarEquipoIdeal(ideal2);
			Eurocopa.mostrarEquipoIdeal("equipoIdeal2.txt", ideal2);

			EurocopaJuegoLimpio ejl = new EurocopaJuegoLimpio("equipos.txt",
					"tarjetas.txt");

			// equipo ideal juego limpio
			SortedSet<Jugador> idealjl = ejl.formarEquipoIdeal(4, 3, 3);
			EurocopaJuegoLimpio.mostrarEquipoIdeal(idealjl);
			EurocopaJuegoLimpio.mostrarEquipoIdeal(
					"equipoIdealJuegoLimpio.txt", idealjl);

		} catch (EurocopaException e) {
			System.out.println("ERROR: " + e.getMessage());
		} catch (IOException e) {
			System.out.println("ERROR de Entrada/Salida: " + e.getMessage());
		}

	}

}
