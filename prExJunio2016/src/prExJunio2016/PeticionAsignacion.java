package prExJunio2016;

public class PeticionAsignacion implements Comparable<PeticionAsignacion>{
	private String nombreProfesor;
	private String nombreAsignatura;
	private FranjaHoraria franjaHoraria;
	
	public PeticionAsignacion(String nombreProfesor, String nombreAsignatura, FranjaHoraria franjaHoraria){
		this.nombreAsignatura=nombreAsignatura;
		this.nombreProfesor=nombreProfesor;
		this.franjaHoraria=franjaHoraria;
	}

	public String getNombreProfesor() {
		return nombreProfesor;
	}

	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public FranjaHoraria getFranjaHoraria() {
		return franjaHoraria;
	}
	
	public boolean equals(Object o){
		boolean res = o instanceof PeticionAsignacion;
		PeticionAsignacion pa = res ? (PeticionAsignacion)o : null;
		return res&&this.getFranjaHoraria().equals(pa.getFranjaHoraria());
	}
	
	public int hashCode(){
		return getFranjaHoraria().hashCode();
	}
	
	public int compareTo(PeticionAsignacion pa){
		int resultado = this.getFranjaHoraria().getDia().compareTo(pa.getFranjaHoraria().getDia());
		if(resultado==0){
			resultado= this.getFranjaHoraria().getHora().compareTo(pa.getFranjaHoraria().getHora());
		}else if(resultado==0){
			throw new AsignacionException("Mismas Asignaciones detectadas");
		}
		return resultado;
	}
	
	
	public String toString(){
		return this.getFranjaHoraria() + " " + this.getNombreAsignatura() + " " + this.getNombreProfesor();
	}
}
