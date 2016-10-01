package Modele;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import Vues.Vue;
import editeurtexte.ITexte;

public class TP implements ITexte{
	protected ArrayList<Vue> lesVues;
	protected ArrayList<String> lesLignes;
	
	public TP(){
		this.lesVues = new ArrayList<Vue>();	
		this.lesLignes = new ArrayList<String>();
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
		this.enregistrerSous("default.txt");
	}
	
	public void enregistrerSous(String name){
		Path file = Paths.get(name); //on créé un fichier du nom fichier
	    StringBuilder texteLignes = new StringBuilder(); // on récupère toutes les lignes qu'on place dans un stringbuilder
			for (String s : lesLignes){
				texteLignes.append(s+"|");
			}
	        try {
	            Files.write(file, texteLignes.toString().getBytes()); //on écrit tout dans le fichier
	        } catch (IOException e){}
	}
	
	public void changerCouleurTexte(){
		
	}
	
	public void changerCouleurMenu(){
		
	}
	
	public void changerCouleurFond(){
		
	}
	
	@Override
	public void addLine(String ligne) {
		this.lesLignes.add(ligne);
		majVues();
	}

	@Override
	public void clear() {
		this.lesLignes.clear();
		majVues();
	}

	@Override
	public int getSize() {
		return this.lesLignes.size();
	}

	@Override
	public String getLine(int index) {
		return this.lesLignes.get(index);
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
