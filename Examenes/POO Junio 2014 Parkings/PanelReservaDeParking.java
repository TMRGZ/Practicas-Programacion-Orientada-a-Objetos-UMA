package prParking;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;


public class PanelReservaDeParking extends JPanel implements VistaReservaDeParking {

	private static final long serialVersionUID = 1L;

	private JButton bIniciar, bBuscar, bReservar, bBorrar;
	private JTextField jFile, jMatricula, jPosX, jPosY, jIn, jOut;
	private JTextArea aParkings;
	private JLabel lmensajes;
	
	public PanelReservaDeParking(){
		
		// Panel Norte ....................................
		bIniciar = new JButton(INICIAR);
		jFile = new JTextField(30);
		jFile.setBorder(new TitledBorder("Fichero de parkings"));
		
		JPanel panelNorte = new JPanel();
		panelNorte.add(jFile);
		panelNorte.add(bIniciar);
		
		// Panel Izq ....................................
		bBuscar   = new JButton(BUSCAR);
		bBuscar.setBorder(new BevelBorder(BevelBorder.RAISED));
		bReservar = new JButton(RESERVAR);
		bReservar.setBorder(new BevelBorder(BevelBorder.RAISED));
		bBorrar	  = new JButton(BORRAR);
		bBorrar.setBorder(new BevelBorder(BevelBorder.RAISED));
		
		JPanel panelIzq = new JPanel(new GridLayout(3,1,40,10));
		panelIzq.add(bBuscar);
		panelIzq.add(bReservar);
		panelIzq.add(bBorrar);
		
		// Panel Dch ...................................
		jMatricula = new JTextField(12);
		jMatricula.setBorder(new TitledBorder("matrícula"));
		jPosX = new JTextField(10);
		jPosX.setBorder(new TitledBorder("X"));
		jPosY = new JTextField(10);
		jPosY.setBorder(new TitledBorder("Y"));
		jIn   = new JTextField(10);
		jIn.setBorder(new TitledBorder("in"));
		jOut  = new JTextField(10);
		jOut.setBorder(new TitledBorder("out"));
		aParkings = new JTextArea(2,30);
		aParkings.setBorder(new BevelBorder(BevelBorder.LOWERED));
		
		JScrollPane sc = new JScrollPane(aParkings);
		
		JPanel panelAux1 = new JPanel(new GridLayout(2,1,10,10));
		panelAux1.add(new JLabel("Datos del vehículo"));
		panelAux1.add(jMatricula);
		
		JPanel panelAux2 = new JPanel(new GridLayout(2,2,5,5));
		panelAux2.add(jPosX);
		panelAux2.add(jPosY);
		panelAux2.add(jIn);
		panelAux2.add(jOut);
		
		JPanel panelDch = new JPanel(new GridLayout(2,1,10,10));
		panelDch.add(panelAux1);
		panelDch.add(panelAux2);

		JPanel panelSuperior = new JPanel(new GridLayout(1,2,10,10));
		panelSuperior.add(panelIzq);
		panelSuperior.add(panelDch);
		
		JPanel panelCentro = new JPanel(new GridLayout(2,1,10,10));
		panelCentro.add(panelSuperior);
		panelCentro.add(sc);
		
		// Panel Sur ......................................
		lmensajes = new JLabel("Mensajes");
		JPanel panelSur = new JPanel();
		panelSur.add(lmensajes);
		
		// ................................................
		this.setLayout(new BorderLayout(10,10));
		this.add(panelNorte, BorderLayout.NORTH);
		this.add(panelCentro, BorderLayout.CENTER);
		
		this.add(panelSur, BorderLayout.SOUTH);
	}
	
	//- Métodos ........................................
	
	@Override
	public String leerNombreFichero() {
		return jFile.getText();
	}

	@Override
	public String leerMatricula() {
		return jMatricula.getText();
	}

	@Override
	public Posicion leerPosicion() {
		double cx = Double.parseDouble(jPosX.getText());
		double cy = Double.parseDouble(jPosY.getText());
		return new Posicion(cx, cy);
	}

	@Override
	public int leerEntrada() {
		return Integer.parseInt(jIn.getText());
	}

	@Override
	public int leerSalida() {
		return Integer.parseInt(jOut.getText());
	}

	@Override
	public void mostrarInformacion(String info) {
		aParkings.append(info + '\n');
	}

	@Override
	public void mostrarMensaje(String msg) {
		this.lmensajes.setForeground(Color.BLUE);
		this.lmensajes.setText(msg);
	}

	@Override
	public void mostrarError(String err) {
		this.lmensajes.setForeground(Color.RED);
		this.lmensajes.setText(err);
	}

	@Override
	public void activarInicio(boolean b){
		this.bIniciar.setEnabled(b);
		this.jFile.setEnabled(b);
		
		this.bBuscar.setEnabled(!b);
		this.bReservar.setEnabled(!b);
		this.bBorrar.setEnabled(!b);
		
		this.jMatricula.setEnabled(!b);
		this.jPosX.setEnabled(!b);
		this.jPosY.setEnabled(!b);
		this.jIn.setEnabled(!b);
		this.jOut.setEnabled(!b);
	}
	
	
	@Override
	public void borrarDatosVehiculo() {
		this.jMatricula.setText("");
		this.jPosX.setText("");
		this.jPosY.setText("");
		this.jIn.setText("");
		this.jOut.setText("");
	}

	@Override
	public void controlador(ActionListener ctr) {
		this.bIniciar.addActionListener(ctr);
		this.bIniciar.setActionCommand(INICIAR);
		this.bBuscar.addActionListener(ctr);
		this.bBuscar.setActionCommand(BUSCAR);
		this.bReservar.addActionListener(ctr);
		this.bReservar.setActionCommand(RESERVAR);
		this.bBorrar.addActionListener(ctr);
		this.bBorrar.setActionCommand(BORRAR);
	}

}
