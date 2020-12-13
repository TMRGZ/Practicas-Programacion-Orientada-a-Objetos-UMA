package prNotas;

public class Alumno {
	private String nombre;
	private String dni;
	private double nota;
	
	public Alumno(String dni,String nombre, double nota) throws AlumnoException{
		this.nombre=nombre;
		this.dni=dni;
		
		if(nota<0){
			throw new AlumnoException();
		}else{
			this.nota=nota;
		}
	}
	
	public Alumno(String dni, String nombre){
		this.nombre=nombre;
		this.dni=dni;
		this.nota=0;
	}
	
	public boolean equals(Object obj) {
		boolean res = obj instanceof Alumno;
		Alumno per = res ? (Alumno)obj: null;
		return res && dni.equalsIgnoreCase(per.dni) && nombre.equalsIgnoreCase(per.nombre);
	}
	
	public int hashCode(){
		return this.getNombre().hashCode()+this.getDni().hashCode();
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getDni(){
		return this.dni;
	}
	
	public double getCalification(){
		return this.nota;
	}
	
	public String toString(){
		return "("+this.nombre+", "+this.dni+", "+this.nota+")";
	}
}
