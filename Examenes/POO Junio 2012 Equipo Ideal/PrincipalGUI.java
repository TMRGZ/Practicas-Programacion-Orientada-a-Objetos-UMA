import javax.swing.JFrame;
import javax.swing.JPanel;

public class PrincipalGUI {

	public static void main(String[] args) {

		VistaEurocopa panel = new PanelEurocopa();
		ControladorEurocopa ctr = new ControladorEurocopa(panel); // el modelo
																	// se crea
																	// dentro
																	// del
																	// controlador
		panel.controlador(ctr);

		JFrame ventana = new JFrame("Equipo Ideal Eurocopa 2012");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel) panel);
		ventana.pack();
		ventana.setVisible(true);
	}

}
