import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.SortedSet;

public class ControladorEurocopa implements ActionListener {

	private VistaEurocopa vista;
	private Eurocopa eurocopa; // modelo

	public ControladorEurocopa(VistaEurocopa v) {
		vista = v;
		vista
				.ok("Introduzca nombre de ficheros (y tope de tarjetas) y pulse Botón Iniciar preferido");
		vista.habilitarInicio(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();
		try {
			if (comando.equals(VistaEurocopa.INICIAR_EUROCOPA)) {
				eurocopa = new Eurocopa(vista.ficheroEquipos());
				vista
						.ok("Datos leídos correctamente. Puede formar el equipo ideal");
				vista.habilitarInicio(false);
			} else if (comando
					.equals(VistaEurocopa.INICIAR_EUROCOPA_JUEGO_LIMPIO)) {
				eurocopa = new EurocopaJuegoLimpio(vista.ficheroEquipos(),
						vista.ficheroTarjetas());
				vista
						.ok("Datos leídos correctamente. Puede formar el equipo ideal de juego límpio");
				vista.habilitarInicio(false);
			} else if (comando.equals(VistaEurocopa.FORMAR_EQUIPO_IDEAL)) {
				SortedSet<Jugador> ideal = eurocopa
						.formarEquipoIdeal(vista.defensas(), vista
								.centrocampistas(), vista.atacantes());
				vista.añadirAHistórico(Eurocopa.representarEquipoIdeal(ideal));
				Eurocopa.mostrarEquipoIdeal(vista.ficheroSalida(), ideal);
				vista.ok("Salida correcta en pantalla y en fichero");
			} else if (comando.equals(VistaEurocopa.FINALIZAR)) {
				vista.limpiar();
				vista
						.ok("Introduzca nombre de ficheros (y tope de tarjetas) y pulse Botón Iniciar preferido");
				vista.habilitarInicio(true);
			}
		} catch (EurocopaException exc) {
			vista.error("ERROR: " + exc.getMessage());
		} catch (IOException exc) {
			vista.error("ERROR de Entrada/Salida: " + exc.getMessage());
		} catch (RuntimeException exc) {
			vista.error("ERROR: faltan datos por introducir");
		}
	}

}
