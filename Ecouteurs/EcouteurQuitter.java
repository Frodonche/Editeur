package Ecouteurs;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class EcouteurQuitter implements ActionListener{
	
	public EcouteurQuitter() {

	}
	
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}