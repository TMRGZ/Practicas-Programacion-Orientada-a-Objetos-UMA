package prEvaluacionPracticas;

public class Alumno implements Comparable<Alumno>{
	private String DNI;
	private String nombre;
	private double calificacion;
	
	public Alumno(String DNI, String nombre) {
		this.DNI=DNI;
		this.nombre=nombre;
		this.calificacion=0.0;
	}

	public String getDNI() {
		return DNI;
	}

	public String getNombre() {
		return nombre;
	}

	public double getCalificacion() {
		return calificacion;
	}
	
	public String toString() {
		return this.getDNI() + " " + this.getNombre() + ": " + this.getCalificacion();
	}
	
	public void setCalificacion(double calif) {
		this.calificacion=calif;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res = o instanceof Alumno;
		Alumno a = res ? (Alumno)o : null;
		return res&&this.getDNI().equalsIgnoreCase(a.getDNI())&&this.getNombre().equalsIgnoreCase(a.getNombre());
	}
	
	public int hashCode(Alumno a) {
		return this.getNombre().hashCode()+a.getNombre().hashCode()+a.getDNI().hashCode()+a.getDNI().hashCode();
	}

	@Override
	public int compareTo(Alumno o) {
		int res = this.getNombre().compareToIgnoreCase(o.getNombre());
		
		if(res==0) {
			res = this.getDNI().compareToIgnoreCase(o.getDNI());
		}
		return res;
	}
}
