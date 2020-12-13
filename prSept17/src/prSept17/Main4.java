package prSept17;

import java.util.Arrays;
import java.util.Set;
import java.util.SortedSet;
import java.util.HashSet;

public class Main4 {
	private static void chk(String ref, String res, String op) {
		if (ref.equals(res)) {
			System.out.println("Prueba correcta: ["+op+"]");
		} else {
			System.out.println("Prueba erronea: ["+op+"]");
			System.out.println("    Su salida:  ["+res+"]");
			System.out.println("    Referencia: ["+ref+"]");
		}
	}
	public static void prueba1() {
		RedSocial r = new RedSocial();
		r.login("admin");
		r.addMsj("todos", "m1-comienzo del sistema");
		r.crearCuenta("pepe");
		r.addMsj("pepe", "m2-bienvenido al sistema");
		r.logout();
		r.login("pepe");
		r.addMsj("admin", "m3-gracias admin");
		r.addMsj("todos", "m4-aqui estoy, es el primer mensaje");
		r.addMsj("pepe", "m5-este es el inicio");
		r.addMsj("admin", "m6-necesito mas espacio");
		r.logout();
		r.login("admin");
		r.addMsj("pepe", "m7-de acuerdo");
		r.crearCuentaModerada("juan", new HashSet<String>(Arrays.asList("mensaje", "inicio")));
		r.logout();
		chk("{ ADMIN: [(ADMIN; todos; m1-comienzo del sistema), (ADMIN; pepe; m2-bienvenido al sistema), (ADMIN; pepe; m7-de acuerdo)] JUAN: [] PEPE: [(PEPE; admin; m3-gracias admin), (PEPE; todos; m4-aqui estoy, es el primer mensaje), (PEPE; pepe; m5-este es el inicio), (PEPE; admin; m6-necesito mas espacio)] }", r.toString(), "r.toString()");
		r.login("juan");
		try {
			r.addMsj("admin", "m8-mensaje de inicio");
			System.out.println("Prueba erronea: ["+"addMsj"+"]");
		} catch (Exception e) {
			System.out.println("Prueba correcta: ["+"addMsj"+"]");
		}
		r.addMsj("admin", "m9-msj final");
		try {
			r.addMsj("admin", "m10-inicio");
			System.out.println("Prueba erronea: ["+"addMsj"+"]");
		} catch (Exception e) {
			System.out.println("Prueba correcta: ["+"addMsj"+"]");
		}
		r.addMsj("admin", "m10-adios");
		r.logout();
		chk("{ ADMIN: [(ADMIN; todos; m1-comienzo del sistema), (ADMIN; pepe; m2-bienvenido al sistema), (ADMIN; pepe; m7-de acuerdo)] JUAN: [(JUAN; admin; m9-msj final), (JUAN; admin; m10-adios)] PEPE: [(PEPE; admin; m3-gracias admin), (PEPE; todos; m4-aqui estoy, es el primer mensaje), (PEPE; pepe; m5-este es el inicio), (PEPE; admin; m6-necesito mas espacio)] }", r.toString(), "r.toString()");
		r.login("pepe");
		SortedSet<Mensaje> s1 = r.getMsjsCon("admin");
		chk("[(ADMIN; pepe; m2-bienvenido al sistema), (PEPE; admin; m3-gracias admin), (PEPE; admin; m6-necesito mas espacio), (ADMIN; pepe; m7-de acuerdo)]", s1.toString(), "r.getMsjsCon(\"admin\")");
		SortedSet<Mensaje> s2 = r.getMsjsClaves(new HashSet<String>(Arrays.asList("saje", "acio")));
		chk("[(PEPE; todos; m4-aqui estoy, es el primer mensaje), (PEPE; admin; m6-necesito mas espacio)]", s2.toString(), "r.getMsjsClaves(\"saje\", \"acio\")");
		r.logout();
		try {
			r.guardarEnFichero("salida1.txt");
		} catch (Exception e) {
			System.out.println("Error en guardarEnFichero: "+e.getMessage());
		}
		RedSocial r2 = null;
		try {
			r2 = new RedSocial();
			r2.cargarDeFichero("salida1.txt");
		} catch (Exception e) {
			System.out.println("Error en cargarDeFichero: "+e.getMessage());
		}
		chk("{ ADMIN: [(ADMIN; todos; m1-comienzo del sistema), (ADMIN; pepe; m2-bienvenido al sistema), (ADMIN; pepe; m7-de acuerdo)] JUAN: [(JUAN; admin; m9-msj final), (JUAN; admin; m10-adios)] PEPE: [(PEPE; admin; m3-gracias admin), (PEPE; todos; m4-aqui estoy, es el primer mensaje), (PEPE; pepe; m5-este es el inicio), (PEPE; admin; m6-necesito mas espacio)] }", r2.toString(), "r1.guardarEnFichero(); r2.cargarDeFichero(); r2.toString()");
	}
	public static void prueba2() {
		RedSocial r = new RedSocial();
		r.login("admin");
		r.crearCuenta("pepe");
		r.logout();
		try {
			r.login("juan");
			System.out.println("Prueba erronea: ["+"login(\"juan\")"+"]");
		} catch (Exception e) {
			System.out.println("Prueba correcta: ["+"login(\"juan\")"+"]");
		}
		r.logout();
		r.login("pepe");
		try {
			r.crearCuenta("lola");
			System.out.println("Prueba erronea: ["+"crearCuenta(\"lola\")"+"]");
		} catch (Exception e) {
			System.out.println("Prueba correcta: ["+"crearCuenta(\"lola\")"+"]");
		}
		r.logout();
		r.login("admin");
		try {
			r.crearCuenta("pepe");
			System.out.println("Prueba erronea: ["+"crearCuenta(\"pepe\")"+"]");
		} catch (Exception e) {
			System.out.println("Prueba correcta: ["+"crearCuenta(\"pepe\")"+"]");
		}
		try {
			SortedSet<Mensaje> s1 = r.getMsjsCon("xxx");
			System.out.println("Prueba erronea: ["+"getMsjsCon(\"xxx\")"+"]");
		} catch (Exception e) {
			System.out.println("Prueba correcta: ["+"getMsjsCon(\"xxx\")"+"]");
		}
		r.logout();
		
	}
	public static void main(String[] args) {
		prueba1();
		prueba2();
		//----------------------------
		System.out.println("\nLa ejecucion CORRECTA de esta prueba NO grarantiza que la clase ");
		System.out.println("RedSocial sea CORRECTA ya que hay caracteristicas no comprobadas");
	}
}
