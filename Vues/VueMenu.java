package Vues;


import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import Modele.TP;

@SuppressWarnings("serial")
public class VueMenu extends JPanel implements Vue{
	protected static final Component JPanel = null;
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
		
		this.ouvrir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				////
			}
		});
		
		this.enregistrer.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				appli.enregistrer();
				JOptionPane.showConfirmDialog(VueMenu.JPanel, "Enregistré !", "Confirmation", JOptionPane.DEFAULT_OPTION);
			}
		});
		
		this.enregistrerSous.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane demande = new JOptionPane();
				String nom = demande.showInputDialog("Entrez un nom");
				appli.enregistrerSous(nom+".txt");
				demande.showConfirmDialog(VueMenu.JPanel, "Enregistré !", "Confirmation", JOptionPane.DEFAULT_OPTION);
			}
		});
		
		this.quitter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		this.couleurTexte = new JMenuItem("Couleur Texte");
		this.couleurMenu = new JMenuItem("Couleur Menu");
		this.couleurFond = new JMenuItem("Couleur Fond");
		
		this.style.add(this.couleurTexte);
		this.style.add(this.couleurMenu);
		this.style.add(this.couleurFond);
		
		this.couleurTexte.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				appli.clear();
			}
		});
		
		this.couleurMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				appli.clear();
			}
		});
		
		this.couleurFond.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				appli.clear();
			}
		});
		
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
