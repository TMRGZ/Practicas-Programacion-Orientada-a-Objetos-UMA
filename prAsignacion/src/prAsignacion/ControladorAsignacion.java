package prAsignacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class ControladorAsignacion implements ActionListener{
	VistaAsignacion va;
	Asignaciones a;
	
	public ControladorAsignacion(VistaAsignacion va) {
		this.va=va;
		va.habilitarInicio(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		try {
			if(cmd.equals(va.INICIO)) {
				boolean alt = va.conAlternativas();
				int lab = va.laboratorios();
				String nFich = va.fichPeticiones();
				
				if(lab<1) {
					throw new AsignacionException("Numero de laboratorios no valido.");
				}
				if(nFich.equals("")) {
					throw new AsignacionException("Fichero de entrada no detectado.");
				}
				if(!alt) {
					a = new Asignaciones(lab, nFich);
				}else {
					a = new AsignacionesConAlternativas(lab, nFich);
				}
				
			va.habilitarInicio(false);
			va.entradaHistorial(a.toString());
			va.mensaje("Hecho");
			}
			
			if(cmd.equals(va.GUARDAR)) {
				String fichSalida = va.fichSalida();
				a.escribirAFIchero(fichSalida);
				va.mensaje("Guardado");
			}
			
			if(cmd.equals(va.REINICIO)) {
				va.habilitarInicio(true);
				va.limpiarHistorial();
			}
		}catch(AsignacionException a) {
			va.error(a.getMessage());
			
		} catch (FileNotFoundException e1) {
			va.error(e1.getMessage());
		}
		
	}

}
