package prJarrasGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorJarras implements ActionListener{
	VistaJarras vj;
	
	public ControladorJarras(VistaJarras vj){
		this.vj=vj;
	}

	public void actionPerformed(ActionEvent aj) {
		String comando = aj.getActionCommand();
		
		if(comando == "INICIAR"){
			
			
		}if(comando == "LLENAR_A"){
			
	
		}if(comando == "LLENAR_B"){
			

		}if(comando == "VACIAR_A"){
			

		}if(comando == "VACIAR_B"){
			

		}if(comando == "VOLCAR_A_EN_B"){
			

		}if(comando == "VOLCAR_B_EN_A"){
			

		}if(comando == "FINALIZAR"){
			

		}
		
	}
}
