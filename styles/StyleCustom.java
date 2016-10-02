package editeur.styles;

import java.awt.Color;

public class StyleCustom {
	protected String name;
	protected Color coul;

		public StyleCustom(String name, Color coul){
			this.name = name;
			this.coul = coul;						
		}
		
		public String getName(){
			return this.name;
		}
		
		public Color getColor(){
			return this.coul;
		}
}
