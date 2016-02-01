package com.marta.services;

import java.util.List;

import com.marta.domain.Fournisseur;

public interface FournisseurService {

	/**
	 * Retourne tous les fournisseurs enresgistrées
	 * @return
	 */
	List<Fournisseur> getTousFournisseurs();
	
	/**
	 * Retourne fournisseur id
	 * @return
	 */
	Fournisseur getFournisseur(int id);

	/**
	 * Enresgitre un fournisseur
	 * @return
	 */
	void save(Fournisseur fournisseur);
	
	/**
	 * Delete un fournisseur
	 * @return
	 */	
	void delete(Fournisseur fournisseur);
	
	
	int getConteurId();

	void setConteurId(int couteurId);
}