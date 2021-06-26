package societe;

public class Achat {

	
	/*
	 * les attributs
	 */
	private int achatID;
	private String description;
	
	/*
	 * le constructeur
	 */
	public Achat(int achatID,String description){
		this.achatID = achatID;
		this.description = description;
	}
	
	/*
	 * le constructeur vide d'Achat
	 */
	
	public Achat(){
		
	}
	/*
	 * generation automatique des accesseurs et mutateurs
	 */

	public int getAchatID() {
		return achatID;
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
	
}
