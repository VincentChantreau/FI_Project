package items;

public abstract class Truc {
	// attributs
	private static int id = 1;
	
	protected int identifiant;
	protected String nom;
	protected String desc;
	
	protected boolean pickable;
	protected boolean usable;
	protected boolean openable;
	
	// constructeur
	public Truc(String nom, boolean pick, boolean use, boolean open) {
		this.nom = nom;
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
}
