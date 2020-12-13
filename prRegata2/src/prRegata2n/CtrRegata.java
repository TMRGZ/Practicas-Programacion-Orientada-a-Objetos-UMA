package prRegata2n;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrRegata implements ActionListener{
	VistaRegata vr;
	Regata r;
	
	public CtrRegata(VistaRegata vr) {
		this.vr=vr;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		try {
			if(cmd.equals(VistaRegata.LEE)) {
				r = new Regata();
				r.leeFichero(vr.getFicheroEntrada());
				
				for(Barco b : r.getParticipantes()) {
					vr.agregaLinea(b.toString());
				}
				vr.setMensaje("Exito al Cargar");
			}
			
			if(cmd.equals(VistaRegata.AVANZA)) {
				r.avanza(10);
				
				for(Barco b : r.getParticipantes()) {
					vr.agregaLinea(b.toString());
				}
				
				vr.setMensaje("Ha avanzado");
			}
			
			if(cmd.equals(VistaRegata.GUARDA)) {
				r.escribeFichero(vr.getFicheroSalida());
				vr.setMensaje("Ha guardado");
			}
		}catch(Exception ex) {
			vr.setMensaje("Error");
		}
		
	}

	
}
