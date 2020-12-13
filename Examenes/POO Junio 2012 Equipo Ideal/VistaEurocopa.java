import java.awt.event.ActionListener;


public interface VistaEurocopa {
	public static final String INICIAR_EUROCOPA = "INICIAR_EUROCOPA";
	public static final String INICIAR_EUROCOPA_JUEGO_LIMPIO = "INICIAR_EUROCOPA_JUEGO_LIMPIO";
	public static final String FORMAR_EQUIPO_IDEAL = "FORMAR_EQUIPO_IDEAL";
	public static final String FINALIZAR = "FINALIZAR";
	
	/**
	 * Pasamos el controlador.
	 */
	public void controlador(ActionListener ctr);
	
	/**
	 * Obtenemos el fichero con los datos de los equipos y jugadores.
	 * @return String con el nombre de fichero de los equipos.
	 */
	public String ficheroEquipos();
	
	/**
	 * Obtenemos el fichero con los datos de las tarjetas.
	 * @return String con el nombre de fichero de las tarjetas.
	 */
	public String ficheroTarjetas();

	/**
	 * Obtenemos el fichero para salida de datos.
	 * @return String con el nombre de fichero de salida.
	 */
	public String ficheroSalida();
	
	/**
	 * Obtenemos el número de defensas para el equipo ideal
	 * @return int con el número de defensas
	 */
	public int defensas();
	
	/**
	 * Obtenemos el número de centrocampistas para el equipo ideal
	 * @return int con el número de centrocampistas
	 */
	public int centrocampistas();
	
	/**
	 * Obtenemos el número de atacantes para el equipo ideal
	 * @return int con el número de atacantes
	 */
	public int atacantes();
	
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
	 * Habilitamos o deshabilitamos el modo inicialización o formación de equipos
	 * @param b
	 *       true para habilitar el modo inicialización; false para el modo formación de equipos
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
