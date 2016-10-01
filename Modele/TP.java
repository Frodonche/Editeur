package Modele;

import java.awt.Color;
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
	protected Color currentColor;
	protected Color defaultColor;
	protected ArrayList<Color> mesCouleurs;
	protected ArrayList<String> mesCouleursNoms;
	
	public TP(){
		this.lesVues = new ArrayList<Vue>();	
		this.lesLignes = new ArrayList<String>();
		this.currentColor = Color.BLACK;
		this.defaultColor = Color.BLACK;
		this.mesCouleurs = new ArrayList<Color>();
		this.mesCouleursNoms = new ArrayList<String>();
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
				texteLignes.append(s+"\n");
			}
	        try {
	            Files.write(file, texteLignes.toString().getBytes()); //on écrit tout dans le fichier
	        } catch (IOException e){}
	}
	
	@Override
	public void addLine(String ligne) {
		this.lesLignes.add(ligne);
		majVues();
	}

	@Override
	public void clear() { //pour le reset total de l'appli
		this.lesLignes.clear();
		this.currentColor = this.defaultColor;
		majVues();
	}
	
	public void clearLines(){ //pour le reset du texte uniquement
		this.lesLignes.clear();
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

	public void setColor(Color color) {
		this.currentColor = color;
		majVues();
	}
	
	public Color getCurrentColor(){
		return this.currentColor;
	}
	
	public void addColor(Color coul, String nom){
		this.mesCouleurs.add(coul);
		this.mesCouleursNoms.add(nom);
	}
}
