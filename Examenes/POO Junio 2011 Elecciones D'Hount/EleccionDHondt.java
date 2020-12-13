package dhondt;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/** 
 * La clase Eleccion almacena los votos computables recibidos por diversos partidos en unas elecciones
 * @author POO
 *
 */
public class EleccionDHondt {
	protected Map<String,Integer> votos;
	
	/**
	 * Crea un objeto Eleccion a partir de una correspondencia partido/nro. votos.
	 * La estructura votos se crea con los elementos que se pasan como argumento, en vez
	 * de hacer referencia directamente al argumento. Es decir, se evita hacer votos = vs.
	 * 
	 * @param vs	Correspondencia entre partidos y votos
	 */
	public EleccionDHondt(Map<String,Integer> vs) {
		// Se inicializa la estructura
		votos = new HashMap<String,Integer>();
		// Se recorre la correspondencia pasada como par‡metro
		for (Map.Entry<String,Integer> votosPartido : vs.entrySet()) {
			// Y a–adimos a "votos" la entrada correspondiente
			votos.put(votosPartido.getKey(),votosPartido.getValue());
		}
	}
	
	/**
	 * Realiza el reparto de un nœmero determinado de cargos electos sobre los votos 
	 * almacenados en la estructura votos.
	 *
	 * @param car	El nœmero de cargos electos a repartir
	 * @return		Una correspondencia partido/nro. de cargos.
	 */
	public SortedMap<String,Integer> reparto(int car) {
		// Creamos un conjunto auxiliar para almacenar los divisores de la ley D'Hondt
		SortedSet<Divisor> cjtoDivisores = new TreeSet<Divisor>();
		// Recorremos la estructura
		for (String partido : votos.keySet()) {
			// Para cada partido, tomamos sus votos,
			int votosPartido = votos.get(partido);
			for (int i = 1; i <= car ; i++) {
				// Creamos un objeto divisor para cada esca–o.
				Divisor div = new Divisor(partido,votosPartido/i);
				// Y los a–adimos al conjunto de divisores.
				cjtoDivisores.add(div);
			}
		}
		// Solo queda seleccionar los primeros esc objetos divisores en el conjunto ordenado
		Iterator<Divisor> itCjtoDivisores = cjtoDivisores.iterator();
		// Y almacenarlos en una correspondencia partido/esca–os
		SortedMap<String,Integer> cargos = new TreeMap<String,Integer>();
		for (int i = 1; i <= car; i++) {
			// Recorremos los primeros divisores, y obtenemos su partido
			Divisor div = itCjtoDivisores.next();
			String partido = div.getPartido();
			// Incrementamos el nœmero de esca–os del partido, si Žste ya ten’a alguno, 
			// o lo inicializamos a uno, si es la primera vez.
			Integer escs = cargos.get(partido);
			if (escs == null) cargos.put(partido,1);
			else cargos.put(partido,escs+1);
		}
		return cargos;
	}
	
}
