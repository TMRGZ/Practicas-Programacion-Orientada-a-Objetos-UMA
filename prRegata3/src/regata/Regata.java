package regata;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;
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
		participantes.add(b);
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
		Set<Barco> ordenados = new TreeSet<>(new SatBarco());
		
		for(Barco b : participantes) {
			ordenados.add(b);
		}
		return ordenados;
	}
	
	public boolean velocidadSuperiorA(int velocidad) {
		boolean res = false;
		
		for(Barco b : participantes) {
			if(b.getVelocidad()>velocidad) {
				res = true;
			}
		}
		return res;
	}
	
	public List<Barco> dentroDelCirculo(Posicion p, int km){
		List<Barco> dentro = new ArrayList<>();
		
		for(Barco b : participantes) {
			if(b.getPosicion().distancia(p)<km) {
				dentro.add(b);
			}
		}
		return dentro;
	}
	
	public Map<Integer, Set<Barco>> barcosPorVelocidad(){
		Map<Integer, Set<Barco>> mapa = new TreeMap<>();
		int cota;
		
		
		for(Barco b : participantes) {
			cota = b.getVelocidad()/10;
			Set<Barco> lista =mapa.get(cota);
			
			if(lista==null) {
				lista = new TreeSet<>();
				mapa.put(cota, lista);
			}
			lista.add(b);
		}
		return mapa;
	}
	
	public Barco creaBarcoString(String linea) {
		try(Scanner sc = new Scanner(linea)){
			sc.useDelimiter("[ ,]+");
			
			Barco b = new Barco(sc.next(), new Posicion(sc.nextDouble(), sc.nextDouble()), sc.nextInt(), sc.nextInt());
			return b;
		}catch(InputMismatchException e) {
			throw new RegataException("Datos leidos no validos");
		}
	}
	
	public void leeFichero(String nFich) {
		try(Scanner sc = new Scanner(new File(nFich))){
			creaBarcoString(sc.nextLine());
			
		} catch (FileNotFoundException e) {
			throw new RegataException("Archivo no encontrado");
		}
	}
	
	public void escribeFichero(String nFich) {
		try(PrintWriter pw = new PrintWriter(new File(nFich))){
			escribe(pw);
		} catch (FileNotFoundException e) {
			throw new RegataException("Nombre de archivo no encontrado.");
		}
	}

	void escribe(PrintWriter pw) {
		pw.print(this.toString());
	}
}
