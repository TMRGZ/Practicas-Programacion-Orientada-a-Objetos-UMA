package prTema5;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Posiciones {
	public static void main(String[] args) {
		Map<String, List<Integer>> map = new TreeMap<>();
		
		for(int i=0; i<args.length; i++){
			String palabra = args[i];
			List<Integer> asoc = map.get(palabra);	//Puedes ser null o una lista
				if(asoc==null){
					asoc = new ArrayList<>();
					map.put(palabra, asoc);
				}	//Seguro que asoc es una lista asociada a palabra en map
				asoc.add(i);
		}
		System.out.println(map);
		
	}

}
