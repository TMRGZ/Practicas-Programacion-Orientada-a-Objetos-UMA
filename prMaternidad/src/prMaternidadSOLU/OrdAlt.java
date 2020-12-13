package prMaternidadSOLU;

import java.util.Comparator;

public class OrdAlt implements Comparator<Persona>{

	//Las personas se comparan usando el nombre. En caso de igualdad se utiliza el c�digo.
	public int compare(Persona p1, Persona p2) {
		int res = p1.getNombre().compareToIgnoreCase(p2.getNombre());
		
		if (res == 0)
			res = p1.getCodigo() - p2.getCodigo();
		
		return res;
	}

}
