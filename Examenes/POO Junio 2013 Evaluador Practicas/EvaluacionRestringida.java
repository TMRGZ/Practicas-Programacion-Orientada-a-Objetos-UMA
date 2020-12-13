import java.io.*;
import java.util.*;


public class EvaluacionRestringida extends Evaluacion {

	private List<Alumno> alumnosNoEvaluables;
	
	public EvaluacionRestringida(String ficheroPracticas, String ficheroNoEvaluables) throws IOException {
		super(ficheroPracticas);
		alumnosNoEvaluables = new ArrayList<Alumno>();
		leerNoEvaluables(ficheroNoEvaluables);
	}
	
	private void leerNoEvaluables(String nombreFichero) throws FileNotFoundException {
		Scanner sc = new Scanner(new File(nombreFichero));
		leer(sc);
		sc.close();
	}
	
	private void leer(Scanner sc)  {
		while (sc.hasNextLine()) {
			procesarAlumno(sc.nextLine(),sc);
		}
	}
	
	private void procesarAlumno(String lineaAlumno, Scanner sc) {
		StringTokenizer st = new StringTokenizer(lineaAlumno,":");
		try { 
			String dni = st.nextToken();
			String nombre = st.nextToken();
			
			Alumno alumno = new Alumno(dni,nombre);

			alumnosNoEvaluables.add(alumno);
			
		} catch(NoSuchElementException e) {
			throw new EvaluacionException("Faltan datos de alumno");
		}
	}
	
	public void evaluarAlumnos(double extra) {
		double media = mediaNumeroPracticas();
		
		for (Alumno alu : practicas.keySet()) {
			if (!alumnosNoEvaluables.contains(alu)) {
				double calificacion = 0;
			
				int contadorNumeroPracticas = 0;
				for (Practica pra : practicas.get(alu)) {
					calificacion += pra.getPuntuacion();
					contadorNumeroPracticas++;
				}
				alu.setCalificacion((contadorNumeroPracticas >= media)? calificacion + extra: calificacion - extra);
			}
		}
	}	
}
