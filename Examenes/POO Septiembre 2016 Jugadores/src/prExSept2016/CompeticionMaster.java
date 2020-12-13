package prExSept2016;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompeticionMaster extends Competicion {
	private int umbral;
	
	public CompeticionMaster(String nombreFichero, int umbral) throws FileNotFoundException {
		super();
		this.umbral = umbral;
		leerDatos(nombreFichero);
	}
	
	public void insertaJugadoresEquipo(Equipo equipo, List<Jugador> jugadores) {
		List<Jugador> jugadoresAsociados = competicion.get(equipo);
		
		if (jugadoresAsociados == null) {
			List<Jugador> listaDef = new ArrayList<Jugador>();
			for (Jugador jug : jugadores) {
				if (jug.getPGanados() >= umbral) {
					listaDef.add(jug);
				}
			}
			competicion.put(equipo, listaDef);
		} else {
			for (Jugador jug : jugadores) {
				if (!jugadoresAsociados.contains(jug)
					&& (jug.getPGanados() >= umbral)) {
					jugadoresAsociados.add(jug);
				}
			}
		}
	}


}
