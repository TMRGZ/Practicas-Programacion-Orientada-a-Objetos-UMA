package prMaternidad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Maternidad {
	protected Map<Persona, Set<Persona>> pacientes;
	
	public Maternidad() {
		pacientes = new TreeMap<>(new OrdAlt());
	}
	
	public Maternidad(String nFich) throws FileNotFoundException {
		this();
		addPacientesFichero(nFich);
	}

	protected void addPacientesFichero(String nFich) throws FileNotFoundException {
		try(Scanner sc = new Scanner(new File(nFich))){
			addPacientes(sc);
		}
	}

	private void addPacientes(Scanner sc) {
		while(sc.hasNextLine()) {
			String linea = sc.nextLine();
			addMadreBebes(linea);
		}
	}

	public void addMadreBebes(String nextLine) {
		try(Scanner sc = new Scanner(nextLine)){
			sc.useDelimiter("[#]+");
			Set<Persona> bebes = new HashSet<>();
			
			Persona madre = leerPersona(sc.next());
			
			while(sc.hasNext()) {
				bebes.add(leerPersona(sc.next()));
			}
			addMadreBebes(madre, bebes);
		}
	}

	public void addMadreBebes(Persona madre, Collection<Persona> bebes) {
		Set<Persona> set = pacientes.get(madre);
		
		if(set==null) {
			set = new TreeSet<Persona>();
			pacientes.put(madre, set);
		}
		set.addAll(bebes);
	}

	private Persona leerPersona(String next) {
		Persona p = null;
		
		try(Scanner sc = new Scanner(next)){
			sc.useDelimiter("[:]+");
			p = new Persona(sc.next(), sc.nextInt(), sc.nextInt());
		}catch(Exception e) {
			throw new MaternidadException("Error al leer Persona");
		}
		return p;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(Persona madre : pacientes.keySet()) {
			sb.append(madre + "#");
			
			for(Persona bebes : pacientes.get(madre)) {
				sb.append("#");
				sb.append(bebes);
			}
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	public void escribirFichero(String nFich) throws FileNotFoundException {
		try(PrintWriter pw = new PrintWriter(nFich)){
			escribir(pw);
		}
	}

	void escribir(PrintWriter pw) {
		pw.print(this.toString());
	}
	
	public double mediaBebes() {
		double suma = 0.0;
		int madres = 0;
		
		for(Set<Persona> bebes : pacientes.values()) {
			if(bebes.size()>0) {
				suma = suma + bebes.size();
				madres++;
			}
		}
		return suma/madres;
	}
	
	public int encontrarMadre(int codigoBebe) {
		int habitacion = -1;
		Persona unaMadre = null;
		Persona p = new Persona("", codigoBebe, 0);
		
		Set<Persona> madres = pacientes.keySet();
		Iterator<Persona> it = madres.iterator();
		
		while(habitacion==-1&&it.hasNext()) {
			unaMadre = it.next();
			
			if(pacientes.get(unaMadre).contains(p)) {
				habitacion = unaMadre.getHabitacion();
			}
		}
		if(habitacion==-1) {
			throw new MaternidadException("Madre no encontrada");
		}
		return habitacion;
	}
}
