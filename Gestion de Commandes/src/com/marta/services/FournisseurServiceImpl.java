package com.marta.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.marta.domain.Fournisseur;

public class FournisseurServiceImpl implements FournisseurService {

	/**
	 * @return the listeFournisseurs
	 */
	public List<Fournisseur> getListeFournisseurs() {
		return listeFournisseurs;
	}

	/**
	 * @param listeFournisseurs the listeFournisseurs to set
	 */
	public void setListeFournisseurs(List<Fournisseur> listeFournisseurs) {
		this.listeFournisseurs = listeFournisseurs;
	}

	private List<Fournisseur> listeFournisseurs = new ArrayList<Fournisseur>();
	private int conteurId = 1;

	@Override
	public List<Fournisseur> getTousFournisseurs() {
		return listeFournisseurs;
	}

	@Override
	public Fournisseur getFournisseur(int id) {
		for (Fournisseur fournisseur : listeFournisseurs) {
			if (id == fournisseur.getId()) {
				return fournisseur;
			}
		}
		return null;
	}

	@Override
	public void save(Fournisseur fournisseur) {
		if (fournisseur.getId() > 0) {
			//Trouver commande de la liste e substituer pour celle-ci
			for (Iterator iterator = listeFournisseurs.iterator(); iterator.hasNext();) {
				Fournisseur f = (Fournisseur) iterator.next();
				if (f.getId() == fournisseur.getId()) {
					iterator.remove();
					break;
				}
			}
			// trouver commande de la liste e substituer pour celle-ci
			this.listeFournisseurs.add(fournisseur);
		} else {
			fournisseur.setId(this.conteurId++);
			this.listeFournisseurs.add(fournisseur);
		}
	}

	@Override
	public void delete(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
	}

	public int getConteurId() {
		return conteurId;
	}

	public void setConteurId(int couteurId) {
		this.conteurId = couteurId;
	}

}
