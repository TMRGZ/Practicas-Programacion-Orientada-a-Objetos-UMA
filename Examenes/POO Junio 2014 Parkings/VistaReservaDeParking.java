package prParking;

import java.awt.event.ActionListener;


public interface VistaReservaDeParking {
	
	String INICIAR = "Iniciar";
	String BUSCAR = "Buscar";
	String RESERVAR = "Reservar";
	String BORRAR = "Borrar";

	/* Devuelve el nombre de un fichero de parkings */
	String leerNombreFichero();
	
	/* Devuelve la matr�cula de un veh�culo */
	String leerMatricula();
	
	/* Devuelve la posici�n de un veh�culo  */
	Posicion leerPosicion();
	
	/* Devuelve la hora de entrada de un veh�culo */
	int leerEntrada();
	
	/* Devuelve la hora de salida de un veh�culo  */
	int leerSalida();
	
	/* Muestra informaci�n sobre un parking */
	void mostrarInformacion(String info);
	
	/* Muestra operaci�n realizada correctamente */
	void mostrarMensaje(String msg);
	
	/* Muestra mensaje de error */
	void mostrarError(String err);
	
	/* Borra los datos introducidos de un veh�culo*/
	void borrarDatosVehiculo();
	
	/* Activa/desactiva el estado inicial de la interfaz gr�fica */
	void activarInicio(boolean activar);
	
	/* Da de alta al controlador ctr como oyente de los botones del panel*/
	void controlador(ActionListener ctr);
}

