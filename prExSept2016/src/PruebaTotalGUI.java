import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import prExSept2016SOL.ControladorCompeticion;
import prExSept2016SOL.PanelCompeticion;
import prExSept2016SOL.VistaCompeticion;



public class PruebaTotalGUI {
	public static void main(String [] args){
		VistaCompeticion panel = new PanelCompeticion();
		ActionListener ctr = new ControladorCompeticion(panel); 
		panel.controlador(ctr);
		
		JFrame ventana = new JFrame("Competicion Padel");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setContentPane((JPanel) panel);
		ventana.pack();
		ventana.setVisible(true);
	}
	
}
