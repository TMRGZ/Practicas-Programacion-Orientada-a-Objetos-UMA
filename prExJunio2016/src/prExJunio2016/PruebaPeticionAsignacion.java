package prExJunio2016;

public class PruebaPeticionAsignacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FranjaHoraria f1 = new FranjaHoraria("LUNES", "PRIMERA");
		FranjaHoraria f2 = new FranjaHoraria("MARTES", "PRIMERA");
		
		PeticionAsignacion pa1 = new PeticionAsignacion("Paco", "POO", f1);
		PeticionAsignacion pa2 = new PeticionAsignacion("Casermeiro", "Estadistica", f2);
		
		System.out.println("Primera = " + pa1);
		System.out.println("Segunda = " + pa2);
		if (pa1.compareTo(pa2)==0) {
			System.out.println("Error");
		} else {
			System.out.println("Validos");
		}
	}

}
