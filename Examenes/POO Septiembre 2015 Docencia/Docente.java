package prDocencia;


public class Docente implements Comparable<Docente>{
		
		private String nombre;
		private int capacidad; //Será único para cada persona.
		private int carga;
		private int horquilla;
		
		public Docente(String n, int capa){
			if (n == null || capa < 0)
				throw new DocenciaException("Parámetros incorrectos");
			
			nombre = n;
			capacidad = capa;
			carga = 0;
			horquilla =carga-capacidad;
		
		}
		
		public String getNombre() { return nombre;}
		public int getCapacidad() { return capacidad;}
		public int getCarga() { return carga;}
		public int getHorquilla(){ return horquilla;}
		
		public void setCarga(int valor){
			carga=valor;
			horquilla=carga-capacidad;
		}
		
		
		
		public String toString(){
			return nombre + ":" + capacidad + ":" + carga + ":" + horquilla;
		}
		
		public boolean equals(Object o){
			boolean res = o instanceof Docente; 
			Docente per = res ? (Docente)o: null;
			return res && nombre.equalsIgnoreCase(per.nombre);
		}
		
		public int hashCode(){
			return nombre.hashCode();
		}

		@Override
		
		public int compareTo(Docente p) {
			int res;
			//res=horquilla - p.horquilla;
			//if(res==0){
				res=nombre.compareToIgnoreCase(p.nombre);
			//}
			return res;
		}
	}



