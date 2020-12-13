package prAgenda;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Agenda{
	static final int TAM=5;
	Contacto[] ArrayContactos;
	
	public Agenda(int capacidad){
		ArrayContactos = new Contacto[capacidad];
	}
	
	public Agenda(){
		ArrayContactos = new Contacto[TAM];
	}
	
	public Contacto buscarContacto(String nombre, String apellidos){
		boolean encontrado=false;
		int i=0;
		
		while(i<ArrayContactos.length&&!encontrado){
			if(ArrayContactos[i].nombre.equals(nombre)&&ArrayContactos[i].apellidos.equals(apellidos)){
				encontrado=true;
			}
		i++;
		}
		
		if(encontrado){
			return ArrayContactos[i];
		}else{
			return null;
		}
	}
	
	public void agregaContacto(Contacto c){
		int i=0;
		
		while(ArrayContactos[i]!=null){
			i++;
			if(i==ArrayContactos.length){
				ArrayContactos = Arrays.copyOf(ArrayContactos,ArrayContactos.length*2);
			}
		}
		ArrayContactos[i]=c;
	}
	
	public void eliminaTodos(){
		for(int i=0; i<ArrayContactos.length; i++){
			ArrayContactos[i]=null;
		}
	}
	
	public int nroContactosConEmail(String dominio){
		int contador=0;
		
		for(int i=0; i<ArrayContactos.length; i++){
			if(ArrayContactos[i].correo.indexOf(dominio)>-1){
				contador++;
			}
		}
	return contador;
	}
	
	/*
	public Contacto creaDesde(String dato){
		try(Scanner sc=new Scanner(dato)){
			sc.useDelimiter("[:]");
			
			apellidos=sc.next();
			nombre=sc.next();
			correo=sc.next();
			numerotel=sc.next();
			
		}
		return c;
	}*/
	
	public void lee(String nombreFichero) throws FileNotFoundException{
		try(Scanner sc = new Scanner(new File("contactos.txt"))){
			lee(sc);
		}
	}
	
	private void lee(Scanner sc){
		while(sc.hasNextLine()){
			System.out.println(sc.nextLine());
		}
	}
	
	public void guarda(String nombreFichero) throws FileNotFoundException{
		try(PrintWriter pw = new PrintWriter(new File("contactos.txt"))){
			guarda(pw);
		}
	}
	
	private void guarda(PrintWriter pw){
		pw.println();
	}	
}
