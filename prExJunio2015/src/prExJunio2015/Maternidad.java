package prExJunio2015;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Maternidad {
	SortedMap<Persona, SortedSet<Persona>> pacientes;
	
	public Maternidad(){
		pacientes = new TreeMap<>(new OrdAlt());
	}
	
	public Maternidad(String nFich) throws FileNotFoundException{
		this();
		addPacientesFichero(nFich);
	}

	private void addPacientesFichero(String nFich) throws FileNotFoundException {
		try(Scanner scLinea = new Scanner(new File(nFich))){
			addPacientes(scLinea);
		}
	}

	private void addPacientes(Scanner scLinea) {
		while (scLinea.hasNextLine()){
			addMadreBebes(scLinea.nextLine());
		}
	}
	
	private void addMadreBebes(String nextLine) {
		StringTokenizer st = new StringTokenizer(nextLine, "#");
		try{
			Persona madre = leerPersona(st.nextToken());
			Set<Persona> bebes = new HashSet<>();
			while (st.hasMoreTokens()){
				bebes.add(leerPersona(st.nextToken()));
			}
			addMadreBebes(madre,bebes);
			
		}catch (NoSuchElementException e){
			//Si no hay ni siquiera madre, entonces filtramos esa línea y seguimos ejecutando.
		}
		
	}

	private Persona leerPersona(String datos) {
		Persona p = null;
		StringTokenizer st = new StringTokenizer(datos, ":");
		try{
			p = new Persona(st.nextToken(), 
					 		Integer.parseInt(st.nextToken()), 
					 		Integer.parseInt(st.nextToken()));
		}catch (NoSuchElementException e){
			throw new MaternidadException("Faltan datos");
		}catch (NumberFormatException e){
			throw new MaternidadException("Datos incorrectos.");
		}
		return p;
	}

	public void addMadreBebes(Persona madre, Collection<Persona> bebes){
		if (!pacientes.containsKey(madre)){
			pacientes.put(madre, new TreeSet<Persona>());
		}
		pacientes.get(madre).addAll(bebes);
	}
	
	public int encontrarMadre(int codigoBebe){
		boolean encontrado=false;
		Persona bebe = new Persona("", codigoBebe, 0);
		Persona madre = null;
		Set<Persona> madres = pacientes.keySet();
		Iterator<Persona> it = madres.iterator();
		
		while(!encontrado&&it.hasNext()){
			madre=it.next();
			
			if(pacientes.get(madre).contains(bebe)){
				encontrado=true;
			}
		}
		if(encontrado){
			return madre.getHabitacion();
		}else{
			throw new MaternidadException("Falta Madre");
		}
	}
	
	public double mediaBebes(){
		int contador=0;
		double suma = 0;
		pacientes.values().size();
		
		for(Persona madre : pacientes.keySet()){
			if(pacientes.get(madre).size()>0){
				suma = suma+pacientes.get(madre).size();
				contador++;
			}
		}
		return suma/contador;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		for(Persona madre : pacientes.keySet()){
			sb.append(madre);
			for(Persona bebe : pacientes.get(madre)){
				sb.append("#").append(bebe);
			}
				sb.append("\n");
		}
		return sb.toString();
	}
	
	public void escribirFichero(String nFich) throws FileNotFoundException{
		try(PrintWriter pw = new PrintWriter(new File(nFich))){
			escribir(pw);
		}
	}

	public void escribir(PrintWriter pw) {
		pw.print(this.toString());
	}
}
