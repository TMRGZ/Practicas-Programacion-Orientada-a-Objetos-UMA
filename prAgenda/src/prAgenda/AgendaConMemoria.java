package prAgenda;

public class AgendaConMemoria {
	static final int TAM=5;
	Contacto[] ArrayContactos;
	
	public AgendaConMemoria(int capacidad){
		ArrayContactos = new Contacto[capacidad];
	}
	
	public AgendaConMemoria(){
		ArrayContactos = new Contacto[TAM];
	}
	
	public Contacto buscarContacto(String nombre, String apellidos){
		boolean encontrado=false;
		int i=0;
		
		while(i<ArrayContactos.length&&!encontrado){
			if(ArrayContactos[i].nombre.equals(nombre)&&ArrayContactos[i].apellidos.equals(apellidos)){
				encontrado=true;
			}
		i++;
		}
		
		if(encontrado){
			return ArrayContactos[i];
		}else{
			return null;
		}
	}
	
	/*
	public Contacto ultimoContacto(Contacto c){
		boolean buscado=false;
		if(buscarContacto(nombre, apellidos)!=null){
			buscado =true;
			
		}
		
		if(!buscado){
			return null;
		}
		
	}*/
}
