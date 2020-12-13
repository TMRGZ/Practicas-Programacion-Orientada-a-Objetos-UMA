package prDocencia;

	
public class Asignatura implements Comparable<Asignatura>{
		
		private String nombre;
		private int creditos;
		private int codigoCentro;
		private int codigoAsig;
		
		public Asignatura(String n, int cred, int codigoA, int codigoC){
			if (n == null || cred <= 0){
				throw new DocenciaException("Parámetros incorrectos");
			}
			nombre = n;
			creditos = cred;
			codigoCentro = codigoC;
			codigoAsig=codigoA;
		
		}
		
		public String getNombre() { return nombre;}
		public int getCodigoCentro() { return codigoCentro;}
		public int getCreditos() { return creditos;}
		public int getCodigoAsig(){return codigoAsig;}
		
		
		
		public String toString(){
			return nombre + ":" + creditos + ":" + codigoAsig + ":" + codigoCentro;
		}
		
		public boolean equals(Object o){
			boolean res = o instanceof Asignatura;
			Asignatura per = res ? (Asignatura)o: null;
			return res && codigoAsig == per.codigoAsig && creditos==per.creditos;
		}
		
		public int hashCode(){
			return codigoAsig+creditos;
		}

		@Override
		
		public int compareTo(Asignatura p) {
			int res;
			res=creditos - p.creditos;
			if(res==0){
				res=codigoAsig-p.codigoAsig;
			}
			return res;
		}
	}


