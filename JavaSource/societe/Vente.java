package societe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.MysqlDB;

public class Vente {

	/*
	 * les attributs
	 */
	private int venteID;
	private String description;
	private int quantite;
	private int prix_vente;
	private String msg;
	
	/*
	 * le constructeur de la classe Vente
	 */
	public Vente(int venteID,String description,int quantite,int prix_vente){
		this.venteID = venteID;
		this.description = description;
		this.quantite = quantite;
		this.prix_vente = prix_vente;
	}
	
	private List<Vente> vente_list;
	
	
	
	/*
	 * le constructeur vide de Vente
	 */
	
	public List<Vente> getVente_list() {
		
		ResultSet result = MysqlDB.extraire_DB("select * from vente");
		if(vente_list == null)
			vente_list = new ArrayList<Vente>();
		else
			vente_list.clear();
		if(result != null)
			try {
				while(result.next())
					vente_list.add(new Vente(result.getInt("venteID"),result.getString("description"),result.getInt("quantite"),
							result.getInt("prix_vente")));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return vente_list;
	}

	public Vente(){
		
	}
	
	private List<Vente> list_vente = new ArrayList<Vente>();
	
	public void add_vente(){
		int msg = MysqlDB.update_Bd("insert into vente(description,quantite,prix_vente) "+
				"values('"+this.description+"','"+this.quantite+"','"+this.prix_vente+"')");
		
		if(msg>0)
			this.msg ="ok,vous avez enregistre la vente avec succes";
		else
			this.msg = "desole,erreur d'enregistrement";
	}

	/*
	 * generate auto setters and getters
	 */
	
	
	public int getVenteID() {
		return venteID;
	}

	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public int getPrix_vente() {
		return prix_vente;
	}

	public void setPrix_vente(int prix_vente) {
		this.prix_vente = prix_vente;
	}

	public List<Vente> getList_vente() {
		return list_vente;
	}

	public void setVenteID(int venteID) {
		this.venteID = venteID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public void update(){
		
	}
	public void delete(){
		
	}
	
}
