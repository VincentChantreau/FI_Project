package main;

public class Arme extends Truc {
	// attributs
	protected int bonus = 0;

	public Arme(String nom, boolean pick, boolean use, boolean open, String lieu, int bonus) {
		super(nom, pick, use, open, lieu);
		this.bonus += bonus;

	}

	@Override
	public void pick() {
		System.out.println("Vous ramassez l'arme.");
		visible = "inventaire";

	}

	@Override
	public void use() {
		System.out.println("Vous ne pouvez utiliser ça de cette façon.\n");

	}

	@Override
	public void open() {
		System.out.println("Vous ne pouvez utiliser ça de cette façon.\n");

	}

	@Override
	public void use(Hero h) {
		// TODO Auto-generated method stub

	}

}
