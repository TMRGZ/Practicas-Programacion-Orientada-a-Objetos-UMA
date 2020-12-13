package prCoche;

public class CocheImportado extends Coche {
	private double homologacion;
	
	public CocheImportado(String nombre, double precio, double homologacion){
		super(nombre, precio);
		this.homologacion=homologacion;
	}
	
	public double precioTotal(){
		double preciofinal=super.precioTotal()+homologacion;
		
	return preciofinal;
	}
}
