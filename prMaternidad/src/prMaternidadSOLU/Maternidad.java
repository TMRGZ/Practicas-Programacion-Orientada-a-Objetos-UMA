package prMaternidadSOLU;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;


public class Maternidad {
	private Map<Persona, Set<Persona>> pacientes;
	
	public Maternidad(){
		pacientes = new TreeMap<>(new OrdAlt());
	}
	
	public Maternidad(String fileName) throws FileNotFoundException{
		this();
		addPacientesFichero(fileName);
	}
	
	//Añade a la estructura de datos la información del fichero sobre las madres e hijos ingresados.
	public void addPacientesFichero (String fileName) throws FileNotFoundException{
		try (Scanner sc = new Scanner (new File(fileName))) {
			addPacientes(sc);
		}
	}
	
	public void addPacientes(Scanner sc){
		while (sc.hasNextLine()){
			addMadreBebes(sc.nextLine());
		}
	}
	
	private void addMadreBebes(String linea){
		try (Scanner sc = new Scanner (linea)) {
			sc.useDelimiter("[#]+");
			Persona madre = leerPersona(sc.next());
			Set<Persona> bebes = new HashSet<>();
			while (sc.hasNext()){
				bebes.add(leerPersona(sc.next()));
			}
			addMadreBebes(madre,bebes);
			
		}catch (NoSuchElementException e){
			throw new MaternidadException("Linea incorrecta.");
		}
	}
	
	private Persona leerPersona(String datos){
		Persona p = null;
		try (Scanner sc = new Scanner(datos)) {
			sc.useDelimiter("[:]+");
			p = new Persona(sc.next(), 
					 		sc.nextInt(), 
					 		sc.nextInt());
		}catch (InputMismatchException e){
			throw new MaternidadException("Datos incorrectos.");
		}catch (NoSuchElementException e){
			throw new MaternidadException("Faltan datos");
		}
		return p;
	}
	
	
	public void addMadreBebes(Persona madre, Collection<Persona> bebes){
		Set<Persona> set = pacientes.get(madre);
		if (set == null) {
			set = new TreeSet<Persona>();
			pacientes.put(madre, set);
		}
		set.addAll(bebes);
	}
	
	
	public void escribirFichero (String fileName) throws FileNotFoundException{
		try (PrintWriter pw = new PrintWriter(fileName)) {
			escribir(pw);
		}
	}
	
	public void escribir(PrintWriter pw){
		pw.print(this.toString());
	}

		
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for (Persona madre : pacientes.keySet()){
			sb.append(madre);
			for(Persona bebe : pacientes.get(madre)){
				sb.append("#");
				sb.append(bebe);
			}
			sb.append("\n");
		}
		return sb.toString();
	}
	
	//Calcula la media de hijos por madre. Aquellas madres que no tienen hijos asociados se tienen en cuenta al
	//no se tienen en cuenta para computar la media.
	public double mediaBebes(){
		double suma = 0.0;
		int madres = 0;
			
		for (Set<Persona> bebes : pacientes.values()){
			if (bebes.size() > 0){
				suma += bebes.size();
				madres ++;
			}
		}
		return suma/madres;
	}
	
	//Encontrar el número de habitación de la madre correspondiente al bebé cuyo código se pasa como parámetro.
	public int encontrarMadre(int codigo){
		int habitacion = -1;
		Persona unaMadre = null;
		Persona p = new Persona(" ",codigo,0);
		
		Set<Persona> madres = pacientes.keySet();
		Iterator<Persona> it = madres.iterator();
		
		while (habitacion == -1 && it.hasNext()) {
			unaMadre = it.next();
			if (pacientes.get(unaMadre).contains(p)) {
				habitacion = unaMadre.getHabitacion();
			}
		}
		
		if (habitacion == -1) {
			throw new MaternidadException("El bebé no está registrado en el servicio de maternidad");
		}
		
		return habitacion;
	}		
}
