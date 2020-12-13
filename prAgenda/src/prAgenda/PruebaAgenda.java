package prAgenda;

import java.io.FileNotFoundException;

public class PruebaAgenda {
	public static void main(String[] args) {
		// Creamos un array con contactos
		Contacto[] contactos = { new Contacto("Pepe", "Montes", "jmontes@gmail.com", "111222333"),
				new Contacto("Jose", "Llanos", "jllanos@hotmail.com", "666777888"),
				new Contacto("Fefi", "RiÌ�os", "mjrios@gmail.com", "333444555"),
				new Contacto("Pepi", "Colinas", "jcolinas@uma.es", "222333444") };

		// Creamos un contacto
		Contacto contacto = new Contacto("Pepito", "Arroyo", "ja@gmail.com", "444555666");
		// AnÌƒadimos a una agenda los cuatro contactos del array anterior
		Agenda agenda = new Agenda(100);
		for (Contacto c : contactos)
			agenda.agregaContacto(c);
		// Agregamos contacto ya existente (aunque con diferente email). // No
		// deberiÌ�a anÌƒadirse
		agenda.agregaContacto(new Contacto("Pepe", "Montes", "pepe.montes@hotmail.com", "111222333"));
		// Agregamos contacto que no estaÌ� en la agenda. DeberiÌ�a anÌƒadirse
		agenda.agregaContacto(contacto);
		// Visualizamos la agenda. DeberiÌ�a incluir cinco contactos
		System.out.println("La agenda debe incluir cinco contactos: \n\t" + agenda);
		// Imprimimos el nuÌ�mero de contactos con correo electroÌ�nico en
		// gmail.com:
		// 3
		System.out.println(
				"El numero de contactos con direccion en gmail.com es: " + agenda.nroContactosConEmail("gmail.com"));

		//QUITAR ESTE COMENTARIO PARA USAR ENTRADA Y SALIDA 
		// Ahora agregamos los del fichero
		try {
			agenda.lee("contactos.txt");
		} catch (FileNotFoundException e) {
			System.err.println("No existe el fichero de concactos");
		}
		
		// Mostramos ahora la agenda
		System.out.println("Agenda incluyendo los datos del fichero");
		System.out.println(agenda);
		System.out.println(
				"Ahora el nuÌ�mero de contactos con direccioÌ�n en gmail.com es: " + agenda.nroContactosConEmail("gmail.com"));
		
		// Guardamos todos los contactos en un fichero
		try {
			agenda.guarda("nuevosContactos.txt");
		} catch (FileNotFoundException e) {
			System.err.println("No puede crearse el fichero de contactos");
		}
		
		
		
		// Eliminamos la agenda
		agenda.eliminaTodos();
		// Visualizamos la agenda, que deberiÌ�a estar vaciÌ�a
		System.out.println("La agenda debe estar vacia: \n\t" + agenda);
	}
}
