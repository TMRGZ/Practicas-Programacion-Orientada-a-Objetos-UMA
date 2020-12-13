package prParking;

public class Posicion {
	private double x, y;
	
	public Posicion(double a, double b){
		x = a; 
		y = b;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public double distancia(Posicion p){
		return Math.sqrt(Math.pow(x-p.x, 2) + Math.pow(y-p.y, 2));
	}
	
	public boolean equals(Object o){
		boolean res = false;
		
		if (o instanceof Posicion) {
			Posicion p = (Posicion) o; 
			res =  p.x == x && p.y == y;
		}
				
		return res;
	}
	
	public int hashCode(){
		return (new Double(x+y)).intValue();
	}
	
	public String toString(){
		return "(" + x + ", " + y + ")";
	}

}
