package prMaternidad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class ControladorMaternidad implements ActionListener {
	Maternidad m;
	VistaMaternidad v;
	
	public ControladorMaternidad(VistaMaternidad v) {
		this.v=v;
		v.habilitarInit(true);
		v.mensaje("Introduzca nombre fichero.");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if(cmd.equals(v.INICIO)) {
			try {
				m = new Maternidad(v.fichEntrada());
				v.habilitarInit(false);
				v.mensaje("Fichero cargado correctamente");
					
			} catch (FileNotFoundException e1) {
					throw new MaternidadException("No hay nombre de fichero");
			}
		}if(cmd.equals(v.GUARDAR)) {
			try {
				String salida = v.fichSalida();
				m.escribirFichero(salida);
				v.mensaje("Archivo guardado correctamente");
				
			}catch (FileNotFoundException e1) {
				throw new MaternidadException("Error al guardar, revise nombre");
			}
		}if(cmd.equals(v.BUSCAR)) {
			int codigo = v.codigoBebe();
			int hab = m.encontrarMadre(codigo);
			
			v.entradaHistorial("La madre del niño con codigo: "+ codigo + " esta en la habitacion: " + hab + "\n");
			v.mensaje("Buscar realizado correctamente");
		}if(cmd.equals(v.MEDIA)) {
			v.entradaHistorial("La rato bebes/madre es: " + m.mediaBebes() + "\n");
		}
	}
}
