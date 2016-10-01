package Vues;


import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
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
	
	protected JMenuItem rouge;
	protected JMenuItem noir;
	protected JMenu couleurCustom;
	protected JMenuItem newColor;

	
	public VueMenu(TP appli){
		super();
		this.appli = appli;
		
		this.menuBar = new JMenuBar();
		this.fichier = new JMenu("Fichier");
		this.style = new JMenu("Style");
		
		///////////////// MENU FICHIER ////////////////
		
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
				appli.clearLines();
				JFileChooser choice = new JFileChooser();
				choice.setDialogTitle("Choisir un fichier"); // on ouvre la fenetre et on choisit le fichier
				int retour = choice.showOpenDialog(null);
				
				if (retour == JFileChooser.APPROVE_OPTION) {
					File file = choice.getSelectedFile(); // on le recupere dans une variable
				    try {
				    	Scanner lecteur = new Scanner(file);
						lecteur.useDelimiter("\n"); // on set le separateur
						while(lecteur.hasNext()){
							appli.addLine(lecteur.next());
						}
						
						lecteur.close();
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
				}
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
				String nom = JOptionPane.showInputDialog("Entrez un nom");
				appli.enregistrerSous(nom+".txt");
				JOptionPane.showConfirmDialog(VueMenu.JPanel, "Enregistré !", "Confirmation", JOptionPane.DEFAULT_OPTION);
			}
		});
		
		this.quitter.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		///////////////////////   COULEUR TEXTE ///////////////////
		
		this.rouge = new JMenuItem("Rouge");
		this.style.add(this.rouge);
		
		this.noir = new JMenuItem("Noir");
		this.style.add(this.noir);
		
		this.couleurCustom = new JMenu("Mes couleurs");
		this.style.add(couleurCustom);
		this.newColor = new JMenuItem("Nouvelle couleur");
		this.couleurCustom.add(this.newColor);
		
		this.rouge.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				appli.setColor(Color.RED);
			}
		});
		
		this.noir.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				appli.setColor(Color.BLACK);
			}
		});
		
		
		this.newColor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				Color maCouleur = JColorChooser.showDialog(null, "Couleur du texte", Color.BLACK);
				String nom = JOptionPane.showInputDialog("Nommez votre couleur");
				if(maCouleur != null){
					appli.addColor(maCouleur, nom);
					appli.setColor(maCouleur);
				}
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
