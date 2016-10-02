package editeur.styles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import editeur.modele.TP;

@SuppressWarnings("serial")
public class MenuStyle extends JMenu{
	protected TP appli;
	protected JMenu couleurCustom;
	
	public MenuStyle(TP appli, String name){
		super();
		this.appli = appli;
		this.setText(name);
		
		
		/// POUR MES COULEURS ////
		
		this.couleurCustom = new JMenu("Mes couleurs");
		this.add(couleurCustom);
		
				
		///// POUR LE ROUGE /////
		
		JMenuItem rouge = new JMenuItem("Rouge");
		rouge.setForeground(Color.RED);
		this.add(rouge);

		rouge.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				appli.setColor(Color.RED);
			}
		});
		
		
		/// POUR LE NOIR //////
		
		JMenuItem noir = new JMenuItem("Noir");
		this.add(noir);
		
		noir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				appli.setColor(Color.BLACK);
			}
		});
		
		// NOUVELLE COULEUR //
		JMenuItem newColor = new JMenuItem("Nouvelle couleur");
		this.add(newColor);
		
		newColor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				Color maCouleur = JColorChooser.showDialog(null, "Couleur du texte", Color.BLACK);
				String nom = JOptionPane.showInputDialog("Nommez votre couleur");
				if(maCouleur != null){
					appli.addColor(maCouleur, nom);
					appli.setColor(maCouleur);
				}
			}

		});
		
	}

	public void mettreAJour() {
		this.couleurCustom.removeAll(); // on nettoie le menu	
		for (int i = this.appli.getColorNumber()-1 ; i >= 0; i--){ // on parcourt la liste de couleur à l'envers pour ajouter les eléments du menu
			StyleCustom styleTemp = new StyleCustom(this.appli.getColorName(i), this.appli.getColor(i)); // on créé un style 
			
			JMenuItem temp = new JMenuItem(styleTemp.getName()); // on récupère son nom pour nommer le menu item
			
			temp.setForeground(styleTemp.getColor()); // idem pour la couleur
			this.couleurCustom.add(temp);		
			
			temp.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent arg0) {
					appli.setColor(styleTemp.getColor()); // on dit au modèle de set une nouvelle couleur courante
				}
			});
		}
	}
}
