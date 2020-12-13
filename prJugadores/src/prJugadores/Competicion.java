package prJugadores;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

public class Competicion {
	SortedMap<Equipo, List<Jugador>> competicion;
	
	public Competicion() {
		competicion = new TreeMap<Equipo, List<Jugador>>();
	}
	
	public Competicion(String nFich) throws FileNotFoundException, CompeticionException {
		competicion = new TreeMap<Equipo, List<Jugador>>();
		leerDatos(nFich);
	}

	protected void leerDatos(String nFich) throws FileNotFoundException, CompeticionException {
			try(Scanner sc = new Scanner(new File (nFich))) {			
				while(sc.hasNextLine()) {
					procesarEquipo(sc.nextLine());
				}
		}
	}

	private void procesarEquipo(String linea) throws CompeticionException {
		try(Scanner scEquipo = new Scanner(linea)){
			scEquipo.useDelimiter("[:]");
			List<Jugador> jugadores = new ArrayList<Jugador>();
			
			Equipo equipo = new Equipo(scEquipo.next(), scEquipo.nextInt(), scEquipo.nextInt());
			
			while(scEquipo.hasNext()) {
				jugadores.add(new Jugador(scEquipo.next(), scEquipo.nextInt(), scEquipo.nextInt()));
			}
			
			insertaJugadoresEquipo(equipo, jugadores);
		}catch(Exception e) {
			throw new RuntimeException("Error");
		}
		
	}
	
	public void insertaJugadoresEquipo(Equipo e, List<Jugador> lista) {
		List<Jugador> jugadoresAsociados = competicion.get(e);
		
		if(jugadoresAsociados==null) {
			competicion.put(e, lista);
		}else {
			for(Jugador j : lista) {
				if(!jugadoresAsociados.contains(j)) {
					jugadoresAsociados.add(j);
				}
			}
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(Equipo e : competicion.keySet()) {
			sb.append(e).append("\n").append(competicion.get(e)).append("\n");
		}
		return sb.toString();
	}
	
	public void escribirFichero(String nFich) throws FileNotFoundException {
		try(PrintWriter pw = new PrintWriter(new File(nFich))){
			escribir(pw);
		}
	}

	void escribir(PrintWriter pw) {
		pw.print(this.toString());
	}
	
	public void increPartidos(String nombre, int pganados, int pjugados) throws CompeticionException {
		Jugador j = buscarJugador(nombre);
		
		if(j==null) {
			throw new CompeticionException("Jugador no encontrado");
		}else {
			j.increPartidos(pganados, pjugados);
		}
	}

	private Jugador buscarJugador(String nombre) {
		Jugador resultado = null;
		Jugador  j = new Jugador(nombre);
		
		Iterator<Equipo> it = competicion.keySet().iterator();
		
		while(it.hasNext()&&resultado==null) {
			List<Jugador> jugadores = competicion.get(it.next());
			Iterator<Jugador> subit = jugadores.iterator();
			
			while(subit.hasNext()&&resultado==null) {
				Jugador ju = subit.next();
				
				if(ju.equals(j)) {
					resultado=ju;
				}
			}
		}
		return resultado;
	
	}
	
	
	
}
