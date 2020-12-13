package prExJunio2016;

import java.awt.event.ActionListener;

public interface VistaAsignacion {
	public static final String INICIO = "INICIO";
	public static final String GUARDAR = "GUARDAR";
	public static final String REINICIO = "REINICIO";
	
	/**
	 * Habilita/Deshabilita el panel de inicialización
	 * @param init Si true, se habilitan los componentes del panel de inicialización y se deshabilita el resto.
	 * 			   Si false, lo contrario.
	 */
	public void habilitarInicio(boolean inicio);
	
	/**
	 * Muestra un mensaje informativo en el panel
	 */
	public void mensaje(String msg);
	
	/**
	 * Muestra un mensaje de error en el panel.
	 * @param msg
	 */
	public void error(String msg);
	
	/**
	 * Devuelve la ruta del fichero de entrada con las peticiones
	 */
	public String fichPeticiones();
	
	/**
	 * Devuelve si se deben considerar alternativas 
	 */
	public boolean conAlternativas();
	
	/**
	 * Devuelve la ruta del fichero de salida
	 */
	public String fichSalida();
	
	/**
	 * Devuelve el numero de laboratorios
	 */
	public int laboratorios();
	
	/**
	 * Añade una cadena de texto al historial del panel
	 */
	public void entradaHistorial(String s);
	
	/**
	 * Limpia el historial del panel
	 */
	public void limpiarHistorial();
		
	/**
	 * Registra el controlador en los componentes de la vista
	 * 
	 */
	public void controlador(ActionListener ctr);
	
}
