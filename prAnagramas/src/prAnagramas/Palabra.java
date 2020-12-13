package prAnagramas;

public class Palabra implements Comparable<Palabra>{
	private String cadena;
	private String signatura;
	
	public Palabra(String pal){
		this.cadena=pal;
		char[] s = pal.toLowerCase().toCharArray();
		signatura = new String(s);
	}
	
	public String getCadena(){
		return this.cadena;
	}
	
	public String getSignatura(){
		return this.signatura;
	}
	
	public boolean esAnagrama(Palabra palabra){
		return signatura.equals(palabra.equals(signatura));
	
	}
	
	@Override
	
	public boolean equals(Object obj){
		boolean res = obj instanceof Palabra; 
		Palabra pal = res ? (Palabra)obj: null; 
		return res && this.cadena.equalsIgnoreCase(pal.cadena);

	}
	
	@Override
	
	public int hashCode(){
		return cadena.toLowerCase().hashCode();
	}
	
	public int compareTo(Palabra s){
		return cadena.compareToIgnoreCase(s.cadena);
	}
	
	public String toString(){
		return " [ " +this.cadena +/*","+ pal.cadena  +*/" ] ";
	}
}
