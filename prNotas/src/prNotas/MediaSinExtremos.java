package prNotas;

public class MediaSinExtremos implements CalculoMedia{
	private double min;
	private double max;
	
	public MediaSinExtremos(double max, double min){
		this.max=max;
		this.min=min;
	}
	
	public double calcular(Alumno[] A) throws AlumnoException{
		double suma=0;
		boolean encontrado=false;
		int contador=0;
		
		for(Alumno a : A){
			if(a.getCalification()>=min&&a.getCalification()>=max){
				encontrado=true;
				suma=suma+a.getCalification();
				contador++;
			}
		}
		if(!encontrado){
			throw new AlumnoException("Fuera de rango");
		}
		return suma/contador;
	}
}
