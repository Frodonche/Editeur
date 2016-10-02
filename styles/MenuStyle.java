package editeur.styles;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

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
		
//		newColor.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent arg0) {
//				Color maCouleur = JColorChooser.showDialog(null, "Couleur du texte", Color.BLACK);
//				String nom = JOptionPane.showInputDialog("Nommez votre couleur");
//				if(maCouleur != null){
//					appli.addColor(maCouleur, nom);
//					appli.setColor(maCouleur);
//				}
//			}
//
//		});
		
		newColor.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser choice = new JFileChooser();
				choice.setDialogTitle("Choisir un fichier"); // on ouvre la fenetre et on choisit le fichier
				int retour = choice.showOpenDialog(null);
				
				if (retour == JFileChooser.APPROVE_OPTION) {
					@SuppressWarnings("unused")
					File file = choice.getSelectedFile(); // on le recupere dans une variable
					String jarPath = choice.getSelectedFile().getPath();		
				
					JarFile jarFile;
					try {
						jarFile = new JarFile(jarPath);
					
					Enumeration<JarEntry> e = jarFile.entries();
	
					URL[] urls = { new URL("jar:file:" + jarPath+"!/") };
					URLClassLoader cL = URLClassLoader.newInstance(urls);
	
					while (e.hasMoreElements()) {
						JarEntry je = e.nextElement();
						if(je.isDirectory() || !je.getName().endsWith(".class")){
							continue;
						}
						// -6 because of .class
						String className = je.getName().substring(0,je.getName().length()-6);
						className = className.replace('/', '.');
						@SuppressWarnings("rawtypes")
						Class c;
						try {
								c = cL.loadClass(className);
							//System.out.println(c.getName());
			
							if(Style.class.isAssignableFrom(c)){
								Color tempCoul = (Color)((Style) c.newInstance()).getColor();
								String tempName = (String)((Style) c.newInstance()).getName();
								
								appli.addColor(tempCoul, tempName);
								appli.setColor(tempCoul);
							}
		
						} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					
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
