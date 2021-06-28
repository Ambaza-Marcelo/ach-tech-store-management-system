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
	private String msg;
	
	/*
	 * le constructeur
	 */
	public Achat(int achatID,String description){
		this.achatID = achatID;
		this.description = description;
	}
	
	private static List<Achat> achat_list;
	
	
	
	/*
	 * le constructeur vide d'Achat
	 */
	
	public static List<Achat> getAchat_list() {
		ResultSet result = MysqlDB.extraire_DB("select * from achat");
		if(achat_list==null)
			achat_list = new ArrayList<Achat>();
		else
			achat_list.clear();
		if(result != null){
			try {
				while(result.next()){
					achat_list.add(new Achat(result.getInt("achatID"),result.getString("description")));
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
	private static List<Achat> list_achat = new ArrayList<Achat>();
	public void add_achat(){
		int msg = MysqlDB.update_Bd("insert into achat(description)"+
				"values('"+this.description+"')");
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

	public static List<Achat> getList_achat() {
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
