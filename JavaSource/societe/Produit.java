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
	
	/*
	 * le constructeur vide du produit
	 */
	public Produit(){
		
	}

	/*
	 * generation auoto des getters et setters
	 */
	public int getProduitID() {
		return produitID;
	}

	public void setProduitID(int produitID) {
		this.produitID = produitID;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getPrix_unitaire() {
		return prix_unitaire;
	}

	public void setPrix_unitaire(int prix_unitaire) {
		this.prix_unitaire = prix_unitaire;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
	
}
