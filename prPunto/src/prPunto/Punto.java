package prPunto;

public class Punto {
	double x, y;
	
	public Punto(){
		x=y=0;
	}
	
	public Punto(double x, double y){
		this.x=x;
		this.y=y;
	}
	
	double getX(){
		return x;
	}
	
	double getY(){
		return y;
	}
	
	void transladar(double x, double y){
		this.x+=x;
		this.y+=y;
	}
	
	public String toString(){
		return "("+this.x+", "+this.y+")";
	}
	
	
	
}
