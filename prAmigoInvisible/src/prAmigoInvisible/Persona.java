package prAmigoInvisible;

public class Persona {
	private String nombre;
	Persona p;
	
	public Persona (String nombre){
		this.nombre=nombre;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public Persona getAmigo(){
		return p;
	}
	
	public void setAmigo(Persona am){
		p=am;
	}
	
	@Override
	public boolean equals(Object obj){
		boolean res = obj instanceof Persona;
		Persona per = res ? (Persona)obj: null;
		return res && nombre.equalsIgnoreCase(per.nombre);

	}
	
	@Override
	public int hashCode(){
		return nombre.toUpperCase().hashCode();
	}
	
	public String toString(){
		if(p != null){
			return nombre + " ----> " + p.nombre;
		}else{
			return nombre + " no tiene amigo";
		}
		
	}
}
