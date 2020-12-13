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
				vista.mensaje("Operaci�n INICIO realizada con �xito");
			} else if (comando.equals(VistaCompeticion.GUARDAR)) {
				String fichSalida = vista.fichSalida();
				if (fichSalida.equals("")) {
					vista.entradaHistorial(modelo.toString());
				} else {
					modelo.escribirFichero(fichSalida);
				}
				vista.mensaje("Operaci�n GUARDAR realizada con �xito");
			} else if (comando.equals(VistaCompeticion.INC_PARTIDOS)) {
				modelo.increPartidos(vista.jugador(),vista.pJugados(),vista.pGanados());
				vista.mensaje("Operaci�n Incrementar Partidos realizada con �xito");
			}
			
		} catch (Exception exc){
			vista.error(exc.getMessage());
		}
		
	}
}
