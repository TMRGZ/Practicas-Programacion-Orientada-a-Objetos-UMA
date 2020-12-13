import java.io.*;
import java.util.*;


public class Evaluacion {
	protected SortedMap<Alumno,SortedSet<Practica>> practicas;
	
	public Evaluacion(String nombreFichero) throws FileNotFoundException {
		practicas = new TreeMap<Alumno,SortedSet<Practica>>();
		leer(nombreFichero);
	}
	
	private void leer(String nombreFichero) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(nombreFichero));
		leer(sc);
		sc.close();
	}
	
	private void leer(Scanner sc) {
		while (sc.hasNextLine()) {
			procesarAlumno(sc.nextLine(),sc);
		}
	}
	
	private void procesarAlumno(String lineaAlumno, Scanner sc) {
		StringTokenizer st = new StringTokenizer(lineaAlumno,":");
		try { 
			String dni = st.nextToken();
			String nombre = st.nextToken();
			int numeroPracticas = Integer.parseInt(st.nextToken());
			
			Alumno alumno = new Alumno(dni,nombre);
			procesarPracticas(alumno,numeroPracticas,sc);
		} catch(NoSuchElementException e) {
			throw new EvaluacionException("Faltan datos de alumno");
		} catch (NumberFormatException e) {
			throw new EvaluacionException("Formato incorrecto en datos de alumno");
		}
	}
	
	private void procesarPracticas(Alumno alumno, int numeroPracticas, Scanner sc) {
		SortedSet<Practica> practicasRealizadas = new TreeSet<Practica>();
		
		for (int cont = 0; cont < numeroPracticas; cont++) {
			String lineaPractica = sc.nextLine();
			StringTokenizer st = new StringTokenizer(lineaPractica," ");
			try {
				String nombre = st.nextToken();
				double puntuacion = Double.parseDouble(st.nextToken());
				
				practicasRealizadas.add(new Practica(nombre,puntuacion));
				
			} catch(NoSuchElementException e) {
				throw new EvaluacionException("Faltan datos de practica");
			} catch (NumberFormatException e) {
				throw new EvaluacionException("Formato incorrecto en datos de practica");
			}
		}
		
		practicas.put(alumno, practicasRealizadas);
	}
	
	public void evaluarAlumnos(double extra) {
		double media = mediaNumeroPracticas();
		
		for (Alumno alu : practicas.keySet()) {
			double calificacion = 0;
			int contadorNumeroPracticas = 0;
			for (Practica pra : practicas.get(alu)) {
				calificacion += pra.getPuntuacion();
				contadorNumeroPracticas++;
			}
			alu.setCalificacion((contadorNumeroPracticas >= media)? calificacion + extra: calificacion - extra);
		}
	}
	
	protected double mediaNumeroPracticas() {
		double suma = 0;
		for (Alumno alu : practicas.keySet()) {
			suma += practicas.get(alu).size();
		}
		
		return suma / practicas.keySet().size();  
	}
	
	public SortedMap<Practica,Integer> practicasAprobadas() {
		SortedMap<Practica,Integer> aprobadas = new TreeMap<Practica,Integer>();
		
		for (Alumno alu : practicas.keySet()) {
			for (Practica pra : practicas.get(alu)) {
				if (pra.getPuntuacion() >= 5) {
					Integer numeroAlumnos = aprobadas.get(pra);
					if (numeroAlumnos == null) {
						aprobadas.put(pra, 1);
					} else {
						aprobadas.put(pra, numeroAlumnos+1);
					}
				}
			}
		}
		
		return aprobadas;
	}
	
	
	public String representarAlumnos() {
		StringBuilder sb = new StringBuilder();
		for (Alumno alu : practicas.keySet()) {
			sb.append(alu).append("\n");
		}
		return sb.toString();
	}
	
	public void listarAlumnos(String nombreFichero) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(nombreFichero);
		listarAlumnos(pw);
		pw.close();
	}
	
	public void listarAlumnos(PrintWriter pw) {
			pw.println(representarAlumnos());
	}
	
}
