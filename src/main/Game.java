package main;

import java.util.Scanner;

import items.Pomme;
import tools.Bot;

public class Game {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner clavier = new Scanner(System.in);

		System.out.println("Salutation aventurier, veuillez renseigner votre nom :");
		Hero character = new Hero(clavier.nextLine());

		Salle cuisine = new Salle("cuisine");
		Arme epee = new Arme("�p�e courte", true, true, false, cuisine.getNom(), 2);
		Consommable pommes = new Pomme("pomme", true, true, false, cuisine.getNom(), 2);

		cuisine.addObjet(pommes);
		cuisine.addObjet(epee);

		System.out.println("Vous �tes dans une cuisine, il y a des pommes sur la table.");
		System.out.println("Il y a �galement une " + epee.getNom() + " ici.");

		// d�but
		while (true) {
			cuisine.listerObjets();

			System.out.println("que faites vous ?\n");

			String rep = clavier.nextLine();
			Bot.faire(rep, cuisine, character);

			// System.out.println("Classe de Pomme : " +
			// pommes.getClass().getSuperclass().getName());

		}
	}

}
