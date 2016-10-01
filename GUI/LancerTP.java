package editeur.GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

import editeur.Modele.TP;
import editeur.Vues.VueMenu;
import editeur.Vues.VueSelectionTexte;
import editeur.Vues.VueTexte;

@SuppressWarnings("serial")
public class LancerTP extends JFrame{

	public LancerTP(){
		
		super("Editeur");
		setPreferredSize(new Dimension(1000, 600));
		
		TP appli = new TP();
		
		VueMenu vueM = new VueMenu(appli);
		this.setJMenuBar(vueM.getMenuBar());
		
		VueSelectionTexte vueS = new VueSelectionTexte(appli);
		this.add(vueS, BorderLayout.SOUTH);
		
		VueTexte vueT = new VueTexte(appli);
		this.add(vueT, BorderLayout.NORTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack() ;
		setVisible(true) ;	
	}
	
	
	
	public static void main(String[] args){
		new LancerTP();
	}
}
