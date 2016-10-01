package Ecouteurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.TP;

public class EcouteurCouleurMenu implements ActionListener{
	protected TP appli;
	
	public EcouteurCouleurMenu(TP appli){
		this.appli = appli;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.appli.changerCouleurMenu();
		
	}

}
