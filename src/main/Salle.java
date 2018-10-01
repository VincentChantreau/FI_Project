package main;

import java.util.ArrayList;

public class Salle {
	// attributs
	private static int id;
	
	protected int identite;
	protected int liens[];
	protected ArrayList<Truc> contient;
	
	protected String nom;
	protected String desc;
	
	// constructeur
	public Salle(String nom) {
		contient = new ArrayList<Truc>();
		identite = id;
		this.nom = nom;
		
		id++;
	}
	
	// methodes
	public void addObjet(Truc o) {
		contient.add(o);
	}
}
