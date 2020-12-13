package prExJunio2016;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelAsignacion extends JPanel implements VistaAsignacion {

	private JTextField fichPeticiones;
	private JCheckBox restricciones;
	private JTextField laboratorios;
	private JButton bInicio;
	private JButton bReInicio;
	
	private JLabel mensaje;
	
	private JTextArea areaTexto;
	
	private JButton bGuardar;
	private JTextField guardarDatos;
		
	public PanelAsignacion() {
		setLayout(new BorderLayout());

		// Zona Norte
		fichPeticiones = new JTextField(10);
		fichPeticiones.setBorder(BorderFactory.createTitledBorder("Fich Peticiones"));
		restricciones = new JCheckBox("Alternativas");
		laboratorios = new JTextField(10);
		laboratorios.setBorder(BorderFactory.createTitledBorder("Num Lab:"));
		bInicio = new JButton("Inicio");
		bReInicio = new JButton("ReInicio");

		JPanel panelNorte = new JPanel();
		panelNorte.setLayout(new FlowLayout());
		panelNorte.add(fichPeticiones);
		panelNorte.add(restricciones);
		panelNorte.add(laboratorios);
		panelNorte.add(bInicio);
		panelNorte.add(bReInicio);

		// Zona Sur
		mensaje = new JLabel(" ");

		// Zona central
		JPanel panelCentro = new JPanel();
		panelCentro.setLayout(new BorderLayout());

		// Central Norte
		areaTexto = new JTextArea(20, 55);
		JScrollPane panelCentralNorte = new JScrollPane(areaTexto);

		// Central Centro
		JPanel panelCentralCentro = new JPanel();
		panelCentralCentro.setLayout(new GridLayout(1, 2, 5, 5));

		bGuardar = new JButton("Guardar");
		guardarDatos = new JTextField(10);
		guardarDatos.setBorder(BorderFactory.createTitledBorder("Fich Salida"));
				
		panelCentralCentro.add(bGuardar);
		panelCentralCentro.add(guardarDatos);
		panelCentro.add(panelCentralNorte,BorderLayout.NORTH);
		panelCentro.add(panelCentralCentro,BorderLayout.CENTER);

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

		bReInicio.addActionListener(ctr);
		bReInicio.setActionCommand(REINICIO);
	}

	@Override
	public void habilitarInicio(boolean inicio) {
		bInicio.setEnabled(inicio);
		fichPeticiones.setEnabled(inicio);
		laboratorios.setEnabled(inicio);

		bReInicio.setEnabled(!inicio);

		areaTexto.setEnabled(!inicio);
		
		bGuardar.setEnabled(!inicio);
		guardarDatos.setEnabled(!inicio);
		
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
	public String fichPeticiones() {
		return fichPeticiones.getText();
	}

	@Override
	public boolean conAlternativas() {
		return restricciones.isSelected();
	}
	
	@Override
	public int laboratorios() {
		try{
			return Integer.parseInt(laboratorios.getText());
		}catch(NumberFormatException e){
			return 0;
		}
	}
	
	@Override
	public String fichSalida() {
		return guardarDatos.getText();
	}
	
	@Override
	public void entradaHistorial(String s) {
		areaTexto.append(s + "\n");
	}
	
	@Override
	public void limpiarHistorial() {
		areaTexto.setText("");
	}
}
