package com.marta.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.marta.domain.Commande;
import com.marta.domain.Fournisseur;

public class MonDialogueCommande extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// private FenetrePrincipale parent;

	private JPanel panelCentre, panelSud;

	private int id = 0;

	private JComboBox<Object> fournisseur_box, unite_box;
	private JButton enregistrer, ajout_fournisseur;
	private JLabel desc_produit, quantite, unite, fournisseur, date_command, prix;
	private JLabel date_arrive, date_fin_stock;
	private JTextField desc_produit_txtfield;
	private JFormattedTextField quantite_txtfield, prix_txtfield, date_command_txtfield, date_arrive_txtfield,
			date_fin_stock_txtfield;
	private JLabel phrase_champs_oblig;

	private GridBagConstraints gbc = new GridBagConstraints();

	private Nouveau_fournisseur new_fournisseur = null;
	private Dialog_Modif_Succes new_dialog_modif_succ = null;

	public MonDialogueCommande(JFrame _parent, String title) {
		// false --> dialogue non modal
		super(_parent, title);// , false);

		setLayout(new BorderLayout());

		// ZONE CENTRE
		panelCentre = new JPanel();
		// panelCentre.setPreferredSize(new Dimension(850,450));
		panelCentre.setLayout(new GridBagLayout());

		// Créer les labels nord
		desc_produit = new JLabel("*Descriptif du produit  ");
		quantite = new JLabel("*Quantité  ");
		unite = new JLabel("*Unité  ");
		fournisseur = new JLabel("*Fournisseur  ");
		prix = new JLabel("*Prix de la commande (CHF):  ");
		date_command = new JLabel("*Commande effectuée le:  ");
		date_arrive = new JLabel("Commande arrivée le:  ");
		date_fin_stock = new JLabel("Date fin de stock  ");

		// Créer les jtextfields nord
		desc_produit_txtfield = new JTextField(20);
		quantite_txtfield = new JFormattedTextField(new Double(0.));
		quantite_txtfield.setPreferredSize(new Dimension(50, 20));
		String[] data_unit = new String[4];
		data_unit[0] = "unité(s)";
		data_unit[1] = "kg";
		data_unit[2] = "litres";
		data_unit[3] = "gr";

		unite_box = new JComboBox<Object>(data_unit);// combobox model

		fournisseur_box = new JComboBox<Object>();

		loadFournisseurs();

		prix_txtfield = new JFormattedTextField(new Double(0.));
		prix_txtfield.setPreferredSize(new Dimension(50, 20));
		date_command_txtfield = new JFormattedTextField(new Date());
		date_command_txtfield.setPreferredSize(new Dimension(80, 20));
		date_arrive_txtfield = new JFormattedTextField(new Date());
		date_arrive_txtfield.setPreferredSize(new Dimension(80, 20));
		date_fin_stock_txtfield = new JFormattedTextField(new Date());
		date_fin_stock_txtfield.setPreferredSize(new Dimension(80, 20));

		gbc.insets = new Insets(4, 4, 4, 4);
		addComponents(desc_produit, desc_produit_txtfield, panelCentre, gbc);
		addComponents(quantite, quantite_txtfield, panelCentre, gbc);
		addComponents(unite, unite_box, panelCentre, gbc);
		addComponents(fournisseur, fournisseur_box, panelCentre, gbc);
		addComponents(prix, prix_txtfield, panelCentre, gbc);
		addComponents(date_command, date_command_txtfield, panelCentre, gbc);
		addComponents(date_arrive, date_arrive_txtfield, panelCentre, gbc);
		addComponents(date_fin_stock, date_fin_stock_txtfield, panelCentre, gbc);

		// ZONE SUD
		panelSud = new JPanel();
		panelSud.setLayout(new FlowLayout());

		// Créer les boutons
		enregistrer = new JButton("Enregistrer");
		enregistrer.addActionListener(this);
		ajout_fournisseur = new JButton("Ajouter un fournisseur");
		ajout_fournisseur.addActionListener(this);

		// Phrase champs obligatoires
		phrase_champs_oblig = new JLabel("*Champs obligatoires");

		// adds to panelSud
		panelSud.setBackground(Color.lightGray);
		panelSud.add(phrase_champs_oblig);
		panelSud.add(ajout_fournisseur);
		panelSud.add(enregistrer);

		// Création de la boîte de dialogue nouveua fournisseur
		new_fournisseur = new Nouveau_fournisseur(this, "Nouveau Fournisseur");

		// Création de la boîte de dialogue _modif succes
		new_dialog_modif_succ = new Dialog_Modif_Succes(this, "Confirmation");

		add(panelCentre, BorderLayout.CENTER);
		add(panelSud, BorderLayout.SOUTH);

		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		// setVisible(true);
		// Initialize this dialog to its preferred size.
		pack();
		setLocationRelativeTo(_parent);
		// setBounds(80, 20, 900, 500);
	}

	protected void loadFournisseurs() {
		// Fournisseurs - ComboBox

		List<Fournisseur> tousFournisseurs = FournisseurServiceLocator.getService().getTousFournisseurs();

		String[] data_fournisseur = null;

		if (tousFournisseurs != null && tousFournisseurs.size() > 0) {

			data_fournisseur = new String[tousFournisseurs.size()];

			for (int i = 0; i < tousFournisseurs.size(); i++) {

				data_fournisseur[i] = FournisseurServiceLocator.getService().getTousFournisseurs().get(i)
						.getNom_fournisseur();
			}

		}
		// combobox

		if (!(data_fournisseur == null)) {

			fournisseur_box.removeAllItems();
			for (String string : data_fournisseur) {

				fournisseur_box.addItem(string);
			}
		}
	}

	private void addComponents(JLabel label, JComponent tf, JPanel p, GridBagConstraints gbc) {
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		p.add(label, gbc);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		p.add(tf, gbc);
	}

	// private void addComponentsComboBox(JLabel label, JComboBox<?> cb, JPanel
	// p, GridBagConstraints gbc) {
	// gbc.anchor = GridBagConstraints.EAST;
	// gbc.gridwidth = GridBagConstraints.RELATIVE;
	// p.add(label, gbc);
	// gbc.anchor = GridBagConstraints.WEST;
	// gbc.gridwidth = GridBagConstraints.REMAINDER;
	// p.add(cb, gbc);
	// }

	@SuppressWarnings("unchecked")
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == enregistrer) {
			// enresgitrer une commmande
			Commande commande = new Commande();
			JTable t = ((FenetrePrincipale) this.getParent()).getTableau();

			if (t.getSelectedRow() > -1) {
				int indexRow = t.getSelectedRow();
				id = (int) t.getValueAt(indexRow, 0);
				commande.setId(id);

				desc_produit_txtfield = (JTextField) t.getValueAt(indexRow, 1);
				quantite_txtfield = (JFormattedTextField) t.getValueAt(indexRow, 2);
				prix_txtfield = (JFormattedTextField) t.getValueAt(indexRow, 3);
				date_command_txtfield = (JFormattedTextField) t.getValueAt(indexRow, 4);
				date_arrive_txtfield = (JFormattedTextField) t.getValueAt(indexRow, 5);
				date_fin_stock_txtfield = (JFormattedTextField) t.getValueAt(indexRow, 6);
				fournisseur_box = (JComboBox<Object>) t.getValueAt(indexRow, 7);
				unite_box = (JComboBox<Object>) t.getValueAt(indexRow, 8);

			}
			commande.setDescriptif_produit(this.desc_produit_txtfield.getText());
			commande.setQuantite((double) this.quantite_txtfield.getValue());
			commande.setPrix((double) this.prix_txtfield.getValue());
			commande.setDate_commande((Date) this.date_command_txtfield.getValue());
			commande.setDate_arrivee((Date) this.date_arrive_txtfield.getValue());
			commande.setDate_fin((Date) this.date_fin_stock_txtfield.getValue());
			commande.setFournisseur((String) this.fournisseur_box.getSelectedItem());
			commande.setUnite((String) this.unite_box.getSelectedItem());

			CommandeServiceLocator.getService().save(commande);
			// refresh jtable avec la nouvelle commande
			((FenetrePrincipale) this.getParent()).refresh(commande);

			// clean champs
			desc_produit_txtfield.setText(null);
			quantite_txtfield.setText(null);
			prix_txtfield.setText(null);
			// date_command_txtfield.setText(null);
			// date_arrive_txtfield.setText(null);
			// date_fin_stock_txtfield.setText(null);

			if (new_dialog_modif_succ == null) {
				new_dialog_modif_succ = new Dialog_Modif_Succes(this, "Confirmation");
			}
			new_dialog_modif_succ.setVisible(true);
			new_dialog_modif_succ.setLocationRelativeTo(getParent());

		} else if (source == ajout_fournisseur) {
			if (new_fournisseur == null) {
				new_fournisseur = new Nouveau_fournisseur(this, "Nouveau Fournisseur");
			}
			new_fournisseur.setVisible(true);
			new_fournisseur.setLocationRelativeTo(getParent());
		}
	}
}