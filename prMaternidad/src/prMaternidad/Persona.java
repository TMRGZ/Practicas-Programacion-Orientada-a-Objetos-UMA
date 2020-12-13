package prMaternidad;

public class Persona implements Comparable<Persona>{
	private String nombre;
	private int codigo;
	private int habitacion;
	
	public Persona(String nombre, int codigo, int habitacion) {
		if(codigo<0||habitacion<0) {
			throw new MaternidadException("Codigo o habitacion no validos");
		}else {
			this.codigo=codigo;
			this.nombre=nombre;
			this.habitacion=habitacion;
		}
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
	
	public String toString() {
		return this.getNombre() + ":" + this.getCodigo() + ":" + this.getHabitacion();
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res = o instanceof Persona;
		Persona p = res ? (Persona)o : null;
		return res&&this.getCodigo()==p.getCodigo();
	}
	@Override
	public int hashCode() {
		return this.getCodigo();
	}

	@Override
	public int compareTo(Persona o) {
		int res = Integer.compare(this.getCodigo(), o.getCodigo());
		return res;
	}
}
