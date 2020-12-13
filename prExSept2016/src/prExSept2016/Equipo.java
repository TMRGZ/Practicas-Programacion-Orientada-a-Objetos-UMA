package prExSept2016;

public class Equipo implements Comparable<Equipo>{
	private String nombreeq;
	private int categoria;
	private int puntos;
	
	public Equipo(String nombreeq, int categoria, int puntos) throws CompeticionException{
		this.nombreeq=nombreeq;
		this.categoria=categoria;
		this.puntos=puntos;
		
		if(categoria<1 || categoria>5){
			throw new CompeticionException("Categoria no valida");
		}if(puntos<0){
			throw new CompeticionException("Puntos negativos");
		}
	}
	
	public String getNombre(){
		return nombreeq;
	}
	
	public int getCategoria(){
		return categoria;
	}
	
	public int getPuntos(){
		return puntos;
	}
	
	public void setCategoria(int categoria) throws CompeticionException{
		if(categoria<1&&categoria<5){
			throw new CompeticionException("Categoria mala");
		}else{
			this.categoria=categoria;
		}
	}
	
	public void increPuntos(int puntos) throws CompeticionException{
		if(puntos<0){
			throw new CompeticionException("Puntos negativos");
		}else{
			this.puntos+=puntos;
		}
	}
	
	
	@Override
	public boolean equals(Object o){
		boolean res = o instanceof Equipo;
		Equipo eq = res ? (Equipo)o : null;
		return res&& this.nombreeq.equalsIgnoreCase(eq.nombreeq)&&this.categoria==eq.categoria&&this.puntos==eq.puntos;
	}
	
	@Override
	public int hashCode(){
		return nombreeq.hashCode()+Integer.hashCode(getCategoria())+Integer.hashCode(getPuntos());
	}
	@Override
	public int compareTo(Equipo equ){
		int resultado=Integer.compare(this.getCategoria(), equ.getCategoria());
		resultado = -resultado;
		
		if(this.getCategoria()==equ.getCategoria()){
			resultado = Integer.compare(this.getPuntos(), equ.getPuntos());
			
			if(this.getPuntos()==equ.getPuntos()){
				resultado = this.getNombre().compareToIgnoreCase(equ.getNombre());
			}
		}
		return resultado;
	}
	
	public String toString(){
		return this.getNombre()+ " " + this.getCategoria() + ":" + this.getPuntos();
	}
}
