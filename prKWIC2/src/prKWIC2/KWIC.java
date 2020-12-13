package prKWIC2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class KWIC {
	protected SortedMap<String, SortedSet<TituloKWIC>> indice;
	protected List<String> palabrasNoSig;
	
	public KWIC(){
		indice = new TreeMap<>();
		palabrasNoSig = new ArrayList<>();
	}
	
	public void palabrasNoSignificativas(String nomFich) throws FileNotFoundException {
		try(Scanner sc = new Scanner(new File(nomFich))){
			palabrasNoSignificativas(sc);
		}
	}

	private void palabrasNoSignificativas(Scanner sc) {	
		while(sc.hasNext()){
			palabrasNoSig.add(sc.next());
		}
	}
	
	public void generaIndice(String nomFich) throws FileNotFoundException{
		try(Scanner sc = new Scanner(new File(nomFich))){
			generaIndice(sc);
		}
	}

	private void generaIndice(Scanner sc) {
		while(sc.hasNextLine()) {
			anyadir(sc.nextLine());
		}
	}

	protected void anyadir(String lineafichero) {
		String linea = lineafichero;
		
		try(Scanner sc = new Scanner(linea)){
			while(sc.hasNext()) {
				String palabra = sc.next();
				
				if(!palabrasNoSig.contains(palabra)) {
					SortedSet<TituloKWIC> lineas = indice.get(palabra);
					TituloKWIC pelicula = new TituloKWIC(linea);
					
					if(lineas==null) {
						lineas = new TreeSet<>();
						lineas.add(pelicula);
						indice.put(palabra.toLowerCase(), lineas);
					}else{
						lineas.add(pelicula);
						indice.put(palabra.toLowerCase(), lineas);
					}	
				}	
			}
		}
	}
	
	public void presentaIndice(String nomFich) throws FileNotFoundException {
		try(PrintWriter pw = new PrintWriter(new File(nomFich))){
			presentaIndice(pw);
		}
	}

	public void presentaIndice(PrintWriter pw) {
		for(String frase : indice.keySet()) {
			pw.print(frase.toUpperCase() + "\n");
			
			for(TituloKWIC t : indice.get(frase)) {
				pw.print("\t");
				pw.println(t + " ");
			}
			pw.print("\n");
		}
	}
}
