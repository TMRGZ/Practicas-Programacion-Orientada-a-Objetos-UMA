package prMasterMind;

import java.util.Random;

public class MasterMind {
	private static final int TAM=4;
	private static Random alea = new Random();
	private String combinacionSecreta;
	
	public MasterMind(int numCifras){
		if(numCifras<1 || numCifras>10){
			throw new MasterMindException("Numero de cifras erroneo " + numCifras);
		}
		//Todo OK
		generaCombinacionSecreta(numCifras);
	}

	public MasterMind(){
		this(TAM);
	}
	
	public MasterMind(String cs){
		combinacionSecreta=cs;
		validaCombinacion(cs);
	}
	
	private void generaCombinacionSecreta(int num){
		int cifrasgeneradas = 0;
		combinacionSecreta = "";
		while(cifrasgeneradas < num){
			int cifra = alea.nextInt(10);
			if(combinacionSecreta.indexOf(Integer.toString(cifra))<0){
				//Cifra OK
				combinacionSecreta+=cifra;
				cifrasgeneradas++;
			}
		}
		//Combinacion generada
	}

	private void validaCombinacion(String cs){
		boolean res = longitud() == cs.length();
		if(!res){
			throw new MasterMindException(cs + " no tiene longitud adecuada");
		}
		//Longitud OK
		
		try{
			Integer.parseInt(cs);
		}catch(NumberFormatException e){
			throw new MasterMindException(cs + " Numero no encontrado");
		}//Numero OK
		int i=0;
		while (res&&i<longitud()-1){
			int j= i+1;
			while(res&& j<longitud()){
				res = cs.charAt(i) != cs.charAt(j);
				j++;
			}
			i++;
		}
		if(!res){
			throw new MasterMindException(cs + "Numero no bueno");
		}
	}

	public int longitud(){
		return combinacionSecreta.length();
	}
	
	public String secreto(){
		return combinacionSecreta;
	}
	
	public Movimiento intento(String cifras){
		validaCombinacion(cifras);
		int i=0;
		int colocadas=0;
		int descolocadas=0;
		
		while(i<longitud()){
			if(combinacionSecreta.charAt(i)==cifras.charAt(i)){
				colocadas++;
			}else if(combinacionSecreta.indexOf(cifras.charAt(i))>=0){
				descolocadas++;
			}
		i++;
		}
	return new Movimiento(cifras, colocadas, descolocadas);
	}
	
}