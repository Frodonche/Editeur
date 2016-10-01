package editeur.Vues;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import editeur.Modele.TP;

@SuppressWarnings("serial")
public class VueSelectionTexte extends JPanel implements Vue{

	protected TP appli;
	protected JTextField selection;
	protected JButton valider;
	
	public VueSelectionTexte(TP appli){
		this.appli = appli;
		
		// Zone de selection du texte
		this.selection = new JTextField();	
		this.selection.setColumns(60);
		this.add(selection);
		
		// Bouton de validation
		this.valider = new JButton("Valider");	
		this.valider.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				appli.addLine(selection.getText());
				selection.setText("");
			}
		});
		
		this.add(valider);
		
		
		this.appli.ajouterVue(this);
		
		mettreAJour();
	}
	
	@Override
	public void mettreAJour() {
		// TODO Auto-generated method stub
		
	}

}
