
public class Alumno implements Comparable<Alumno>{
	private String dni;
	private String nombre;
	private double calificacion;
	
	public Alumno(String dni, String nombre) {
		this.dni = dni;
		this.nombre = nombre;
		this.calificacion = 0;
	}
	
	public String getDni() {
		return dni;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getCalificacion() {
		return calificacion;
	}
	
	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	
	public boolean equals(Object o){ 
	    boolean res = false;
		if (o instanceof Alumno) { 
		  Alumno a = (Alumno) o; 
	      res = dni.equalsIgnoreCase(a.dni) && nombre.equalsIgnoreCase(a.nombre);
		}
		return res;
	}
	
	public int compareTo(Alumno a) {
		int res = nombre.compareToIgnoreCase(a.nombre); 
		if (res == 0) {
			res = dni.compareToIgnoreCase(a.dni);
		}
		return res;
	}
	
	public String toString() {
		return dni + " " + nombre + " " + calificacion;
	}

	
}
