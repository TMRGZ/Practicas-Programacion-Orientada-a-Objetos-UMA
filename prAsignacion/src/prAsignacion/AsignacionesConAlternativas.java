package prAsignacion;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class AsignacionesConAlternativas extends Asignaciones{

	public AsignacionesConAlternativas(int num, String nFich) throws FileNotFoundException {
		super(num, nFich);
	}
	
	@Override
	public void realizarAsignacion(String linea) {
		Set<PeticionAsignacion> alternativas = leerAlternativas(linea);
		
		if(alternativas.isEmpty()) {
			throw new AsignacionException("Linea Incompleta: " + linea);
		}
		
		Iterator<PeticionAsignacion> it = alternativas.iterator();
		boolean asignado = false;
		PeticionAsignacion pa = null;
		
		while(it.hasNext()&&!asignado) {
			pa = it.next();
			asignado=nuevaAsignacion(pa);
		}
		
		if(!asignado) {
			conflictos.add(pa);
		}
	}

	private Set<PeticionAsignacion> leerAlternativas(String linea) {
		Set<PeticionAsignacion> alternativas = new TreeSet<>();
		
		try(Scanner sc = new Scanner(linea)){
			sc.useDelimiter("[#]+");
			String na = sc.next();
			String np = sc.next();
			
			while(sc.hasNext()) {
				String dia = sc.next();
				String hora = sc.next();
				alternativas.add(new PeticionAsignacion(na, np, new FranjaHoraria(dia,hora)));
			}
		}catch(NoSuchElementException e) {
			throw new AsignacionException("Faltan Datos");
		}
		
		return alternativas;
	}

}
