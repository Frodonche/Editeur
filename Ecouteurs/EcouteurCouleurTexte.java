package Ecouteurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Modele.TP;

public class EcouteurCouleurTexte implements ActionListener{
	protected TP appli;
	
	public EcouteurCouleurTexte(TP appli){
		this.appli = appli;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		this.appli.changerCouleurTexte();
		
	}

}
