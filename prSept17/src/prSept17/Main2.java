package prSept17;


public class Main2 {
	private static void chk(String ref, String res, String op) {
		if (ref.equals(res)) {
			System.out.println("Prueba correcta: ["+op+"]");
		} else {
			System.out.println("Prueba erronea: ["+op+"]");
			System.out.println("    Su salida:  ["+res+"]");
			System.out.println("    Referencia: ["+ref+"]");
		}
	}
	public static void main(String[] args) {
		Cuenta c1 = new Cuenta("u1");
		chk("u1", c1.getUsuario(), "c1.getUsuario()");
		c1.addMsj("r1", "t1");
		c1.addMsj("r2", "t2");
		c1.addMsj("r3", "t3");
		c1.addMsj("r4", "t4");
		c1.addMsj("r5", "t5");
		chk("[(u1; r1; t1), (u1; r2; t2), (u1; r3; t3), (u1; r4; t4), (u1; r5; t5)]", c1.toString(), "c1.addMsj(...); c1.toString()");
		try {
			Cuenta c4 = new Cuenta("");
			System.out.println("Prueba erronea: ["+"new Cuenta(\"\")"+"]");
		} catch (AppException e) {
			System.out.println("Prueba correcta: ["+"new Cuenta(\"\")"+"]");
		}
		try {
			Cuenta c4 = new Cuenta(null);
			System.out.println("Prueba erronea: ["+"new Cuenta(null)"+"]");
		} catch (AppException e) {
			System.out.println("Prueba correcta: ["+"new Cuenta(null)"+"]");
		}
		//----------------------------
		System.out.println("\nLa ejecucion CORRECTA de esta prueba NO grarantiza que la clase ");
		System.out.println("Cuenta sea CORRECTA ya que hay caracteristicas no comprobadas");
	}
}
