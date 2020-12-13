package regata;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrRegata implements ActionListener {
	Regata r;
	VistaRegata v;
	
	public CtrRegata(VistaRegata v) {
		this.v=v;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if(cmd.equals(v.LEE)) {
			r = new Regata();
			r.leeFichero(v.getFicheroEntrada());
			
			for(Barco b : r.getParticipantes()) {
				v.agregaLinea(b.toString());
			}
			
			v.setMensaje("Ficehero cargado");
		}else if(cmd.equals(v.AVANZA)) {
			r.avanza(5);
			v.setMensaje("Los barcos han avanzado");
		}else if(cmd.equals(v.GUARDA)) {
			r.escribeFichero(v.getFicheroSalida());
			v.setMensaje("Se ha guardado con exito");
		}

	}

}
