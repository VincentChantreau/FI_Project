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

	protected String visible = "";

	// constructeur
	public Truc(String nom, boolean pick, boolean use, boolean open, String lieu) {
		this.nom = nom.toUpperCase();
		pickable = pick;
		usable = use;
		openable = open;
		visible = lieu;

		identifiant = id;
		id++;
	}

	// methodes
	public abstract void pick();

	public abstract void use();

	public abstract void use(Hero h);

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

	public boolean usable() {
		return usable;
	}

	public void setDisplay(String b) {
		visible = b;
	}

	public boolean isVisible(String emplacement) {
		boolean res = false;
		if (visible.equals(emplacement.toLowerCase()))
			res = true;
		return res;
	}
}
