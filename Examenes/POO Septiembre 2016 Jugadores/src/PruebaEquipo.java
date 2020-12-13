import java.util.*;

import prExSept2016.*;

public class PruebaEquipo {
	public static void main(String [] args) {
		Set<Equipo> conj = new TreeSet<Equipo>();
	
		conj.add(new Equipo("Parque Litoral",3,10));
		conj.add(new Equipo("Centro Padel",2,6));
		conj.add(new Equipo("Padel Palo",3,8));
		
		System.out.println(conj);
		
		Set<Equipo> conj2 = new TreeSet<Equipo>(new OrdenAltEquipo());
		
		conj2.add(new Equipo("Parque Litoral",3,10));
		conj2.add(new Equipo("Centro Padel",2,6));
		conj2.add(new Equipo("Padel Palo",3,8));
		
		System.out.println(conj2);
		
	}
}
