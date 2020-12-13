
package prKWIC;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;



public class KWIC {
	private SortedMap<TituloKWIC, SortedSet<TituloKWIC>> indice;
	List<String> palabrasNoSig;
	
	public KWIC(){
		indice = new TreeMap<>();
		palabrasNoSig = new LinkedList<>();
	}
	
	public void palabrasNoSignificativas(String nFichero) throws FileNotFoundException{
		try(Scanner sc = new Scanner(new File(nFichero))){
			palabrasNoSignificativas(sc);
		}	
	}
	
	private void palabrasNoSignificativas(Scanner sc){
		while(sc.hasNextLine()){
			String linea = sc.nextLine();
			try(Scanner scLinea = new Scanner(linea)){
				scLinea.useDelimiter(" ");
				while(scLinea.hasNext()){
					palabrasNoSig.add(sc.next());
				}
			}
		}
	}
	
	public void generaIndice(String nFichero) throws FileNotFoundException{
		try(Scanner sc = new Scanner(new File(nFichero))){
			generaIndice(sc);
		}
	}
	
	private void generaIndice(Scanner sc){
		while(sc.hasNextLine()){
			String linea = sc.nextLine();
			try(Scanner scLinea = new Scanner(linea)){
				scLinea.useDelimiter(" ");
				while(scLinea.hasNext()){
					palabrasNoSig.add(sc.next());
				}
			}
		}
	}
	
	protected void anyadir(String pal){
		TituloKWIC nuevaPalabra = new TituloKWIC(pal);
		if(!indice.containsKey(nuevaPalabra)){
			SortedSet<TituloKWIC> titulos = new TreeSet<>();
			
			for(TituloKWIC clave : indice.keySet()){
				indice.get(clave).add(nuevaPalabra);
			}
			indice.put(nuevaPalabra, titulos);
		}
	}
	
	public void presentaIndice(String texto){
		PrintWriter pw = new PrintWriter(System.out, true);
		presentaIndice(pw);
	}
	
	public void presentaIndice(PrintWriter pw){
		for(TituloKWIC frase : indice.keySet()){
			pw.print(frase + "\t (");
			for(TituloKWIC t : indice.get(frase)){
				pw.print(t + " ");
			}
			pw.print(")");
		}
	}
}
