package prCuentasGUI;


/*********************************************************
 *    Aplicaci�n con GUI
 *********************************************************/

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import prCuentasGUI.CtrCuenta;

public class CuentaDemo {
	public static void main(String[] args) {
		// Montamos el MVC
		// Creamos la vista
		// VistaCuenta vistaCuenta = new PanelCuenta1();
		// VistaCuenta vistaCuenta = new PanelCuenta2();
		VistaCuenta vistaCuenta = new PanelCuenta3();
		// el modelo
		Cuenta cuenta = new Cuenta(0);
		// y el controlador
		CtrCuenta ctrCuenta = new CtrCuenta(vistaCuenta, cuenta);
		// Asignamos el controlador a la vista
		vistaCuenta.controlador(ctrCuenta);

		// Mostramos la vista en una ventana
		JFrame ventana = new JFrame("Control de cuentas");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel) vistaCuenta);
		ventana.pack();
		ventana.setVisible(true);
	}
}
