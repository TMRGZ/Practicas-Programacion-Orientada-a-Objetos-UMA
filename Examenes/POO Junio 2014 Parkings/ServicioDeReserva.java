package prParking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class ServicioDeReserva {
	Set<Parking> parkings;

	public ServicioDeReserva() {
		parkings = new HashSet<Parking>();
	}

	public ServicioDeReserva(String nombreFichero) throws FileNotFoundException {
		this();
		tratarFichero(nombreFichero);
	}

	private void tratarFichero(String nombreFichero)
			throws FileNotFoundException {
		Scanner sc = new Scanner(new File(nombreFichero));
		leer(sc);
		sc.close();
	}

	private void leer(Scanner sc) {
		while (sc.hasNextLine()) {
			tokenizar(sc.nextLine());
		}
	}

	// con Scanner
	private void tokenizar(String linea) {

		try {
			Scanner scLinea = new Scanner(linea);
			scLinea.useLocale(Locale.ENGLISH);
			String id = scLinea.next();
			double x = scLinea.nextDouble();
			double y = scLinea.nextDouble();
			int pzs = scLinea.nextInt();
			addParking(new Parking(id, new Posicion(x, y), pzs));
			scLinea.close();
		} catch (NoSuchElementException e) {
			throw new ParkingException(
					"Faltan datos en linea de fichero de parkings");
		}

	}

	// con StringTokenizer
	/*
	  private void tokenizar(String linea) {
	  
	  	try { 
	  		StringTokenizer st = new StringTokenizer(linea); 
	  		String id = st.nextToken(); 
	  		double x = Double.parseDouble(st.nextToken()); 
	  		double y = Double.parseDouble(st.nextToken()); 
	  		int pzs = Integer.parseInt(st.nextToken()); 
	  		addParking(new Parking(id,new Posicion(x,y),pzs)); 
	  	} catch (NoSuchElementException e) { 
	  		throw new ParkingException("Faltan datos en linea de fichero de parkings"); 
	  	}
	  
	  }
	 */
	public boolean addParking(Parking p) {
		return parkings.add(p);
	}

	public boolean reservaPlaza(Vehiculo v, Parking p) {
		boolean res = false;

		if (parkings.contains(p)) {
			int pz = p.buscarPlaza(v);
			if (pz >= 0) {
				p.reservarPlaza(v, pz);
				res = true;
			}
		}
		return res;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (Parking pk : parkings) {
			sb.append(pk).append('\n');
		}
		return sb.toString();
	}

	public Parking parkingLibreMasProximo(Vehiculo v) {
		Parking res = null;

		SortedSet<Parking> parkingsOrdenados = new TreeSet<Parking>(
				new ComparadorParking(v));
		parkingsOrdenados.addAll(parkings);
		Iterator<Parking> it = parkingsOrdenados.iterator();
		Parking candidato;
		while ((res == null) && it.hasNext()) {
			candidato = it.next();
			if (candidato.buscarPlaza(v) >= 0) {
				res = candidato;
			}
		}

		return res;
	}

	public Map<String, String> reservaDePlazas(List<Vehiculo> lv) {
		Map<String, String> res = new HashMap<String, String>();
		Parking p;

		for (Vehiculo v : lv) {
			p = parkingLibreMasProximo(v);
			if (p != null) {
				p.reservarPlaza(v, p.buscarPlaza(v));
				res.put(v.getMatricula(), p.getId());
			}
		}

		return res;
	}

}
