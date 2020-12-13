package prCuentaPalabrasSimpleFicheros;

public class PalabraEnTexto {
	private String palabra;
	private int veces;
	
	public PalabraEnTexto(String palabra){
		this.palabra=palabra.toUpperCase();
		this.veces=1;
	}
	
	public void incrementa(){
		this.veces++;
	}
	@Override
	public boolean equals(Object obj){
		boolean res = obj instanceof PalabraEnTexto;
		PalabraEnTexto pal= res ? (PalabraEnTexto) obj : null;
	return res&&(this.palabra.equals(pal.palabra));
	}
	public int hashcode(){
		return this.palabra.hashCode();
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append(palabra);
		sb.append(": ");
		sb.append(veces);
	return sb.toString();
		//return "Ha aparecido: " + palabra + ", " + veces + " veces";  
	}
}
