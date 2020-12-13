
public class Practica implements Comparable<Practica>{
	private String nombre;
	private double puntuacion;
	
	public Practica(String nombre, double puntuacion) {
		this.nombre = nombre;
		this.puntuacion = puntuacion;
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
	
	public boolean equals(Object o){ 
	    boolean res = false;
		if (o instanceof Practica) { 
		  Practica a = (Practica) o; 
	      res = nombre.equalsIgnoreCase(a.nombre);
		}
		return res;
	}
	
	public int compareTo(Practica p) {
		return nombre.compareToIgnoreCase(p.nombre);
	}
	
	public String toString() {
		return nombre;
	}

}
