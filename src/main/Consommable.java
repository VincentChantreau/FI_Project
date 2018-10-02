package main;

public abstract class Consommable extends Truc {

	// attributs
	protected int nombre;

	public Consommable(String nom, boolean pick, boolean use, boolean open, String lieu, int nombre) {
		super(nom, pick, use, open, lieu);
		this.nombre = nombre;
	}

	public abstract void use(Hero h);

}
