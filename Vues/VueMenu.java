package Vues;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import Ecouteurs.EcouteurCouleurFond;
import Ecouteurs.EcouteurCouleurMenu;
import Ecouteurs.EcouteurCouleurTexte;
import Ecouteurs.EcouteurEnregistrer;
import Ecouteurs.EcouteurEnregistrerSous;
import Ecouteurs.EcouteurNouveau;
import Ecouteurs.EcouteurOuvrir;
import Ecouteurs.EcouteurQuitter;
import Modele.TP;

@SuppressWarnings("serial")
public class VueMenu extends JPanel implements Vue{
	protected TP appli;
	public JMenuBar menuBar;
	protected JMenu fichier;
	protected JMenu style;
	protected JToolBar toolBar;
	
	protected JMenuItem nouveau;
	protected JMenuItem ouvrir;
	protected JMenuItem enregistrer;
	protected JMenuItem enregistrerSous;
	protected JMenuItem quitter;
	
	protected JMenuItem couleurTexte;
	protected JMenuItem couleurMenu;
	protected JMenuItem couleurFond;
	
	public VueMenu(TP appli){
		super();
		this.appli = appli;
		
		this.menuBar = new JMenuBar();
		this.fichier = new JMenu("Fichier");
		this.style = new JMenu("Style");
		
		this.menuBar.add(fichier);
		this.menuBar.add(style);
		
		this.nouveau = new JMenuItem ("Nouveau");
		this.ouvrir = new JMenuItem ("Ouvrir");
		this.enregistrer = new JMenuItem ("Enregistrer");
		this.enregistrerSous = new JMenuItem ("EnregistrerSous");
		this.quitter = new JMenuItem ("Quitter");
		
		
		this.fichier.add(this.nouveau);
		this.fichier.add(this.ouvrir);
		this.fichier.add(this.enregistrer);
		this.fichier.add(this.enregistrerSous);
		this.fichier.add(this.quitter);
		
		this.nouveau.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				appli.clear();
			}
		});
		
		this.ouvrir.addActionListener(new EcouteurOuvrir(appli));
		this.enregistrer.addActionListener(new EcouteurEnregistrer(appli));
		this.enregistrerSous.addActionListener(new EcouteurEnregistrerSous(appli));
		this.quitter.addActionListener(new EcouteurQuitter());
		
		this.couleurTexte = new JMenuItem("Couleur Texte");
		this.couleurMenu = new JMenuItem("Couleur Menu");
		this.couleurFond = new JMenuItem("Couleur Fond");
		
		this.style.add(this.couleurTexte);
		this.style.add(this.couleurMenu);
		this.style.add(this.couleurFond);
		
		this.couleurTexte.addActionListener(new EcouteurCouleurTexte(appli));
		this.couleurMenu.addActionListener(new EcouteurCouleurMenu(appli));
		this.couleurFond.addActionListener(new EcouteurCouleurFond(appli));
		
		
		this.appli.ajouterVue(this);
		mettreAJour();
	}
	
	public JMenuBar getMenuBar(){
		return this.menuBar;
	}
	
	@Override
	public void mettreAJour() {
	}

}
