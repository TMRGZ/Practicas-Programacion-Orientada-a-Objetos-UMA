package prDocencia;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
//import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
//import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;

public class AsignacionExtra extends Asignacion{
	
		private List<Asignatura> docenciaSinAsignar; 
		private int codigoCentro; // sin asignar
		
		public AsignacionExtra(int c){
			super();
			codigoCentro=c;
			docenciaSinAsignar = new ArrayList<Asignatura>();
		}
		
		
		public AsignacionExtra(int c, String asigExtra, String fileName) throws FileNotFoundException{
			//Se inicializa la estructura 
			this(c);
			leeAsignaturasFichero(asigExtra);
			leeAsignacionFichero(fileName);
		}
		
		//Añade a la estructura de datos la información del fichero relativa a la asignacion docente
		public void leeAsignaturasFichero (String fileName) throws FileNotFoundException{
					Scanner sc = new Scanner (new File(fileName));
					leeAsignaturaLinea(sc);
					sc.close();
				
				}
				
	    private void leeAsignaturaLinea(Scanner sc){
	    	        Asignatura a=null;
					while (sc.hasNext()){
						a=leerAsignatura(sc.nextLine());
						docenciaSinAsignar.add(a);
						//System.out.println(docenciaSinAsignar);
					}	
		}
	    
	    
	    /*private Asignatura leeAsignatura(String datos){
			Asignatura a = null;
			try { 
			    Scanner sc = new Scanner(datos);
				sc.useDelimiter("[;]+");
				a = new Asignatura(sc.next(), 
						 		sc.nextInt(),
						 		sc.nextInt(),
						 		sc.nextInt());
				sc.close();
			}catch (InputMismatchException e){
				throw new DocenciaException("Datos incorrectos2.");
			}catch (NoSuchElementException e){
				throw new DocenciaException("Faltan datos");
			}
		return a;
	    }*/
	    
	    //Se selecciona primera la asignatura con codigo de centro coincidente y se elimina
	    private Asignatura seleccionaAsignatura (){
	    	Asignatura a=null;
	    	boolean encontrado=false;
	    	
	    	Iterator<Asignatura> it=docenciaSinAsignar.iterator();
	    	while ((!encontrado)&&(it.hasNext())){
	    		a=it.next();
	    		//System.out.println(a);
	    		if (a.getCodigoCentro()==codigoCentro){
	    			it.remove();
	    			encontrado=true;
	    		}
	    	}
	    	if(!encontrado){
	    		throw new DocenciaException("Error.No hay docencia sin asignar de ese centro");
	    	}
	    		
	    	return a;   	
	    	
	    	
	    }
	    
	    public void insertaAsignacionProfesor(Docente profe, Set<Asignatura> asig){
	    	super.insertaAsignacionProfesor(profe, asig);
	    	Asignatura a;
	    	if (profe.getHorquilla()<0){
	    		//System.out.println(profe);
	    		a= seleccionaAsignatura();
	    		if (asig!=null){
	    		asignacion.get(profe).add(a);
	    		
	    		//actualizamos la carga y la horquilla de profe
	    		int nuevaCarga=profe.getCarga()+a.getCreditos();
	    		profe.setCarga(nuevaCarga);
	    		
	    		}else{
	    		  throw new DocenciaException("No queda Docencia sin Asignar");
	    		}
	    	}
	    }
	
	    
		//Las asignaturas de docenciaSinAsignar se muestran línea a línea
	    
		public String toString(){
			StringBuilder sb = new StringBuilder(super.toString());
			
			sb.append("\n");
			for (Asignatura a : docenciaSinAsignar){
				sb.append(a);
				sb.append("\n");
			}
			
			return sb.toString();
		}
}



