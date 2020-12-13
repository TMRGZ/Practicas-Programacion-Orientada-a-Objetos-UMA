package prBanco;
import java.util.Arrays;

public class Banco {
	final static int NCTAS=10, NUMCTALIBRE=1001;
	
	String nombre;
	int ppl;
	int unca;
	
	Cuenta[] cuentas;
	
	public Banco(String nombre, int n){
		cuentas = new Cuenta[n];
	}
	
	public Banco(String nombre){
		this(nombre, NCTAS);
	}
	
	int abrirCuenta(String nombre, double saldo){
		if(ppl==cuentas.length){
			cuentas = Arrays.copyOf(cuentas, cuentas.length*2);
		}
		
		cuentas[ppl] = new Cuenta(nombre, unca, saldo);
		
		ppl++;
		unca++;
		
	return unca-1;
	}
	
	int abrirCuenta(String nombre){
		return abrirCuenta(nombre, 0);
	}
	
	private int posicionCuenta(int ncuenta){
		boolean encontrado=false;
		int i=0;
		
		while(i<cuentas.length&&encontrado==false){
			if(cuentas[i].cuenta()==ncuenta){
				encontrado=true;
			}
		}
		if(encontrado==false){
			throw new RuntimeException("Cuenta no existe");
		}
		
	return i;
	}
	
	void cerrarCuenta(int ncuenta){
		int pos = posicionCuenta(ncuenta);
		
		for(int i=pos; i<cuentas.length; i++){
			cuentas[i]=cuentas[i+1];
		}
		
		cuentas[pos]=null;
	}
	
	void ingreso(int ncuenta, double cantidad){
		int pos=posicionCuenta(ncuenta);
		cuentas[pos].ingreso(cantidad);
		
	}
	
	void debito(int ncuenta, double cantidad){
		int pos=posicionCuenta(ncuenta);
		cuentas[pos].debito(cantidad);
	}
	
	double transferencia(int ncuenta1, int ncuenta2, int cuanto){
		int pos1=posicionCuenta(ncuenta1);
		int pos2=posicionCuenta(ncuenta2);
		
		cuentas[pos1].ingreso(cuanto);
		cuentas[pos2].debito(cuanto);
	
	return cuanto;
	}
	
	public String toString() {
		return this.nombre;
	}
}
