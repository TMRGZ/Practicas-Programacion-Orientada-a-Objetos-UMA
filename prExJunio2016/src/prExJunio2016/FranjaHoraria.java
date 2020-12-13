package prExJunio2016;

public class FranjaHoraria {
	public static enum DiaSemana {LUNES, MARTES, MIERCOLES, JUEVES, VIERNES};
	public static enum HoraDia {PRIMERA, SEGUNDA, TERCERA, CUARTA, QUINTA, SEXTA};
	
	private DiaSemana dia;
	private HoraDia hora;
	
	public FranjaHoraria(String dia, String hora) throws AsignacionException{
		try{
			/** valueOf() Recibe una cadena de caracteres y la convierte a un valor de tipo enumerado
			 *            Tenemos que convertir la cadena a mayúsculas antes de hacer la conversión    
			 *			  Si la cadena de caracteres no es un valor del tipo enumerado este método lanza 
			 *			  la excepción IllegalArgumentException
			 */
			this.dia  = DiaSemana.valueOf(dia.toUpperCase());
			this.hora = HoraDia.valueOf(hora.toUpperCase());
		}catch(IllegalArgumentException e){
			throw new AsignacionException("Error. Dia u hora incorrectos");
		}
	}
	
	public DiaSemana getDia(){
		return dia;
	}
	
	public HoraDia getHora(){
		return hora;
	}
	
	@Override public String toString() {
		return "("+dia+", "+hora+")";
	}
}
