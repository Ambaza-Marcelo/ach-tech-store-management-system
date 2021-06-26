package societe;

public class Client {
	/*
	 * les attributs
	 */
	private int clientID;
	private String nom;
	private String prenom;
	private String adresse;
	private int telephone;
	private Produit produitID;
	
	/*
	 * le constructeur de la classe Client
	 */
	public Client(String nom,String prenom,String adresse,int telephone){
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
	}
}
