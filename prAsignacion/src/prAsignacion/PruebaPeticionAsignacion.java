package prAsignacion;

public class PruebaPeticionAsignacion {

	public static void main(String[] args) {
		PeticionAsignacion p1 = new PeticionAsignacion("POO", "Juan Lopez", new FranjaHoraria("lunes", "primera"));
		PeticionAsignacion p2 = new PeticionAsignacion("FP", "Maria Gomez", new FranjaHoraria("lunes", "primera"));
		
		System.out.println(p1);
		System.out.println(p2);
		
		if(p1.compareTo(p2)==0) {
			System.out.println("Error, Conflicto en: " + p1.getFranja());
		}

	}

}
