import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import prExJunio2016.*;

public class PruebaTotalGUI {
	public static void main(String [] args){
		VistaAsignacion panel = new PanelAsignacion();
		ActionListener ctr = new ControladorAsignacion(panel); 
		panel.controlador(ctr);
		
		JFrame ventana = new JFrame("Asignacion Peticiones de Laboratorio");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel) panel);
		ventana.pack();
		ventana.setVisible(true);
	}	
}
