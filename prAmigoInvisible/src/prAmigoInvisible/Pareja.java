package prAmigoInvisible;

public class Pareja {
	Persona p1;
	Persona p2;
	
	public Pareja (Persona p1, Persona p2){
		this.p1=p1;
		this.p2=p2;
	}
	
	public String toString(){
		return "(" + p1.getNombre() + ", " + p2.getNombre(); 
	}
	
	@Override
	public boolean equals(Object obj){
		boolean res = obj instanceof Pareja;
		Pareja p = res ? (Pareja)obj: null;
		return res && p1.equals(p.p2)&&p2.equals(p.p1);
	}
	
	public int hashCode(){
		return p1.hashCode()+p2.hashCode();
	}
}
