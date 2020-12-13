package prParking;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class TestParkingGui {

	public static void main(String[] args) {
		VistaReservaDeParking panel = new PanelReservaDeParking();
		
		// el modelo se crea dentro del controlador
		ControladorDeReservas ctr = new ControladorDeReservas(panel);
		
		panel.controlador(ctr);
		
		JFrame ventana = new JFrame("Gestión de aparcamientos");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel)panel);
		ventana.pack();
		ventana.setVisible(true);
	}
}

