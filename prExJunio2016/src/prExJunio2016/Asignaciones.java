package prExJunio2016;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;


public class Asignaciones {
	protected SortedMap<Integer, SortedSet<PeticionAsignacion>> asignacion;
	protected List<PeticionAsignacion> conflictos;
	public int LAB;
	
	public Asignaciones(int LAB){		//Hecho
		this.LAB=LAB;
		asignacion = new TreeMap<>();
		conflictos = new ArrayList<>();
		
		for(int i=0; i<LAB; i++){
			asignacion.put(i, new TreeSet<>());
		}
	}
	
	public Asignaciones(int LAB, String nFich) throws FileNotFoundException{	//Hecho
		this(LAB);
		leerPeticionesDelFichero(nFich);
	}

	private void leerPeticionesDelFichero(String nFich) throws FileNotFoundException {		//Hecho
		try(Scanner scLinea = new Scanner(new File(nFich))){
			while(scLinea.hasNextLine()){
				realizarAsignacion(scLinea.nextLine());
			}
		}
	}

	private void realizarAsignacion(String linea) {			//Hecho
		try(Scanner sc = new Scanner(linea)){
			sc.useDelimiter("[#]+");
			
			String asignatura= sc.next();
			String nombre = sc.next();
			String dia = sc.next();
			String hora = sc.next();
			
			FranjaHoraria f = new FranjaHoraria(dia, hora);
			PeticionAsignacion ae = new PeticionAsignacion(asignatura, nombre, f);
			
			if(!nuevaAsignacion(ae)){
				conflictos.add(ae);
			}
			
		}catch(NoSuchElementException e){
			throw new AsignacionException("Error");
		}
	}
	
	public Set<Integer> buscarHuecos(FranjaHoraria franja){		//Hecho
		PeticionAsignacion buscar = new PeticionAsignacion("","",franja);
		Set<Integer> set = new TreeSet<>();
		
		for(int i : asignacion.keySet()){
			if(!asignacion.get(i).contains(buscar)){
				set.add(i);
			}
		}
		return set;
	}
	
	public boolean nuevaAsignacion(PeticionAsignacion ae){		//Hecho
		boolean asignado=false;
		Set<Integer> huecos = buscarHuecos(ae.getFranjaHoraria());
		
		if(!huecos.isEmpty()){
			asignacion.get(huecos.iterator().next()).add(ae);
			asignado=true;
		}
		
		return asignado;
	}
	
	public String toString() {					//Hecho
        StringBuilder sb = new StringBuilder();
        sb.append("Asignacion de laboratorios\n");
        sb.append("--------------------------\n");
        
        for (int i : asignacion.keySet()) {
            sb.append("Laboratorio " + i + "\n");
            for(PeticionAsignacion pa : asignacion.get(i)) {
                sb.append("\t"+pa+"\n");
            }
        }
        
        sb.append("Conflictos\n");
        sb.append("----------\n");
       
        for(PeticionAsignacion pa: conflictos) {
            sb.append("\t"+pa+"\n");
        }
        
        return sb.toString();
    }
	
	public void escribirAFichero(String nFich) throws FileNotFoundException{	//Hecho
		try(PrintWriter pw = new PrintWriter(new File(nFich))){
			escribirAsignaciones(pw);
		}
	}

	private void escribirAsignaciones(PrintWriter pw) {	//Hecho
		pw.print(this.toString());
		
	}
}
