package prRegata2n;

import java.util.Arrays;

public class PruebaBarco {

	public static void main(String[] args) {
		
		
		Barco b1 = new Barco("B", new Posicion(0, 0), 0, 0);
		Barco b2 = new Barco("A", new Posicion(0, 0), 0, 0);
		Barco b3 = new Barco("C", new Posicion(0, 0), 0, 0);
		
		Barco[] lista = {b1, b2, b3};

		Arrays.sort(lista);
		
		for(int i=0; i<lista.length; i++) {
			System.out.println(lista[i]);
		}
	}

}
