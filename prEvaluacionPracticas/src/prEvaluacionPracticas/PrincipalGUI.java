package prEvaluacionPracticas;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PrincipalGUI {
	
	public static void main(String[] args) {

		VistaEvaluacion panel = new PanelEvaluacion();
		ControladorEvaluacion ctr = new ControladorEvaluacion(panel); // el modelo se crea dentro del controlador
		panel.controlador(ctr);
		
		JFrame ventana = new JFrame("Evaluacion Practicas");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel) panel);
		ventana.pack();
		ventana.setVisible(true);
	}
}