public class Equipo implements Comparable<Equipo> {
	private String nombre;
	private int votos;

	public Equipo(String n, int v) {
		nombre = n;
		votos = v;
	}

	public int compareTo(Equipo e) {
		int res = e.votos - votos;
		if (res == 0) {
			res = nombre.compareToIgnoreCase(e.nombre);
		}
		return res;
	}

	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Equipo) {
			Equipo e = (Equipo) o;
			res = nombre.equalsIgnoreCase(e.nombre) && votos == e.votos;
		}
		return res;
	}

	public int hasCode() {
		return nombre.toLowerCase().hashCode();
	}

	public int getVotos() {
		return votos;
	}

	public void setVotos(int v) {
		votos = v;
	}

	public String toString() {
		return nombre + " " + votos;
	}
}
