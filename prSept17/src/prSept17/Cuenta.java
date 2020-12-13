package prSept17;

import java.util.SortedSet;
import java.util.TreeSet;

public class Cuenta {
	private String usuario;
	private SortedSet<Mensaje> enviados;
	
	public Cuenta(String usr){
		if(usr==null){
			throw new AppException("Usuario vacio");
		}else if(usr.equals("")){
			throw new AppException("Usuario vacio");
		}else{
			this.usuario=usr;
			enviados = new TreeSet<>();
		}
	}
	
	public String getUsuario(){
		return this.usuario;
	}
	
	public void addMsj(String receptor, String txt){
		Mensaje m = new Mensaje(this.getUsuario(), receptor, txt);
		enviados.add(m);
	}
	
	public SortedSet<Mensaje> getMsj(Filtro flt){
		SortedSet<Mensaje> nuevo;
		
		if(flt==null){
			nuevo = new TreeSet<>();
			
			for(Mensaje m : enviados){
				nuevo.add(m);
			}
		}else{
			nuevo = new TreeSet<>();
			for(Mensaje m : enviados){
				if(flt.select(m)){
					nuevo.add(m);
				}
			}
		}
		return nuevo;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		for(Mensaje m : enviados){
			sb.append(m);
			sb.append(", ");
		}
		sb.append("]");
		return sb.toString();
	}
}
