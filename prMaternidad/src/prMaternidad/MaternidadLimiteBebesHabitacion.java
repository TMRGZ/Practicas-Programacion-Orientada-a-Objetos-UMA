package prMaternidad;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


public class MaternidadLimiteBebesHabitacion extends Maternidad {
	private int MAX;
	private Map<Integer, Integer> ocupacion;
	private List<String> cambios;
	
	public MaternidadLimiteBebesHabitacion(int maximo) {
		ocupacion = new TreeMap<>();
		cambios = new ArrayList<>();
		MAX=maximo;
	}
	
	public MaternidadLimiteBebesHabitacion(int maximo, String nFich) throws FileNotFoundException {
		this(maximo);
		addPacientesFichero(nFich);
	}
	
	public void addMadreBebes(Persona madre, Collection<Persona> bebes) {
		int hab, ocupantes;
		
		super.addMadreBebes(madre, bebes);
		
		for(Persona b : bebes) {
			hab = b.getHabitacion();
			ocupantes = ocupacion.getOrDefault(hab, 0)+1;
			ocupacion.put(hab, ocupantes);
			
			if(ocupantes>MAX&&hab!=0) {
				cambios.add("La habitacion " + hab + " ha superado el limite establecido: " + MAX);
			}
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("\n");
		
		for(String a : cambios) {
			sb.append(a + "\n");
		}
	return sb.toString();
	}
}
