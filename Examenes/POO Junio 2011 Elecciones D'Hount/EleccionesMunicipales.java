package dhondt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class EleccionesMunicipales {
	/**
	 * Correspondencia que asocia a cada ciudad otra correspondencia con los votos de cada partido
	 */
	private SortedMap<String,Map<String,Integer>> todosVotos;
	
	/**
	 * Correspondencia que asocia a cada ciudad los resultados electorales (concejales) para cada partido.
	 */
	private Map<String,Map<String,Integer>> resElectorales;
	
	/**
	 * Asociación que almacena el número de concejales para cada ciudad
	 */
	private Map<String,Integer> concejalesPorProvincia;
	
	/**
	 * Constante que representa el porcentaje mínimo del total de votos 
	 * para la Ley D'Hondt en las elecciones municipales en España
	 */
	public static double MIN_MUNICIPALES = 0.05;

	
	/**
	 * A partir de la información incluida en un fichero, crea un objeto de la 
	 * clase Elecciones que realiza el reparto según la Ley D'Hondt modificada
	 * con el 5% del mínimo de votos. El formato del fichero es el siguiente:
	 * 
	 * PROVINCIA:Concejales:Partido1 \t Votos1;Partido2 \t Votos2; ...
	 * 
	 * @param fichero	Fichero con la información sobre ciudades, concejales, partidos y votos
	 * @throws IOException
	 */
	public EleccionesMunicipales(String fichero) throws IOException {
		leerVotos(fichero);
	}

	/**
	 * Lee de un fichero los resultados de unas elecciones y los incorpora a la información
	 * de la clase.
	 * 
	 * @param fichero	Fichero con la información sobre las elecciones
	 * @throws IOException
	 */
	public void leerVotos(String fichero) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(fichero));
		leerVotos(br);
		br.close();
	}
	
	/**
	 * A partir de la información incluida en un flujo de entrada de texto,  
	 * con el formato antes indicado, se crea un objeto de la clase Elecciones que 
	 * establece el reparto de concejales para todas las provincias leídas.
	 * @param br	Flujo de entrada con los datos de ciudades, concejales, partidos y votos
	 * @throws IOException
	 */
	public void leerVotos(BufferedReader br) throws IOException {
		todosVotos = new TreeMap<String,Map<String,Integer>>();
		concejalesPorProvincia = new TreeMap<String,Integer>();
		String linea = br.readLine();
		int totalVotos = 0;
		while (linea != null) {
			StringTokenizer st = new StringTokenizer(linea,":;\t");
			try {
				// Para cada línea se lee la provincia y el número de concejales
				String provincia = st.nextToken();
				int concejales = Integer.parseInt(st.nextToken());
				// Añadimos la información sobre los concejales de la provincia
				concejalesPorProvincia.put(provincia, concejales);
				// Creamos un Map para asociar los votos a los partidos y lo asociamos a la provincia
				Map<String,Integer> votosPartidos = new HashMap<String,Integer>();
				todosVotos.put(provincia,votosPartidos);
				while (st.hasMoreTokens()) {
					// Leemos cada partido y sus votos
					String partido = st.nextToken();
					int votos = Integer.parseInt(st.nextToken());
					// Suponemos que en el fichero los datos no están repetidos;
					// en caso de ser así, se considera la última información.
					votosPartidos.put(partido,votos);				
					// Se van acumulando el total de votos.
					totalVotos += votos;
				}
			} catch (NoSuchElementException nsee) { // Si una línea tiene menos de dos tokens
				throw new EleccionesException("Formato de fichero erróneo");
			} catch (NumberFormatException nfe) {   // Si un número de votos no tiene el formato adecuado
				throw new EleccionesException("Formato del número de votos erróneo");
			}
			linea = br.readLine();
		}
		// Una vez leídos todos los pares partido/votos asociados a cada provincia, se
		// invoca el método reparto con el porcentaje establecido para las municipales
		reparto(MIN_MUNICIPALES);
	}

	/**
	 * Realiza el reparto de concejales entre los partidos para cada ciudad, teniendo en cuenta el 
	 * porcentaje mínimo de votos determinado por el argumento.
	 * @param porc	Porcentaje mínimo para realizar el reparto
	 */
	public void reparto(double porc) {
		// Una vez leídos todos los pares partido/votos, se utiliza la clase EleccionDHondtModificado
		// para hacer el reparto en cada provincia, y se almacena en resElectorales.
		resElectorales = new TreeMap<String,Map<String,Integer>>();
		for(String provincia : todosVotos.keySet()) {
			Map<String,Integer> votosProvincia = todosVotos.get(provincia);
			EleccionDHondtModificado elec = new EleccionDHondtModificado(votosProvincia,porc);
			resElectorales.put(provincia, elec.reparto(concejalesPorProvincia.get(provincia)));
		}
	}
	
	
	public void print(String fichero) throws IOException {
		PrintWriter salida = new PrintWriter(fichero);
		print(salida);
		salida.close();  
	}
	
	public void print(PrintWriter pw) {
		for(String provincia : resElectorales.keySet()) {
			pw.println(provincia + ":");
			Map<String,Integer> resProvincia = resElectorales.get(provincia);
			for (String partido : resProvincia.keySet()) {
				pw.printf("%12s %3d", partido, resProvincia.get(partido));
				pw.println();
			}
		}
	}

}
