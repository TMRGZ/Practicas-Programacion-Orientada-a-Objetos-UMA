package prMaternidad;

import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
		try{
			//Testing class Maternidad------------------------------------------------
			Maternidad mat = new Maternidad("pacientes2.txt");
			System.out.println("Datos leidos:");
			System.out.println(mat);
			
			System.out.println("Ratio Beb�s/Madre: " + mat.mediaBebes());
						
			int codigoBebe = 1100;
			System.out.println("La madre del beb� con c�digo " + codigoBebe +
								" est� en la habitaci�n " + mat.encontrarMadre(codigoBebe));
			
			
			System.out.println("Enviando la informaci�n a la salida est�ndar");
			PrintWriter pw = new PrintWriter(System.out,true); 
			mat.escribir(pw);
			pw.flush();
			
			System.out.println("Guardar Datos en salida.txt");
			mat.escribirFichero("salida.txt");
			
			//Testing class MaternidadLimiteNi�osHabitacion-----------------------------------
			System.out.println("\n\nProbando maternidad con l�mite de beb�s por habitaci�n");
			mat = new MaternidadLimiteBebesHabitacion(2,"pacientes2.txt");
			System.out.println("Datos leidos:");
			System.out.println(mat);
			
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}

}
