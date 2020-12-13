package dhondt;

import java.util.Iterator;
import java.util.Map;

/**
 * Clase que modela el sistema de elecciones de D'Hondt modificado mediante la 
 * no consideraci—n de los partidos con un nœmero de votos por debajo de un porcentaje m’nimo.
 * 
 * @author POO
 *
 */
public class EleccionDHondtModificado extends EleccionDHondt {
	
	/**
	 * Crea un objeto EleccionDHondtModificado a partir de una correspondencia de partidos con votos
	 * y el porcentaje m’nimo para que Žstos se consideren.
	 * @param vs	Votos de todos los partidos
	 * @param porc	Porcentaje m’nimo para que se consideren
	 */
	public EleccionDHondtModificado(Map<String,Integer> vs, double porc) {
		super(vs);
		filtrar(porc);
	}
	
	/**
	 * MŽtodo auxiliar que elimina aquellas entradas que correspondan a partidos que no
	 * alcanzan el porcentaje m’nimo de votos.
	 * 
	 * @param porc	Porcentaje m’nimo a alcanzar
	 */
	private void filtrar(double porc) {
		int totalVotos = 0;
		// Sumamos todos los votos emitidos.
		for (int vot : votos.values()) totalVotos += vot;
		// Iteramos sobre las claves y eliminamos aquellas que 
		// correspondan a partidos que no llegan al m’nimo de votos determinado por porc.
		Iterator<String> itPartidos = votos.keySet().iterator();
		while (itPartidos.hasNext()) {
			String partido = itPartidos.next();
			int votosPartido = votos.get(partido);
			if (votosPartido < porc*totalVotos) itPartidos.remove();
		}
	}

}
