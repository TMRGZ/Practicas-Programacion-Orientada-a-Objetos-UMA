package prMasterMind;

public class Movimiento {
	private String cifras;
	private int colocadas;
	private int descolocadas;
	
	public Movimiento(String cifras, int colocadas, int descolocadas){
		this.cifras=cifras;
		this.colocadas=colocadas;
		this.descolocadas=descolocadas;
	}
	
	public String cifras(){
		return cifras;
	}
	
	public int colocadas(){
		return colocadas;
	}
	
	public int descolocadas(){
		return descolocadas;
	}
	
	public boolean equals(Object obj){
		boolean res = obj instanceof Movimiento;
		Movimiento movimiento = res ? (Movimiento) obj : null;
		return res && cifras.equals(movimiento.cifras);
	}
	
	public int hashcode(){
		return cifras.hashCode();
	}
	
	public String toString(){
		return "[" + cifras + ", " + colocadas + ", " + descolocadas + "]";
	}
	
}
