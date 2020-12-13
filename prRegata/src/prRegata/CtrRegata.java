package prRegata;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CtrRegata implements ActionListener{
	VistaRegata vr;
	Regata r;
	
	public CtrRegata(VistaRegata vr){
		this.vr=vr;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String comando = ae.getActionCommand();
		
		try{
			if(comando.equals(VistaRegata.LEE)){
				r = new Regata();	
				r.leeFichero(vr.getFicheroEntrada());
				
				for(Barco b : r.getParticipantes()){
					vr.agregaLinea(b.toString());
				}
				vr.setMensaje("Exito al cargar.");
				
			}if(comando.equals(VistaRegata.AVANZA)){
				r.avanza(10);
				
				for(Barco b : r.getParticipantes()){
					vr.agregaLinea(b.toString());
				}
				
				vr.setMensaje("la regata ha avanzado 10min");
			}if(comando.equals(VistaRegata.GUARDA)){
				r.escribeFichero(vr.getFicheroSalida());;
				vr.setMensaje("Se ha guardado con exito");
			}
		}catch(Exception e){
			vr.setMensaje("Error");
		}	
	}
}
