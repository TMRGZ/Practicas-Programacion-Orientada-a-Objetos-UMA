import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.SortedSet;

public class ControladorEvaluacion implements ActionListener {

	private VistaEvaluacion vista;
	private Evaluacion evaluacion; // modelo
	
	public ControladorEvaluacion(VistaEvaluacion v) {
		vista = v;
		vista.ok("Introduzca nombre de ficheros y pulse Botón Iniciar preferido");
		vista.habilitarInicio(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		try {
			if (comando.equals(VistaEvaluacion.INICIAR_EVALUACION)) {
				evaluacion = new Evaluacion(vista.ficheroPracticas());
				vista.ok("Datos leídos correctamente. Puede evaluar alumnos y calcular prácticas aprobadas");
				vista.habilitarInicio(false);
			} else if (comando.equals(VistaEvaluacion.INICIAR_EVALUACION_RESTRINGIDA)) {
				evaluacion = new EvaluacionRestringida(vista.ficheroPracticas(), 
																	vista.ficheroNoEvaluables());
				vista.ok("Datos leídos correctamente. Puede formar el equipo ideal de juego límpio");
				vista.habilitarInicio(false);
			} else if (comando.equals(VistaEvaluacion.EVALUAR)) {
				evaluacion.evaluarAlumnos(vista.extra());
				evaluacion.listarAlumnos(vista.ficheroSalida());
				vista.añadirAHistórico(evaluacion.representarAlumnos());
				vista.ok("Salida correcta en pantalla y en fichero");
			} else if (comando.equals(VistaEvaluacion.PRACTICAS_APROBADAS)) {
				vista.añadirAHistórico(evaluacion.practicasAprobadas().toString());
				vista.ok("Salida correcta en pantalla");
			} else if (comando.equals(VistaEvaluacion.FINALIZAR)) {
				vista.limpiar();
				vista.ok("Introduzca nombre de ficheros y pulse Botón Iniciar preferido");
				vista.habilitarInicio(true);
			} 
		} catch (EvaluacionException exc) {
			vista.error("ERROR: " + exc.getMessage());
		} catch (IOException exc) {
			vista.error("ERROR de Entrada/Salida: " + exc.getMessage());
		} catch (RuntimeException exc) {
			vista.error("ERROR: faltan datos por introducir");
		}
	}

}
