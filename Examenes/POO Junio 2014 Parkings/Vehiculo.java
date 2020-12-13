package prParking;

public class Vehiculo {
	private String matricula;
	private Posicion posicion;
	private int entrada, salida;
	
	public Vehiculo(String m, Posicion p, int e, int s) {
		if ((e < 0) || (e > 23) || (s < 1) || (s > 24) || (e >= s)) {
			throw new ParkingException("Franja horaria incorrecta al crear Vehiculo");
		}
		
		matricula = m;
		posicion = p;
		entrada = e;
		salida = s;
	}
	
	public String toString() {
		return "Vehiculo: " + matricula + ", pos" + posicion + ", horas(" + 
				entrada + ", " + salida + ")";
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public Posicion getPosicion() {
		return posicion;
	}
	
	public int getEntrada() {
		return entrada;
	}
	
	public int getSalida() {
		return salida;
	}
	
	public boolean equals(Object o) {
		boolean res = false;
		
		if (o instanceof Vehiculo) {
			Vehiculo v = (Vehiculo) o; 
			res = matricula.equalsIgnoreCase(v.matricula);
		}
				
		return res;
	}
	
	public int hashCode() {
		return matricula.toLowerCase().hashCode();
	}
	
	
}
