package prDocencia;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;



public class Asignacion {
	
		protected Map<Docente, Set<Asignatura>> asignacion;
		
		public Asignacion(){
			asignacion = new TreeMap<Docente, Set<Asignatura>>();
		}
		
		public Asignacion(String fileName) throws FileNotFoundException{
			this();
			leeAsignacionFichero(fileName);
		}
		
		//Añade a la estructura de datos la información del fichero relativa a la asignacion docente
		protected void leeAsignacionFichero (String fileName) throws FileNotFoundException{
			/*try(Scanner sc = new Scanner (new File(fileName))) {
				LeeAsignacion(sc);
			}*/
			Scanner sc = new Scanner (new File(fileName));
			leeAsignacion(sc);
			sc.close();
		
		}
		
		protected void leeAsignacion(Scanner sc){
			while (sc.hasNext()){
				leeAsignacionProfesor(sc.nextLine());
			}
		}
		
		private void leeAsignacionProfesor(String linea){
						
		try{
			Scanner sc = new Scanner (linea);
			sc.useDelimiter("[&]+");
			Docente docente = leerDocente(sc.next());
			Set<Asignatura> asignaturas = new HashSet<Asignatura>();
			while (sc.hasNext()){
				asignaturas.add(leerAsignatura(sc.next()));
			}
			insertaAsignacionProfesor(docente,asignaturas);
			sc.close();
			
		}catch (NoSuchElementException e){
			throw new DocenciaException("Linea incorrecta.");
		}
			
		}
		
		private Docente leerDocente(String datos){
			Docente d = null;
						
			try {
				Scanner sc = new Scanner(datos);
				sc.useDelimiter("[;]+");
				d = new Docente(sc.next(), 
							 		sc.nextInt());
				sc.close();
				}catch (InputMismatchException e){
					throw new DocenciaException("Datos incorrectos1.");
				}catch (NoSuchElementException e){
					throw new DocenciaException("Faltan datos");
				}
			    
				return d;
			}
			
		
		protected Asignatura leerAsignatura(String datos){
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
		}
		
		
		public void insertaAsignacionProfesor(Docente profe, Set<Asignatura> asig){
		
            
			Set<Asignatura> conj = asignacion.get(profe);
			int carga=0;		
			if (conj == null) {
				conj= new TreeSet<Asignatura>();
				asignacion.put(profe, conj);
			}
			conj.addAll(asig);
			asignacion.remove(profe);
			
			for (Asignatura a:conj){
				carga=carga + a.getCreditos();
			}
			profe.setCarga(carga);
			Set<Asignatura>c=new TreeSet<Asignatura>();
			asignacion.put (profe, c);
			c.addAll(conj); 
			
			
		}

		public void escribirFichero (String fileName) throws FileNotFoundException{
			PrintWriter pw = new PrintWriter(fileName);
			escribir(pw);
			pw.close();
			
		}
		
		public void escribir(PrintWriter pw){
			pw.print(this.toString());
		}

			
		public String toString(){
			StringBuilder sb = new StringBuilder();
			for (Docente prof: asignacion.keySet()){
				sb.append(prof);
				for(Asignatura asig : asignacion.get(prof)){
					sb.append("&");
					sb.append(asig);
				}
				sb.append("\n");
			}
			return sb.toString();
		}
		
		//Calcula el número medio de asignaturas impartidas por profesor
		
	   public double mediaAsignaturas(){
			double suma = 0.0;
			int numAsig = 0;
		    int numProf=0;
				
			for (Docente prof:asignacion.keySet()){
					numAsig= asignacion.get(prof).size();
					suma += numAsig;
					numProf ++;
				
			}
			return suma/numProf;
		}

			
				
		//Dada la asignatura, encuentra el profesor que la imparte.
				public Set<Asignatura> encontrarDocencia(String nombre){
					Docente profe = null;
				    Set<Asignatura> asigs=null;
					Set<Docente> claustro = asignacion.keySet();
					Iterator<Docente> it = claustro.iterator();
					boolean encontrado=false;
					while ((!encontrado)&&(it.hasNext())){
						profe = it.next();
						if(profe.getNombre().equalsIgnoreCase(nombre)){
							encontrado=true;
							asigs=asignacion.get(profe);
						}
					}
					
					if (!encontrado) {
						throw new DocenciaException("El profesor/a " + nombre + " no se encuentra");
					}
					
					return asigs;
				}	
				
				
	}


