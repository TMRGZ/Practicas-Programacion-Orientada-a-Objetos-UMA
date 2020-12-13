
	
	import java.util.Set;

    import prDocencia.*;


    import java.io.PrintWriter;
	//import java.util.Map;

	public class Main {

		public static void main(String[] args) {
			try{
				//Testing class Asignacion------------------------------------------------
				Asignacion as = new Asignacion("asigna.txt");
				System.out.println("Datos leidos:");
				System.out.println(as);
				
				
				String nombre="Pablo Lopez";
				Set<Asignatura> asisg=as.encontrarDocencia(nombre);
				System.out.println("Las asignaturas que imparte el profesor" + nombre +" son: "+asisg);
				System.out.println("La media de asignaturas impartidas por profesor es: "+ as.mediaAsignaturas());
				
				
				
				System.out.println("Enviando la información a la salida estándar");
				PrintWriter pw = new PrintWriter(System.out,true); 
				as.escribir(pw);
				pw.flush();
				
				System.out.println("Guardar Datos en salida.txt");
				as.escribirFichero("salida.txt");
				
				//Testing class AsignacionExtra-----------------------------------
				System.out.println("\n\nProbando Asignacion Extra");
				as= new AsignacionExtra(101,"asignaturas.txt","asigna.txt");
				System.out.println("Datos leidos:");
				System.out.println(as);
				
			
			}catch (Exception e){
				System.out.println(e.getMessage());
			}
			
		}
		

	}



