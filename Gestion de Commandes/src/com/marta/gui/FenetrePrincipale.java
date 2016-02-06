package com.marta.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.marta.domain.Commande;

public class FenetrePrincipale extends JFrame implements ActionListener {

	/**
	 * @return the tableau
	 */
	public JTable getTableau() {
		return tableau;
	}

	/**
	 * @param tableau the tableau to set
	 */
	public void setTableau(JTable tableau) {
		this.tableau = tableau;
	}

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
	private Modifier_Selection new_modif_selection = null;
	private Fenetre_Consult_Fournisseurs new_fen_consult_fournisseurs = null;
	private MyTableModel model;
	// private ListSelectionModel selectmodel;

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

		// TODO create icons boutons
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

		// JTABLE
		model = new MyTableModel();
		tableau = new JTable(model);
		// tableau.setPreferredScrollableViewportSize(new Dimension (800, 500));
		tableau.setFillsViewportHeight(true);
		scpane1 = new JScrollPane(tableau);
		// final MyTableRowSorter trs = new MyTableRowSorter(model);
		// tableau.setRowSorter(trs);
		// final RowFilter<MyTableModel,Object> rf =
		// RowFilter.numberFilter(RowFilter.ComparisonType.AFTER,4,1);
		//
		// TableColumn tc = tableau.getColumnModel().getColumn(1);
		// tc.setCellRenderer(new MyNoteRenderer());
		// tc = tableau.getColumnModel().getColumn(0);
		// tc.setPreferredWidth(100);
		// tc.setCellRenderer(new MyNomRenderer());
		//
		// tableau.setRowHeight(1,50);

		scpane1.setViewportView(tableau);

		ZoneCentre.add(scpane1);

		// ZONENORD
		ZoneNord = new JPanel();
		label_entete = new JLabel("Historique des commandes");
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

		// Création de la boîte de dialogue COMMANDE
		new_mon_dialog_command = new MonDialogueCommande(this, "Enresgistrement d'une commande");

		// Création de la boîte de dialogue avertissement SELECTION
		new_modif_selection = new Modifier_Selection(this, "Selection ligne table");

		// Création de la boîte de dialogue fournisseurs
		new_fen_consult_fournisseurs = new Fenetre_Consult_Fournisseurs(this, "Fournisseurs");

		// Ajouter Panelprincipal
		this.add(PanelPrincipal, BorderLayout.CENTER);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);

	}

	public void refresh(Commande c) {
		model.addCommande(c);

	}

	// Méthode de l'interface ActionListener
	public void actionPerformed(ActionEvent e) {
		// AJOUTER
		if (e.getSource() == ajouter) {
			if (new_mon_dialog_command == null) {
				new_mon_dialog_command = new MonDialogueCommande(this, "Enresgistrement d'une commande");
			}
			new_mon_dialog_command.setVisible(true);
			new_mon_dialog_command.setLocationRelativeTo(this);
			// MODIFIER
		} else if (e.getSource() == modifier) {

			if (tableau.getSelectedRow() ==-1) {

				if (new_modif_selection == null) {
					new_modif_selection = new Modifier_Selection(this, "SELECTION");
				}
				new_modif_selection.setVisible(true);
				new_modif_selection.setLocationRelativeTo(this);
			} else {
				
				if (new_mon_dialog_command == null) {
					new_mon_dialog_command = new MonDialogueCommande(this, "Changement d'une commande");
				}
				int indexRow = tableau.getSelectedRow();

				new_mon_dialog_command.getDesc_produit_txtfield().setText((String)tableau.getValueAt(indexRow,1));
				new_mon_dialog_command.getQuantite_txtfield().setText(String.valueOf(tableau.getValueAt(indexRow,2)));
				new_mon_dialog_command.getUnite_box().setSelectedItem((String)tableau.getValueAt(indexRow,3));
				new_mon_dialog_command.getFournisseur_box().setSelectedItem((String)tableau.getValueAt(indexRow,4));
				new_mon_dialog_command.getPrix_txtfield().setText(String.valueOf(tableau.getValueAt(indexRow,5)));
				new_mon_dialog_command.getDate_command_txtfield().setText((tableau.getValueAt(indexRow,6)).toString());
				new_mon_dialog_command.getDate_arrive_txtfield().setText((tableau.getValueAt(indexRow,7).toString()));
				new_mon_dialog_command.getDate_fin_stock_txtfield().setText((tableau.getValueAt(indexRow,8).toString()));

				
				new_mon_dialog_command.setVisible(true);
				new_mon_dialog_command.setLocationRelativeTo(this);

			}

			// QUITTER
		} else if (e.getSource() == quitter) {
			System.exit(1);
			// FOURNISSEURS
		} else if (e.getSource() == fournisseurs) {
			if (new_fen_consult_fournisseurs == null) {
				new_fen_consult_fournisseurs = new Fenetre_Consult_Fournisseurs(this, "Fournisseurs");
			}
			new_fen_consult_fournisseurs.setVisible(true);
			new_fen_consult_fournisseurs.setLocationRelativeTo(this);
			
		}
	}
} // Fin de la classe FenetrePrincipale
