package main;

public class Roboto {
	// attributs
	String[] picks = { "attraper", "agripper", "empoigner", "prélever", "extraire", "puiser", "appréhender", "saisir",
			"choper", "emprunter", "ôter", "prendre", "ramasser" };
	String[] uses = { "exciper", "user", "manier", "employer", "servir", "appliquer", "utiliser" };
	String[] opens = { "frayer", "découvrir", "dégager", "entrouvrir", "déplier", "déboucher", "percer", "décapsuler",
			"percer", "forcer", "fendre" };

	// constructeur
	public Roboto() {

	}

	// methodes
	public Truc toObject(String s, Salle e) {
		Truc res = null;
		String[] parts = s.split(" ", 2);
		res = e.isInRoom(parts[1]);

		System.out.println(res);
		return res;
	}

	public String interprete(String s) {
		String res = "raw";
		s = s.toUpperCase();

		String parts[] = s.split(" ", 2);

		// System.out.println("\n_Début pick_");
		for (int i = 0; i < picks.length; i++) {
			if (parts[0].equals(picks[i].toUpperCase()))
				res = "pick";
			// else System.out.println("nope");
		}
		// System.out.println("\n_Début use_");
		for (int i = 0; i < uses.length; i++) {
			if (parts[0].equals(uses[i].toUpperCase()))
				res = "use";
			// else System.out.println("nope");
		}
		// TODO last for
		System.out.println(res);
		return res;
	}

	public void doThis(String s, Truc o) {
		switch (s) {
		case "pick":
			o.pick();
			break;
		case "use":
			o.use();
			break;
		case "open":
			o.open();
			break;
		}
	}
}
