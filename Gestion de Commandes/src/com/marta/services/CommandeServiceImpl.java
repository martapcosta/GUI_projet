package com.marta.services;

import java.util.ArrayList;
import java.util.List;
import com.marta.domain.Commande;

public class CommandeServiceImpl implements CommandeService {

	private List<Commande> listeCommandes = new ArrayList<Commande>();
	private int conteurId = 1;

	@Override
	public List<Commande> getToutesCommandes() {
		return listeCommandes;
	}

	@Override
	public Commande getCommande(int id) {
		for (Commande commande : listeCommandes) {
			if (id == commande.getId()) {
				return commande;
			}
		}
		return null;
	}

	@Override
	public void save(Commande commande) {
		if (commande.getId() > 0) {
			// trouver commande de la liste e substituer pour celle-ci
		} else {
			commande.setId(this.conteurId++);
			this.listeCommandes.add(commande);
		}
	}

	@Override
	public void delete(Commande commande) {
		// TODO Auto-generated method stub
	}

}
