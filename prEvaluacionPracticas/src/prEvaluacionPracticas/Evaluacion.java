package prEvaluacionPracticas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class Evaluacion {
	SortedMap<Alumno, SortedSet<Practica>> practicas;
	
	public Evaluacion() {
		practicas = new TreeMap<Alumno, SortedSet<Practica>>();
	}
	
	public Evaluacion(String nFich) {
		this();
		try(Scanner sc = new Scanner(new File(nFich))){
			leer(sc);
			
		} catch (FileNotFoundException e) {
			throw new EvaluacionException("FIchero no encontrado");
		}catch(NoSuchElementException e) {
			throw new EvaluacionException("Error al procesar");
		}
	}

	private void leer(Scanner sc) {
		while(sc.hasNextLine()) {
			procesarAlumno(sc);
		}
	}

	private void procesarAlumno(Scanner sc) {
		String lineaAlumno = sc.nextLine();
		
		try(Scanner scAlumno = new Scanner(lineaAlumno)){
			scAlumno.useDelimiter(":");
			String dni = scAlumno.next();
			String nombre = scAlumno.next();
			int numPracticas = scAlumno.nextInt();
			
			Alumno a = new Alumno(dni, nombre);
			procesarPractica(a, numPracticas, sc);
		}
	}

	private void procesarPractica(Alumno a, int numPracticas, Scanner sc) {
		SortedSet<Practica> pRealizadas = new TreeSet<>();
		
		for(int i=0; i<numPracticas; i++) {
			String lineaPractica = sc.nextLine();
			
			try(Scanner scPrac = new Scanner(lineaPractica)){
				scPrac.useDelimiter(" ");
				
				String nombre = scPrac.next();
				double nota = scPrac.nextDouble();
				
				pRealizadas.add(new Practica(nombre, nota));
			}catch(NoSuchElementException e) {
				throw new EvaluacionException("Faltan datos para crear practica");
			}
		}
		practicas.put(a, pRealizadas);
	}
	
	public void evaluarAlumnos(double extra) {
		double media = mediaNumeroPracticas();
		double calificacion;
		
		for(Alumno a : practicas.keySet()) {
			calificacion=0;
			int contador=0;
			
			for(Practica p : practicas.get(a)) {
				calificacion=calificacion + p.getPuntuacion();
				contador++;
			}
			a.setCalificacion((contador>=media) ? calificacion+extra : calificacion-extra);
		}
	}

	protected double mediaNumeroPracticas() {
		double suma = 0;
		
		for(Alumno a : practicas.keySet()) {
			suma = suma + practicas.get(a).size();
		}
		return suma/practicas.keySet().size();
	}
	
	public SortedMap<Practica, Integer> practicasAprobadas(){
		SortedMap<Practica, Integer> aprobadas = new TreeMap<Practica, Integer>();
		
		for(Alumno a : practicas.keySet()) {
			for(Practica p : practicas.get(a)) {
				if(p.getPuntuacion()>=5) {
					Integer numAlumnos = aprobadas.get(p);
					
					if(numAlumnos==null) {
						aprobadas.put(p, 1);
					}else {
						aprobadas.put(p, numAlumnos+1);
					}
				}
			}
		}
		return aprobadas;
	}
	
	public String representarAlumnos() {
		StringBuilder sb = new StringBuilder();
		
		for(Alumno a : practicas.keySet()) {
			sb.append(a).append("\n");
		}
		return sb.toString();
	}
	
	public void listarAlumnos(String nFich) {
		try(PrintWriter pw = new PrintWriter(new File(nFich))){
			listarAlumnos(pw);
		} catch (FileNotFoundException e) {
			throw new EvaluacionException("Error al guardar");
		}
	}

	public void listarAlumnos(PrintWriter pw) {
		pw.println(representarAlumnos());
	}
}
