package prSept17;

import java.util.Set;
import java.util.TreeSet;

public class CuentaModerada extends Cuenta{
	Set<String> claves;
	
	public CuentaModerada(String usr, Set<String> c) {
		super(usr);
		
		if(c==null){
			throw new AppException("Claves vacias");
		}else{
			claves=c;
		}
	}
	
	@Override
	public void addMsj(String receptor, String txt){
		if(claves.contains(txt)){
			throw new AppException("Clave no permitida");
		}else{
			super.addMsj(receptor, txt);
		}
	}
}
