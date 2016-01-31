package com.marta.domain;

import java.util.Date;

public class Commande {

	private int id;
	private String descriptif_produit;
	private double quantite;
	private String unite;
	private String fournisseur;
	private double prix;
	private Date date_commande;
	private Date date_arrivee;
	private Date date_fin;
	/**
	 * @return the id
	 */
	public Commande (){};
	
	public Commande (int iden, String descrip, double quant,String unite,String four,
					double prix, Date date1, Date date2, Date date3){
		
		this.id = iden;
		descriptif_produit = descrip;
		quantite = quant;
		this.unite = unite;
		fournisseur = four;
		this.prix = prix;
		date_commande  = date1;
		date_arrivee = date2;
		date_fin = date3;
		
	}
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
	 * @return the descriptif_produit
	 */
	public String getDescriptif_produit() {
		return descriptif_produit;
	}
	/**
	 * @param descriptif_produit the descriptif_produit to set
	 */
	public void setDescriptif_produit(String descriptif_produit) {
		this.descriptif_produit = descriptif_produit;
	}
	/**
	 * @return the quantite
	 */
	public double getQuantite() {
		return quantite;
	}
	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	/**
	 * @return the unite
	 */
	public String getUnite() {
		return unite;
	}
	/**
	 * @param unite the unite to set
	 */
	public void setUnite(String unite) {
		this.unite = unite;
	}
	/**
	 * @return the fournisseur
	 */
	public String getFournisseur() {
		return fournisseur;
	}
	/**
	 * @param fournisseur the fournisseur to set
	 */
	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}
	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}
	/**
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}
	/**
	 * @return the date_commande
	 */
	public Date getDate_commande() {
		return date_commande;
	}
	/**
	 * @param date_commande the date_commande to set
	 */
	public void setDate_commande(Date date_commande) {
		this.date_commande = date_commande;
	}
	/**
	 * @return the date_arrivee
	 */
	public Date getDate_arrivee() {
		return date_arrivee;
	}
	/**
	 * @param date_arrivee the date_arrivee to set
	 */
	public void setDate_arrivee(Date date_arrivee) {
		this.date_arrivee = date_arrivee;
	}
	/**
	 * @return the date_fin
	 */
	public Date getDate_fin() {
		return date_fin;
	}
	/**
	 * @param date_fin the date_fin to set
	 */
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}

	
}
