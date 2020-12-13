package regata;

import java.util.Arrays;

public class PruebaBarco {

	public static void main(String[] args) {
		Barco[] barcos = {
				new Barco("alisa", new Posicion(30,  240), 80, 20),
				new Barco("veraVela", new Posicion(-30, 290), 20, 14),
				new Barco("kamira", new Posicion(80, 182), 230, 33),
				new Barco("gamonal", new Posicion(0, -260), 0, 24),			
		};

		Arrays.sort(barcos);
		
		for(Barco b : barcos) {
			System.out.println(b + "\n");
		}
	}

}
