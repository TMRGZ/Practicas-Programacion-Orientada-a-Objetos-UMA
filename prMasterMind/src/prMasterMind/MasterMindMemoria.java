package prMasterMind;

public class MasterMindMemoria extends MasterMind{
	private int primeraPosicionLibre=0;
	private static final int TAMARRAYMOV=10;
	Movimiento movs [] = new Movimiento[TAMARRAYMOV];
	
	public MasterMindMemoria(){
		super();
	}
	
	public MasterMindMemoria(int num){
		super(num);
	}
	
	public Movimiento intento(String cifras){
		Movimiento M = super.intento(cifras);
		int i=0;
		
		while(i<movs.length){
			if(movs[i].equals(M)){
				throw new MasterMindException("Movimiento ya realizado");
			}i++;
		}
		primeraPosicionLibre++;
		movs[primeraPosicionLibre]=M;
		return M;
	}
	
	public Movimiento[] movimientos(){
		return movs;
	}
}
