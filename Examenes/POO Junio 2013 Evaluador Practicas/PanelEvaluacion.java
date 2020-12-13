import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelEvaluacion extends JPanel implements VistaEvaluacion {

	private JTextField fichPracticas, fichNoEvaluables, fichSalida, extra;
	private JButton iniciarEV, iniciarEVR, evaluar, practicasAprobadas, finalizar;
	private JLabel mensaje;
	private JTextArea historico;
	
	public PanelEvaluacion() {
		// panel norte
				JPanel norte = new JPanel();
				norte.setLayout(new GridLayout(2,2,5,5));
				
				JLabel fP = new JLabel("Fichero Practicas Realizadas");
				fichPracticas = new JTextField(10);
				
				iniciarEV = new JButton("Iniciar Evaluacion");
				
				iniciarEVR = new JButton("Iniciar Evaluacion Restringida");
								
				JLabel fNE = new JLabel("Fichero Alumnos No Evaluables");
				fichNoEvaluables = new JTextField(10);
				
				JPanel eq = new JPanel();
				eq.add(fP);
				eq.add(fichPracticas);
					
				JPanel ta = new JPanel();
				ta.add(fNE);
				ta.add(fichNoEvaluables);
					
				norte.add(eq);
				norte.add(ta);
				norte.add(iniciarEV);
				norte.add(iniciarEVR);
			
				
				
		// panel central
				
				// zona de evaluacion 
								
				JPanel salidaDatos = new JPanel();
				extra = new JTextField(10);
				extra.setBorder(new TitledBorder("NOTA EXTRA"));
				JLabel salida = new JLabel("Fichero de Salida:");
				fichSalida = new JTextField(10);
				salidaDatos.add(extra);
				salidaDatos.add(salida);
				salidaDatos.add(fichSalida);
				
				finalizar = new JButton("Finalizar");
							
				
				evaluar = new JButton("Evaluar Alumnos");
				practicasAprobadas = new JButton("Practicas Aprobadas");
				
				
				
				
				JPanel zonaFormacion = new JPanel();
				zonaFormacion.setLayout(new GridLayout(4,1,5,5));
				zonaFormacion.add(salidaDatos);
				zonaFormacion.add(evaluar);
				zonaFormacion.add(practicasAprobadas);
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

		iniciarEV.addActionListener(ctr);
		iniciarEV.setActionCommand(INICIAR_EVALUACION);
		iniciarEVR.addActionListener(ctr);
		iniciarEVR.setActionCommand(INICIAR_EVALUACION_RESTRINGIDA);
		evaluar.addActionListener(ctr);
		evaluar.setActionCommand(EVALUAR);
		practicasAprobadas.addActionListener(ctr);
		practicasAprobadas.setActionCommand(PRACTICAS_APROBADAS);
		finalizar.addActionListener(ctr);
		finalizar.setActionCommand(FINALIZAR);
	}

	@Override
	public String ficheroPracticas() {
		// TODO Auto-generated method stub
		return fichPracticas.getText();
	}

	@Override
	public String ficheroNoEvaluables() {
		// TODO Auto-generated method stub
		return fichNoEvaluables.getText();
	}
	
	@Override
	public String ficheroSalida() {
		// TODO Auto-generated method stub
		return fichSalida.getText();
	}
	
	@Override
	public double extra() {
		// TODO Auto-generated method stub
		return  Double.parseDouble(extra.getText());
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

		iniciarEV.setEnabled(b);
		iniciarEVR.setEnabled(b);
		fichPracticas.setEnabled(b);
		fichNoEvaluables.setEnabled(b);
		
			
		evaluar.setEnabled(!b);
		practicasAprobadas.setEnabled(!b);
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
		fichPracticas.setText("");
		fichNoEvaluables.setText("");
		fichSalida.setText("");
	}


}
