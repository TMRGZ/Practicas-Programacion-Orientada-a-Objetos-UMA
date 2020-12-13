package prExSept2016;

public class Equipo implements Comparable<Equipo> {

	private String nombre;
	private int categoria;
	private int puntos;
	
	public Equipo(String nombre, int categoria, int puntos) {
		if (!(categoria >= 1 && categoria <= 5)) {
			throw new CompeticionException("Categoría incorrecta al crear equipo");
		}
		if (puntos < 0) {
			throw new CompeticionException("Puntos negativos al crear equipo");
		}
		this.nombre = nombre;
		this.categoria = categoria;
		this.puntos = puntos;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public int getCategoria() {
		return categoria;
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	public void setCategoria(int categoria) {
		if (!(categoria >= 1 && categoria <= 5)) {
			throw new CompeticionException("Categoría incorrecta al modificar la de un equipo");
		}
		this.categoria = categoria;
	}
	
	public void increPuntos(int puntos) {
		if (puntos < 0) {
			throw new CompeticionException("Puntos negativos al incrementar los de un equipo");
		}
		this.puntos += puntos;;
	}
	
	public String toString() {
		return nombre + ":" + categoria + ":" + puntos;
	}
	
	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Equipo) {
			Equipo j = (Equipo) o;
			res = nombre.equalsIgnoreCase(j.nombre) 
				&& categoria == j.categoria
				&& puntos == j.puntos;
		}
		return res;
	}
	
	public int hashCode() {
		return nombre.toLowerCase().hashCode() + categoria + puntos;
	}

	public int compareTo(Equipo e) {
		int resultado = categoria - e.categoria;
		if (resultado == 0) {
			resultado = e.puntos - puntos; // ojo, a mayor puntos, menor en la ordenación
			if (resultado == 0) {
				resultado = nombre.compareToIgnoreCase(e.nombre);
			}
		}
		return resultado;
	}

}
