package main;

public class Arme extends Truc {
	// attributs
	protected int bonus = 0;

	public Arme(String nom, boolean pick, boolean use, boolean open, int bonus) {
		super(nom, pick, use, open);
		this.bonus += bonus;

	}

	@Override
	public void pick() {
		System.out.println("Vous ramassez l'arme.");

	}

	@Override
	public void use() {
		System.out.println("Vous ne pouvez utiliser ça de cette façon.\n");

	}

	@Override
	public void open() {
		System.out.println("Vous ne pouvez utiliser ça de cette façon.\n");

	}

}
