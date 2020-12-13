package prSept17;

public class FiltroReceptor implements Filtro{
	private String receptor;
	
	public FiltroReceptor(String r){
		this.receptor=r;
	}
	
	@Override
	public boolean select(Mensaje m){
		boolean res = m.getReceptor().equals(this.receptor);
		return res;
	}
}
