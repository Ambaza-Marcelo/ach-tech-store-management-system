package societe;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DB.MysqlDB;

public class Achat {

	
	/*
	 * les attributs
	 */
	private int achatID;
	private String description;
	private int prix_achat;
	private int prix_vente;
	private String msg;
	
	/*
	 * le constructeur
	 */
	public Achat(int achatID,String description,int prix_achat,int prix_vente){
		this.achatID = achatID;
		this.description = description;
		this.prix_achat = prix_achat;
		this.prix_vente = prix_vente;
	}
	
	private List<Achat> achat_list;
	
	
	public List<Achat> getAchat_list() {
		ResultSet result = MysqlDB.extraire_DB("select * from achat");
		if(achat_list == null)
			achat_list = new ArrayList<Achat>();
		else
			achat_list.clear();
		if(result != null){
			try {
				while(result.next()){
					achat_list.add(new Achat(result.getInt("achatID"),result.getString("description"),
							result.getInt("prix_achat"),
							result.getInt("prix_vente")));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return achat_list;
	}
	
	/*
	 * le constructeur vide
	 */

	public Achat(){
		
	}
	/*
	 * tableau dynamique
	 */
	private List<Achat> list_achat = new ArrayList<Achat>();
	/*
	 * ajouter un achat
	 */
	public void add_achat(){
		int msg = MysqlDB.update_Bd("insert into achat(description,prix_achat,prix_vente)"+
				"values('"+this.description+"','"+this.prix_achat+"','"+this.prix_vente+"')");
		if(msg>0)
			this.msg = "ok, vous avez ajoutee l'achat avec succes";
		else
			this.msg ="desole,erreur d'enregistrement";
	}
	/*
	 * generation automatique des accesseurs et mutateurs
	 */

	
	public int getAchatID() {
		return achatID;
	}
	

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getPrix_achat() {
		return prix_achat;
	}

	public void setPrix_achat(int prix_achat) {
		this.prix_achat = prix_achat;
	}

	public int getPrix_vente() {
		return prix_vente;
	}

	public void setPrix_vente(int prix_vente) {
		this.prix_vente = prix_vente;
	}

	public List<Achat> getList_achat() {
		return list_achat;
	}

	public void setAchatID(int achatID) {
		this.achatID = achatID;
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
