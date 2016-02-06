package com.marta.gui;

import java.awt.*;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;
import com.marta.domain.Fournisseur;

public class Fenetre_Consult_Fournisseurs extends JDialog implements ActionListener {

	private JPanel PanelPrincipal;

	//private int id;

	// zone nord
	private JPanel ZoneNord;
	private JLabel label_entete;

	// zone centre
	private JPanel ZoneCentre;
	private JTable tableau;
	private JScrollPane scpane1;

	// zone sud
	private JPanel ZoneSud;
	private JPanel quitter_panel;
	private JButton quitter;

	private MyTableModel_Fournisseur model;

	private static final long serialVersionUID = 1L;

	public Fenetre_Consult_Fournisseurs(JFrame _parent, String title) {

		super(_parent, title);
		this.setBounds(80, 20, 800, 600);
		this.setTitle(title);

		setLayout(new BorderLayout());

		// ZONESUD
		ZoneSud = new JPanel();
		ZoneSud.setBackground(Color.lightGray);
		ZoneSud.setPreferredSize(new Dimension(900, 60));

		// Créer les boutons
		quitter = new JButton("Quitter"); // creation du bouton
		quitter.addActionListener(this); // actionListener
		quitter_panel = new JPanel(); // creation du jpanel du bouton

		quitter_panel.setBackground(Color.lightGray);// set color de
														// fournisseurs_panel
		quitter_panel.add(quitter);// adition de bouton au jpanel
		quitter.setPreferredSize(new Dimension(110, 40));// dimensioné le
															// bouton
		ZoneSud.add(quitter_panel);// add jpanel à la zone sud

		// ZONECENTRE
		ZoneCentre = new JPanel();
		ZoneCentre.setBackground(Color.lightGray);
		ZoneCentre.setPreferredSize(new Dimension(900, 550));
		ZoneCentre.setLayout(new BorderLayout());

		// JTABLE
		model = new MyTableModel_Fournisseur();
		tableau = new JTable(model);
		tableau.setFillsViewportHeight(true);
		scpane1 = new JScrollPane(tableau);
		scpane1.setViewportView(tableau);

		// show tous les fournisseurs
		List<Fournisseur> fourn = FournisseurServiceLocator.getService().getTousFournisseurs();
		
		for (int i = 0; i < fourn.size(); i++) {
			tableau.setValueAt(fourn.get(i).getId(), i, 1);
			tableau.setValueAt(fourn.get(i).getNom_fournisseur(), i, 2);
			tableau.setValueAt(fourn.get(i).getAdresse(), i, 3);
			tableau.setValueAt(fourn.get(i).getEmail(), i, 4);
			tableau.setValueAt(fourn.get(i).getTelephone(), i, 5);
		}

		ZoneCentre.add(scpane1);

		// ZONENORD
		ZoneNord = new JPanel();
		label_entete = new JLabel("Fournisseurs existants");
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

		// Ajouter Panelprincipal
		this.add(PanelPrincipal, BorderLayout.CENTER);


	}

	public void refresh(Fournisseur f) {
		model.addFournisseur(f);

	}

	/**
	 * @return the tableau
	 */
	public JTable getTableau() {
		return tableau;
	}

	/**
	 * @param tableau
	 *            the tableau to set
	 */
	public void setTableau(JTable tableau) {
		this.tableau = tableau;
	}

	/**
	 * 
	 */

	// Méthode de l'interface ActionListener
	public void actionPerformed(ActionEvent e) {
		// QUITTER
		if (e.getSource() == quitter) {
			this.setVisible(false);
		}
	}
}
