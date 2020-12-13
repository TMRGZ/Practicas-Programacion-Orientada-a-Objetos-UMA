public class Jugador implements Comparable<Jugador> {
	private String nombre;
	private int valoracion;
	private String demarcacion;
	private boolean elegido;

	public Jugador(String n, String d, int v) {
		nombre = n;
		valoracion = v;
		demarcacion = d;
		elegido = false;
	}

	public int compareTo(Jugador j) {
		int res = j.getDemarcacion().compareToIgnoreCase(this.getDemarcacion());
		if (res == 0) {
			res = j.valoracion - valoracion;
			if (res == 0) {
				res = nombre.compareToIgnoreCase(j.nombre);
			}
		}
		return res;
	}

	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Jugador) {
			Jugador j = (Jugador) o;
			res = demarcacion.equalsIgnoreCase(j.demarcacion)
					&& valoracion == j.valoracion
					&& nombre.equalsIgnoreCase(j.nombre);
		}
		return res;
	}

	public int hasCode() {
		return nombre.toLowerCase().hashCode();
	}

	public void setElegido() {
		elegido = true;
	}

	public boolean getElegido() {
		return elegido;
	}

	public String getDemarcacion() {
		return demarcacion;
	}

	public String getNombre() {
		return nombre;
	}

	public String toString() {
		return nombre + " " + demarcacion + " " + valoracion;
	}

}
