package prExSept2016;

import java.awt.event.*;


public class ControladorCompeticion implements ActionListener {
	private Competicion modelo;
	private VistaCompeticion vista;
	
	public ControladorCompeticion(VistaCompeticion v) {
		vista = v;
		vista.habilitarInit(true);
		vista.mensaje("Introduzca nombre de fichero de entrada y pulse Inicio");
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		try {
			if (comando.equals(VistaCompeticion.INICIO)) {
				modelo = new Competicion(vista.fichEntrada());
				vista.habilitarInit(false);
				vista.mensaje("Operación INICIO realizada con éxito");
			} else if (comando.equals(VistaCompeticion.GUARDAR)) {
				String fichSalida = vista.fichSalida();
				if (fichSalida.equals("")) {
					vista.entradaHistorial(modelo.toString());
				} else {
					modelo.escribirFichero(fichSalida);
				}
				vista.mensaje("Operación GUARDAR realizada con éxito");
			} else if (comando.equals(VistaCompeticion.INC_PARTIDOS)) {
				modelo.increPartidos(vista.jugador(),vista.pJugados(),vista.pGanados());
				vista.mensaje("Operación Incrementar Partidos realizada con éxito");
			}
			
		} catch (Exception exc){
			vista.error(exc.getMessage());
		}
		
	}
}
