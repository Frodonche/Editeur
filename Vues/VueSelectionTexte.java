package Vues;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Modele.TP;

@SuppressWarnings("serial")
public class VueSelectionTexte extends JPanel implements Vue{

	protected TP appli;
	protected JTextField selection;
	
	public VueSelectionTexte(TP appli){
		this.appli = appli;
		this.selection = new JTextField();
		this.selection.setSize(15,15);
		this.add(selection);
		this.appli.ajouterVue(this);
		
		mettreAJour();
	}
	
	@Override
	public void mettreAJour() {
		// TODO Auto-generated method stub
		
	}

}
