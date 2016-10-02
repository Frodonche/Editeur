package editeur.styles;

import java.awt.Color;

public class Style {
	protected Color coul;
	
	public Style(Color coul){
		this.coul = coul;
	}
	
	public Color getColor(){
		return this.coul;
	}
	
	public String getName(){
		return this.getClass().toString();
	}
}
