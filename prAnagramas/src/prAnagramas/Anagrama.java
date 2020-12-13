package prAnagramas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Anagrama {
	private Map<Palabra, Set<Palabra>> anagramas;
	
	
	public Anagrama(){
		anagramas = new TreeMap<>();
	}
	
	public Anagrama(String nFichero) throws FileNotFoundException{
		this();
		try(Scanner sc = new Scanner(new File(nFichero))){
			leeFichero(sc);
		}	
	}
	
	public Anagrama(Comparator<Palabra> sat){
		anagramas = new TreeMap<>(sat);
	}
	
	public Anagrama(Comparator<Palabra> sat, String nFichero) throws FileNotFoundException{
		this(sat);
		try(Scanner sc = new Scanner(new File(nFichero))){
			leeFichero(sc);
		}
	}
	
	private void leeFichero(Scanner sc){
		while(sc.hasNextLine()){
			String linea = sc.nextLine();
			try(Scanner scLinea = new Scanner(linea)){
				scLinea.useDelimiter("[ ,]+");
				while(scLinea.hasNext()){
					String pal = sc.next();
					nuevaPalabra(pal);
				}
			}
		}
	}
	
	public void nuevaPalabra(String pal){
		Palabra nuevaPalabra = new Palabra(pal);
		if(!anagramas.containsKey(nuevaPalabra)){
			Set<Palabra> set = new TreeSet<>();
			
			for(Palabra clave : anagramas.keySet()){	//KeySet conjunto de claves iteradas en un conjunto
				if(clave.esAnagrama(nuevaPalabra)){
					anagramas.get(clave).add(nuevaPalabra);
				}
			}
			anagramas.put(nuevaPalabra, set);
		}
	}
	
	public void mostrarEnConsola(){
		PrintWriter pw = new PrintWriter(System.out, true);
		escribirAnagrama(pw);
	}
	
	public void escribirAFichero(String nFichero) throws FileNotFoundException{
		try(PrintWriter pw = new PrintWriter(new File(nFichero))){
			escribirAnagrama(pw);
		}	
	}
	
	private void escribirAnagrama(PrintWriter pw){
		for(Palabra palabra : anagramas.keySet()){
			pw.print(palabra + "\t (");
			for(Palabra p : anagramas.get(palabra)){
				pw.print(p + " ");
			}
			pw.print(")");
		}
	}
	
	public boolean contieneAnagrama(String pal){
		Palabra nuevaPalabra = new Palabra(pal);
		boolean contiene = false;
		Iterator<Palabra> it = anagramas.keySet().iterator();	//Se crea iterator para usar hasNext()
		
		while(it.hasNext() && !contiene){
			contiene = it.next().esAnagrama(nuevaPalabra);
		}
		return contiene;
	}
}
