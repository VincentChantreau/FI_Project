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
	public void addPV(int pv) {
		this.pv += pv;
	}

	public void add(Truc o) {
		inventaire.add(o);
	}

	public void showInventory() {
		System.out.println("--- INVENTAIRE DE " + nom.toUpperCase() + " ---");
		for (int i = 0; i < inventaire.size(); i++) {
			System.out.println(inventaire.get(i).getNom());
		}
		System.out.println("--- ------------------------- ---");
	}

	public Truc isInInventory(String s) {
		Truc res = null;
		for (int i = 0; i < inventaire.size(); i++) {
			if (inventaire.get(i).getNom().equals(s.toUpperCase()) && inventaire.get(i).isVisible("inventaire"))
				res = inventaire.get(i);
		}
		for (int i = 0; i < equipement.size(); i++) {
			if (equipement.get(i).getNom().equals(s.toUpperCase()) && equipement.get(i).isVisible("equipement"))
				res = equipement.get(i);
		}

		return res;
	}
}
