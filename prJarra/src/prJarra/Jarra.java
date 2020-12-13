package prJarra;

public class Jarra {
	int contenido=0, capacidad;
	
	public Jarra(int capacidad) throws JarraCapacidadException{
		if(capacidad<=0){
			throw new JarraCapacidadException();
		}
		this.capacidad=capacidad;
	}
	
	int contenido(){
		return this.contenido;
	}
	
	int capacidad(){
		return this.capacidad;
	}
	
	void llenar(){
		this.contenido=this.capacidad;
	}
	
	void vaciar(){
		this.contenido=0;
	}
	
	void llenarDesde(Jarra j){
		while((this.contenido<this.capacidad)&&(this.contenido<j.contenido)){
			j.contenido--;
			this.contenido++;
		}
	}
	
	public String toString(){
		return "("+this.contenido+", "+this.capacidad+")";
	}
}
