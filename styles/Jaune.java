package editeur.styles;

import java.awt.Color;

public class Jaune {
	protected String name;
	protected Color coul;

		public Jaune(String name, Color coul){
			this.name = "Jaune";
			this.coul = Color.yellow;						
		}
		
		public String getName(){
			return this.name;
		}
		
		public Color getColor(){
			return this.coul;
		}
		
}