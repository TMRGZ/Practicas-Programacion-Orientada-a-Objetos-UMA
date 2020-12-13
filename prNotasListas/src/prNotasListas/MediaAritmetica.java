package prNotasListas;
import java.util.List;

import prNotasListas.Alumno;

public class MediaAritmetica implements CalculoMedia{
	public MediaAritmetica(){}
	
	public double calcular(List <Alumno>alumnos) throws AlumnoException{
		double sum=0;
		
		for(int i=0; i<A.length; i++){
			sum = A[i].getCalification() + sum;
		}
	return sum/A.length;
	}
}
