package main;

import java.util.ArrayList;

import items.Truc;

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
	public void addObjet(Truc o) {
		inventaire.add(o);
	}
}
