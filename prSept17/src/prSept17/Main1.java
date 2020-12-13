package prSept17;
import java.util.Arrays;

public class Main1 {
	private static void chk(String ref, String res, String op) {
		if (ref.equals(res)) {
			System.out.println("Prueba correcta: ["+op+"]");
		} else {
			System.out.println("Prueba erronea: ["+op+"]");
			System.out.println("    Su salida:  ["+res+"]");
			System.out.println("    Referencia: ["+ref+"]");
		}
	}
	private static void chk(int ref, int res, String op) {
		if (ref == res) {
			System.out.println("Prueba correcta: ["+op+"]");
		} else {
			System.out.println("Prueba erronea: ["+op+"]");
			System.out.println("    Su salida:  ["+res+"]");
			System.out.println("    Referencia: ["+ref+"]");
		}
	}
	private static void chk(boolean ref, boolean res, String op) {
		if (ref == res) {
			System.out.println("Prueba correcta: ["+op+"]");
		} else {
			System.out.println("Prueba erronea: ["+op+"]");
			System.out.println("    Su salida:  ["+res+"]");
			System.out.println("    Referencia: ["+ref+"]");
		}
	}
	public static void main(String[] args) {
		Mensaje m1 = new Mensaje("e1", "r1", "t1");
		Mensaje m2 = new Mensaje("e1", "r1", "t1");
		Mensaje m3 = new Mensaje("E1", "R1", "T1");
		chk("e1", m1.getEmisor(), "m1.getEmisor()");
		chk("r1", m1.getReceptor(), "m1.getReceptor()");
		chk("t1", m1.getTexto(), "m1.getTexto()");
		chk("(e1; r1; t1)", m1.toString(), "m1.toString()");
		chk(true, m1.equals(m1), "m1.equals(m1)");
		chk(false, m1.equals(m2), "m1.equals(m2)");
		chk(false, m3.equals(m2), "m3.equals(m2)");
		int hm1 = m1.hashCode();
		chk(hm1+0, m1.hashCode(), "m1.hashCode()");
		chk(hm1+1, m2.hashCode(), "m2.hashCode()");
		chk(hm1+2, m3.hashCode(), "m3.hashCode()");
		chk(0, m1.compareTo(m1), "m1.compareTo(m1)");
		chk(1, m2.compareTo(m1), "m2.compareTo(m1)");
		chk(-1, m1.compareTo(m3), "m1.compareTo(m3)");
		Mensaje[] msgs = new Mensaje[] { m3, m2, m1 };
		Arrays.sort(msgs);
		if (msgs[0] == m1 && msgs[1] == m2 && msgs[2] == m3) {
			System.out.println("Prueba correcta: ["+"Arrays.sort"+"]");
		} else {
			System.out.println("Prueba erronea: ["+"Arrays.sort"+"]");
		}
		try {
			Mensaje m4 = new Mensaje("", "", "");
			System.out.println("Prueba erronea: ["+"new Mensaje(\"\",\"\",\"\")"+"]");
		} catch (AppException e) {
			System.out.println("Prueba correcta: ["+"new Mensaje(\"\",\"\",\"\")"+"]");
		}
		try {
			Mensaje m4 = new Mensaje(null, null, null);
			System.out.println("Prueba erronea: ["+"new Mensaje(null,null,null)"+"]");
		} catch (AppException e) {
			System.out.println("Prueba correcta: ["+"new Mensaje(null,null,null)"+"]");
		}
		//----------------------------
		System.out.println("\nLa ejecucion CORRECTA de esta prueba NO grarantiza que la clase ");
		System.out.println("Mensaje sea CORRECTA ya que hay caracteristicas no comprobadas");
	}
}
