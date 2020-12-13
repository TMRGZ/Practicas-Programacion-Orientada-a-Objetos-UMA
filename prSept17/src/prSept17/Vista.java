
package prSept17;

import java.util.Set;
import java.awt.event.ActionListener;

public interface Vista {
	//- Eventos -------------------------------
	public static final String LOGIN  = "Login";
	public static final String LOGOUT = "Logout";
	public static final String CREARCNT = "Crear Cuenta";
	public static final String ENVMSJ = "Enviar Mensaje";
	public static final String LEERMSJ = "Leer Mensajes";
	public static final String CARGARFICH = "CargarFichero";
	public static final String GUARDARFICH = "GuardarFichero";
	//- Consultas ------------------------------
	public String getLogin();
	public String getNuevoUsuario();
	public Set<String> getClvBloqueo();
	public String getNombreFichero();
	public String getReceptorMsj();
	public String getTextoMsj();
	public String getUsuarioMsj();
	public Set<String> getClvMsj();
	//- Actualizaciones ------------------------
	public void setLogin(String u);
	public void setLineaEstado(String e);
	public void cleanMensajes();
	public void addMensaje(String e);
	public void activarInteraccion(boolean e);
	//- Administracion -------------------------
	public void setControlador(ActionListener c);
	//------------------------------------------
}
