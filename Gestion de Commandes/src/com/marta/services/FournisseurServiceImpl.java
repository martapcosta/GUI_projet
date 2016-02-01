package com.marta.services;

import java.util.ArrayList;
import java.util.List;
import com.marta.domain.Fournisseur;

public class FournisseurServiceImpl implements FournisseurService{

	private List<Fournisseur> listeFournisseurs = new ArrayList<Fournisseur>();
	private int conteurId = 0;
	
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
			// trouver commande de la liste e substituer pour celle-ci
			this.listeFournisseurs.set(fournisseur.getId(),fournisseur);
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
