package prEstadistica;

public class pruebaEstadistica {

	public static void main(String[] args) {
		// TODO Auto-generated method stub          
			
		Estadistica est = new Estadistica();           
			java.util.Random ran = new java.util.Random();           
			for (int i = 0; i < 100000 ; i++) {                
				est.agrega(ran.nextGaussian());           
			}          
			
		System.out.println("Media = "+est.getMedia());          
		System.out.println("Desviación típica = "+est.getDesviacionTipica());       
	}
}
