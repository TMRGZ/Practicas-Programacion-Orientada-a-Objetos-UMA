package prSept17;

import java.util.Set;

public class FiltroTexto implements Filtro{
	private Set<String> claves;
	
	public FiltroTexto(Set<String> c){
		for(String s : c){
			claves.add(s.toUpperCase());
		}
	}
	
	@Override
	public boolean select(Mensaje m){
		boolean res = false;
		
		for(String s : claves){
			if(m.getTexto().equalsIgnoreCase(s)){
				res=true;
			}
		}
		return res;
	}
}
