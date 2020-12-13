package prCuentaPalabrasSimpleFicherosListas;

public class PruebaPalabraEnTexto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PalabraEnTexto pal1 = new PalabraEnTexto("gorra");
		PalabraEnTexto pal2 = new PalabraEnTexto("GORRA");
		
		pal1.incrementa();
		
		System.out.println(pal1);
		System.out.println(pal2);
		
		if(pal1.equals(pal2)){
			System.out.println("Las palabras son iguales");
		}else{
			System.out.println("Las palabras son distintas");
		}
	}
}
