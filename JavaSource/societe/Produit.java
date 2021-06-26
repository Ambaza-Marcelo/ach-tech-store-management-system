package societe;

public class Produit {

	/*
	 * les attributs
	 */
	private int produitID;
	private String nom;
	private int prix_unitaire;
	private int quantite;
	
	/*
	 * le constructeur de la classe Produit
	 */
	public Produit(String nom,int prix_unitaire,int quantite){
		this.nom = nom;
		this.prix_unitaire = prix_unitaire;
		this.quantite = quantite;
	}
}
