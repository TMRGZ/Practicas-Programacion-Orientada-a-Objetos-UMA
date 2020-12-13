package prExSept2016SOL;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PanelCompeticion extends JPanel implements VistaCompeticion {

	private JTextField datosEntrada;
	private JButton bInicio;
	
	private JLabel mensaje;
	
	private JTextArea areaTexto;
	
	private JButton bGuardar;
	private JTextField guardarDatos;
	
	
	private JTextField jugadorIncrePartidos;
	private JButton bIncrePartidos;
	private JTextField pJugados;
	private JTextField pGanados;
	
	public PanelCompeticion() {
		setLayout(new BorderLayout());

		// Zona Norte
		datosEntrada = new JTextField(10);
		datosEntrada.setBorder(BorderFactory.createTitledBorder("Fich Entrada"));
		bInicio = new JButton("Inicio");

		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(new FlowLayout());
		panelNorte.add(datosEntrada);
		panelNorte.add(bInicio);

		// Zona Sur
		mensaje = new JLabel(" ");

		// Zona central
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new GridLayout(1, 2));

		// Central izquierdo
		areaTexto = new JTextArea(10, 30);
		JScrollPane panelIzquierdo = new JScrollPane(areaTexto);

		// Central derecho
		JPanel panelDerecho = new JPanel();
		panelDerecho.setLayout(new GridLayout(4, 1, 5, 5));

		bGuardar = new JButton("Guardar");
		guardarDatos = new JTextField(10);
		guardarDatos.setBorder(BorderFactory.createTitledBorder("Fich Salida"));
		
		bIncrePartidos = new JButton("Incrementar Partidos");
		jugadorIncrePartidos = new JTextField(10);
		jugadorIncrePartidos
				.setBorder(BorderFactory.createTitledBorder("Nombre Jugador"));
		
		pJugados = new JTextField(5);
		pJugados.setBorder(BorderFactory.createTitledBorder("Partidos Jugados"));
		
		pGanados = new JTextField(5);
		pGanados.setBorder(BorderFactory.createTitledBorder("Partidos Ganados"));
		
		
		
		panelDerecho.add(bGuardar);
		panelDerecho.add(guardarDatos);
		panelDerecho.add(bIncrePartidos);
		panelDerecho.add(jugadorIncrePartidos);
		panelDerecho.add(pJugados);
		panelDerecho.add(pGanados);
		
		panelCentro.add(panelIzquierdo);
		panelCentro.add(panelDerecho);

		// Panel principal
		add(panelNorte, BorderLayout.NORTH);
		add(panelCentro, BorderLayout.CENTER);
		add(mensaje, BorderLayout.SOUTH);

	}

	@Override
	public void controlador(ActionListener ctr) {
		bInicio.addActionListener(ctr);
		bInicio.setActionCommand(INICIO);
		
		bGuardar.addActionListener(ctr);
		bGuardar.setActionCommand(GUARDAR);
		
		bIncrePartidos.addActionListener(ctr);
		bIncrePartidos.setActionCommand(INC_PARTIDOS);
		
	}

	@Override
	public void habilitarInit(boolean init) {
		bInicio.setEnabled(init);
		datosEntrada.setEnabled(init);

		areaTexto.setEnabled(!init);
		
		bGuardar.setEnabled(!init);
		guardarDatos.setEnabled(!init);
		
		bIncrePartidos.setEnabled(!init);
		jugadorIncrePartidos.setEnabled(!init);
		pJugados.setEnabled(!init);
		pGanados.setEnabled(!init);
		
	}

	@Override
	public void mensaje(String msg) {
		mensaje.setForeground(Color.BLUE);
		mensaje.setText(msg);
	}

	@Override
	public void error(String msg) {
		mensaje.setForeground(Color.RED);
		mensaje.setText(msg);
	}

	@Override
	public String fichEntrada() {
		return datosEntrada.getText();
	}

	@Override
	public String fichSalida() {
		return guardarDatos.getText();
	}

	@Override
	public void entradaHistorial(String s) {
		areaTexto.append(s + "\n");
	}

	public String jugador() {
		if (jugadorIncrePartidos.getText().equals("")) {
			throw new RuntimeException("Debe introducir un nombre de jugador");
		}return jugadorIncrePartidos.getText();
	}

	@Override
	public int pGanados() {
		int res;
		if (pGanados.getText().equals("")) {
			throw new RuntimeException("Debe introducir un numero de partidos ganados");
		}
		try {
			res = Integer.parseInt(pGanados.getText());
		} catch (NumberFormatException e) {
			throw new RuntimeException("Numero de partidos ganados incorrecto");
		}
		
		return res;
	}

	@Override
	public int pJugados() {
		int res;
		if (pJugados.getText().equals("")) {
			throw new RuntimeException("Debe introducir un numero de partidos jugados");
		}
		try {
			res = Integer.parseInt(pJugados.getText());
		} catch (NumberFormatException e) {
			throw new RuntimeException("Numero de partidos jugados incorrecto");
		}
		
		return res;
	}

}
