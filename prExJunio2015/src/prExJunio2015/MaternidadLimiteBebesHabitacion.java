package prExJunio2015;

import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MaternidadLimiteBebesHabitacion extends Maternidad{
	private int maximo;
	private Map<Integer, Integer> ocupacion;
	private List<String> cambios;
	
	public MaternidadLimiteBebesHabitacion(int maximo){
		super();
		this.maximo=maximo;
	}
	
	public MaternidadLimiteBebesHabitacion(int maximo, String nFich) throws FileNotFoundException{
		super(nFich);
		this.maximo=maximo;
	}
	
	public void addMadreBebes(Persona madre, Collection<Persona> bebes){
		super.addMadreBebes(madre, bebes);
		ocupacion = new TreeMap<>();
		int nBebes=1;
		
		for(Persona b : bebes){
			Integer i = ocupacion.get(b.getHabitacion());
			
			if(i==null){
				ocupacion.put(b.getHabitacion(), nBebes);
			}else{
				i++;
			}
			
			if(i>maximo&&b.getHabitacion()!=0){
				cambios.add("La habitacion " + b.getHabitacion() + "esta llena.");
			}
		}
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder(super.toString());
		sb.append("\n");
		
		for(String s : cambios){
			sb.append(s);
		}
		sb.append("\n");
		return toString();
		
	}
}
