package prExSept2016;

import java.util.SortedSet;
import java.util.TreeSet;

public class PruebaOrden {

	public static void main(String[] args) throws CompeticionException {
		// TODO Auto-generated method stub
		 	Equipo e1 = new Equipo("MALAGA",3,2);
	        Equipo e2 = new Equipo("MADRID",3,10);
	        Equipo e3 = new Equipo("BARCELON", 1, 10);
	        
	        SortedSet<Equipo> s = new TreeSet<>();
	        s.add(e2); s.add(e1); s.add(e3);
	        System.out.println(s);
	}

}
