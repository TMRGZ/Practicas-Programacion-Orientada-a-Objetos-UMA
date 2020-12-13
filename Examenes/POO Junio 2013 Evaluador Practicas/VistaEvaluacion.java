import java.awt.event.ActionListener;


public interface VistaEvaluacion {
	public static final String INICIAR_EVALUACION = "INICIAR_EVALUACION";
	public static final String INICIAR_EVALUACION_RESTRINGIDA = "INICIAR_EVALUACION_RESTRINGIDA";
	public static final String EVALUAR = "EVALUAR";
	public static final String PRACTICAS_APROBADAS = "PRACTICAS_APROBADAS";
	public static final String FINALIZAR = "FINALIZAR";
	
	/**
	 * Pasamos el controlador.
	 */
	public void controlador(ActionListener ctr);
	
	/**
	 * Obtenemos el fichero con los datos de los alumnos y practicas realizadas.
	 * @return String con el nombre de fichero.
	 */
	public String ficheroPracticas();
	
	/**
	 * Obtenemos el fichero con los datos de los alumnos no evaluables.
	 * @return String con el nombre de fichero.
	 */
	public String ficheroNoEvaluables();

	/**
	 * Obtenemos el fichero para salida de datos.
	 * @return String con el nombre de fichero de salida.
	 */
	public String ficheroSalida();

	/**
	 * Obtenemos la nota extra para la calificacion de los alumnos.
	 * @return double con la nota extra.
	 */
	double extra();
	
	/**
	 * Mostramos un mensaje de error.
	 * @param mensaje
	 *            String con el mensaje a mostrar.
	 */
	public void error(String mensaje);
	
	/**
	 * Mostramos un mensaje de información.
	 * @param mensaje
	 *            String con el mensaje a mostrar.
	 */
	public void ok(String mensaje);
	
	/**
	 * Habilitamos o deshabilitamos el modo inicialización o evaluacion de alumnos
	 * @param b
	 *       true para habilitar el modo inicialización; false para el modo evaluacion de alumnos
	 */
	public void habilitarInicio(boolean b);
	
	/**
	 * Añadimos un mensaje al histórico.
	 * @param mensaje
	 *            String con el mensaje a añadir.
	 */
	public void añadirAHistórico(String mensaje);
	
	/**
	 * Limpiamos el histórico.
	 */
	public void limpiar();

}

