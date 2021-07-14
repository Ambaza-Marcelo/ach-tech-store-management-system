package societe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import DB.MysqlDB;

public class Client {
	/*
	 * les attributs
	 */
	private int clientID;
	private String nom,msg;
	private String prenom;
	private String adresse;
	private int telephone;
	private Produit produitID;
	private int quantite;
	
	
	/*
	 * le constructeur de la classe Client
	 */
	public Client(int clientID,String nom,String prenom,String adresse,int telephone,Produit prod,int quantite){
		this.clientID = clientID;
		this.nom = nom;
		this.prenom = prenom;
		
	}
	
	public void get_client_with_produit(List<SelectItem> list){
		ResultSet result = MysqlDB.extraire_DB("select * from client where produitID="
				+produitID.getProduitID());
		if(list==null)
			list = new ArrayList<SelectItem>();
		else
			list.clear();
		
		if(result != null)
			try {
				while(result.next())
					list.add(new SelectItem(result.getInt("clientID"),result.getString("nom")));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	/*
	 * le constructeur vide du client
	 */
	
	public Client(){
		
	}
	
	private List<Client> client_list;
	
	

	/*
	 * list des clients
	 */


	public List<Client> getClient_list() {
		ResultSet result = MysqlDB.extraire_DB("select * from client");
		if(client_list==null)
			client_list = new ArrayList<Client>();
		else
			client_list.clear();
		
		if(result != null){
			try {
				while(result.next()){
					client_list.add(new Client(result.getInt("clientID"),result.getString("nom")
							,result.getString("prenom"),result.getString("adresse")
							,result.getInt("telephone"),Produit.getProduit(result.getInt("produitID")),
							result.getInt("quantite")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return client_list;
	}
	
	public static Client getClient_Objet(int clID){
		
		Client el=null;
		ResultSet result=MysqlDB.extraire_DB("select * from client where clientID="+clID);
		
		if(result!=null)
			try {
				if(result.next())
					el=new Client(result.getInt("clientID"),result.getString("nom"),
							result.getString("prenom"),
							result.getString("adresse"),
							result.getInt("telephone"),
							Produit.getProduit(result.getInt("produitID")),result.getInt("quantite"));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return el;
	}
	
	/*
	 * select Item list
	 */
	private List<SelectItem> list_produit;
	
	/*
	 * liste des produits
	 */

	public List<SelectItem> getList_produit() {
		
		ResultSet result = MysqlDB.extraire_DB("select * from produit");
		if(list_produit == null)
			list_produit = new ArrayList<SelectItem>();
		else
			list_produit.clear();
		if(result != null){
			try {
				while(result.next()){
					list_produit.add(new SelectItem(result.getInt("produitID"),result.getString("nom"),
							result.getInt("prix_unitaire")+""+""+""));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list_produit;
	}
	
	/*
	 * tableau dynamique
	 */
	private List<Client> list_client = new ArrayList<Client>();
	/*
	 * ajouter un client
	 */
	public void add_client(){
		int msg = MysqlDB.update_Bd("insert into client(nom,prenom,adresse,telephone,produitID,quantite) values('"+this.nom
				+"','"+this.prenom+"','"+this.adresse+"','"+this.telephone
				+"','"+this.produitID.getProduitID()+"','"+this.quantite+"')");
		if(msg>0)
			this.msg = "enregistrement avec succes";
		else
			this.msg = "desole,erreur d'enregistement";
	}

	/*
	 * les accesseurs et les mutateurs
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
	
	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	
	public Produit getProduitID() {
		return produitID;
	}

	public void setProduitID(Produit produitID) {
		this.produitID = produitID;
	}
	/*
	 * modifier un client
	 */
	public void update(){
		
	}
	/*
	 * supprimer un client
	 */
	public void delete(){
		
	}
	
}
