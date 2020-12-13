package prAnagramas;

import java.util.Comparator;

public class SatPalabra implements Comparator<Palabra>{
	public SatPalabra(){}
	
	public int compare(Palabra p1, Palabra p2){
		int res = Integer.compare(p1.getCadena().length(), p2.getCadena().length());
		
		if(res == 0){
			res = p1.getCadena().compareToIgnoreCase(p2.getCadena());
		}
		
		return res;
	}
}
