package prParking;

import java.util.Comparator;

public class ComparadorParking implements Comparator<Parking> {
	Vehiculo vehiculo;
	
	public ComparadorParking(Vehiculo v) {
		vehiculo = v;
	}
	
	@Override
	public int compare(Parking p1, Parking p2) {
		// TODO Auto-generated method stub
		int res;
		double d1 = vehiculo.getPosicion().distancia(p1.getPosicion());
		double d2 = vehiculo.getPosicion().distancia(p2.getPosicion());
		
		if (d1 < d2) {
			res = -1;
		} else if (d1 > d2) {
			res = 1;
		} else {
			res = 0;
		}
		
		return res;
	}

}
