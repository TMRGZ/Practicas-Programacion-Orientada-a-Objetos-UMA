package prCilindro;

	public class TestCilindro{  
		public static void main(String[] args){
			Punto centroBase = new Punto(3.0, 5.0);
			Circulo base = new Circulo(centroBase, 4.0);
			Cilindro miCilindro = new Cilindro(base, 10.0);
			
			System. out .println(miCilindro);
			
			miCilindro.trasladar(2.0, 2.0);
			System. out .println(miCilindro);
			
			System. out .println(new Cilindro(new Circulo(new Punto(3.0, 5.0), 4.0), 10.0)); 

		}  
	} 
