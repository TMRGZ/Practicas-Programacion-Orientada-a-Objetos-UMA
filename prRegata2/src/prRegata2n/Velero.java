package prRegata2n;

public class Velero extends Barco{
	public Velero(String nombre, Posicion posicion, int rumbo, int velocidad) {
		super(nombre, posicion, rumbo, velocidad);
	}
	
	public void avanza(int mnt){
		if(this.getRumbo()<=45||this.getRumbo()>=315) {
			this.posicion =this.posicion.posicionTrasRecorrer(mnt, this.getRumbo(), this.getVelocidad()-3);
		}else if(this.getRumbo()<=145||this.getRumbo()>=225) {
			this.posicion =this.posicion.posicionTrasRecorrer(mnt, this.getRumbo(), this.getVelocidad()+3);
		}
	}
}
