package prSept17;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;

public class Main3 {
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
		Set<String> clvs = new HashSet<String>(Arrays.asList("x1", "x2", "x3"));
		CuentaModerada c1 = new CuentaModerada("u1", clvs);
		chk("u1", c1.getUsuario(), "c1.getUsuario()");
		try {
			c1.addMsj("r1", "t1 x1xxxxx");
			chk("[]", c1.toString(), "c1.addMsj(...); c1.toString()");
		} catch (AppException e) {
			chk("[]", c1.toString(), "c1.addMsj(...); c1.toString()");
		}
		try {
			c1.addMsj("r2", "t2 xx2xx2xx");
			chk("[]", c1.toString(), "c1.addMsj(...); c1.toString()");
		} catch (AppException e) {
			chk("[]", c1.toString(), "c1.addMsj(...); c1.toString()");
		}
		try {
			c1.addMsj("r3", "t3 xxxxxx3");
			chk("[]", c1.toString(), "c1.addMsj(...); c1.toString()");
		} catch (AppException e) {
			chk("[]", c1.toString(), "c1.addMsj(...); c1.toString()");
		}
		try {
			c1.addMsj("r4", "t4 xxxxxx");
			chk("[(u1; r4; t4 xxxxxx)]", c1.toString(), "c1.addMsj(...); c1.toString()");
		} catch (AppException e) {
			chk("[(u1; r4; t4 xxxxxx)]", c1.toString(), "c1.addMsj(...); c1.toString()");
		}
		try {
			c1.addMsj("r5", "t5 xxxxxx");
			chk("[(u1; r4; t4 xxxxxx), (u1; r5; t5 xxxxxx)]", c1.toString(), "c1.addMsj(...); c1.toString()");
		} catch (AppException e) {
			chk("[(u1; r4; t4 xxxxxx), (u1; r5; t5 xxxxxx)]", c1.toString(), "c1.addMsj(...); c1.toString()");
		}
		chk("[(u1; r4; t4 xxxxxx), (u1; r5; t5 xxxxxx)]", c1.toString(), "c1.addMsj(...); c1.toString()");
		try {
			CuentaModerada c4 = new CuentaModerada("u7", null);
			System.out.println("Prueba erronea: ["+"new CuentaModerada(\"u7\",null)"+"]");
		} catch (AppException e) {
			System.out.println("Prueba correcta: ["+"new CuentaModerada(\"u7\",null)"+"]");
		}
		//----------------------------
		System.out.println("\nLa ejecucion CORRECTA de esta prueba NO grarantiza que la clase ");
		System.out.println("CuentaModerada sea CORRECTA ya que hay caracteristicas no comprobadas");
	}
}
