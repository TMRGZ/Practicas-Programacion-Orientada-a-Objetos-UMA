package prCuentaPalabrasSimpleFicherosListas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContadorPalabrasSig extends ContadorPalabras {
	private Set<String> noSignificativas;
	
	public ContadorPalabrasSig(){
		noSignificativas = new HashSet<>();
		
		for(String p : noSignificativas){
			noSignificativas.add(p.toUpperCase());	
		}
	}
	
	public ContadorPalabrasSig(int n, String fich, String del) throws FileNotFoundException{
		super();
		leerFicheroNoSig(fich, del);
	}
	
	private void leerFicheroNoSig(String fich, String del) throws FileNotFoundException{
		try(Scanner sc = new Scanner(new File(fich))){
			leerPalabrasNoSignificativas(sc, del);
		}
	}
	
	private void leerPalabrasNoSignificativas(Scanner sc, String del){
		while(sc.hasNextLine()){
			String linea = sc.nextLine();
			
			try(Scanner scLinea = new Scanner(linea)){
				scLinea.useDelimiter(del);
				
				while(scLinea.hasNext()){
					noSignificativas.add(sc.next().toUpperCase());
				}
			}
		}
	}
	
	@Override
	
	public void incluye(String pal){
		if(!noSignificativas.contains(pal.toUpperCase())){
			super.incluye(pal);
		}
	}
}
