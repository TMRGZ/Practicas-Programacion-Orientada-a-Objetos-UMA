import java.io.*;
import java.util.*;

public class Eurocopa {

	protected SortedMap<Equipo, List<Jugador>> puntuaciones;

	public Eurocopa(String nombreFichero) throws IOException {
		puntuaciones = new TreeMap<Equipo, List<Jugador>>();
		leerPuntuaciones(nombreFichero);
	}

	private void leerPuntuaciones(String nombreFichero) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(nombreFichero));
		leer(br);
		br.close();
	}

	private void leer(BufferedReader br) throws IOException {
		String lineaEquipo = br.readLine();
		while (lineaEquipo != null) {
			procesarEquipo(lineaEquipo, br);
			lineaEquipo = br.readLine();
		}
	}

	private void procesarEquipo(String lineaEquipo, BufferedReader br)
			throws IOException {
		StringTokenizer st = new StringTokenizer(lineaEquipo, " ");
		try {
			String nombre = st.nextToken();
			int votos = Integer.parseInt(st.nextToken());
			int numeroJugadores = Integer.parseInt(st.nextToken());
			Equipo equipo = new Equipo(nombre, votos);
			procesarJugadores(equipo, numeroJugadores, br);
		} catch (NoSuchElementException e) {
			throw new EurocopaException("Faltan datos de equipo");
		} catch (NumberFormatException e) {
			throw new EurocopaException("Formato incorrecto en datos de equipo");
		}
	}

	private void procesarJugadores(Equipo eq, int numeroJugadores,
			BufferedReader br) throws IOException {
		List<Jugador> listaJugadores = new ArrayList<Jugador>();

		for (int cont = 0; cont < numeroJugadores; cont++) {
			String lineaJugador = br.readLine();
			StringTokenizer st = new StringTokenizer(lineaJugador, " ");
			try {
				String nombre = st.nextToken();
				String demarcacion = st.nextToken();
				int valoracion = Integer.parseInt(st.nextToken());

				Jugador j = new Jugador(nombre, demarcacion, valoracion);

				listaJugadores.add(j);
			} catch (NoSuchElementException e) {
				throw new EurocopaException("Faltan datos de jugador");
			} catch (NumberFormatException e) {
				throw new EurocopaException(
						"Formato incorrecto en datos de jugador");
			}
		}

		puntuaciones.put(eq, listaJugadores);
	}

	public SortedSet<Jugador> formarEquipoIdeal(int defensa, int centro,
			int ataque) {
		SortedSet<Jugador> ideal = new TreeSet<Jugador>();

		ideal.addAll(seleccionar(1, "PORTERIA")); // por defecto se selecciona
													// un portero
		ideal.addAll(seleccionar(defensa, "DEFENSA"));
		ideal.addAll(seleccionar(centro, "CENTRO"));
		ideal.addAll(seleccionar(ataque, "ATAQUE"));

		return ideal;
	}

	private SortedSet<Jugador> seleccionar(int numJugadores, String demarcacion) {
		SortedSet<Jugador> ideal = new TreeSet<Jugador>();

		int contJugadores = 0;

		Set<Equipo> equipos = puntuaciones.keySet();
		Iterator<Equipo> iter = equipos.iterator();
		int numeroEquiposPorConsultar = equipos.size();

		while ((contJugadores < numJugadores)
				&& (numeroEquiposPorConsultar > 0)) {
			if (iter.hasNext()) {
				Jugador j = seleccionarJugador(iter.next(), demarcacion);
				if (j != null) {
					contJugadores++;
					j.setElegido();
					ideal.add(j);
					numeroEquiposPorConsultar = equipos.size();
				} else {
					numeroEquiposPorConsultar--;
				}
			} else {
				iter = equipos.iterator();
			}
		}
		return ideal;
	}

	protected Jugador seleccionarJugador(Equipo eq, String demarcacion) {
		List<Jugador> jugadores = puntuaciones.get(eq);
		Iterator<Jugador> iter = jugadores.iterator();
		Jugador resultado = null;
		while ((resultado == null) && iter.hasNext()) {
			Jugador j = iter.next();
			if (!j.getElegido()
					&& (demarcacion.equalsIgnoreCase(j.getDemarcacion()))) {
				resultado = j;
			}
		}
		if (resultado != null) {
			while (iter.hasNext()) {
				Jugador j = iter.next();
				if (!j.getElegido()
						&& (demarcacion.equalsIgnoreCase(j.getDemarcacion()))
						&& (j.compareTo(resultado) < 0)) {
					resultado = j;
				}
			}
		}

		return resultado;
	}

	public static String representarEquipoIdeal(SortedSet<Jugador> ideal) {
		StringBuilder sb = new StringBuilder();
		for (Jugador j : ideal) {
			sb.append(j.toString()).append("\n");
		}
		return sb.toString();
	}

	public static void mostrarEquipoIdeal(SortedSet<Jugador> ideal) {
		System.out.println(representarEquipoIdeal(ideal));
	}

	public static void mostrarEquipoIdeal(String nombreFichero,
			SortedSet<Jugador> ideal) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(nombreFichero);
		pw.println(representarEquipoIdeal(ideal));
		pw.close();
	}

}
