package prDocencia;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;



public class PanelDocencia extends JPanel implements VistaDocencia{

		
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		JTextField datosJTF; 
		JButton bInicio; 
		
		JLabel mensajeL; 
		
		JTextArea areaTA; 
		
		JButton bMedia;
		JButton bGuardar;
		JTextField guardarJTF;
		//JButton bBuscar;
		JButton aBuscar;
		//JTextField buscarJTF;
		JTextField buscarAJTF;
		
		public PanelDocencia(){
			setLayout(new BorderLayout());
			
			//Zona Norte
			datosJTF = new JTextField(10);
			datosJTF.setBorder(BorderFactory.createTitledBorder("Fich Datos"));
			bInicio = new JButton("Inicio");
			
			JPanel panelNorte = new JPanel();
			panelNorte.setLayout(new FlowLayout());
			panelNorte.add(datosJTF);
			panelNorte.add(bInicio);
			
			//Zona Sur
			mensajeL = new JLabel(" ");
			
			//Zona central
			JPanel panelCentro= new JPanel();
			panelCentro.setLayout(new GridLayout(1,2));
			
			//Central izquierdo
			areaTA = new JTextArea(10,30);
			JScrollPane panelIzquierdo = new JScrollPane(areaTA);
			
			//Central derecho
			JPanel panelDerecho = new JPanel();
			panelDerecho.setLayout(new GridLayout(4,3,5,5));
			
			bGuardar = new JButton("Guardar");
			guardarJTF = new JTextField(10);
			guardarJTF.setBorder(BorderFactory.createTitledBorder("Fich Salida"));
			//bBuscar  = new JButton("Buscar Profesor");
			//buscarJTF = new JTextField(10);
			//buscarJTF.setBorder(BorderFactory.createTitledBorder("Código Asignatura"));
			aBuscar  = new JButton("Buscar Asignaturas");
			buscarAJTF = new JTextField(10);
			buscarAJTF.setBorder(BorderFactory.createTitledBorder("NombreProfesor"));
			bMedia = new JButton("Carga Media");
			
			
			panelDerecho.add(bGuardar);
			panelDerecho.add(guardarJTF);
			//panelDerecho.add(bBuscar);
			//panelDerecho.add(buscarJTF);
			panelDerecho.add(aBuscar);
			panelDerecho.add(buscarAJTF);
			panelDerecho.add(bMedia);
					
			
			panelCentro.add(panelIzquierdo);
			panelCentro.add(panelDerecho);
			
			//Panel principal
			add(panelNorte,BorderLayout.NORTH);
			add(panelCentro,BorderLayout.CENTER);
			add(mensajeL, BorderLayout.SOUTH);
			
		}

		@Override
		public void controlador(ActionListener ctr) {
			bInicio.addActionListener(ctr);
			bInicio.setActionCommand(INICIO);
			bGuardar.addActionListener(ctr);
			bGuardar.setActionCommand(GUARDAR);
			//bBuscar.addActionListener(ctr);
			//bBuscar.setActionCommand(BUSCAR);
			aBuscar.addActionListener(ctr);
			aBuscar.setActionCommand(BUSCARASIG);
			bMedia.addActionListener(ctr);
			bMedia.setActionCommand(MEDIA);
		}

		@Override
		public void habilitarInit(boolean init) {
			bInicio.setEnabled(init);
			datosJTF.setEnabled(init);
			
			
			areaTA.setEnabled(!init);
			bGuardar.setEnabled(!init);
			//bBuscar.setEnabled(!init);
			bMedia.setEnabled(!init);
			guardarJTF.setEnabled(!init);
			//buscarJTF.setEnabled(!init);
			buscarAJTF.setEnabled(!init);
			aBuscar.setEnabled(!init);
			
			//mensajeL.setEnabled(!init);		
		}

		@Override
		public void mensaje(String msg) {
			mensajeL.setForeground(Color.BLUE);
			mensajeL.setText(msg);
		}

		@Override
		public void error(String msg) {
			mensajeL.setForeground(Color.RED);
			mensajeL.setText(msg);
		}

		@Override
		public String fichEntrada() {
			return datosJTF.getText();
		}

		@Override
		public String fichSalida() {
			return guardarJTF.getText();
		}

		@Override
		public void entradaHistorial(String s) {
			areaTA.append(s + "\n");
		}

		@Override
		/*public int codigoAsig() {
			return Integer.parseInt(buscarJTF.getText());
		}*/
		
		public String nombreProf(){
			return buscarAJTF.getText();
		}
	}

	
