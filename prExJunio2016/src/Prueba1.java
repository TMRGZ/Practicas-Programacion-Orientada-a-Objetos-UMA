import java.io.FileNotFoundException;
import java.util.Set;

import prExJunio2016.AsignacionException;
import prExJunio2016.Asignaciones;
import prExJunio2016.FranjaHoraria;


public class Prueba1 {
	public static void main(String[] args) {
		try{
			System.out.println("Prueba 1");
			System.out.println("--------");
			//Asignamos las peticiones de laboratorio a 2 laboratorios
			Asignaciones pet = new Asignaciones(2,"peticiones.txt");
			//Mostramos el resultado de la asignación
			System.out.println(pet);
			//Escribimos en fichero el resultado de la asignación
			pet.escribirAFichero("asignaciones.txt");
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

/*
Prueba 1
--------
Asignacion de laboratorios
--------------------------
Laboratorio 1
	(LUNES, PRIMERA) -> POO, Antonio Lopez
	(MARTES, PRIMERA) -> FP, Maria Molina
	(JUEVES, PRIMERA) -> FP3, Juan Perez
Laboratorio 2
	(LUNES, PRIMERA) -> FP, Juan Perez
Conflictos
----------
	(LUNES, PRIMERA) -> FP1, Juan Perez
	(LUNES, PRIMERA) -> FP2, Juan Perez

Laboratorios libres los Martes a Primera hora: [2]
*/
