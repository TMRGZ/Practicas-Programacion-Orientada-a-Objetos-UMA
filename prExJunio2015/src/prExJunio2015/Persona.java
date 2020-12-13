package prExJunio2015;

public class Persona implements Comparable<Persona>{
	private String nombre;
	private int codigo;
	private int habitacion;
	
	public Persona(String nombre, int codigo, int habitacion){
		this.nombre=nombre;
		if(codigo<1||habitacion<0){
			throw  new MaternidadException("Habitacion o codigo no valido");
		}
		
		this.codigo=codigo;
		this.habitacion=habitacion;
	}

	@Override
	public int hashCode() {
		return Integer.hashCode(getCodigo());	
	}

	@Override
	public String toString() {
		return "Persona [Nombre: " + nombre + ", Codigo: " + codigo + ", Habitacion: " + habitacion + "]";
	}

	@Override
	public boolean equals(Object obj) {
		boolean res = obj instanceof Persona;
		Persona p = (Persona) obj;
		return res && this.getCodigo()==p.getCodigo();
	}
	@Override
	public int compareTo(Persona p){
		int res = Integer.compare(this.getCodigo(), p.getCodigo());
		return res;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public int getCodigo() {
		return codigo;
	}

	public int getHabitacion() {
		return habitacion;
	}
}
