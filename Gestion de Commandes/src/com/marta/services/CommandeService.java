package com.marta.services;

import java.util.List;

import com.marta.domain.Commande;

public interface CommandeService {

	/**
	 * Retourne toutes les commandes enresgistrées
	 * @return
	 */
	List<Commande> getToutesCommandes();
	
	/**
	 * Retourne commande id
	 * @return
	 */
	Commande getCommande(int id);
	
	/**
	 * Enresgitre une commande
	 * @return
	 */	
	void save(Commande commande);
	
	
	/**
	 * Delete une commande
	 * @return
	 */	
	void delete(Commande commande);
	
	
	/**
	 * @return the conteurId
	 */
	int getConteurId();

	/**
	 * @param conteurId the conteurId to set
	 */
	void setConteurId(int conteurId);
}
