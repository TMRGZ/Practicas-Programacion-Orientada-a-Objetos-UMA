package prParking;

import java.awt.event.ActionListener;


public interface VistaReservaDeParking {
	
	String INICIAR = "Iniciar";
	String BUSCAR = "Buscar";
	String RESERVAR = "Reservar";
	String BORRAR = "Borrar";

	/* Devuelve el nombre de un fichero de parkings */
	String leerNombreFichero();
	
	/* Devuelve la matrícula de un vehículo */
	String leerMatricula();
	
	/* Devuelve la posición de un vehículo  */
	Posicion leerPosicion();
	
	/* Devuelve la hora de entrada de un vehículo */
	int leerEntrada();
	
	/* Devuelve la hora de salida de un vehículo  */
	int leerSalida();
	
	/* Muestra información sobre un parking */
	void mostrarInformacion(String info);
	
	/* Muestra operación realizada correctamente */
	void mostrarMensaje(String msg);
	
	/* Muestra mensaje de error */
	void mostrarError(String err);
	
	/* Borra los datos introducidos de un vehículo*/
	void borrarDatosVehiculo();
	
	/* Activa/desactiva el estado inicial de la interfaz gráfica */
	void activarInicio(boolean activar);
	
	/* Da de alta al controlador ctr como oyente de los botones del panel*/
	void controlador(ActionListener ctr);
}

