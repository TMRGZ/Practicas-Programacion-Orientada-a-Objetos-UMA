package prExSept2016;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCompeticion implements ActionListener{
	VistaCompeticion vc;
	Competicion c;
	
	public ControladorCompeticion(VistaCompeticion vc){
		this.vc=vc;
		vc.habilitarInit(true);
		vc.mensaje("Introduzca nombre de fichero de entrada y pulse Inicio");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String comando = ae.getActionCommand();
		
		try{
			if(comando.equals(VistaCompeticion.INICIO)){
				c = new Competicion(vc.fichEntrada());
				vc.habilitarInit(false);
				vc.mensaje("Exito");
				
			}else if(comando.equals(VistaCompeticion.GUARDAR)){
				String fichSalida = vc.fichSalida();
				
				if(fichSalida.equals("")){
					vc.entradaHistorial(c.toString());
				}else{
					c.escribirFichero(fichSalida);
				}
				vc.mensaje("Escribir EXITO");
				
			}else if(comando.equals(VistaCompeticion.INC_PARTIDOS)){
				c.increPartidos(vc.jugador(), vc.pJugados(), vc.pGanados());
				vc.mensaje("Incrementado BIEN");
				
			}
		}catch(Exception e){
			vc.error(e.getMessage());
		}
		
		
		
	}

}
