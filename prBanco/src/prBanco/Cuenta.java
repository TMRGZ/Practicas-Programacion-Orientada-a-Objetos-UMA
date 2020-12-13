package prBanco;

public class Cuenta {
	int numero;
	double saldo;
	String titular;
	
	public Cuenta(String tit, int num, double sal){
		titular=tit;
		numero=num;
		saldo=sal;
	}
	
	public Cuenta(String tit, int num){
		titular=tit;
		numero=num;
		saldo=0;
	}
	
	public void ingreso(double ingresado){
		saldo=saldo+ingresado;
	}
	
	public void debito(double retirado){
		saldo=saldo+retirado;
	}
	
	public String titular(){
		return titular;
	}
	
	public double saldo(){
		return saldo;
	}
	
	public int cuenta(){
		return numero;
	}
	
	public String toString(){
		return "\n Numero de cuenta: "+cuenta() + "\n Titular: " + titular() + "\n Saldo: " + saldo();
	}
}
