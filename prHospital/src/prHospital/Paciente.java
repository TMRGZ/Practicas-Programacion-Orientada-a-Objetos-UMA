package prHospital;

public class Paciente extends Persona{
	private double altura;
	private double peso;
	private String segSocial;
	private boolean urgente;
	
	public Paciente(String dni, String nombre, String apellidos, int edad, Genero sexo, double a, double p, String ss, boolean urg, Cama cama) {
		super(dni, nombre, apellidos, edad, sexo);
		
		this.altura=a;
		this.peso=p;
		this.segSocial=ss;
		this.urgente=urg;
		this.cama=cama;
	}
	
	public double getAltura(){
		return this.altura;
	}
	
	public double getPeso(){
		return this.peso;
	}
	
	
	
	
	
}
