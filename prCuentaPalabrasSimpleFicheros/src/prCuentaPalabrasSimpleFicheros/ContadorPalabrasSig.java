package prCuentaPalabrasSimpleFicheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ContadorPalabrasSig extends ContadorPalabras {
	private String[] noSignificativas;
	private static int TAM;
	private int numNoSig;
	
	public ContadorPalabrasSig(int n, String [] pns){
		super(n);
		noSignificativas = new String[pns.length];
		
		for(int i=0; i<numNoSig; i++){
			noSignificativas[i] = pns[i].toUpperCase();	
		}
	}
	
	public ContadorPalabrasSig(String [] pns){
		this(TAM, pns);
	}
	
	public ContadorPalabrasSig(int n, String fich, String del) throws FileNotFoundException{
		super(n);
		noSignificativas = new String [TAM];
		numNoSig=0;
		leerFicheroNoSig(fich, del);
	}
	
	public ContadorPalabrasSig(String fich, String del) throws FileNotFoundException{
		this(TAM, fich, del);
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
					if(numNoSig == noSignificativas.length){
						noSignificativas = Arrays.copyOf(noSignificativas, noSignificativas.length*2);
					}
					noSignificativas[numNoSig]=sc.next();
					numNoSig++;
				}
			}
		}
	}
	
	@Override
	
	public void incluye(String pal){
		String palabra = pal.toUpperCase();
		int i=0;
		
		while(i<numNoSig && !palabra.equals(noSignificativas[i])){
			i++;
		}
		if(i==numNoSig){
			super.incluye(pal);
		}
	}
}
