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
	private String msg;
	
	/*
	 * le constructeur de la classe Vente
	 */
	public Vente(int venteID,String description){
		this.venteID = venteID;
		this.description = description;
	}
	
	private static List<Vente> vente_list;
	
	
	
	/*
	 * le constructeur vide de Vente
	 */
	
	public static List<Vente> getVente_list() {
		
		ResultSet result = MysqlDB.extraire_DB("select * from vente");
		if(vente_list == null)
			vente_list = new ArrayList<Vente>();
		else
			vente_list.clear();
		if(result != null)
			try {
				while(result.next())
					vente_list.add(new Vente(result.getInt("venteID"),result.getString("description")));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return vente_list;
	}

	public Vente(){
		
	}
	
	private static List<Vente> list_vente = new ArrayList<Vente>();
	
	public void add_vente(){
		int msg = MysqlDB.update_Bd("insert into vente(description)"+
				"values('"+this.description+"')");
		
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

	public static List<Vente> getList_vente() {
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
