package tools;

import main.Hero;
import main.Salle;
import main.Truc;

public class Bot {
	// interpreteur
	public static void faire(String clavier, Salle salle, Hero h) {
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

		// traitement de la chaine
		String s = StringOperation.sansAccents(clavier);
		s = s.toLowerCase();
		// division des verbes et des objets
		String[] parts = s.split(" ", 2);
		String action = "";
		// récupération de l'objet
		boolean isHere = false;
		Truc objet = salle.isInRoom(parts[1]);
		if (objet == null) {
			// on regarde dans l'inventaire
			objet = h.isInInventory(parts[1]);
			if (objet == null)
				action = "noObj";
		} // objet trouvé !

		for (int i = 0; i < picks.length; i++) {
			if (parts[0].equals(picks[i].toLowerCase()))
				action = "pick";
		}
		for (int i = 0; i < uses.length; i++) {
			if (parts[0].equals(uses[i].toLowerCase()))
				action = "use";
		}
		for (int i = 0; i < opens.length; i++) {
			if (parts[0].equals(opens[i].toLowerCase()))
				action = "open";
		}
		for (int i = 0; i < eats.length; i++) {
			if (parts[0].equals(eats[i].toLowerCase()))
				action = "eat";
		}
		// action réelle
		if (action.equals("eat") || action.equals("use")) {
			if (objet.getClass().getSuperclass().getName().equals("main.Consommable"))
				action = "eat";
			else
				action = "dumb";
		}

		if (objet == null) {
			action = "noobj";
		} else if (!objet.isVisible())
			action = "noobj";

		System.out.println("action : " + action);
		System.out.println("objet : " + objet);

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
			break;
		case "open":
			objet.open();
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

	}
}
