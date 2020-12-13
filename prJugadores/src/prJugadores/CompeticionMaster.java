package prJugadores;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class CompeticionMaster extends Competicion{
	private int umbral;
	
	public CompeticionMaster(String nFIch, int umbral) throws FileNotFoundException, CompeticionException {
		super();
		this.umbral=umbral;
		leerDatos(nFIch);
	}
	
	public void insertaJugadoresEquipo(Equipo e, List<Jugador> jugadores) {
		List<Jugador> jugadoresAsociados = competicion.get(e);
		
		if(jugadoresAsociados == null) {
			jugadoresAsociados = new ArrayList<Jugador>();
			
			for(Jugador ju : jugadoresAsociados) {
				if(ju.getPGanados()>=umbral) {
					jugadoresAsociados.add(ju);
				}
			}
			competicion.put(e, jugadoresAsociados);
		}else {
			for(Jugador ju : jugadoresAsociados) {
				if(!jugadoresAsociados.contains(ju)&&ju.getPGanados()>=umbral) {
					jugadoresAsociados.add(ju);
				}
			}
		}
	}
	
}
