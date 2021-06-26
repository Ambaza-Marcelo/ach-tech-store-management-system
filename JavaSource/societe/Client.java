package societe;

import java.util.List;

import javax.faces.model.SelectItem;

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
	
	private List<SelectItem> list_client;
	
	/*
	 * le constructeur de la classe Client
	 */
	public Client(String nom,String prenom,String adresse,int telephone){
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
	}
	
	
	/*
	 * le constructeur vide du client
	 */
	
	public Client(){
		
	}

	/*
	 * generation auto des getters et setters
	 */
	
	public int getClientID() {
		return clientID;
	}

	public void setClientID(int clientID) {
		this.clientID = clientID;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
}
