package prJugadores;

import java.util.SortedSet;
import java.util.TreeSet;

public class PruebaEquipo {

	public static void main(String[] args) throws CompeticionException {
		SortedSet<Equipo> conjunto = new TreeSet<Equipo>();
		SortedSet<Equipo> conjuntoAlternativo = new TreeSet<Equipo>(new OrdenAltEquipo());
		
		Equipo e1 = new Equipo("LolesFC", 3, 10);
		Equipo e2 = new Equipo("CVTM", 2, 6);
		Equipo e3 = new Equipo("Niggu", 3,8);
		
		conjunto.add(e1);
		conjunto.add(e2);
		conjunto.add(e3);
		
		conjuntoAlternativo.add(e1);
		conjuntoAlternativo.add(e2);
		conjuntoAlternativo.add(e3);
		
		System.out.println(conjunto);
		System.out.println(conjuntoAlternativo);
	}

}
