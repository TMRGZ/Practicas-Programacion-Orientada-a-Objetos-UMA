package prExSept2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

import prExSept2016SOL.Equipo;
import prExSept2016SOL.Jugador;

public class Competicion {
	protected SortedMap<Equipo, List<Jugador>> Competicion;
	
	public Competicion(){
		Competicion = new TreeMap<Equipo, List<Jugador>>();
	}
	
	public Competicion (String nomFich) throws FileNotFoundException, CompeticionException{
		Competicion = new TreeMap<Equipo, List<Jugador>>();
		leerDatos(nomFich);
	}
	
	public void leerDatos(String nomFich) throws FileNotFoundException, CompeticionException{
		try(Scanner sclinea = new Scanner(new File(nomFich))){
			while(sclinea.hasNextLine()){
				crearEquipo(sclinea.nextLine());
			}
		}
	}
	
	private void crearEquipo(String linea) throws CompeticionException {
		try(Scanner sc = new Scanner(linea)){
			sc.useDelimiter("[:]+");
			
			Equipo e = new Equipo(sc.next(), sc.nextInt(), sc.nextInt());
			List<Jugador> J = new ArrayList<Jugador>();
			
			while(sc.hasNext()){
				J.add(new Jugador(sc.next(), sc.nextInt(), sc.nextInt()));
			}
			insertaJugadoresEquipo(e, J);
		
		}catch(InputMismatchException e){
			throw new CompeticionException("Datos no validos");
		}catch(NoSuchElementException e){
			throw new CompeticionException("Faltan Datos");
		}
	}

	private void insertaJugadoresEquipo(Equipo E, List<Jugador> J) {
		List<Jugador> jAsociados = Competicion.get(E);
		
		if(jAsociados==null){
			Competicion.put(E, J);
		}else{
			for(Jugador j:J){
				if(!jAsociados.contains(j)){
					jAsociados.add(j);
				}
			}
		}
	}

	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		for(Equipo E : Competicion.keySet()){
			sb.append(E)
				.append("\n")
				.append(Competicion.get(E))
				.append("\n");
		}
		return sb.toString();
	}
	
	public void escribirFichero(String nomFich) throws FileNotFoundException{
		try(PrintWriter pw = new PrintWriter(new File(nomFich))){
			escribir(pw);
		}
	}
	
	public void escribir(PrintWriter pw){
		pw.print(this.toString());
	}
	
	public void increPartidos(String nomJugador, int pjugados, int pganados) throws CompeticionException{
		Jugador jugador = buscarJugador(nomJugador);
		
		if(jugador==null){
			throw new CompeticionException("Jugador no encontrado");
		}
		jugador.increPartidos(pganados, pjugados);
	}

	private Jugador buscarJugador(String nomJugador) {
		Jugador resultado = null;
		
		Jugador jugador = new Jugador(nomJugador);
		Iterator<Equipo> iterEq = Competicion.keySet().iterator();
				
		while (iterEq.hasNext() && (resultado == null)) {
			List<Jugador> jugadores = Competicion.get(iterEq.next());
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
}
