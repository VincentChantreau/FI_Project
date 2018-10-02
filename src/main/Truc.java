package main;

public abstract class Truc {
	// attributs
	private static int id = 1;

	protected int identifiant;
	protected String nom;
	protected String desc;

	protected boolean pickable;
	protected boolean usable;
	protected boolean openable;

	protected boolean visible = true;

	// constructeur
	public Truc(String nom, boolean pick, boolean use, boolean open) {
		this.nom = nom.toUpperCase();
		pickable = pick;
		usable = use;
		openable = open;

		identifiant = id;
		id++;
	}

	// methodes
	public abstract void pick();

	public abstract void use();

	public abstract void open();

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getDesc() {
		return desc;
	}

	public String getNom() {
		return nom;
	}

	public void setDisplay(boolean b) {
		visible = b;
	}
	public boolean isVisible() {
		return visible;
	}
}
