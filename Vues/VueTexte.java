package Vues;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Modele.TP;

@SuppressWarnings("serial")
public class VueTexte extends JPanel implements Vue{

	protected TP appli;
	protected JTextArea texte;
	
	public VueTexte(TP appli){
		this.appli = appli;
			
		// Affichage texte
		this.texte = new JTextArea();
		this.add(this.texte);
		
		
		this.appli.ajouterVue(this);
		
		mettreAJour();
	}
	
	@Override
	public void mettreAJour() {
		this.texte.setText("");
		for (int i = 0; i < this.appli.getSize(); i++){
			this.texte.append(this.appli.getLine(i)+"\n");
		}
	}

}
