package com.marta.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class FenetrePrincipale extends JFrame implements ActionListener, ListSelectionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel PanelPrincipal;

	// zone nord
	private JPanel ZoneNord;
	private JLabel label_entete;

	// zone centre

	private JPanel ZoneCentre;
	private JTable commandes;
	private JScrollPane scpane1;

	// zone sud
	private JPanel ZoneSud;

	private JPanel ajouter_panel;
	private JButton ajouter;

	private JPanel modifier_panel;
	private JButton modifier;

	private JPanel quitter_panel;
	private JButton quitter;

	private JPanel fournisseurs_panel;
	private JButton fournisseurs;

	private MonDialogueCommande new_mon_dialog_command = null;

	public FenetrePrincipale(String titre, int larg, int haut) {
		super(titre);
		this.setBounds(80, 20, larg, haut);
		this.setTitle(titre);

		setLayout(new BorderLayout());

		// ZONESUD
		ZoneSud = new JPanel();
		ZoneSud.setBackground(Color.lightGray);
		ZoneSud.setPreferredSize(new Dimension(900, 60));
		ZoneSud.setLayout(new GridLayout(1, 4, 0, 50));

		// create icons boutons
		ImageIcon modifierIcon = new ImageIcon("load.gif");
		ImageIcon ajouterIcon = new ImageIcon("save.gif");
		// ImageIcon subscribeIcon = new ImageIcon("subscribe.gif");
		// ImageIcon unsubscribeIcon = new ImageIcon("unsubscribe.gif");

		// Créer les boutons
		// Bouton Consulter les fournisseurs
		fournisseurs = new JButton("Fournisseurs"); // creation du bouton
		fournisseurs.addActionListener(this); // actionListener
		fournisseurs_panel = new JPanel(); // creation du jpanel du bouton
											// fournisseurs
		fournisseurs_panel.setBackground(Color.lightGray);// set color de
															// fournisseurs_panel
		fournisseurs_panel.add(fournisseurs);// adition de bouton au jpanel
		fournisseurs.setPreferredSize(new Dimension(110, 40));// dimensioné le
																// bouton
		ZoneSud.add(fournisseurs_panel);// add jpanel à la zone sud

		// Bouton Quitter le programme
		quitter = new JButton("Quitter");
		quitter.addActionListener(this);
		quitter_panel = new JPanel();
		quitter_panel.setBackground(Color.lightGray);
		quitter_panel.add(quitter);
		quitter.setPreferredSize(new Dimension(110, 40));
		ZoneSud.add(quitter_panel);

		// Bouton Modifier une commande
		modifier = new JButton("Modifier", modifierIcon);
		modifier.addActionListener(this);
		modifier_panel = new JPanel();
		modifier_panel.setBackground(Color.lightGray);
		modifier_panel.add(modifier);
		modifier.setPreferredSize(new Dimension(110, 40));
		ZoneSud.add(modifier_panel);

		// Bouton Ajouter commande
		ajouter = new JButton("Ajouter", ajouterIcon);
		ajouter.addActionListener(this);
		ajouter_panel = new JPanel();
		ajouter_panel.setBackground(Color.lightGray);
		ajouter_panel.add(ajouter);
		ajouter.setPreferredSize(new Dimension(110, 40));
		ZoneSud.add(ajouter_panel);

		// ZONECENTRE
		ZoneCentre = new JPanel();
		ZoneCentre.setBackground(Color.lightGray);
		ZoneCentre.setPreferredSize(new Dimension(900, 550));
		ZoneCentre.setLayout(new BorderLayout());

		// tabela que no futuro vai ter un numero fixo de colunas e um numero
		// dinamico de linhas

		/*
		 * String[] columnNames = {"Desc. Commande", "Quantité", "Unités",
		 * "Fourniseur", "Date Commande", "Date arrivée", "Date fin"};
		 */

		// Object [] [] data = null;

		commandes = new JTable(30, 8);
		/*
		 * commandes.setShowVerticalLines(false);
		 * commandes.setCellSelectionEnabled(true);
		 * commandes.setColumnSelectionAllowed(true); //commandes.setBorder(new
		 * LineBorder(null));
		 * commandes.getColumnModel().getColumn(0).setPreferredWidth(346);
		 * commandes.getColumnModel().getColumn(1).setPreferredWidth(34);
		 * commandes.getColumnModel().getColumn(2).setPreferredWidth(33);
		 * commandes.getColumnModel().getColumn(3).setPreferredWidth(31);
		 * commandes.getColumnModel().getColumn(4).setPreferredWidth(28);
		 * commandes.getColumnModel().getColumn(5).setPreferredWidth(28);
		 * commandes.getColumnModel().getColumn(6).setPreferredWidth(28);
		 */

		scpane1 = new JScrollPane();
		scpane1.setViewportView(commandes);

		ZoneCentre.add(scpane1);

		// ZONENORD
		ZoneNord = new JPanel();
		label_entete = new JLabel("Historique");
		ZoneNord.add(label_entete);
		label_entete.setFont(new Font("Calibri", Font.PLAIN, 25));
		ZoneNord.setBackground(Color.lightGray);
		ZoneNord.setPreferredSize(new Dimension(900, 60));

		// Ajouter zoneSud et zone nord à panelprincipal
		PanelPrincipal = new JPanel();
		PanelPrincipal.setLayout(new BorderLayout());
		PanelPrincipal.setPreferredSize(new Dimension(700, 500));
		PanelPrincipal.add(ZoneSud, BorderLayout.SOUTH);
		PanelPrincipal.add(ZoneCentre, BorderLayout.CENTER);
		PanelPrincipal.add(ZoneNord, BorderLayout.NORTH);

		// Création de la boîte de dialogue
		new_mon_dialog_command = new MonDialogueCommande(this, "Enresgistrement d'une commande");

		// Ajouter Panelprincipal
		this.add(PanelPrincipal, BorderLayout.CENTER);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	
	public void refresh ()
	{
		// limpar jtable
		// TODO
	}
	// Méthode de l'interface ActionListener
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ajouter) {
			if (new_mon_dialog_command == null) {
				new_mon_dialog_command = new MonDialogueCommande(this, "Enresgistrement d'une commande");
			}
			new_mon_dialog_command.setVisible(true);
		} else if (e.getSource() == modifier) {
			// coder ici
		} else if (e.getSource() == quitter) {
			// setVisible(false);
			System.exit(1);
		} else if (e.getSource() == fournisseurs) {
			// coder ici
		}
	}

	public void valueChanged(ListSelectionEvent e) {
		// La valeur a changée dans la JList.
		/*
		 * int i = liste.getSelectedIndex(); if(i <= 10) {
		 * monCanvas.setCouleur(couleurs[i]); } monCanvas.repaint();
		 */
	}
} // Fin de la classe FenetrePrincipale

// JTable tabelaGrafica;
//
// public void save() {
// Commande newCommande = new Commande();
// //newEncomenda.setPrice(fenetre.prix);
//
// //CommandeServiceLocator.getService().save(commande);
// }
