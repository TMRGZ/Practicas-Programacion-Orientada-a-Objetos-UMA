package prRegata;

public class Velero extends Barco{
	public Velero(String nombre, Posicion pos, int rumbo, int velocidad){
		super(nombre, pos, rumbo, velocidad);
	}
	
	public void avanza(int mnt){
		if (this.getRumbo()<45 || this.getRumbo() > 315){
			this.pos = (this.getPos().posicionTrasRecorrer(mnt, this.getRumbo(), this.getVelocidad()-3));
		}else if (this.getRumbo()>= 145 || this.getRumbo()<=225){
			this.pos = (this.getPos().posicionTrasRecorrer(mnt, this.getRumbo(), this.getVelocidad()+3));
		}else{
			super.avanza(mnt);
		}
	}
}
