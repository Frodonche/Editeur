package editeur.Vues;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import editeur.Modele.TP;

@SuppressWarnings("serial")
public class VueTexte extends JPanel implements Vue{

	protected TP appli;
	protected JTextArea texte;
	
	public VueTexte(TP appli){
		this.appli = appli;
			
		// Affichage texte
		this.texte = new JTextArea();
		this.texte.setEditable(false);
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
		this.texte.setForeground(this.appli.getCurrentColor());
	}

}
