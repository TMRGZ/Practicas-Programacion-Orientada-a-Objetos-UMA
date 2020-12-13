package prEvaluacionPracticas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorEvaluacion implements ActionListener{
	private VistaEvaluacion v;
	Evaluacion r;


	public ControladorEvaluacion(VistaEvaluacion v) {
		this.v = v;
		v.habilitarInicio(true);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if(cmd.equals(v.INICIAR_EVALUACION)) {
			v.habilitarInicio(false);
			r = new Evaluacion(v.ficheroPracticas());
		}else if(cmd.equals(v.INICIAR_EVALUACION_RESTRINGIDA)) {
			v.habilitarInicio(false);
			r = new EvaluacionRestringida(v.ficheroPracticas(), v.ficheroNoEvaluables());
		}else if(cmd.equals(v.EVALUAR)){
			r.evaluarAlumnos(v.extra());
			r.listarAlumnos(v.ficheroSalida());
			v.añadirAHistorico(r.representarAlumnos());
		}else if(cmd.equals(v.PRACTICAS_APROBADAS)) {
			v.añadirAHistorico(r.practicasAprobadas().toString());
		}else if(cmd.equals(v.FINALIZAR)) {
			v.limpiar();
			v.habilitarInicio(true);
		}
		
	}

}
