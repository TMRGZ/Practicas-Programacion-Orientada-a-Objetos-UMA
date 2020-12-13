package prKWIC;


public class TituloKWIC {
	String frase;
	
	public TituloKWIC(String frase){
		this.frase=frase;
	}
	
	public boolean equals(Object obj){
		boolean res = obj instanceof TituloKWIC;
		TituloKWIC tit = res ? (TituloKWIC)obj: null;
		return res && frase.equalsIgnoreCase(tit.frase);
	}
	
	public int hashCode(){
		return frase.hashCode();
	}
	
	public int compareTo(TituloKWIC t){
		return frase.compareToIgnoreCase(t.frase);
	}
	
	public String toString(){
		return this.frase;
	}
}
