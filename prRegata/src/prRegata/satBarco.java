package prRegata;

import java.util.Comparator;

public class satBarco implements Comparator<Barco>{
	Barco b1;
	Barco b2;
	
	public int compare(Barco b1, Barco b2) {
		int res = Double.compare(b1.getPos().getLatitud()+b1.getPos().getLongitud(), b2.getPos().getLatitud()+b2.getPos().getLongitud());
		
		if(res==0){
			res = b1.getNombre().compareToIgnoreCase(b2.getNombre());
		}
	return res;
	}
}
