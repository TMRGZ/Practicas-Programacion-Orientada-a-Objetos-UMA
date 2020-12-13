package prExSept2016;

import java.io.*;
import java.util.*;

public class Competicion {

	protected SortedMap<Equipo, List<Jugador>> competicion;

	public Competicion() {
		competicion = new TreeMap<Equipo, List<Jugador>>();
	}
	
	public Competicion(String nombreFichero) throws FileNotFoundException {
		competicion = new TreeMap<Equipo, List<Jugador>>();
		leerDatos(nombreFichero);
	}

	public void leerDatos(String nombreFichero) throws FileNotFoundException {
		try (Scanner scFich = new Scanner(new File(nombreFichero))) {
			while (scFich.hasNextLine()) {
				procesarEquipo(scFich.nextLine());
			}
		}
	}
	
	private void procesarEquipo(String linea) {
		try (Scanner scEquipo = new Scanner(linea)) {
			scEquipo.useDelimiter("[:]");
			Equipo equipo = new Equipo(scEquipo.next(), scEquipo.nextInt(),scEquipo.nextInt());
			List<Jugador> jugadores = new ArrayList<Jugador>();
			while (scEquipo.hasNext()) {
					jugadores.add(new Jugador(scEquipo.next(), scEquipo.nextInt(), scEquipo.nextInt()));	
			}
			insertaJugadoresEquipo(equipo, jugadores);
		} catch (InputMismatchException e) {
			throw new CompeticionException("Dato de tipo incorrecto en equipo o jugador");
		} catch (NoSuchElementException e) {
			throw new CompeticionException("Faltan datos en equipo o jugador");
		}
	}

	public void insertaJugadoresEquipo(Equipo equipo, List<Jugador> jugadores) {
		List<Jugador> jugadoresAsociados = competicion.get(equipo);
		
		if (jugadoresAsociados == null) {
			competicion.put(equipo, jugadores);
		} else {
			for (Jugador jug : jugadores) {
				if (!jugadoresAsociados.contains(jug)) {
					jugadoresAsociados.add(jug);
				}
			}
		}
	}


	public String toString() {
		StringBuilder resultado = new StringBuilder();
		
		for (Equipo e : competicion.keySet()) {
			resultado.append(e).append("\n").append(competicion.get(e)).append("\n");
		}
		
		return resultado.toString();
	}
	
	public void escribirFichero(String nombreFichero) throws FileNotFoundException {
		try (PrintWriter pw = new PrintWriter(nombreFichero)) {
			escribir(pw);
		}
	}
	
	public void escribir(PrintWriter pw) {
		pw.print(this.toString());
	}
	
	public void increPartidos(String nombreJugador, int pJugados, int pGanados) {
		Jugador jugador = buscarJugador(nombreJugador);
		
		if (jugador == null) {
			throw new CompeticionException("Jugador no encontrado al intentar incrementar sus partidos");
		} 
		
		jugador.increPartidos(pJugados, pGanados);
	}

	private Jugador buscarJugador(String nombreJugador) {
		Jugador resultado = null;
		
		Jugador jugador = new Jugador(nombreJugador);
		Iterator<Equipo> iterEq = competicion.keySet().iterator();
				
		while (iterEq.hasNext() && (resultado == null)) {
			List<Jugador> jugadores = competicion.get(iterEq.next());
			Iterator<Jugador> iterJug = jugadores.iterator();
			while (iterJug.hasNext() && (resultado == null)) {
				Jugador sig = iterJug.next();
				if (sig.equals(jugador)) {
					resultado = sig;
				}
			}
		}
		
		return resultado;
	}

/* Estos dos siguientes métodos públicos no se les pide al final 
 
	public void increPuntos(Equipo equipo, int puntos) {
		
		Equipo equipoEncontrado = buscarEquipo(equipo);
		
		if (equipoEncontrado == null) {
			throw new CompeticionException("Equipo no encontrado al intentar incrementar sus puntos");
		} else {
			List<Jugador> jugadores = competicion.get(equipoEncontrado);
			competicion.remove(equipoEncontrado);
			equipo.increPuntos(puntos);
			competicion.put(equipo,jugadores);
		}
	}

	private Equipo buscarEquipo(Equipo equipo) {
		Equipo resultado = null;
		
		Iterator<Equipo> it = competicion.keySet().iterator();
		
		while (it.hasNext() && resultado == null) {
			Equipo sig = it.next();
			if (sig.equals(equipo)) {
				resultado = sig;
			}
		}
		
		return resultado;
	}
	
	public Jugador jugadorMasValioso() {
		Jugador resultado = null;
		
		int mayorPGanados = 0;
		
		for (Equipo equipo: competicion.keySet()) {
			for (Jugador jug : competicion.get(equipo)) {
				int pGanados = jug.getPGanados();
				if (pGanados > mayorPGanados) {
					resultado = jug;
					mayorPGanados = pGanados;
				}
			}
		}
		
		return resultado;
	}

*/
	
}
