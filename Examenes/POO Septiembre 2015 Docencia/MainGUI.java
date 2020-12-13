

	import java.awt.event.ActionListener;

	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import prDocencia.*;

	public class MainGUI {
		public static void main(String [] args){
			VistaDocencia panel = new PanelDocencia();
			ActionListener ctr = new ControladorDocencia(panel); 
			panel.controlador(ctr);
			
			JFrame ventana = new JFrame("Asignacion Docente");
			ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ventana.setContentPane((JPanel) panel);
			ventana.pack();
			ventana.setVisible(true);
		}
		
	}
