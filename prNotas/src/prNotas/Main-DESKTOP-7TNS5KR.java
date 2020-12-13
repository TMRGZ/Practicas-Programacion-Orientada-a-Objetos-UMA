package prNotas;

import java.io.FileNotFoundException;

public class Main {
	static String[] als = { 
			"25653443S;Garcia Gomez, Juan;8.1",
			"23322443K;Lopez Turo, Manuel;4.3",
			"24433522M;Merlo Martinez, Juana;5.3",
			"53553421D;Santana Medina, Petra;-7.1",
			"55343442L,Godoy Molina, Marina;6.3",
			"342424f2J;Fernandez Vara, Pedro;2.k",
			"42424312G;Lopez Gama, Luisa;7.1" };
	
	public static void main(String[] args) throws FileNotFoundException {
		Asignatura algebra = new Asignatura("Algebra", als);
		
		try{
			Alumno al1 = new Alumno("Lopez Turo, Manuel", "23322443k");
			Alumno al2 = new Alumno("Fernandez Vara, Pedro", "342424f2J");
			System.out.println("Calificacion de " + al1 + ": "
					+ algebra.getCalification(al1));
			System.out.println("Calificacion de " + al2 + ": "
					+ algebra.getCalification(al2));
			
		}catch (AlumnoException e) {
			System.err.println(e.getMessage());
		
		}try {
			CalculoMedia m1 = new MediaAritmetica();
			CalculoMedia m2 = new MediaArmonica();
			double min = 5.0;
			double max = 9.0;
			CalculoMedia m3 = new MediaSinExtremos(min,max);
			System.out.println("Media aritmetica " + algebra.getMedia(m1));
			System.out.println("Media armonica " + algebra.getMedia(m2));
			System.out.println("Media de valores en ["+min+","+max+"] " +
					algebra.getMedia(m3));
			
		}catch (AlumnoException e) {
			System.out.println("Error "+ e.getMessage());
			
		}
		
		System.out.println("Alumnos...");
		
		for(Alumno alumno : algebra.getAlumnos()) {
			System.out.println(alumno + ": " + alumno.getCalification());
			
		}
		
		System.out.println("Malos...");
		
		for (String malo : algebra.getErrores()){
			System.out.println(malo);
			
		}
		
		System.out.println(algebra);
	}
}
