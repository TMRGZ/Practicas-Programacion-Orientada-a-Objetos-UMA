package prEvaluacionPracticas;

public class Practica implements Comparable<Practica>{
	private String nombre;
	private double puntuacion;
	
	public Practica(String nombre, double puntuacion) {
		this.nombre=nombre;
		this.puntuacion=puntuacion;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPuntuacion() {
		return puntuacion;
	}

	public void setPuntuacion(double puntuacion) {
		this.puntuacion = puntuacion;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res = o instanceof Practica;
		Practica p = res ? (Practica)o : null;
		return res&&this.getNombre().equalsIgnoreCase(p.getNombre());
	}
	
	public int hashCode(Alumno a) {
		return this.getNombre().toLowerCase().hashCode()+a.getNombre().toLowerCase().hashCode();
	}

	@Override
	public int compareTo(Practica o) {
		int res = this.getNombre().compareToIgnoreCase(o.getNombre());
		return res;
	}
	
	public String toString() {
		return this.getNombre()  +": " + this.getPuntuacion(); 
	}
}
