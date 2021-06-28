package societe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.MysqlDB;

public class Produit {

	/*
	 * les attributs
	 */
	private int produitID;
	private String nom,msg;
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
	
	private List<Produit> prod_liste;
	
	
	/*
	 * liste des produits
	 */
	public List<Produit> getProd_liste() {
		ResultSet result = MysqlDB.extraire_DB("select * from produit");
		if(prod_liste == null)
			prod_liste = new ArrayList<Produit>();
		else
			prod_liste.clear();
		
		try {
			while(result.next()){
				prod_liste.add(new Produit(result.getString("nom"),
						result.getInt("prix_unitaire"),result.getInt("quantite")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prod_liste;
	}

	/*
	 * le constructeur vide du produit
	 */
	public Produit(){
		
	}
	
	private List<Produit> list_produit = new ArrayList<Produit>();
	/*
	 * ajouter un produit
	 */
	public void add_produit(){
		
		int msg = MysqlDB.update_Bd("insert into produit(nom,prix_unitaire,quantite) "+
				"values('"+this.nom+"','"+this.prix_unitaire+"','"+this.quantite+"')");
		
		if(msg>0){
			this.msg = "ok,vous avez enregistre le produit avec succes";
			return;
		}else
			this.msg ="desole,erreur d'enregistrement";
			
	}

	/*
	 * generation automatique des getters et setters
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

	public List<Produit> getList_produit() {
		return list_produit;
	}

	public String getMsg() {
		return msg;
	}
	/*
	 * la modification du produit
	 */
	public static void update(){
		
	}
	public static void delete(){
		
	}

	public static Produit getProduit(int int1) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
