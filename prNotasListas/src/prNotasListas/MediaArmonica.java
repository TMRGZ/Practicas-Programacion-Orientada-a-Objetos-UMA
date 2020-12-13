package prNotasListas;

import java.util.List;

public class MediaArmonica implements CalculoMedia{
	public MediaArmonica(){}
	
	public double calcular(List <Alumno>alumnos) throws AlumnoException{
		double sum=0;
		
		for(int i=0; i<A.length; i++){
			sum = 1/(A[i].getCalification()) + sum;
		}
	return A.length/sum;
	}
}
