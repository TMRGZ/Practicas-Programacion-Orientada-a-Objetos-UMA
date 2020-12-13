package prExSept2016SOL;

import java.util.Comparator;

public class OrdenAltEquipo implements Comparator<Equipo> {

	public int compare(Equipo e1, Equipo e2) {
		int resultado = e1.getCategoria() - e2.getCategoria();
		if (resultado == 0) {
			resultado = e1.getNombre().compareToIgnoreCase(e2.getNombre());
			if (resultado == 0) {
				resultado = e2.getPuntos() - e1.getPuntos(); //// ojo, a mayor puntos, menor en la ordenación
			}
		}
		return resultado;
	}

}
