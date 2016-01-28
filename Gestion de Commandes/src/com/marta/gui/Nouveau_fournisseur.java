package com.marta.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Nouveau_fournisseur extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton valider, quitter;
	private JLabel ajoutez_n_fourn, nom_fournisseur, adresse, email;
	private JTextField nom_fourn_txfield, adresse_txfield, email_txfield;
	
	// private MonDialogueCommande parent;
	private Dialog_Modif_Succes modif_succ = null;
	
	public Nouveau_fournisseur(MonDialogueCommande _parent, String title) {

		super(_parent, title);
		// parent = (FenetrePrincipale)_parent;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		ajoutez_n_fourn = new JLabel("Ajoutez un nouveau fournisseur");
		ajoutez_n_fourn.setBounds(10, 11, 215, 14);
		contentPanel.add(ajoutez_n_fourn);
		
		nom_fournisseur = new JLabel("Nom du fournisseur");
		nom_fournisseur.setBounds(20, 36, 112, 14);
		contentPanel.add(nom_fournisseur);
		
		nom_fourn_txfield = new JTextField();
		nom_fourn_txfield.setBounds(140, 33, 189, 20);
		contentPanel.add(nom_fourn_txfield);
		nom_fourn_txfield.setColumns(10);
		
		adresse = new JLabel("Adresse");
		adresse.setBounds(64, 71, 60, 14);
		contentPanel.add(adresse);
		
		adresse_txfield = new JTextField();
		adresse_txfield.setBounds(140, 68, 189, 60);
		contentPanel.add(adresse_txfield);
		adresse_txfield.setColumns(10);
		
		email = new JLabel("E-mail");
		email.setBounds(64, 143, 46, 14);
		contentPanel.add(email);
		
		email_txfield = new JTextField();
		email_txfield.setBounds(140, 140, 189, 20);
		contentPanel.add(email_txfield);
		email_txfield.setColumns(10);
		
		valider = new JButton("Valider");
		valider.setBounds(309, 194, 89, 23);
		contentPanel.add(valider);
		valider.addActionListener(this);
			
		quitter = new JButton("Quitter");
		quitter.setBounds(202, 194, 89, 23);
		contentPanel.add(quitter);
		quitter.addActionListener(this);
		
		
		// Création de la boîte de dialogue
		modif_succ = new Dialog_Modif_Succes(this, "Nouveau Fournisseur");

		
	}

	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == valider) {
				if (modif_succ == null) {
					modif_succ = new Dialog_Modif_Succes(this, "Nouveau Fournisseur");
				}
				modif_succ.setVisible(true);
			}
		else if (source == quitter) {
			setVisible(false);
		}
	}

}