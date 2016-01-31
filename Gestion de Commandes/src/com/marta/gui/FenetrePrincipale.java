package com.marta.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.TableColumn;

import com.marta.domain.Commande;

public class FenetrePrincipale extends JFrame implements ActionListener {
	
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
	private JTable tableau;
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
	
	private MyTableModel model;
	
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

		//JTABLE
		
		tableau = new JTable(new MyTableModel());
		//tableau.setPreferredScrollableViewportSize(new Dimension (800, 500));
		tableau.setFillsViewportHeight(true);
		scpane1 = new JScrollPane(tableau);
//		final MyTableRowSorter trs = new MyTableRowSorter(model);
//		tableau.setRowSorter(trs);
//		final RowFilter<MyTableModel,Object> rf = RowFilter.numberFilter(RowFilter.ComparisonType.AFTER,4,1);
//		
//		TableColumn tc = tableau.getColumnModel().getColumn(1);
//		tc.setCellRenderer(new MyNoteRenderer());
//		tc = tableau.getColumnModel().getColumn(0);
//		tc.setPreferredWidth(100);
//		tc.setCellRenderer(new MyNomRenderer());
//
//		tableau.setRowHeight(1,50);

		scpane1.setViewportView(tableau);

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


	public void refresh (Commande c)
	{
		model.addCommande(c);
		
	}
	// Méthode de l'interface ActionListener
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == ajouter) {
			if (new_mon_dialog_command == null) {
				new_mon_dialog_command = new MonDialogueCommande(this, "Enresgistrement d'une commande");
			}
			new_mon_dialog_command.setVisible(true);
			new_mon_dialog_command.setLocationRelativeTo(this);
		} else if (e.getSource() == modifier) {
			// coder ici
		} else if (e.getSource() == quitter) {
			System.exit(1);
		} else if (e.getSource() == fournisseurs) {
			// coder ici
		}
	}
} // Fin de la classe FenetrePrincipale

