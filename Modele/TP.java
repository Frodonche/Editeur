package Modele;

import java.util.ArrayList;

import Vues.Vue;
import editeurtexte.ITexte;

public class TP implements ITexte{
	protected ArrayList<Vue> lesVues;
	public TP(){
		this.lesVues = new ArrayList<Vue>();	
	}
	
	public void majVues(){
		for(Vue v : lesVues){
			v.mettreAJour();
		}
	}
	
	public void ajouterVue(Vue v){
		this.lesVues.add(v);
	}
	
	public void ouvrir(){
		
	}
	
	public void enregistrer(){
		
	}
	
	public void enregistrerSous(){
		
	}
	
	public void changerCouleurTexte(){
		
	}
	
	public void changerCouleurMenu(){
		
	}
	
	public void changerCouleurFond(){
		
	}
	
	@Override
	public void addLine(String ligne) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getLine(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getLineCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setLine(int i, String ligne) {
		// TODO Auto-generated method stub
		
	}
}
