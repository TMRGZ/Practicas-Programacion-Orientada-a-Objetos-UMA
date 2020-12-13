package prNotasListas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Asignatura {
	private String nombre;
	private List<String> errores;
	public List<Alumno> alumnos; 
	
	public Asignatura(String nombres, String[] array){
		nombre = nombres;
		alumnos = new ArrayList<>();
		errores = new ArrayList<>();
		
		for(String linea: array){
			try(Scanner sc = new Scanner(linea);){
				sc.useDelimiter("[;]");
				sc.useLocale(Locale.ENGLISH);
				
				String dniAlumno = sc.next();
				String nombreAlumno = sc.next();
				double notaAlumno = sc.nextDouble();
				
				Alumno al = new Alumno(dniAlumno ,nombreAlumno, notaAlumno);
				alumnos.add(al);
			
			}catch(InputMismatchException e){
				errores.add(linea);
			}catch(NoSuchElementException e){
				errores.add(linea);
			}catch(AlumnoException e){
				errores.add(linea);
			}
		}
	}
	
	public double getCalification(Alumno al) throws AlumnoException{
		if(!alumnos.contains(al)) {
			throw new AlumnoException("El alumno no existe");
		}else {
			return al.getCalification();
		}
	}
	
	public List<Alumno> getAlumnos(){
		return alumnos;
	}

	public List<String> getErrores(){
		return errores;
	}
	
	public double getMedia(CalculoMedia media) throws AlumnoException{
		return media.calcular(alumnos);
	}
	
	public String toString(){
		StringBuilder sb=new StringBuilder(nombre+"\n");
		
		for(Alumno a : alumnos){
			sb.append(a);
			sb.append("\n");
		}
		
		return sb.toString();
	}
}
