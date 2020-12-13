package prEvaluacionPracticas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvaluacionRestringida extends Evaluacion{
	List<Alumno> alumnosNoEvaluables;
	
	public EvaluacionRestringida(String practicas, String noEvaluables) {
		super(practicas);
		alumnosNoEvaluables = new ArrayList<>();
		
		try(Scanner sc = new Scanner(new File(noEvaluables))){
			while(sc.hasNextLine()) {
				try(Scanner scLinea = new Scanner(sc.nextLine())){
					scLinea.useDelimiter(":");
					String dni = scLinea.next();
					String nombre = scLinea.next();
					
					Alumno a = new Alumno(dni, nombre);
					alumnosNoEvaluables.add(a);
				}
			}	
		} catch (FileNotFoundException e) {
				throw new EvaluacionException("Fichero noEvaluables no encontrado");
		}
	}
	@Override
	public void evaluarAlumnos(double extra) {
		double media = mediaNumeroPracticas();
		double calificacion;
		
		for(Alumno a : practicas.keySet()) {
			if(!alumnosNoEvaluables.contains(a)) {
				calificacion=0;
				int contador=0;
				
				for(Practica p : practicas.get(a)) {
					calificacion=calificacion + p.getPuntuacion();
					contador++;
				}
				a.setCalificacion((contador>=media) ? calificacion+extra : calificacion-extra);
			}else {
				a.setCalificacion(0);
			}
		}
	}
}
