package prEstadistica;

public class Estadistica {
	double sumaX=0, sumaX2=0, numElementos=0;
	
	void agrega(double d){
		numElementos++;
		sumaX=sumaX+d;
		sumaX2=sumaX2+(d*d);
	}
	
	void agrega(double d, int n){
		numElementos=numElementos+n;
		sumaX=sumaX+(n*d);
		sumaX2=sumaX2+(n*d*d);
	}
	
	double getMedia(){
		return sumaX/numElementos;
	}
	
	double getVarianza(){
		return (sumaX2/numElementos)-(getMedia()*getMedia());
	}
	
	double getDesviacionTipica(){
		return Math.sqrt(getVarianza());
	}
}
