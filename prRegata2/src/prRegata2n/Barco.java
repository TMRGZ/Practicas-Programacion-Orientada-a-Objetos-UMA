package prRegata2n;

public class Barco implements Comparable<Barco>{
	protected String nombre;
	protected Posicion posicion;
	protected int rumbo;
	protected int velocidad;
	
	public Barco(String nombre, Posicion posicion, int rumbo, int velocidad) {
		if(rumbo<0||rumbo>359) {
			throw new RegataException("Rumbo no valido");
		}else {
			this.nombre=nombre;
			this.posicion=posicion;
			this.rumbo=rumbo;
			this.velocidad=velocidad;
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean res = obj instanceof Barco;
		Barco b = res ? (Barco)obj : null;
		return res&&this.getNombre().equalsIgnoreCase(b.getNombre());
	}
	
	public int hashCode(Barco b) {
		return this.getNombre().toLowerCase().hashCode()+b.getNombre().toLowerCase().hashCode();
	}
	
	public void avanza(int mnt) {
		this.posicion= this.posicion.posicionTrasRecorrer(mnt, rumbo, velocidad);
	}
	
	public String toString() {
		return this.getNombre() + ": l=" + this.getPosicion().getLatitud() + " L=" + this.getPosicion().getLongitud() + " R=" + this.getRumbo() + " V=" + this.getVelocidad();
	}
	
	public String getNombre() {
		return nombre;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public int getRumbo() {
		return rumbo;
	}

	public int getVelocidad() {
		return velocidad;
	}

	@Override
	public int compareTo(Barco b) {
		int res = this.getNombre().toLowerCase().compareTo(b.getNombre().toLowerCase());
		return res;
	}
}
