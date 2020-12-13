package prParking;

import java.util.Arrays;

public class Parking {
	private static final String LIBRE = "libre";
	private String identificador;
	private Posicion posicion;
	private String[][] plazas;
	
	public Parking(String id, Posicion p, int pzs) {
		if (pzs <= 0) {
			throw new ParkingException("Numero de plazas negativo o cero al crear Parking");
		}
		
		identificador = id;
		posicion = p;
		plazas = new String[pzs][24];
		
		for (int f = 0; f < pzs; f++) {
			for (int c = 0; c < 24; c++) {
				plazas[f][c] = LIBRE;
			}
		}
	}
		
	public String getId() {
		return identificador;
	}
		
	public Posicion getPosicion() {
		return posicion;
	}

	private boolean hayHuecoEnPlaza(Vehiculo v, int pz) {
		int cont = v.getEntrada();
		
		while ((cont < v.getSalida()) && (plazas[pz][cont].equals(LIBRE))) {
			cont++;
		}
		
		return cont >= v.getSalida();
	}
	
	public int buscarPlaza(Vehiculo v) {
		int res;
		
		int pz = 0;
		while ((pz < plazas.length) && !hayHuecoEnPlaza(v,pz)) {
			pz++;
		}
		
		if (pz >= plazas.length) {
			res = -1;
		} else {
			res = pz;
		}
		
		return res;
	}
	
	public boolean reservarPlaza(Vehiculo v, int pz) {
		boolean res;
		
		if ((pz < 0) || (pz >= plazas.length)) {
			throw new ParkingException("Numero de plaza incorrecto al intentar reservar plaza");
		}
		
		res = hayHuecoEnPlaza(v,pz);
		if (res) {
			for (int cont = v.getEntrada(); cont < v.getSalida(); cont++) {
				plazas[pz][cont] = v.getMatricula();
			}
		}
		return res;
	}
	
	public boolean equals(Object o) {
		boolean res = false;
		
		if (o instanceof Parking) {
			Parking p = (Parking) o; 
			res = identificador.equalsIgnoreCase(p.identificador) &&
					posicion.equals(p.posicion);
		}
				
		return res;
	}
	
	public int hashCode() {
		return identificador.toLowerCase().hashCode() + posicion.hashCode();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(identificador).append(posicion).append('\n');
		
		for (int f = 0; f < plazas.length; f++) {
			sb.append(Arrays.toString(plazas[f])).append('\n');
		}
		
		return sb.toString();
	}
	
}
