package prCoche;

public class Coche {
	private String nombre;
	private double precio;
	private static double PIVA=0.16;
	
	public Coche(String nombre, double precio){
		this.nombre=nombre;
		this.precio=precio;
	}
	
	public static void setPiva(double IVA){
		PIVA=IVA;
	}
	
	public double precioTotal(){
		double preciofinal=precio+(precio*PIVA);
		
	return preciofinal;
	}
	
	public String toString(){
		return "\n Coche: " + nombre + "\n Precio sin IVA: " + precio + "\n Precio con IVA del " + PIVA*100 + "%: " + precioTotal();
	}
}
