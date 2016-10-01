package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

import Modele.TP;
import Vues.VueMenu;
import Vues.VueSelectionTexte;

@SuppressWarnings("serial")
public class LancerTP extends JFrame{

	public LancerTP(){
		
		super("CPOA-TP");
		setPreferredSize(new Dimension(1000, 600));
		
		TP appli = new TP();
		
		VueMenu vueM = new VueMenu(appli);
		this.setJMenuBar(vueM.getMenuBar());
		
		VueSelectionTexte vueS = new VueSelectionTexte(appli);
		this.add(vueS, BorderLayout.SOUTH);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack() ;
		setVisible(true) ;	
	}
	
	
	
	public static void main(String[] args){
		new LancerTP();
	}
}
