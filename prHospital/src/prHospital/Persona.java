package prHospital;

public class Persona {
	private String dni;
	private String nombre;
	private String apellidos;
	private int edad;
	private Genero sexo;
	
	public Persona (String dni, String nombre, String apellidos, int edad, Genero sexo){
		this.dni=dni;
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.edad=edad;
		this.sexo=sexo;
	}
	
	public String getDni(){
		return this.dni;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getApellidos(){
		return this.apellidos;
	}

	public int getEdad(){
		return this.edad;
	}
	
	public Genero getSexo(){
		return this.sexo;
	}
	
	public void setEdad(int e){
		this.edad=e;
	}
	
	public void setSexo(Genero x){
		this.sexo=x;
	}
	
	public String toString(){
		return "La persona con el DNI: "+dni+" llamada: "+nombre+" "+apellidos+" de genero: "+sexo+" tiene: "+edad+" annos.";
	}
	
	
	
	
	
	
	
	
}
