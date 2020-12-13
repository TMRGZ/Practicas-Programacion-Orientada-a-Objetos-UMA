package prExSept2016;

public class Jugador {
	String nombre;
	int pjugados;
	int pganados;
	
	public Jugador(String nombre, int pjugados, int pganados) throws CompeticionException{
		this.nombre=nombre;
		this.pjugados=pjugados;
		this.pganados=pganados;
		
		if(pjugados<pganados || pjugados<0){
			throw new CompeticionException("Numero de partidos jugados/ganados no validos");
		}
	}
	
	public Jugador(String nombre){
		this.nombre=nombre;
		pjugados=0;
		pganados=0;
	}
	
	public String getNombre(){
		return nombre;
	}
	
	public int getPJugados(){
		return pjugados;
	}
	
	public int getPGanados(){
		return pganados;
	}
	
	public void increPartidos(int pganados, int pjugados){
		this.pganados++;
		this.pjugados++;
	}
	
	@Override
	
	public boolean equals(Object o){
		boolean res = o instanceof Jugador;
		Jugador ju = res ? (Jugador)o : null;
		return res&& this.nombre.equalsIgnoreCase(ju.nombre);
	}
	
	@Override
	public int hashCode(){
		return nombre.toLowerCase().hashCode();
	}
	
	public String toString(){
		return this.getNombre() + " " + this.getPJugados() + ":" + this.getPGanados();
	}
}
