package prExJunio2016;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorAsignacion implements ActionListener{
	VistaAsignacion va;
	Asignaciones a;

	public ControladorAsignacion(VistaAsignacion va){
		this.va=va;
		va.habilitarInicio(true);
		va.mensaje("Introduce nombre de fichero e inicie");
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String comando = ae.getActionCommand();
		
		try{
			boolean chk = va.conAlternativas();
			String fichero = va.fichPeticiones();
			
			
			
			if(comando.equals(VistaAsignacion.INICIO)){
				int nLab = va.laboratorios();
				
				if(nLab<=0){
					throw new AsignacionException("El numero de lab es malo");
				}else if(chk){
					a = new AsignacionesConAlternativas(nLab, fichero);
				}else if(!chk){
					a = new Asignaciones(nLab, fichero);
				}
				
				va.habilitarInicio(false);
				va.entradaHistorial(a.toString());
				va.mensaje("Exito");
			}else if(comando.equals(VistaAsignacion.GUARDAR)){
				String fichSalida = va.fichSalida();
				a.escribirAFichero(fichSalida);			
				va.mensaje("Texto Escrito");
			}else if(comando.equals(VistaAsignacion.REINICIO)){
				va.limpiarHistorial();
				va.habilitarInicio(true);
			}
		}catch(Exception e){
			va.error(e.getMessage());
		}
	}
}
