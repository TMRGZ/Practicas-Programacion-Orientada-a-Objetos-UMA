package prAgenda;

public class Contacto {
	String nombre;
	String apellidos;
	String correo;
	String numerotel;
	
	public Contacto(String nombre, String apellidos, String correo, String numerotel){
		int pos=-1;
		
		this.nombre=nombre;
		this.apellidos=apellidos;
		this.correo=correo;
			/*pos=correo.indexOf('@');
			if(pos==-1){
				throw new RuntimeException("Formato de correo erroneo, falta @.");
			}*/
		this.numerotel=numerotel;
	}
	
	public boolean equals(Object o) {
		boolean res = o instanceof Contacto;
		Contacto c = res ? (Contacto)o : null;
		return res && (c.apellidos.equals(apellidos)) && (c.nombre.equals(nombre));
	}
	
	public int hashCode() {
		return nombre.hashCode() + apellidos.hashCode();
	}
	
	public String toString(){
		return "Nombre: "+nombre+" Apellidos:  " + apellidos + " Email:  <"+ correo + "> telefono: "+numerotel;
	}
}
