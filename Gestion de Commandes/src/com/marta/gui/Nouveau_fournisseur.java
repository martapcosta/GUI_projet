package com.marta.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.marta.domain.Fournisseur;

public class Nouveau_fournisseur extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JButton valider, quitter;
	private JLabel ajoutez_n_fourn, nom_fournisseur, adresse, email, telephone;
	private JTextArea nom_fourn_textArea,email_textArea,adresse_textArea, tel_textArea; 

	// private MonDialogueCommande parent;
	private Dialog_Modif_Succes modif_succ = null;
	private JTextArea textArea;

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

		nom_fourn_textArea = new JTextArea();
		nom_fourn_textArea.setBounds(140, 33, 189, 20);
		contentPanel.add(nom_fourn_textArea);
		nom_fourn_textArea.setColumns(10);

		adresse = new JLabel("Adresse");
		adresse.setBounds(64, 71, 60, 14);
		contentPanel.add(adresse);

		adresse_textArea = new JTextArea();
		adresse_textArea.setBounds(140, 68, 189, 60);
		contentPanel.add(adresse_textArea);
		adresse_textArea.setColumns(10);

		email = new JLabel("E-mail");
		email.setBounds(64, 143, 46, 14);
		contentPanel.add(email);

		email_textArea = new JTextArea();
		email_textArea.setBounds(140, 140, 189, 20);
		contentPanel.add(email_textArea);
		email_textArea.setColumns(10);

		valider = new JButton("Valider");
		valider.setBounds(309, 227, 89, 23);
		contentPanel.add(valider);
		valider.addActionListener(this);

		quitter = new JButton("Quitter");
		quitter.setBounds(202, 227, 89, 23);
		contentPanel.add(quitter);
		
		JLabel telephone = new JLabel("T\u00E9l\u00E9phone");
		telephone.setBounds(64, 181, 68, 14);
		contentPanel.add(telephone);
		
		tel_textArea = new JTextArea();
		tel_textArea.setBounds(140, 175, 106, 20);
		contentPanel.add(tel_textArea);
		quitter.addActionListener(this);

		// Création de la boîte de dialogue
		modif_succ = new Dialog_Modif_Succes(this, "Nouveau Fournisseur");

	}

	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == valider) {

			// enresgitrer un fournisseur
			Fournisseur fournisseur = new Fournisseur();
			// fournisseur.setId(FournisseurServiceLocator.getService().getConteurId());
			fournisseur.setNom_fournisseur(this.nom_fourn_textArea.getText());
			fournisseur.setAdresse(this.adresse_textArea.getText());
			fournisseur.setEmail(this.email_textArea.getText());
			fournisseur.setTelephone(this.tel_textArea.getText());

			FournisseurServiceLocator.getService().save(fournisseur);

			// TODO refresh jtable - manque creer la JTABLE

			if (modif_succ == null) {
				modif_succ = new Dialog_Modif_Succes(this, "Nouveau Fournisseur");
			}


			modif_succ.setVisible(true);
			modif_succ.setLocationRelativeTo(getParent());


			// clean champs
			nom_fourn_textArea.setText(null);
			adresse_textArea.setText(null);
			email_textArea.setText(null);
			tel_textArea.setText(null);

			// refresh combobox
			((MonDialogueCommande) this.getParent()).loadFournisseurs();

		} else if (source == quitter) {
			setVisible(false);
			// clean champs
			nom_fourn_textArea.setText(null);
			adresse_textArea.setText(null);
			email_textArea.setText(null);
			tel_textArea.setText(null);
		}
	}
}