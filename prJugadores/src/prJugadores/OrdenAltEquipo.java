package prJugadores;

import java.util.Comparator;

public class OrdenAltEquipo implements Comparator<Equipo>{

	@Override
	public int compare(Equipo o1, Equipo o2) {
		int res = Integer.compare(o1.getCategoria(), o2.getCategoria());
		res=-res;
		
		if(res==0) {
			res=o1.getNombre().compareToIgnoreCase(o2.getNombre());
		}
		if(res==0) {
			res= Integer.compare(o1.getPuntosConseguidos(), o2.getPuntosConseguidos());
			res=-res;
		}
		
		return res;
	}
}
