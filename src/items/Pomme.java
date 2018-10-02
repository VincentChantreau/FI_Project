package items;

import main.Consommable;
import main.Hero;

public class Pomme extends Consommable {

	public Pomme(String nom, boolean pick, boolean use, boolean open, String lieu, int nombre) {
		super(nom, pick, use, open, lieu, nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void use(Hero h) {
		h.addPV(4);
		System.out.print("Vous dévorez une pomme,");
		System.out.println(" vous récupérez 4 points de vie.");
	}

	@Override
	public void pick() {
		// TODO Auto-generated method stub
		System.out.println("Vous ramassez " + nombre + " pommes.");
		visible = "inventaire";

	}

	@Override
	public void use() {
		// TODO Auto-generated method stub

	}

	@Override
	public void open() {
		// TODO Auto-generated method stub

	}

}
