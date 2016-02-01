package com.marta.domain;

public class Fournisseur {
	
	private int id;
	private String nom_fournisseur;
	private String adresse;
	private String email;

public Fournisseur (){};
	
public Fournisseur (int id,String four, String adresse, String email){
		
		this.id = id;
		this.nom_fournisseur = four;
		this.adresse = adresse;
		this.email = email;
	}
	
	/**
 * @return the id
 */
public int getId() {
	return id;
}

/**
 * @param id the id to set
 */
public void setId(int id) {
	this.id = id;
}

	/**
	 * @return the nom_fournisseur
	 */
	public String getNom_fournisseur() {
		return nom_fournisseur;
	}
	/**
	 * @param nom_fournisseur the nom_fournisseur to set
	 */
	public void setNom_fournisseur(String nom_fournisseur) {
		this.nom_fournisseur = nom_fournisseur;
	}
	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}
	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
		
}