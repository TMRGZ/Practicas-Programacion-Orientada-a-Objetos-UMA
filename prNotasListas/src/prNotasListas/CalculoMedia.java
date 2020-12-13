package prNotasListas;

import java.util.List;

public class CalculoMedia{
	public double calcular(List<Alumno> alumnos) {
		double suma =0;
		int contador = 0;
		
		for(Alumno a : alumnos) {
			suma = suma + a.getCalification();
			contador++;
		}
		
		return suma/contador;
	}
}
