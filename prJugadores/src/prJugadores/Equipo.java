package prJugadores;

public class Equipo implements Comparable<Equipo>{
	private String nombre;
	private int categoria;
	private int puntosConseguidos;
	
	public Equipo(String nombre, int categoria, int puntosConseguidos) throws CompeticionException {
		this.nombre=nombre;
		
		if((categoria<1||categoria>5)||(puntosConseguidos<0)) {
			throw new CompeticionException("Formato malo");
		}else {
			this.categoria=categoria;
			this.puntosConseguidos=puntosConseguidos;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public int getCategoria() {
		return categoria;
	}

	public int getPuntosConseguidos() {
		return puntosConseguidos;
	}
	
	public void setCategoria(int nueva) {
		this.categoria=nueva;
	}
	
	public void increPuntos(int puntos) {
		this.puntosConseguidos=this.puntosConseguidos+puntos;
	}
	
	public String toString() {
		return this.getNombre() + " :" + this.getCategoria() + ":" + this.getPuntosConseguidos(); 
	}
	
	@Override
	public boolean equals(Object o){
		boolean res = o instanceof Equipo;
		Equipo eq = res ? (Equipo)o : null;
		return res&& this.getNombre().equalsIgnoreCase(eq.getNombre())&&this.getCategoria()==eq.getCategoria()&&this.getPuntosConseguidos()==eq.getPuntosConseguidos();
	}
	
	@Override
	public int hashCode(){
		return this.getNombre().toLowerCase().hashCode() + this.getCategoria() + this.getPuntosConseguidos();
	}

	@Override
	public int compareTo(Equipo o) {
		int res = Integer.compare(this.getCategoria(), o.getCategoria());
		
		if(res==0) {
			res= Integer.compare(this.getPuntosConseguidos(), o.getPuntosConseguidos());
			res=-res;
		}if(res==0) {
			res=this.getNombre().compareToIgnoreCase(o.getNombre());
		}
		return res;
	}

}
