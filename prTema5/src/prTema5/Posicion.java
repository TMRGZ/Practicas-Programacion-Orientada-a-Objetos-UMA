package prTema5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Posicion {
	public static void main(String [] args){
		int n = Integer.parseInt(args[0]);
		List<Integer> le =new ArrayList<>();
		
		for(int i=0; i<n; i++){
			le.add(i);
		}
		
		Collections.shuffle(le);
		System.out.println();
	}
}
