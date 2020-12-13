package prExSept2016;

import java.awt.event.ActionListener;

public interface VistaCompeticion {
	public static final String INICIO = "INICIO";
	public static final String GUARDAR = "GUARDAR";
	public static final String INC_PARTIDOS = "INC_PARTIDOS";
	
	
	
	/**
	 * Habilita/Deshabilita el panel de inicializaci�n
	 * @param init Si true, se habilitan los componentes del panel de inicializaci�n y se deshabilita el resto.
	 * 			   Si false, lo contrario.
	 */
	public void habilitarInit(boolean init);
	
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
	 * Devuelve la ruta del fichero de entrada
	 */
	public String fichEntrada();
	
	/**
	 * Devuelve la ruta del fichero de salida
	 */
	public String fichSalida();
	
	/**
	 * A�ade una cadena de texto al historial del panel
	 */
	public void entradaHistorial(String s);
	
	/** 
	 * Lee el nombre jugador al que incrementarle los partidos jugados y ganados
	 */
	public String jugador();
	
	/** 
	 * Lee el n�mero de partidos ganados
	 */
	public int pGanados();
	
	/** 
	 * Lee el n�mero de partidos jugados
	 */
	public int pJugados();
	
	/**
	 * Registra el controlador en los componentes de la vista
	 * 
	 */
	public void controlador(ActionListener ctr);
	
	
}
