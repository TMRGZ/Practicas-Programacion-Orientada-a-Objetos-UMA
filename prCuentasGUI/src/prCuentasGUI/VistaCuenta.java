package prCuentasGUI;



/*********************************************************
 *   Interfaz para la Vista
 *********************************************************/
import java.awt.event.*;

public interface VistaCuenta {
	String INGRESO = "I";
	String GASTO = "G";
	String SALDO = "S";

	double obtenerCantidad();

	void saldo(double saldo);

	void mensaje(String msg);
	
	void borrar();

	void controlador(ActionListener ctr);
}
