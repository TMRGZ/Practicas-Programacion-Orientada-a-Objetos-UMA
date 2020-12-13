package prExSept2016;

public class Jugador {
	
	private String nombre;
	private int pJugados;
	private int pGanados;
	
	public Jugador(String nombre) {
		this(nombre,0,0);
	}
	
	public Jugador(String nombre, int pJugados, int pGanados) {
		if (pJugados < 0 || pGanados < 0) {
			throw new CompeticionException("Número negativo de partidos jugados o ganados al crear jugador");
		}
		if (pGanados > pJugados) {
			throw new CompeticionException("Número de partidos ganados mayor que partidos jugados al crear jugador");
		}
		this.nombre = nombre;
		this.pJugados = pJugados;
		this.pGanados = pGanados;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getPJugados() {
		return pJugados;
	}
	
	public int getPGanados() {
		return pGanados;
	}
	
	public void increPartidos(int pJugados, int pGanados) {
		if (pJugados < 0 || pGanados < 0) {
			throw new CompeticionException("Número negativo de partidos jugados o ganados al incrementar éstos en el jugador");
		}
		if (pGanados > pJugados) {
			throw new CompeticionException("Número de partidos ganados mayor que partidos jugados al incrementar éstos en el jugador");
		}
		this.pJugados += pJugados;
		this.pGanados += pGanados;
	}
	
	public String toString() {
		return nombre + ":" + pJugados + ":" + pGanados;
	}
	
	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Jugador) {
			Jugador j = (Jugador) o;
			res = nombre.equalsIgnoreCase(j.nombre) ;
		}
		return res;
	}
	
	public int hashCode() {
		return nombre.toLowerCase().hashCode();
	}
	
}
