import java.io.FileNotFoundException;
import java.util.Set;

import prExJunio2016.AsignacionException;
import prExJunio2016.Asignaciones;
import prExJunio2016.AsignacionesConAlternativas;
import prExJunio2016.FranjaHoraria;


public class Prueba2 {
	public static void main(String[] args) {
		try{
			System.out.println("Prueba 2");
			System.out.println("--------");
			//Asignamos las peticiones de laboratorio a 2 laboratorios
			Asignaciones pet = new AsignacionesConAlternativas(2,"peticionesca.txt");
			//Mostramos el resultado de la asignación
			System.out.println(pet);
			//Escribimos en fichero el resultado de la asignación
			pet.escribirAFichero("asignacionesca.txt");
			//Mostramos los huecos libres en un dia/hora determinados
			Set<Integer> libres = pet.buscarHuecos(new FranjaHoraria("Martes", "Primera"));
			System.out.println("Laboratorios libres los Martes a Primera hora: " + libres+"\n");			
		}catch(AsignacionException e){
			System.err.println(e.getMessage());
		}catch(FileNotFoundException e){
			System.err.println("ERROR.Fichero no encontrado");
		}
	}

}