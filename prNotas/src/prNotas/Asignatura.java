package prNotas;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Asignatura {
	private String nombre;
	private String[] erroneos;
	private Alumno[] alumnos; 
	
	public Asignatura(String nombres, String[] array){
		nombre = nombres;
		Alumno[] alumnosAux = new Alumno[array.length];
			int correctos=0;
		String[] erroresAux = new String[array.length];
			int errores=0;
		
		for(String linea: array){
			Scanner sc = new Scanner(linea);
			
			
			try{
				sc.useDelimiter("[;]");
				sc.useLocale(Locale.ENGLISH);
				
				String dniAlumno = sc.next();
				String nombreAlumno = sc.next();
				double notaAlumno = sc.nextDouble();
				
				Alumno alumno = new Alumno(dniAlumno ,nombreAlumno, notaAlumno);
				alumnosAux[correctos]=alumno;
					correctos++;
			
			}catch(InputMismatchException e){
				erroresAux[errores]="ERROR, Calificacion no numerica"+linea;
				errores++;
			}catch(NoSuchElementException e){
				erroresAux[errores]="ERROR, Faltan datos"+linea;
				errores++;
			}catch(AlumnoException e){
				erroresAux[errores]="ERROR, Datos Dañados"+linea;
				errores++;
			}finally{
				sc.close();
			}
		}
		alumnos = Arrays.copyOf(alumnosAux, correctos);
		erroneos = Arrays.copyOf(erroresAux, errores);
	}
	
	public double getCalification(Alumno a) throws AlumnoException{
		boolean encontrado=false;
		int i=0;
		
		while(i<alumnos.length&&!encontrado){
			if(alumnos[i].equals(a)){
				encontrado=true;
			}else{
				i++;
			}
		}
		
		if(encontrado){
			return alumnos[i].getCalification();
		}else{
			throw new AlumnoException("Error, no encontrado"+a);
		}
	}
	
	public Alumno[] getAlumnos(){
		return alumnos;
	}

	public String[] getErrores(){
		return erroneos;
	}
	
	public double getMedia(CalculoMedia media) throws AlumnoException{
		return media.calcular(alumnos);
	}
	
	public String toString(){
		StringBuilder sb=new StringBuilder(nombre+"[");
		
		for(int i=0; i<alumnos.length; i++){
			sb.append(alumnos[i]);
			sb.append("; ");
			if(i<alumnos.length-1){
				sb.append("]");
			}
		}
		return sb.toString();
	}
}
