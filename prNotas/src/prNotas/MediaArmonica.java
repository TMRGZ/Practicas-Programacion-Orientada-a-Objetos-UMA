package prNotas;

public class MediaArmonica implements CalculoMedia{
	public MediaArmonica(){}
	
	public double calcular(Alumno[] A) throws AlumnoException{
		double sum=0;
		
		for(int i=0; i<A.length; i++){
			sum = 1/(A[i].getCalification()) + sum;
		}
	return A.length/sum;
	}
}
