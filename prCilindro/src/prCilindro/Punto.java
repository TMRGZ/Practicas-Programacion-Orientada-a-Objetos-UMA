package prCilindro;

public class Punto {
	private double x;
	private double y;
	
	public Punto(){
		this.x=0;
		this.y=0;
	}
	
	public Punto(double x, double y){
		this.x=x;
		this.y=y;
	}
	
	public double abscisa(){
		return this.x;
	}
	
	public double ordenada(){
		return this.y;
	}
	
	public void transladar(double a, double b){
		this.x=this.x+a;
		this.y=this.y+b;
	}
	
	public void abscisa(double x){
		this.x=x;
	}
	
	public void ordenada(double y){
		this.y=y;
	}
	
	public double distancia(Punto p){
		double distanciax, distanciay, distanciafinal;
		
		distanciax = this.x-p.x;
		distanciay = this.y-p.y;
		
		distanciafinal = Math.sqrt((distanciax*distanciax)+distanciay*distanciay);
		
		
		return distanciafinal;
	}
	
	public String toString(Punto p){
		return "Abscisa: " + abscisa() + " Ordenada: " + ordenada() + "Distancia: " + distancia(p); 
	}

}
