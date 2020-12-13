package prCuentasGUI;
/*******************************************************************************
 * Modelo
 ******************************************************************************/
public class Cuenta {
	private double saldo;

	public Cuenta(double si) {
		saldo = Math.max(0, si); // Por simplificar ...
	}

	public void ingresa(double ing) {
		saldo += ing;
	}

	public double extrae(double extrae) {
		double realExtrae = extrae;
		if (saldo < extrae) {
			realExtrae = saldo;
		}
		saldo -= realExtrae;
		return realExtrae;
	}

	public double saldo() {
		return saldo;
	}
}

