package prCuentasGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrCuenta implements ActionListener{
	VistaCuenta v;
	Cuenta cu;
	
	public CtrCuenta(VistaCuenta vc, Cuenta c){
		v = vc;
		cu = c;
	}
	
	public void actionPerformed(ActionEvent ae) {
		String comando = ae.getActionCommand();
		
		if(comando == "I"){
			double ingreso = v.obtenerCantidad();
			v.borrar();
			cu.ingresa(ingreso);
			v.mensaje("Se ha ingresado " + ingreso);
			
		}if(comando == "G"){
			double gasto = v.obtenerCantidad();
			v.borrar();
			cu.extrae(gasto);
			v.mensaje("Se ha extraido " + gasto);
			
		}if(comando == "S"){
			double saldo = v.obtenerCantidad();
			v.mensaje("Su saldo es: " + saldo);
		}
		
	}
}
