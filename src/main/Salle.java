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
		this.nom = nom.toLowerCase();

		id++;
	}

	// methodes
	public void addObjet(Truc o) {
		contient.add(o);
	}

	public void remove(Truc o) {
		contient.remove(o);
	}

	public String getNom() {
		return nom;
	}

	public Truc isInRoom(String s) {
		Truc res = null;
		for (int i = 0; i < contient.size(); i++) {
			if (contient.get(i).getNom().equals(s.toUpperCase()) && contient.get(i).isVisible(nom))
				res = contient.get(i);
		}

		return res;
	}

	public void listerObjets() {
		int i;
		System.out.print("Liste des objets de la pi�ce : \n");
		for (i = 0; i < contient.size(); i++) {
			if (contient.get(i).isVisible(nom))
				System.out.print(contient.get(i).getNom() + ", ");
		}
	}
}
