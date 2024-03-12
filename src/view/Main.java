package view;

import javax.swing.JOptionPane;
import controller.RedesController;

public class Main {
	public static void main(String[] args) {
		RedesController rd = new RedesController(); 
		
		int opc = 0; 
		
		while(opc!= 9) {
			opc = Integer.parseInt(JOptionPane.showInputDialog("1 - Método IP \n2 - Método Ping \n9 - Finalizar Programa")); 
			
			switch(opc){
			case 1: rd.IP();
				break; 
			case 2: rd.ping();
				break;
			case 9: JOptionPane.showMessageDialog(null,"Programa Finalizado.");
				break; 
				default: JOptionPane.showMessageDialog(null,"Opção Inválida!"); 
			}

		}
		
	}
	

}
