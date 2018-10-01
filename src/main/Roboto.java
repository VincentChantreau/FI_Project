package main;

public class Roboto {
	// attributs
	String[] picks = { "attraper", "agripper", "empoigner", "prélever", "extraire", "puiser", "appréhender", "saisir",
			"choper", "emprunter", "ôter", "prendre" };
	String[] uses = { "exciper", "user", "manier", "employer", "servir", "appliquer", "utiliser" };
	String[] opens = { "frayer", "découvrir", "dégager", "entrouvrir", "déplier", "déboucher", "percer", "décapsuler",
			"percer", "forcer", "fendre" };

	// constructeur
	public Roboto() {

	}

	// methodes
	public String toObject(String s) {
		String[] parts = s.split(" ", 2);
		return parts[1];
	}
	public String interprete(String s) {
		String res = "";
		for (int i = 0; i < picks.length; i++) {
			if (s.equalsIgnoreCase(picks[i]))
				res = "pick";
		}
		for (int i = 0; i < uses.length; i++) {
			if (s.equalsIgnoreCase(uses[i]))
				res = "use";
		}
		// TODO last for

		return res;
	}

	public void doThis(String s, Truc o) {
		switch(s) {
		case "pick":
			o.pick();
			break;
		}
	}
}
