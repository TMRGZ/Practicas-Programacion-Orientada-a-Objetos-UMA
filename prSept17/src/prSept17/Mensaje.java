package prSept17;

public class Mensaje implements Comparable<Mensaje>{
	private String nombreEmisor;
	private String nombreReceptor;
	private String mensaje;
	private static int cntSecuencia=1;
	private int secuencia;
	
	public Mensaje(String nombreEmisor, String nombreReceptor, String mensaje){
		if(nombreEmisor==null||nombreReceptor==null||mensaje==null){
			throw new AppException("String vacio detectado");
		}else if(nombreEmisor.equals("")||nombreReceptor.equals("")||mensaje.equals("")){
			throw new AppException("String vacio detectado");
		}else{
			this.nombreEmisor=nombreEmisor;
			this.nombreReceptor=nombreReceptor;
			this.mensaje=mensaje;
			this.secuencia=cntSecuencia;
			cntSecuencia++;
		}
	}

	public String getEmisor() {
		return nombreEmisor;
	}

	public String getReceptor() {
		return nombreReceptor;
	}

	public String getTexto() {
		return mensaje;
	}
	
	public String toString(){
		return "(" +this.getEmisor() + "; " + this.getReceptor() + "; " + this.getTexto() + ")";
	}
	
	@Override
	public boolean equals(Object o){
		boolean res = o instanceof Mensaje;
		Mensaje m = res ? (Mensaje)o : null;
		return res&&this.getEmisor().equalsIgnoreCase(m.getEmisor())&&this.secuencia==m.secuencia;
	}
	
	@Override
	public int hashCode(){
		return this.getEmisor().toUpperCase().hashCode()+this.secuencia;
	}

	@Override
	public int compareTo(Mensaje m) {
		int res = Integer.compare(this.secuencia, m.secuencia);
		
		if(res==0){
			res = this.getEmisor().compareToIgnoreCase(m.getEmisor());
			if(res==0){
				res = this.getReceptor().compareToIgnoreCase(m.getReceptor());
			}
		}
		return res;
	}
	
	
	
}
