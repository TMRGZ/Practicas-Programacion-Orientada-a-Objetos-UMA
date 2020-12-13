package prCuentaPalabrasSimpleFicheros;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class PruebaContadorPalabras {

	public static void main(String[] args) throws FileNotFoundException {
		ContadorPalabras cp = new ContadorPalabras(5);
		String [] datos = {
				"Esta es la primera frase de prueba", "y esta la segunda"
				
		};
		
		cp.IncluyeTodas(datos, "[ ]");
		System.out.println(cp);
		cp.presentaPalabras("salida.txt");
		PrintWriter pw = new PrintWriter(System.out, true);
		cp.presentaPalabras(pw);
	}

}
