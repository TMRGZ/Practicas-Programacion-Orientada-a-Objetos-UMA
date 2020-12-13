package prSept17;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

public class Controlador implements ActionListener{
	Vista v;
	RedSocial r;
	
	public Controlador(Vista v, RedSocial r){
		this.v=v;
		v.activarInteraccion(false);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		
		if(cmd.equals(v.LOGIN)){
			String usuario = v.getLogin();
			r.login(usuario);
			v.setLogin(usuario);
			v.addMensaje("Conectado");
			v.activarInteraccion(true);
			
			if(cmd.equals(v.LOGOUT)){
				r.logout();
				v.setLogin("");
				v.cleanMensajes();
			}
			
			if(cmd.equals(v.CREARCNT)){
				String nuevo = v.getNuevoUsuario();
				Set<String> bloqueo = v.getClvBloqueo();
					if(bloqueo==null){
						Cuenta c = new Cuenta(nuevo);
					}else{
						CuentaModerada cm = new CuentaModerada(nuevo, bloqueo);
					}
			}
			
			if(cmd.equals(v.ENVMSJ)){
				String receptor = v.getReceptorMsj();
				String mensaje = v.getTextoMsj();
				
				r.addMsj(receptor, mensaje);
			}
			
			if(cmd.equals(v.LEERMSJ)){
				String usuariomsg = v.getUsuarioMsj();
				Set<String> claves = v.getClvBloqueo();
				
				if(claves==null){
					r.getMsjsClaves(claves);
				}else{
					r.getMsjsCon(usuariomsg);
				}
			}
			
			if(cmd.equals(v.CARGARFICH)){
				String fich = v.getNombreFichero();
				r.cargarDeFichero(fich);
			}
			
			if(cmd.equals(v.GUARDARFICH)){
				r.guardarEnFichero(v.getNombreFichero());
			}
		}
	}
}
