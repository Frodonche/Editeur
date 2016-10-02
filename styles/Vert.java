package editeur.styles;

import java.awt.Color;

public class Vert {
	protected String name;
	protected Color coul;

		public Vert(String name, Color coul){
			this.name = "Vert";
			this.coul = Color.green;						
		}
		
		public String getName(){
			return this.name;
		}
		
		public Color getColor(){
			return this.coul;
		}
		
}