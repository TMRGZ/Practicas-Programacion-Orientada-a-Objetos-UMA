package prDocencia;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.*;

public class ControladorDocencia implements ActionListener{
	

		private Asignacion model;
		private VistaDocencia vista;
		
		public ControladorDocencia (VistaDocencia v){
			vista = v;
			vista.habilitarInit(true);
			vista.mensaje("Introduzca el nombre del fichero de datos");
		}
		
		@Override
		public void actionPerformed(ActionEvent ea) {
			String command = ea.getActionCommand();
			try{
			  if((command.equals(VistaDocencia.INICIO))){
		
					String entrada = vista.fichEntrada();
					if (entrada.equals(""))
						vista.error("Introduzca un nombre de fichero");
					else{
						model = new Asignacion(entrada);
						vista.habilitarInit(false);
						vista.mensaje("Datos leídos correctamente");
					}
			  }else if((command.equals(VistaDocencia.GUARDAR))){
					String salida = vista.fichSalida();
					if (salida.equals("")){
						vista.entradaHistorial(model.toString());
					}else{
						model.escribirFichero(salida);
					    vista.mensaje("Datos guardados correctamente");
					}
			 /* }else if((command.equals(VistaDocencia.BUSCAR))){	
					int codigoA = vista.codigoAsig();
					Docente profe = model.encontrarDocente(codigoA);
					vista.entradaHistorial("El profesore de la asignatura cuyo codigo es "
								 		  + codigoA + " es" + profe.getNombre() + "\n");
					vista.mensaje("Buscar realizado correctamente");^*/
					
			  }else if((command.equals(VistaDocencia.BUSCARASIG))){	
					String nombre = vista.nombreProf();
					Set<Asignatura> conjA = model.encontrarDocencia(nombre);
					vista.entradaHistorial("Las asignaturas que imparte el profesor  "
								 		  + nombre+ " son:" +"\n" + conjA + "\n");
					vista.mensaje("Buscar realizado correctamente");	
					
			  }else{
					vista.entradaHistorial("Media de asignaturas impartidas por profesor = " + model.mediaAsignaturas() + "\n");
					vista.mensaje("Media calculada correctamente");
			  }
			  
			} catch (NumberFormatException e) {
				vista.error("Código de Asignatura erróneo");
			} catch (FileNotFoundException e){
				vista.error("Error E/S:" + e.getMessage());
			} catch (DocenciaException e){
				vista.error(e.getMessage());
			}		
		}	
	}



