package prMaternidadSOLU;

public class Persona implements Comparable<Persona>{
		
	private String nombre;
	private int codigo; //Será único para cada persona.
	private int numHabitacion;
	
	public Persona(String n, int codigo, int hab){
		if (n == null || codigo <= 0 || hab < 0)
			throw new MaternidadException("Parámetros incorrectos");
		
		nombre = n;
		numHabitacion = hab;
		this.codigo = codigo;
	
	}
	
	public String getNombre() { return nombre;}
	public int getCodigo() { return codigo;}
	public int getHabitacion() { return numHabitacion;}
	
	
	
	public String toString(){
		return nombre + ":" + codigo + ":" + numHabitacion;
	}
	
	public boolean equals(Object o){
		boolean res = o instanceof Persona;
		Persona per = res ? (Persona)o: null;
		return res && codigo == per.codigo;
	}
	
	public int hashCode(){
		return codigo;
	}

	@Override
	//El orden natural ordena a las personas por código 
	public int compareTo(Persona p) {
			return  codigo - p.codigo;
	}
}
