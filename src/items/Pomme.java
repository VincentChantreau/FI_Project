package items;

import main.Consommable;
import main.Hero;

public class Pomme extends Consommable {

	public Pomme(String nom, boolean pick, boolean use, boolean open, int nombre) {
		super(nom, pick, use, open, nombre);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void use(Hero h) {
		h.addPV(4);

	}

	@Override
	public void pick() {
		// TODO Auto-generated method stub

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
