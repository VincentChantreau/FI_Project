package rooms;

public abstract class Salle {
	// attributs
	private static int id;
	
	protected int identite;
	protected int liens[];
	protected String nom;
	protected String desc;
	
	// constructeur
	public Salle(String nom) {
		identite = id;
		this.nom = nom;
		
		id++;
	}
	
	// methodes
	
}
