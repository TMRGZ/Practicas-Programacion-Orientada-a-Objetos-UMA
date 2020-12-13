package prEvaluacionPracticas;
import java.io.PrintWriter;
import java.util.SortedMap;

public class Principal {

	public static void main(String[] args) {
	
		try {
			Evaluacion e = new Evaluacion("practicas.txt");
			
			e.evaluarAlumnos(5);
			
			// para presentar por pantalla
			System.out.println("Calificaciones de alumnos (Evaluacion Normal):\n");
			PrintWriter pw = new PrintWriter(System.out,true);
			e.listarAlumnos(pw);
			
			// para guardar en fichero
			e.listarAlumnos("calificaciones.txt");
			
			SortedMap<Practica,Integer> aprobadas = e.practicasAprobadas();
			
			System.out.println("\nPracticas aprobadas:\n");
			System.out.println(aprobadas.toString());
			
			//ahora EvaluacionRestringida
			EvaluacionRestringida er = new EvaluacionRestringida("practicas.txt","noevaluables.txt");
			
			er.evaluarAlumnos(5);
			
			// para presentar por pantalla
			System.out.println("\nCalificaciones de alumnos (EvaluacionRestringida):\n");
			PrintWriter pwr = new PrintWriter(System.out,true);
			er.listarAlumnos(pwr);
			
			// para guardar en fichero
			er.listarAlumnos("calificacionesRestringidas.txt");
			
		} catch (EvaluacionException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
		
	}

}
