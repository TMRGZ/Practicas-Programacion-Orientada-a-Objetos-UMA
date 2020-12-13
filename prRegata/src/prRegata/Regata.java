package prRegata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Regata {
	SortedSet<Barco> participantes;
	
	public Regata(){
		participantes = new TreeSet<>();
	}
	
	public void agrega(Barco b){
		if(!participantes.contains(b)){
			participantes.add(b);
		}
	}
	
	public boolean velocidadSuperiorA(int vel){
		boolean encontrado = false;
		
		for(Barco b : participantes){
			if(b.getVelocidad()>vel){
				encontrado=true;
			}
		}
		return encontrado;
	}
	
	public Set<Barco> getParticipantes(){
		return participantes;
	}
	
	public Map<Integer, Set<Barco>> barcosPorVelocidad(){
		Map<Integer, Set<Barco>> mapa = new TreeMap<>();
		
		for(Barco b : participantes){
			int cota = b.getVelocidad()/10;
			
			if(mapa.get(cota)==null){
				mapa.put(cota, new TreeSet<>());
			}
			mapa.get(cota).add(b);
		}
		return mapa;
	}
	
	public List<Barco> dentroDelCircuito(Posicion pos, int km){
		List<Barco> lista = new ArrayList<>();
		
		for(Barco b : participantes){
			if(b.getPos().distancia(pos)<km){
				lista.add(b);
			}
		}
		return lista;
	}
	
	public void avanza(int mnt){
		for(Barco b : participantes){
			b.avanza(mnt);
		}
	}
	
	public Set<Barco> ordenadosPorDistancia(){
		Set<Barco> partalt = new TreeSet<>(new satBarco());
		
		for(Barco b : participantes){
			partalt.add(b);
		}
		return partalt;
	}
	
	public Barco creaBarcoString (String Linea){
		try(Scanner scBarco = new Scanner(Linea)){
			
			String nombre = scBarco.next();
			double latitud = scBarco.nextDouble();
			double longitud = scBarco.nextDouble();
			int rumbo = scBarco.nextInt();
			int velocidad = scBarco.nextInt();
			
			Posicion pos = new Posicion(latitud,  longitud);
			Barco annadir = new Barco(nombre, pos, rumbo, velocidad);
			
			return annadir;
		}
	}
	
	public void leeFichero(String nFich) throws FileNotFoundException{
		try(Scanner sc = new Scanner(new File(nFich))){
			sc.useDelimiter("[, ]+");
			lee(sc);
		}catch(RuntimeException e){
			throw new RegataException("Error General");
		}
	}
	
	public void lee(Scanner sc){
		while(sc.hasNextLine()){
			Barco b = creaBarcoString(sc.nextLine());
			participantes.add(b);
		}
	}
	
	public void escribeFichero(String nFich) throws FileNotFoundException{
		try(PrintWriter pw = new PrintWriter(new File(nFich))){
			escribe(pw);
		}
	}
	
	public void escribe(PrintWriter pw){
		for(Barco b : participantes){
			pw.println(b.toString());
			pw.print("/n");
		}
	}
}
