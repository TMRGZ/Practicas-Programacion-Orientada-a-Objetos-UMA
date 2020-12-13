package prRegata;

public class Barco implements Comparable<Barco>{
	protected String nombre;
	protected int rumbo;
	protected int velocidad;
	Posicion pos;
	
	public Barco(String nombre, Posicion pos, int rumbo, int velocidad){
		this.nombre=nombre;
		this.velocidad=velocidad;
		this.pos=pos;
		
		if(rumbo<0||rumbo>359){
			throw new RegataException("El rumbo no es valido");
		}else{
			this.rumbo=rumbo;
		}
	}

	public int hashCode(Barco b) {
		return this.getNombre().hashCode()+b.getNombre().hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		boolean res = obj instanceof Barco;
		Barco b = res ? (Barco)obj : null;
		return res&&this.getNombre().equalsIgnoreCase(b.getNombre());
	}

	public void avanza(int mnt){
	 	pos = pos.posicionTrasRecorrer(mnt, rumbo, velocidad);
	}
	
	@Override
	public int compareTo(Barco b){
		int res = this.getNombre().compareToIgnoreCase(b.getNombre());
		return res;
	}
	
	public String getNombre() {
		return nombre;
	}

	public int getRumbo() {
		return rumbo;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public String toString() {
		return "Nombre: " + nombre + " l=" + pos.getLatitud() + " L=" + pos.getLongitud() + ", R=" + this.getRumbo() + " V=" + this.getVelocidad();
	}

	public Posicion getPos() {
		return pos;
	}
}
