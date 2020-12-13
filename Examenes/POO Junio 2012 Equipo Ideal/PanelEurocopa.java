import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;


@SuppressWarnings("serial")
public class PanelEurocopa extends JPanel implements VistaEurocopa {

	private JTextField fichEquipos, fichTarjetas, defensa, centro, ataque, fichSalida;
	private JButton iniciarEU, iniciarEUJL, formarEI, finalizar;
	private JLabel mensaje;
	private JTextArea historico;
	
	public PanelEurocopa() {
		// panel norte
				JPanel norte = new JPanel();
				norte.setLayout(new GridLayout(2,2,5,5));
				
				JLabel fE = new JLabel("Fichero Equipos");
				fichEquipos = new JTextField(10);
				
				iniciarEU = new JButton("Iniciar Eurocopa");
				
				iniciarEUJL = new JButton("Iniciar Eurocopa Juego Limpio");
								
				JLabel fT = new JLabel("Fichero Tarjetas");
				fichTarjetas = new JTextField(10);
				
				JPanel eq = new JPanel();
				eq.add(fE);
				eq.add(fichEquipos);
					
				JPanel ta = new JPanel();
				ta.add(fT);
				ta.add(fichTarjetas);
					
				norte.add(eq);
				norte.add(ta);
				norte.add(iniciarEU);
				norte.add(iniciarEUJL);
			
				
				
		// panel central
				
				// zona de formacion de equipo ideal 
								
				JPanel numeroJugadores = new JPanel();
				defensa = new JTextField(10);
				defensa.setBorder(new TitledBorder("DEFENSA"));
				centro = new JTextField(10);
				centro.setBorder(new TitledBorder("CENTRO"));
				ataque = new JTextField(10);
				ataque.setBorder(new TitledBorder("ATAQUE"));
				
				numeroJugadores.add(defensa);
				numeroJugadores.add(centro);
				numeroJugadores.add(ataque);
				
				JPanel salidaDatos = new JPanel();
				JLabel salida = new JLabel("Fichero de Salida:");
				fichSalida = new JTextField(10);
				salidaDatos.add(salida);
				salidaDatos.add(fichSalida);
				
				finalizar = new JButton("Finalizar");
							
				
				formarEI = new JButton("Formar Equipo Ideal");
				
				
				JPanel zonaFormacion = new JPanel();
				zonaFormacion.setLayout(new GridLayout(4,1,5,5));
				zonaFormacion.add(formarEI);
				zonaFormacion.add(numeroJugadores);
				zonaFormacion.add(salidaDatos);
				zonaFormacion.add(finalizar);
				
				
				// area de texto en panel central
				historico =  new JTextArea();
				JScrollPane historicoScroll = new JScrollPane(historico);
				// creacion de panel central
				JPanel central = new JPanel();
				central.setLayout(new GridLayout(2,1,5,5));
				central.add(zonaFormacion);
				central.add(historicoScroll);
				
		// panel sur
				mensaje = new JLabel();
				
		// panel principal
				setLayout(new BorderLayout());
				
				add(norte,BorderLayout.NORTH);
				add(central,BorderLayout.CENTER);
				add(mensaje,BorderLayout.SOUTH);
	}
	
	@Override
	public void controlador(ActionListener ctr) {
		// TODO Auto-generated method stub

		iniciarEU.addActionListener(ctr);
		iniciarEU.setActionCommand(INICIAR_EUROCOPA);
		iniciarEUJL.addActionListener(ctr);
		iniciarEUJL.setActionCommand(INICIAR_EUROCOPA_JUEGO_LIMPIO);
		formarEI.addActionListener(ctr);
		formarEI.setActionCommand(FORMAR_EQUIPO_IDEAL);
		finalizar.addActionListener(ctr);
		finalizar.setActionCommand(FINALIZAR);
	}

	@Override
	public String ficheroEquipos() {
		// TODO Auto-generated method stub
		return fichEquipos.getText();
	}

	@Override
	public String ficheroTarjetas() {
		// TODO Auto-generated method stub
		return fichTarjetas.getText();
	}
	
	@Override
	public String ficheroSalida() {
		// TODO Auto-generated method stub
		return fichSalida.getText();
	}
	
	@Override
	public int defensas() {
		// TODO Auto-generated method stub
		return  Integer.parseInt(defensa.getText());
	}
	
	@Override
	public int centrocampistas() {
		// TODO Auto-generated method stub
		return  Integer.parseInt(centro.getText());
	}
	
	@Override
	public int atacantes() {
		// TODO Auto-generated method stub
		return  Integer.parseInt(ataque.getText());
	}
	
	@Override
	public void error(String mensaje) {
		// TODO Auto-generated method stub
		this.mensaje.setForeground(Color.RED);
		this.mensaje.setText(mensaje);
	}

	@Override
	public void ok(String mensaje) {
		// TODO Auto-generated method stub
		this.mensaje.setForeground(Color.BLUE);
		this.mensaje.setText(mensaje);
	}

	@Override
	public void habilitarInicio(boolean b) {
		// TODO Auto-generated method stub

		iniciarEU.setEnabled(b);
		iniciarEUJL.setEnabled(b);
		fichEquipos.setEnabled(b);
		fichTarjetas.setEnabled(b);
		
			
		formarEI.setEnabled(!b);
		defensa.setEnabled(!b);
		centro.setEnabled(!b);
		ataque.setEnabled(!b);
		fichSalida.setEnabled(!b);
		finalizar.setEnabled(!b);
	}

	@Override
	public void añadirAHistórico(String mensaje) {
		// TODO Auto-generated method stub
		historico.append(mensaje + "\n");
	}
	
	@Override
	public void limpiar() {
		// TODO Auto-generated method stub
		historico.setText("");
		fichEquipos.setText("");
		fichTarjetas.setText("");
		defensa.setText("");
		centro.setText("");
		ataque.setText("");
		fichSalida.setText("");
	}


}
