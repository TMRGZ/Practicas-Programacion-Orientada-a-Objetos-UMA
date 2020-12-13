package prCuentaPalabrasSimpleFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ContadorPalabras {
	private int numPalabras;
	private static final int TAM=10;
	PalabraEnTexto palabras[];
	
	public ContadorPalabras(int n){
		this.numPalabras=0;
		palabras = new PalabraEnTexto[n];
	}
	
	public ContadorPalabras(){
		this(TAM);
	}
	
	private int esta(String pal){
		PalabraEnTexto p = new PalabraEnTexto(pal);
		int i=0;
		
		while(i<palabras.length && !p.equals(palabras[i])){
			i++;
		}
		
	return i<numPalabras ? i : -1;
	}
	
	protected void incluye(String pal){
		int i = esta(pal);
		
		if(i<0){
			if(palabras.length==this.numPalabras){
				palabras = Arrays.copyOf(palabras, palabras.length*2);
			}
			palabras[numPalabras]=new PalabraEnTexto(pal);
			numPalabras++;
		}else{
			palabras[i].incrementa();
		}
	}
	
	private void IncluyeTodas(String linea, String del){
		try(Scanner sc = new Scanner(linea)){
			sc.useDelimiter(del);
			while(sc.hasNext()){
				incluye(sc.next());
			}
		}
	}
	
	public void IncluyeTodas(String[] texto, String del){
		for(String linea : texto){
			IncluyeTodas(linea, del);
		}
	}
	
	public void IncluyeTodasFichero(String nomFich, String del){
		try(Scanner sc = new Scanner(new File(nomFich))){
			leerFichero(sc,del);
		}catch(FileNotFoundException e){
			System.out.println("Fichero no encontrado");
		}
	}
	
	private void leerFichero(Scanner sc, String del){
		while(sc.hasNextLine()){
			this.IncluyeTodas(sc.nextLine(), del);
		}
	}
	
	public PalabraEnTexto encuentra(String pal) throws NoSuchElementException{
		int i = esta(pal);
		
		if(i<0){
			throw new NoSuchElementException("La palabra: " + pal + "no se encuentra");
		}
		
		return palabras[i];
	}
	
	@Override
	
	public String toString(){
		StringBuilder sb = new StringBuilder("[");
		
		for(int i=0; i<numPalabras; i++){
			sb.append(palabras[i]);
			if(i<numPalabras-1){
				sb.append(", ");
			}
		}
		sb.append("]");
		return sb.toString();
	}
	
	public void presentaPalabras(String fich) throws FileNotFoundException{
		try(PrintWriter pw = new PrintWriter(fich)){
			presentaPalabras(pw);
		}
	}
	
	public void presentaPalabras(PrintWriter pw){
		for(int i=0; i<numPalabras; i++){
			pw.println(palabras[i]);
		}
	}
}
