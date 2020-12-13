package regata;

public class Velero extends Barco{

	public Velero(String nombre, Posicion p, int rumbo, int velocidad) {
		super(nombre, p, rumbo, velocidad);
	}
	
	public void avanza(int mnt) {
		if(this.getRumbo()<=45||this.getRumbo()>=315) {
			this.getPosicion().posicionTrasRecorrer(mnt, this.getRumbo(), this.getVelocidad()-3);
		}else if(this.getRumbo()<=145||this.getRumbo()>=225) {
			this.getPosicion().posicionTrasRecorrer(mnt, this.getRumbo(), this.getVelocidad()+3);
		}else {
			this.getPosicion().posicionTrasRecorrer(mnt, this.getRumbo(), this.getVelocidad());
		}
	}

}
