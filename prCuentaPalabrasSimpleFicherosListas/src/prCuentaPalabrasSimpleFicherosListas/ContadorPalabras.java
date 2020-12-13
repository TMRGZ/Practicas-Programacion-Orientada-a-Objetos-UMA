package prCuentaPalabrasSimpleFicherosListas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ContadorPalabras {
	List<PalabraEnTexto> palabras;
	
	public ContadorPalabras(){
		palabras = new LinkedList<>();
	}

	private int esta(String pal){
		PalabraEnTexto p = new PalabraEnTexto(pal);
		return palabras.indexOf(p);
	}
	
	protected void incluye(String pal){
		int i = esta(pal);
		
		if(i<0){
			palabras.add(new PalabraEnTexto(pal));
		}else{
			palabras.get(i).incrementa();
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
		
		return palabras.get(i);
	}
	
	@Override
	
	public String toString(){
		return palabras.toString();
	}
	
	public void presentaPalabras(String fich) throws FileNotFoundException{
		try(PrintWriter pw = new PrintWriter(fich)){
			presentaPalabras(pw);
		}
	}
	
	public void presentaPalabras(PrintWriter pw){
		for(PalabraEnTexto palabraEnTexto : palabras){
			pw.println(palabraEnTexto);
		}
	}
}
