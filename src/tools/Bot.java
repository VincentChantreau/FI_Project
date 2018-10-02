package tools;

import main.Hero;
import main.Salle;
import main.Truc;

public class Bot {
	// attributs
	static String action = null;
	static Truc objet = null;
	static String mode = "BASIC";
	static String raw_action = null;
	static String raw_objet = null;

	// methodes pour interpreteur
	private static void getVerbe() {
		// dictionnaire
		String[] picks = { "attraper", "agripper", "empoigner", "prelever", "extraire", "puiser", "apprehender",
				"saisir", "choper", "emprunter", "oter", "prendre", "ramasser" };
		String[] uses = { "exciper", "user", "manier", "employer", "servir", "appliquer", "utiliser" };
		String[] opens = { "frayer", "decouvrir", "degager", "entrouvrir", "deplier", "deboucher", "percer",
				"decapsuler", "percer", "forcer", "fendre" };
		String[] eats = { "manger", "ingerer", "consommer", "devorer", "avaler", "absorber", "chipoter", "croquer",
				"grignoter", "ingurgiter", "boulotter", "bouffer", "becqueter", "crouter", "briffer", "dejeuner",
				"diner", "gouter", "souper", "brouter", "paitre", "paturer", "picorer", "consumer", "bruler", "devorer",
				"ruiner", "depenser", "dilapider", "engloutir", "ronger", "attaquer", "recouvrir", "dissimuler",
				"gaspiller" };

		// traitement
		for (int i = 0; i < picks.length; i++) {
			if (raw_action.equals(picks[i].toLowerCase()))
				action = "pick";
		}
		for (int i = 0; i < uses.length; i++) {
			if (raw_action.equals(uses[i].toLowerCase()))
				action = "use";
		}
		for (int i = 0; i < opens.length; i++) {
			if (raw_action.equals(opens[i].toLowerCase()))
				action = "open";
		}
		for (int i = 0; i < eats.length; i++) {
			if (raw_action.equals(eats[i].toLowerCase()))
				action = "eat";
		}
		if (raw_action.equals("inventaire") || raw_action.equals("sac")) {
			action = "inventaire";
		}
	}

	private static void getObjet(Salle s, Hero h) {
		objet = s.isInRoom(raw_objet);
		if (objet == null) {
			// on regarde dans l'inventaire
			objet = h.isInInventory(raw_objet);
		}
	}

	// interpreteur
	public static void faire(String clavier, Salle salle, Hero h) {
		// reinitialisation
		mode = "BASIC";
		action = null;
		objet = null;
		raw_action = null;
		raw_objet = null;
		// traitement de la chaine
		String s = StringOperation.sansAccents(clavier);
		s = s.toLowerCase();
		// division des verbes et des objets
		String[] parts = s.split(" ", 2);
		raw_action = parts[0];
		// ACTION
		getVerbe();

		// OBJET
		if (parts.length == 1) {
			raw_objet = null;
			objet = null;
			mode = "NO_OBJECT";
		} else {
			raw_objet = parts[1];
			getObjet(salle, h);
		}

		// DO IT FAGGOT
		System.out.println("ACTION : " + action);
		System.out.println("OBJET : " + objet);
		// -----------------------------------------------------------------------------------
		switch (mode) {
		case "NO_OBJECT":
			switch (action.toLowerCase()) {
			case "inventaire":
				h.showInventory();
				break;
			default:
				System.out.println("Erreur action");
				break;
			}
			break;
		case "BASIC":
			if (action.equals("eat") || action.equals("use")) {
				if (objet.getClass().getSuperclass().getName().equals("main.Consommable"))
					action = "eat";
				else
					action = "dumb";
			}
			if (objet == null || !objet.isVisible(salle.getNom()) || !objet.isVisible("inventaire"))
				action = "noobj";

			switch (action.toLowerCase()) {
			case "pick":
				objet.pick();
				salle.remove(objet);
				h.add(objet);
				break;
			case "use":
				objet.use();
				break;
			case "eat":
				objet.use(h);
				objet.setDisplay("");
				break;
			case "open":
				objet.open();
				break;
			case "inventaire":
				h.showInventory();
				break;
			case "dumb":
				System.out.print("Vraiment ?");
				System.out.println(" On ne peut pas manger ceci..");
				break;
			case "noobj":
				System.out.println("Il n'y a rien de la sorte ici.");
				break;
			default:
				System.out.println("Désolé, je n'ai pas compris.");
				break;
			}
			break;
		default:
			System.out.println("ERREUR MODE");
			break;
		}
	}
}
