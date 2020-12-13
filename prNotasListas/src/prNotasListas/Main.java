package prNotasListas;

import java.io.FileNotFoundException;
import java.util.Iterator;

public class Main {
	static String[] als = { 
			"25653443S;Garcia Gomez, Juan;8.1",
			"23322443K;Lopez Turo, Manuel;4.3",
			"24433522M;Merlo Martinez, Juana;5.3",
			"53553421D;Santana Medina, Petra;-7.1",
			"55343442L,Godoy Molina, Marina;6.3",
			"342424f2J;Fernandez Vara, Pedro;2.k",
			"42424312G;Lopez Gama, Luisa;7.1" };
	
	public static void main(String[] args) throws FileNotFoundException, AlumnoException {
		Asignatura algebra = new Asignatura("Algebra", als);
		
		Alumno al1 = new Alumno("Lopez Turo, Manuel", "23322443k");
		Alumno al2 = new Alumno("Fernandez Vara, Pedro", "342424f2J");
		System.out.println("Calificacion de " + al1.getDni() + ": "
				+ al1.getCalification());
		System.out.println("Calificacion de " + al2.getDni()+ ": "
				+ al2.getCalification());
		
		System.out.println("Alumnos...");
		
		for(Alumno alumno : algebra.getAlumnos()) {
			System.out.println(alumno.getNombre() + ": " + alumno.getCalification());
			
		}
		
		System.out.println("Malos...");
		
		for (String malo : algebra.getErrores()){
			System.out.println(malo);
			
		}
		System.out.println(algebra);
		
		/*Iterator<Alumno> iterator =algebra.
		while(iterator.hasNext()){
			System.out.println("Alumno= " + iterator.next());
			//iterator.remove(); no posible
		}
		for(Alumno alumno : algebra){
			System.out.println("Alumno= " + iterator.next());
		}*/
	}
}
