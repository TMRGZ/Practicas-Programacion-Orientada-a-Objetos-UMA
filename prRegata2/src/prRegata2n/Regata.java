package prRegata2n;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Regata {
	Set<Barco> participantes;
	
	public Regata() {
		participantes = new TreeSet<>();
	}
	
	public void agrega(Barco b) {
		if(!participantes.contains(b)) {
			participantes.add(b);
		}
	}
	
	public void avanza(int mnt) {
		for(Barco b : participantes) {
			b.avanza(mnt);
		}
	}
	
	public Set<Barco> getParticipantes(){
		return participantes;
	}
	
	public Set<Barco> ordenadosPorDistancia(){
		Set<Barco> ord = new TreeSet<>(new SatBarco());
		
		for(Barco b : participantes) {
			ord.add(b);
		}
	return ord;
	}
	
	public boolean velocidadSuperiorA(int velocidad) {
		boolean encontrado = false;
		
		for(Barco b : participantes) {
			if(b.getVelocidad()>velocidad) {
				encontrado=true;
			}
		}
	return encontrado;
	}
	
	public List<Barco> dentroDelCirculo(Posicion pos, int km){
		List<Barco> lista = new ArrayList<>();
		
		for(Barco b : participantes) {
			if(b.getPosicion().distancia(pos)<km) {
				lista.add(b);
			}
		}
		return lista;
	}
	public Map <Integer, Set<Barco>> barcosPorVelocidad(){
		Map<Integer, Set<Barco>> mapa = new TreeMap<>();
		int cota;
		
		for(Barco b : participantes) {
			cota = b.getVelocidad()/10;
			
			if(mapa.get(cota)==null) {
				mapa.put(cota, new TreeSet<>());
			}
			mapa.get(cota).add(b);
		}
		return mapa;
	}
		
	public Barco creaBarcoString(String linea) {
		try(Scanner sc = new Scanner(linea)){
			sc.useDelimiter("[ ,]+");
			
			String nombre = sc.next();
			double latitud = sc.nextDouble();
			double longitud = sc.nextDouble();
			int rumbo = sc.nextInt();
			int velocidad = sc.nextInt();
			
			Posicion pos = new Posicion(latitud, longitud);
			Barco nuevo = new Barco(nombre, pos, rumbo, velocidad);
			
			return nuevo;
		}catch(Exception e){
			throw new RegataException("Barco Creado Erroneo");
		}
	}
	
	public void leeFichero(String nFich) throws FileNotFoundException {
		try(Scanner sc = new Scanner(new File(nFich))){
			lee(sc);
		}catch(Exception e){
			throw new RegataException("Error al leer 1");
		}
	}

	private void lee(Scanner sc) {
		while(sc.hasNextLine()) {
			Barco b = creaBarcoString(sc.nextLine());
			participantes.add(b);
		}
	}
	
	public void escribeFichero(String nFich) throws FileNotFoundException {
		try(PrintWriter pw = new PrintWriter(new File(nFich))){
			escribe(pw);
		}
	}

	public void escribe(PrintWriter pw) {
		for(Barco b : participantes) {
			pw.print(b.toString());
			pw.print("\n");
		}
		
	}
}

