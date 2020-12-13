package prExJunio2016;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class AsignacionesConAlternativas extends Asignaciones{

	public AsignacionesConAlternativas(int LAB, String nFich) throws FileNotFoundException {
		super(LAB, nFich);
	}
	
	private Set<PeticionAsignacion> leerAlternativas(String linea){
		Set<PeticionAsignacion> set = new TreeSet<>();
		try(Scanner sc = new Scanner (linea)){
			sc.useDelimiter("[#]+");
			
			String asignatura=sc.next();
			String nombre=sc.next();
			
			while(sc.hasNext()){
				String dia = sc.next();
				String hora = sc.next();
				set.add(new PeticionAsignacion(asignatura, nombre, new FranjaHoraria(dia,hora)));
			}
		}
		return set;
	}

	public void realizarAsignacion(String linea){
		Set<PeticionAsignacion> p = leerAlternativas(linea);
		Iterator<PeticionAsignacion> it = p.iterator();
		PeticionAsignacion pet = it.next();
		
		boolean asignado = false;
		
		while(it.hasNext()&&!asignado){
			if(nuevaAsignacion(it.next())){
				asignado = true;
			}
		}
		if(!asignado){
			conflictos.add(pet);
		}
	}
}
