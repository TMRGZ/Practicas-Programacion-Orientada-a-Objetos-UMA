import java.io.PrintWriter;

import prExSept2016.*;

public class PruebaTotal {
	public static void main(String[] args) {
		try{
			//Prueba clase Competicion --------------------------
			Competicion comp = new Competicion("equipos.txt");
			System.out.println("Datos leidos y Competici�n creada");
			
			System.out.println("\nEnviando la informaci�n de la competicion a la salida est�ndar\n");
			PrintWriter pw = new PrintWriter(System.out,true); 
			comp.escribir(pw);
			pw.flush();
			
			System.out.println("\nGuardando la informaci�n de la competicion en el fichero salida.txt");
			comp.escribirFichero("salida.txt");
			
			System.out.println("\nProbando incremento de partidos\n");
			comp.increPartidos("Alfredo Maroto", 1, 1);
			
			System.out.println(comp);
			
		
			/*Prueba clase CompeticionMaster --------------------------
			CompeticionMaster compMaster = new CompeticionMaster("equipos.txt",2);
			System.out.println("\nDatos leidos y Competici�n Master creada");
			
			System.out.println("\nEnviando la informaci�n de la competicion Master a la salida est�ndar\n"); 
			compMaster.escribir(pw);
			pw.flush();*/
			
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		
	}
}
