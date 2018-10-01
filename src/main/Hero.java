package main;

import java.util.ArrayList;

public class Hero {
	// attribut
	protected String nom;
	protected int pv = 100;
	
	protected ArrayList<Truc> inventaire;
	protected ArrayList<Truc> equipement;
	
	protected int degats;
	protected int armure = 10;
	
	// constructeur
	public Hero(String nom) {
		this.nom = nom;
		inventaire = new ArrayList<Truc>();
		equipement = new ArrayList<Truc>();
	}
	
	// methodes
	public Truc pickUp(Truc o) {
		if(o.pickable == true) {
			inventaire.add(o);
			o.setDisplay(false);
		}
		else System.out.println("On ne peut ramasser ceci.\n");
		return o;
	}
	public void addPV(int pv) {
		this.pv += pv;
	}
}
