package prParking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

public class ControladorDeReservas implements ActionListener {
	VistaReservaDeParking vista;
	ServicioDeReserva sdr;
	
	public ControladorDeReservas(VistaReservaDeParking v) {
		vista = v;
		vista.activarInicio(true);
		vista.mostrarMensaje("Introduzca nombre de fichero y pulse botón de inicio");
		
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		// TODO Auto-generated method stub

		String comando = ae.getActionCommand();
		try {
			
			if (comando.equals(VistaReservaDeParking.INICIAR)) {
				sdr = new ServicioDeReserva(vista.leerNombreFichero());
				vista.activarInicio(false);
				vista.mostrarMensaje("Introduzca los datos de un vehículo");
			} else if (comando.equals(VistaReservaDeParking.BUSCAR)) {
				Vehiculo v = new Vehiculo(vista.leerMatricula(),vista.leerPosicion(),
											vista.leerEntrada(),vista.leerSalida());
				Parking pq = sdr.parkingLibreMasProximo(v);
				if (pq == null) {
					vista.mostrarInformacion("No hay parking disponible");
				} else {
					vista.mostrarInformacion("El parking libre más próximo es: " + pq.getId()
							+ " a una distancia de: " + v.getPosicion().distancia(pq.getPosicion()));
				}
				vista.mostrarMensaje("");
			} else if (comando.equals(VistaReservaDeParking.RESERVAR)) {
				Vehiculo v = new Vehiculo(vista.leerMatricula(),vista.leerPosicion(),
				vista.leerEntrada(),vista.leerSalida());
				Parking pq = sdr.parkingLibreMasProximo(v);
				if (pq == null) {
					vista.mostrarInformacion("No hay parking disponible");
				} else {
					int pz = pq.buscarPlaza(v);
					pq.reservarPlaza(v, pz);
					vista.mostrarInformacion("El parking libre más próximo es: " + pq.getId()
							+ " a una distancia de: " + v.getPosicion().distancia(pq.getPosicion())
							+ "\n" + "La plaza reservada es: " + pz);
				}
				vista.mostrarMensaje("");
			} else if (comando.equals(VistaReservaDeParking.BORRAR)) {
				vista.borrarDatosVehiculo();
				vista.mostrarMensaje("Introduzca los datos de un vehículo");
			}
				
		} catch (FileNotFoundException e){
			vista.mostrarError("No se encuentra el fichero");
		} catch (ParkingException e){
			vista.mostrarError(e.getMessage());
		} catch (NumberFormatException e){
			vista.mostrarError(e.getMessage());
		} 
		
		
	}

}
