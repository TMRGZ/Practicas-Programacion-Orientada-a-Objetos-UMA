package prAsignacion;

public class PeticionAsignacion implements Comparable<PeticionAsignacion>{
	private String nombreProfesor;
	private String nombreAsignatura;
	private FranjaHoraria franja;
	
	public PeticionAsignacion(String nombreAsignatura, String nombreProfesor, FranjaHoraria franja) {
		this.nombreProfesor=nombreProfesor;
		this.nombreAsignatura=nombreAsignatura;
		this.franja=franja;
	}

	public String getNombreProfesor() {
		return nombreProfesor;
	}

	public String getNombreAsignatura() {
		return nombreAsignatura;
	}

	public FranjaHoraria getFranja() {
		return franja;
	}
	
	public String toString() {
		return "("+this.getFranja()+")  -->  " + this.getNombreAsignatura() + ", " + this.getNombreProfesor() + ".";
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res = o instanceof PeticionAsignacion;
		PeticionAsignacion p = res ? (PeticionAsignacion)o : null;
		return res&&this.getFranja().equals(p.getFranja());
	}
	
	public int hashCode(FranjaHoraria f) {
		return this.getFranja().hashCode()+f.hashCode();
	}

	@Override
	public int compareTo(PeticionAsignacion p) {
		int res = this.getFranja().getDia().compareTo(p.getFranja().getDia());
		
		if(res==0) {
			res=this.getFranja().getHora().compareTo(p.getFranja().getHora());
		}
		return res;
	}
}
