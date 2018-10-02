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

	public Truc isInRoom(String o) {
		Truc res = null;
		for (int i = 0; i < contient.size(); i++) {
			if (contient.get(i).getNom().equals(o.toUpperCase()))
				res = contient.get(i);
		}

		return res;
	}
}
