package prKWIC2;

public class TituloKWIC implements Comparable<TituloKWIC>{
	protected String frase;
	
	public TituloKWIC(String frase) {
		this.frase=frase;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean res = obj instanceof TituloKWIC;
		TituloKWIC t = res ? (TituloKWIC)obj : null;
		return res&&this.frase.equalsIgnoreCase(t.frase);
	}
	
	@Override
	public int hashCode() {
		return this.frase.toLowerCase().hashCode();
	}
	
	public String toString() {
		return frase;
	}
	@Override
	public int compareTo(TituloKWIC t) {
		int comparacion = this.frase.compareToIgnoreCase(t.frase);
		return comparacion;
	}
}
