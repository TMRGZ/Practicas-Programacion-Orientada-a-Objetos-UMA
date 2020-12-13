package prRegata2n;

import java.util.Comparator;

public class SatBarco implements Comparator<Barco>{

	@Override
	public int compare(Barco b1, Barco b2) {
		// TODO Auto-generated method stub
		int res = Double.compare(b1.getPosicion().distancia(new Posicion(0,0)), b2.getPosicion().distancia(new Posicion(0,0)));
		
		if(res==0) {
			res = b1.getNombre().toLowerCase().compareTo(b2.getNombre().toLowerCase());
		}
		return 0;
	}
}
