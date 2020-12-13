package regata;

public class Barco implements Comparable<Barco>{
	private String nombre;
	private Posicion p;
	private int rumbo, velocidad;
	
	public Barco(String nombre, Posicion p, int rumbo, int velocidad) {
		if(rumbo<0||rumbo>359) {
			throw new RegataException("Rumbo no valido");
		}else {
			this.nombre=nombre;
			this.p=p;
			this.rumbo=rumbo;
			this.velocidad=velocidad;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public Posicion getPosicion() {
		return p;
	}

	public int getRumbo() {
		return rumbo;
	}

	public int getVelocidad() {
		return velocidad;
	}
	
	@Override
	public boolean equals(Object o) {
		boolean res = o instanceof Barco;
		Barco b = res ? (Barco)o : null;
		return res&&this.getNombre().equalsIgnoreCase(b.getNombre());
	}
	
	@Override
	public int hashCode() {
		return this.getNombre().toUpperCase().hashCode();
	}

	@Override
	public int compareTo(Barco o) {
		int res = this.getNombre().compareToIgnoreCase(o.getNombre());
		return res;
	}
	
	public void avanza(int mnt) {
		this.p = p.posicionTrasRecorrer(mnt, this.getRumbo(), this.getVelocidad());
	}
	
	public String toString() {
		return this.getNombre() + ": l=" + this.getPosicion().getLatitud() + " L=" + this.getPosicion().getLongitud() + " R=" + this.getRumbo() + " V=" + this.getVelocidad();
	}
}
