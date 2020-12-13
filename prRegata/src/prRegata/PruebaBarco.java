package prRegata;

import java.lang.reflect.Array;

public class PruebaBarco {

	public static void main(String[] args) {
		Barco[] barcos = {
				new Barco("alisa", new Posicion(30,  240), 80, 20),
				new Velero("veraVela", new Posicion(-30, 290), 20, 14),
				new Barco("kamira", new Posicion(80, 182), 230, 33),
				new Barco("gamonal", new Posicion(0, -260), 0, 24),			
		};
		
	
		
		for(int i =0; i<barcos.length; i++){
			System.out.println(barcos[i]);
		}
	}
}
