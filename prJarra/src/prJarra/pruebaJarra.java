package prJarra;

public class pruebaJarra{

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		try {
			int capacidad1 = Integer.parseInt(args[0]);
			int capacidad2 = Integer.parseInt(args[1]);
			
			Jarra JarraA = new Jarra(capacidad1);
			Jarra JarraB = new Jarra(capacidad2);
			
			JarraA.llenar();
				System.out.println(JarraA);
				System.out.println(JarraB);
			
			JarraB.llenarDesde(JarraA);
				System.out.println(JarraA);
				System.out.println(JarraB);
				
			JarraB.vaciar();
				System.out.println(JarraA);
				System.out.println(JarraB);
				
			JarraA.llenarDesde(JarraB);
				System.out.println(JarraA);
				System.out.println(JarraB);
			
		}catch (ArrayIndexOutOfBoundsException e){
			System.out.println("Paramentros de entrada no detectados");
		
		}catch (NumberFormatException ee) {
			System.out.println("Los argumentos deben ser números enteros");
		
		}catch (JarraCapacidadException eee){
			System.out.println("Capacidad negativa o nula detectada");
		}	
	}
}
