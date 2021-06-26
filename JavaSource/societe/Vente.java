package societe;

public class Vente {

	/*
	 * les attributs
	 */
	private int venteID;
	private String description;
	
	/*
	 * le constructeur de la classe Vente
	 */
	public Vente(String description){
		this.description = description;
	}
	
	/*
	 * le constructeur vide de Vente
	 */
	
	public Vente(){
		
	}

	/*
	 * generate auto setters and getters
	 */
	public int getVenteID() {
		return venteID;
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
}
