
package prSept17;

import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PanelVista extends JPanel implements Vista {
	private JTextField loginT, loginU;
	private JButton loginB, logoutB;
	private JTextField nuevoUsr, clvBlk;
	private JButton crearCuenta;
	private JTextField nombreFich;
	private JButton cargarB, guardarB;
	private JTextField receptor, texto;
	private JButton enviarMsj;
	private JTextField usuario, filtro;
	private JButton leerMsj;
	private JList<String> msjLista;
	private JLabel estado;
	//private JTabbedPane tabs;
	private Box tabs;
	private List<String> listaMensajes;
	public PanelVista() {
		//----------------------------
		JPanel loginLine = new JPanel(new FlowLayout());
		loginT = new JTextField(10);
		loginB = new JButton(Vista.LOGIN);
		logoutB = new JButton(Vista.LOGOUT);
		loginU = new JTextField(10);
		loginU.setEditable(false);
		loginLine.add(new JLabel("Usuario: "));
		loginLine.add(loginT);
		loginLine.add(loginB);
		loginLine.add(logoutB);
		loginLine.add(loginU);
		//----------------------------
		JPanel cuentaLine = new JPanel(new FlowLayout());
		nuevoUsr = new JTextField(10);
		clvBlk = new JTextField(30);
		crearCuenta = new JButton(Vista.CREARCNT);
		cuentaLine.add(new JLabel("Usuario: "));
		cuentaLine.add(nuevoUsr);
		cuentaLine.add(new JLabel("Blk: "));
		cuentaLine.add(clvBlk);
		cuentaLine.add(crearCuenta);
		//----------------------------
		JPanel fichLine = new JPanel(new FlowLayout());
		nombreFich = new JTextField(10);
		cargarB = new JButton(Vista.CARGARFICH);
		guardarB = new JButton(Vista.GUARDARFICH);
		fichLine.add(new JLabel("Fichero: "));
		fichLine.add(nombreFich);
		fichLine.add(cargarB);
		fichLine.add(guardarB);
		//----------------------------
		Box adminTab = Box.createVerticalBox();
		adminTab.add(cuentaLine);
		adminTab.add(fichLine);
		adminTab.setBorder(BorderFactory.createTitledBorder("Administracion"));
		//----------------------------
		JPanel enviarLine = new JPanel(new FlowLayout());
		receptor = new JTextField(10);
		texto = new JTextField(30);
		enviarMsj = new JButton(Vista.ENVMSJ);
		enviarLine.add(new JLabel("Receptor: "));
		enviarLine.add(receptor);
		enviarLine.add(new JLabel("Texto: "));
		enviarLine.add(texto);
		enviarLine.add(enviarMsj);
		//----------------------------
		JPanel leerLine = new JPanel(new FlowLayout());
		usuario = new JTextField(10);
		filtro = new JTextField(30);
		leerMsj = new JButton(Vista.LEERMSJ);
		leerLine.add(new JLabel("Usuario: "));
		leerLine.add(usuario);
		leerLine.add(new JLabel("Filtro: "));
		leerLine.add(filtro);
		leerLine.add(leerMsj);
		//----------------------------
		listaMensajes = new LinkedList<String>();
		msjLista = new JList<String>();
		JScrollPane listaScroll = new JScrollPane(msjLista,
												  JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
												  JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		//----------------------------
		Box msjTab = Box.createVerticalBox();
		msjTab.add(enviarLine);
		msjTab.add(leerLine);
		msjTab.add(listaScroll);
		msjTab.setBorder(BorderFactory.createTitledBorder("Mensajes"));
		//----------------------------
		//tabs = new JTabbedPane(JTabbedPane.TOP);
		//tabs.addTab("Admin", adminTab);
		//tabs.addTab("Mensajes", msjTab);
		tabs = Box.createVerticalBox();
		tabs.add(adminTab);
		tabs.add(msjTab);
		//----------------------------
		estado = new JLabel(" ");
		this.setLayout(new BorderLayout());
		this.add(loginLine, BorderLayout.NORTH);
		this.add(tabs, BorderLayout.CENTER);
		this.add(estado, BorderLayout.SOUTH);
	}
	//- Consultas ------------------------------
	public String getLogin() {
		String entrada = loginT.getText().trim();
		loginT.setText("");
		return entrada;
	}
	public String getNuevoUsuario() {
		String entrada = nuevoUsr.getText().trim();
		nuevoUsr.setText("");
		return entrada;
	}
	public Set<String> getClvBloqueo() {
		String entrada = clvBlk.getText().trim();
		clvBlk.setText("");
		return string2Set(entrada);
	}
	public String getNombreFichero() {
		String entrada = nombreFich.getText().trim();
		nombreFich.setText("");
		return entrada;
	}
	public String getReceptorMsj() {
		String entrada = receptor.getText().trim();
		receptor.setText("");
		return entrada;
	}
	public String getTextoMsj() {
		String entrada = texto.getText().trim();
		texto.setText("");
		return entrada;
	}
	public String getUsuarioMsj() {
		String entrada = usuario.getText().trim();
		usuario.setText("");
		return entrada;
	}
	public Set<String> getClvMsj() {
		String entrada = filtro.getText().trim();
		filtro.setText("");
		return string2Set(entrada);
	}
	private Set<String> string2Set(String entrada) {
		Set<String> set = new HashSet<String>();
		for (String s : entrada.split("\\s+")) {
			if (s.length() > 0) {
				set.add(s);
			}
		}
		return set;
	}
	//- Actualizaciones ------------------------
	public void setLogin(String u) {
		loginU.setText(u);
	}
	public void setLineaEstado(String e) {
		estado.setText(e);
	}
	public void cleanMensajes() {
		listaMensajes.clear();
		msjLista.setListData(new String[0]);
	}
	public void addMensaje(String e) {
		listaMensajes.add(e);
		msjLista.setListData(listaMensajes.toArray(new String[0]));
	}
	public void activarInteraccion(boolean e) {
		activarComponenteRec(tabs, e);
	}
	private void activarComponenteRec(Component cmp, boolean e) {
		cmp.setEnabled(e);
		if (cmp instanceof Container) {
			for (Component c : ((Container)cmp).getComponents()){
				c.setEnabled(e);
				activarComponenteRec(c, e);
			}
		}
	}
// 	public void seleccionarTab(int t) {
// 		if (t == 1) {
// 			tabs.setSelectedIndex(0);
// 		} else {
// 			tabs.setSelectedIndex(1);
// 		}
// 	}
	//- Administracion -------------------------
	public void setControlador(ActionListener c) {
		loginB.addActionListener(c);
		logoutB.addActionListener(c);
		crearCuenta.addActionListener(c);
		cargarB.addActionListener(c);
		guardarB.addActionListener(c);
		enviarMsj.addActionListener(c);
		leerMsj.addActionListener(c);
	}
	//------------------------------------------
}
