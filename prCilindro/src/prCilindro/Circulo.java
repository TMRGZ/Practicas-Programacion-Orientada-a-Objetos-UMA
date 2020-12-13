package prCilindro;

public class Circulo extends Punto{
	double radio;
	
	public Circulo(){
		this.radio=0;
	}
	
	public Circulo(Punto p, double punto){
		this.radio=distancia(p);
	}
	
	public double radio(){
		return this.radio;
	}
	
	public Punto centro(){
		
	}
	
	public void radio(double radio){
		
	}
	
	public void centro(Punto p){
		
	}
	
	public void transladar(double x, double y){
		
	}
	
}
