import java.io.*;
import java.util.*;

public class EurocopaJuegoLimpio extends Eurocopa {

	List<String> jugadoresNoPermitidos;

	public EurocopaJuegoLimpio(String ficheroPuntuaciones,
			String ficheroTarjetas) throws IOException {
		super(ficheroPuntuaciones);
		jugadoresNoPermitidos = new ArrayList<String>();
		leerTarjetas(ficheroTarjetas);
	}

	private void leerTarjetas(String nombreFichero) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
		leer(br);
		br.close();
	}

	private void leer(BufferedReader br) throws IOException {
		String nombreJugador = br.readLine();
		while (nombreJugador != null) {
			jugadoresNoPermitidos.add(nombreJugador);
			nombreJugador = br.readLine();
		}
	}

	protected Jugador seleccionarJugador(Equipo eq, String demarcacion) {
		List<Jugador> jugadores = puntuaciones.get(eq);
		Iterator<Jugador> iter = jugadores.iterator();
		Jugador resultado = null;
		while ((resultado == null) && iter.hasNext()) {
			Jugador j = iter.next();
			if (!j.getElegido()
					&& (demarcacion.equalsIgnoreCase(j.getDemarcacion()))
					&& (!jugadoresNoPermitidos.contains(j.getNombre()))) {
				resultado = j;
			}
		}
		if (resultado != null) {
			while (iter.hasNext()) {
				Jugador j = iter.next();
				if (!j.getElegido()
						&& (demarcacion.equalsIgnoreCase(j.getDemarcacion()))
						&& (!jugadoresNoPermitidos.contains(j.getNombre()))
						&& (j.compareTo(resultado) < 0)) {
					resultado = j;
				}
			}
		}

		return resultado;
	}

}
