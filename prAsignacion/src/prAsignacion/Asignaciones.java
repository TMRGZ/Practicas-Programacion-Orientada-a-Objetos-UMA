package prAsignacion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Asignaciones {
	private final int NUM_LAB;
	SortedMap<Integer, SortedSet<PeticionAsignacion>> asignaciones;
	protected List<PeticionAsignacion> conflictos;
	
	public Asignaciones(int num) {
		if(num<1) {
			throw new AsignacionException("Numero de laboratorios no valido");
		}else {
			NUM_LAB=num;
			asignaciones = new TreeMap<>();
			conflictos = new ArrayList<>();
			
			for(int i=1; i<=NUM_LAB; i++) {
				asignaciones.put(i, new TreeSet<>());
			}
		}
	}
	
	public Asignaciones(int num, String nFich) throws FileNotFoundException {
		this(num);
		leerPeticionesFichero(nFich);
	}
	
	public Set<Integer> buscarHuecos(FranjaHoraria franja){
		Set<Integer> huecos = new TreeSet<>();
		PeticionAsignacion vacia = new PeticionAsignacion("", "", franja);
		
		for(int i : asignaciones.keySet()) {
			if(!asignaciones.get(i).contains(vacia)) {
				huecos.add(i);
			}
		}
		return huecos;
	}
	
	public boolean nuevaAsignacion(PeticionAsignacion pa) {
		boolean res = false;
		Set<Integer> libres = buscarHuecos(pa.getFranja());
		
		if(!libres.isEmpty()) {
			res = asignaciones.get(libres.iterator().next()).add(pa);
		}
		return res;
	}
	
	public void realizarAsignacion(String linea) {
		PeticionAsignacion pa = null;
		
		try(Scanner sc = new Scanner(linea)){
			sc.useDelimiter("[#]+");
			
			pa = new PeticionAsignacion(sc.next(), sc.next(), new FranjaHoraria(sc.next(),sc.next()));
			
			if(!nuevaAsignacion(pa)) {
				conflictos.add(pa);
			}
			
		}catch(Exception e) {
			conflictos.add(pa);
			throw new AsignacionException("Error añadido a conflictos.");
		}
	}

	private void leerPeticionesFichero(String nFich) throws FileNotFoundException {
		try(Scanner sc = new Scanner(new File(nFich))){
			while(sc.hasNextLine()) {
				realizarAsignacion(sc.nextLine());
			}
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Asignaciones: \n");
		
		for(Integer i : asignaciones.keySet()) {
			sb.append("Laboratorio " + i);
			
			for(PeticionAsignacion p : asignaciones.get(i)) {
				sb.append("\t " +p + "\n");
			}
		}
		
		sb.append("Conflictos: \n");
		
		for(PeticionAsignacion p : conflictos) {
			sb.append("\t" + p + "\n");
		}
		
		return sb.toString();
	}
	
	public void escribirAFIchero(String nFich) throws FileNotFoundException {
		try(PrintWriter pw = new PrintWriter(new File(nFich))){
			escibirAsignaciones(pw);
		}
	}

	private void escibirAsignaciones(PrintWriter pw) {
		pw.print(this.toString());
		
	}
}
