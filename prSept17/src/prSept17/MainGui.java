package prSept17;
import prSept17.*;
import javax.swing.JFrame;

public class MainGui {
	public static void main(String[] args) {
		RedSocial modelo = new RedSocial();
		PanelVista vista = new PanelVista();
		Controlador ctrl = new Controlador(vista, modelo);
		vista.setControlador(ctrl);
		JFrame marco = new JFrame("RedSocial");
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco.setContentPane(vista);
		marco.pack();
		marco.setVisible(true);
	}
}
