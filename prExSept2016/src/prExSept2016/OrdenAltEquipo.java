package prExSept2016;

import java.util.Comparator;

public class OrdenAltEquipo implements Comparator<Equipo>{

	@Override
	public int compare(Equipo e1, Equipo e2) {
		int resultado=0;
		
		if(e1.getCategoria()==e2.getCategoria()){
			resultado = e1.getNombre().compareToIgnoreCase(e2.getNombre());
			
		}else if(resultado==0){
			resultado = Integer.compare(e1.getPuntos(), e2.getPuntos());
		}else{
			resultado = Integer.compare(e1.getCategoria(), e2.getCategoria());
			resultado = -resultado; 
		}
		return resultado;
	}	
}

