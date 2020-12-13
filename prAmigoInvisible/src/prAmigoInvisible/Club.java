package prAmigoInvisible;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;



public class Club {
	List<Persona> personas;
	
	public Club (){
		personas = new ArrayList<>();
	}
	
	public void leeSocios(String fichero) throws FileNotFoundException{
		try(Scanner sc= new Scanner(new File(fichero))){
			sc.useDelimiter("[,;- \\n]");		//Delimitador de salto de linea
			leeSocios(sc);
		}
	}
	
	void leeSocios(Scanner sc){
		while(sc.hasNextLine()){
			personas.add(new Persona(sc.next()));
		}
	}
	
	public void generaAmigos(){
		int i=0;
		int j=0;
		
		List<Integer> posAmigos = new ArrayList<>();
		Iterator<Integer> iter=posAmigos.iterator();
		
		while(iter.hasNext()){
			posAmigos.add(i);
			i++;
			iter.next();
		}
		
		while(hayCoincidencias(posAmigos)==true){
			Collections.shuffle(posAmigos);
		}
		
		for(Persona p : personas){
			p.setAmigo(personas.get(posAmigos.get(j)));
			j++;
		}
	}
	
	private static boolean hayCoincidencias(List<Integer> posAmigos){
		Iterator<Integer> iter=posAmigos.iterator();
		Integer pos=0;
		
		while(iter.hasNext()){
			if(iter.next().equals(pos)){
				pos++;
			}
		}
		
		if(pos==posAmigos.size()){
			return true;
		}else{
			return false;
		}
	}
	
	public void presentaAmigos(String file) throws FileNotFoundException{
		PrintWriter pw = new PrintWriter(file);
		presentaAmigos(pw);
	}
	
	public void presentaAmigos(PrintWriter pw){
		for(Persona p : personas){
			pw.println(p);
		}
	}
}
