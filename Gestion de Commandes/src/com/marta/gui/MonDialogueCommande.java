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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.marta.domain.Commande;


public class MonDialogueCommande  extends JDialog implements ActionListener	{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//private FenetrePrincipale parent;
	
	private JPanel panelCentre,panelSud;
	
	
	private JComboBox<Object>  fournisseur_box, unite_box;
	private JButton enregistrer, ajout_fournisseur;
	private JLabel desc_produit, quantite, unite, fournisseur, date_command, prix;
	private JLabel date_arrive, date_fin_stock;
	private JTextField desc_produit_txtfield;
	private JFormattedTextField quantite_txtfield, prix_txtfield, date_command_txtfield,
											date_arrive_txtfield, date_fin_stock_txtfield;
	private JLabel phrase_champs_oblig;
	
	private GridBagConstraints gbc = new GridBagConstraints();

	private Nouveau_fournisseur new_fournisseur = null;
	private Dialog_Modif_Succes new_dialog_modif_succ = null;


	public MonDialogueCommande(JFrame _parent, String title)
	{
		// false --> dialogue non modal
		super(_parent, title);//, false);
		
		
		setLayout(new BorderLayout());
		
		//ZONE CENTRE
		panelCentre = new JPanel();
		//panelCentre.setPreferredSize(new Dimension(850,450));
		panelCentre.setLayout(new GridBagLayout());
		
		// Créer les labels nord
		desc_produit = new JLabel("*Descriptif du produit  ");
		quantite = new JLabel("*Quantité  ");
		unite = new JLabel("*Unité  ");
		fournisseur = new JLabel ("*Fournisseur  ");
		prix =  new JLabel ("*Prix de la commande (CHF):  ");
		date_command = new JLabel ("*Commande effectuée le:  ");
		date_arrive = new JLabel ("Commande arrivée le:  ");
		date_fin_stock = new JLabel ("Date fin de stock  ");
		
		
		// Créer les jtextfields nord
		desc_produit_txtfield = new JTextField(20);
		quantite_txtfield = new JFormattedTextField(new Double(0.));
		quantite_txtfield.setPreferredSize(new Dimension (50,20));
		String [] data_unit = new String[4];
		data_unit[0] = "unité(s)";
		data_unit[1] = "kg";
		data_unit[2] = "litres";
		data_unit[3] = "gr";
	
		unite_box = new JComboBox<Object>(data_unit);//combobox model
		
		//TEST- CHANGER APRES!!!!
		String [] data_fournisseur = new String[4];
		data_fournisseur[0] = "Ricoh";
		data_fournisseur[1] = "Imprimerie XXXX";
		data_fournisseur[2] = "Nespresso";
		data_fournisseur[3] = "XXXXX";
	
		fournisseur_box = new JComboBox<Object>(data_fournisseur);//combobox model
		
		prix_txtfield = new JFormattedTextField (new Double(0.));
		prix_txtfield.setPreferredSize(new Dimension (50,20));
		date_command_txtfield = new JFormattedTextField (new Date());
		date_command_txtfield.setPreferredSize(new Dimension (80,20));
		date_arrive_txtfield = new JFormattedTextField (new Date());
		date_arrive_txtfield.setPreferredSize(new Dimension (80,20));
		date_fin_stock_txtfield = new JFormattedTextField (new Date());
		date_fin_stock_txtfield.setPreferredSize(new Dimension (80,20));
		
		
		gbc.insets = new Insets(4,4,4,4);
		addComponents(desc_produit, desc_produit_txtfield, panelCentre,gbc);
		addComponents(quantite, quantite_txtfield, panelCentre,gbc);
		addComponentsComboBox(unite, unite_box, panelCentre,gbc);
		addComponentsComboBox(fournisseur, fournisseur_box, panelCentre,gbc);
		addComponents(prix, prix_txtfield, panelCentre,gbc);
		addComponents(date_command, date_command_txtfield, panelCentre,gbc);
		addComponents(date_arrive, date_arrive_txtfield, panelCentre,gbc);
		addComponents(date_fin_stock, date_fin_stock_txtfield, panelCentre,gbc);
		
		//ZONE SUD
		panelSud = new JPanel();
		panelSud.setLayout(new FlowLayout());
				
		// Créer les boutons
		enregistrer = new JButton("Enregistrer");
		enregistrer.addActionListener(this);
		ajout_fournisseur = new JButton("Ajouter un fournisseur");
		ajout_fournisseur.addActionListener(this);
		
		//Phrase champs obligatoires
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
		
		add(panelCentre,BorderLayout.CENTER);
		add(panelSud,BorderLayout.SOUTH);
		
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setVisible(true);
		//Initialize this dialog to its preferred size.
		pack();
		setLocationRelativeTo(_parent);
		//setBounds(80, 20, 900, 500);
	}
	
	/**
	 * @return the panelCentre
	 */
	public JPanel getPanelCentre() {
		return panelCentre;
	}

	/**
	 * @param panelCentre the panelCentre to set
	 */
	public void setPanelCentre(JPanel panelCentre) {
		this.panelCentre = panelCentre;
	}

	/**
	 * @return the panelSud
	 */
	public JPanel getPanelSud() {
		return panelSud;
	}

	/**
	 * @param panelSud the panelSud to set
	 */
	public void setPanelSud(JPanel panelSud) {
		this.panelSud = panelSud;
	}

	/**
	 * @return the fournisseur_box
	 */
	public JComboBox<Object> getFournisseur_box() {
		return fournisseur_box;
	}

	/**
	 * @param fournisseur_box the fournisseur_box to set
	 */
	public void setFournisseur_box(JComboBox<Object> fournisseur_box) {
		this.fournisseur_box = fournisseur_box;
	}

	/**
	 * @return the unite_box
	 */
	public JComboBox<Object> getUnite_box() {
		return unite_box;
	}

	/**
	 * @param unite_box the unite_box to set
	 */
	public void setUnite_box(JComboBox<Object> unite_box) {
		this.unite_box = unite_box;
	}

	/**
	 * @return the enregistrer
	 */
	public JButton getEnregistrer() {
		return enregistrer;
	}

	/**
	 * @param enregistrer the enregistrer to set
	 */
	public void setEnregistrer(JButton enregistrer) {
		this.enregistrer = enregistrer;
	}

	/**
	 * @return the ajout_fournisseur
	 */
	public JButton getAjout_fournisseur() {
		return ajout_fournisseur;
	}

	/**
	 * @param ajout_fournisseur the ajout_fournisseur to set
	 */
	public void setAjout_fournisseur(JButton ajout_fournisseur) {
		this.ajout_fournisseur = ajout_fournisseur;
	}

	/**
	 * @return the desc_produit
	 */
	public JLabel getDesc_produit() {
		return desc_produit;
	}

	/**
	 * @param desc_produit the desc_produit to set
	 */
	public void setDesc_produit(JLabel desc_produit) {
		this.desc_produit = desc_produit;
	}

	/**
	 * @return the quantite
	 */
	public JLabel getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(JLabel quantite) {
		this.quantite = quantite;
	}

	/**
	 * @return the unite
	 */
	public JLabel getUnite() {
		return unite;
	}

	/**
	 * @param unite the unite to set
	 */
	public void setUnite(JLabel unite) {
		this.unite = unite;
	}

	/**
	 * @return the fournisseur
	 */
	public JLabel getFournisseur() {
		return fournisseur;
	}

	/**
	 * @param fournisseur the fournisseur to set
	 */
	public void setFournisseur(JLabel fournisseur) {
		this.fournisseur = fournisseur;
	}

	/**
	 * @return the date_command
	 */
	public JLabel getDate_command() {
		return date_command;
	}

	/**
	 * @param date_command the date_command to set
	 */
	public void setDate_command(JLabel date_command) {
		this.date_command = date_command;
	}

	/**
	 * @return the prix
	 */
	public JLabel getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(JLabel prix) {
		this.prix = prix;
	}

	/**
	 * @return the date_arrive
	 */
	public JLabel getDate_arrive() {
		return date_arrive;
	}

	/**
	 * @param date_arrive the date_arrive to set
	 */
	public void setDate_arrive(JLabel date_arrive) {
		this.date_arrive = date_arrive;
	}

	/**
	 * @return the date_fin_stock
	 */
	public JLabel getDate_fin_stock() {
		return date_fin_stock;
	}

	/**
	 * @param date_fin_stock the date_fin_stock to set
	 */
	public void setDate_fin_stock(JLabel date_fin_stock) {
		this.date_fin_stock = date_fin_stock;
	}

	/**
	 * @return the desc_produit_txtfield
	 */
	public JTextField getDesc_produit_txtfield() {
		return desc_produit_txtfield;
	}

	/**
	 * @param desc_produit_txtfield the desc_produit_txtfield to set
	 */
	public void setDesc_produit_txtfield(JTextField desc_produit_txtfield) {
		this.desc_produit_txtfield = desc_produit_txtfield;
	}

	/**
	 * @return the quantite_txtfield
	 */
	public JFormattedTextField getQuantite_txtfield() {
		return quantite_txtfield;
	}

	/**
	 * @param quantite_txtfield the quantite_txtfield to set
	 */
	public void setQuantite_txtfield(JFormattedTextField quantite_txtfield) {
		this.quantite_txtfield = quantite_txtfield;
	}

	/**
	 * @return the prix_txtfield
	 */
	public JFormattedTextField getPrix_txtfield() {
		return prix_txtfield;
	}

	/**
	 * @param prix_txtfield the prix_txtfield to set
	 */
	public void setPrix_txtfield(JFormattedTextField prix_txtfield) {
		this.prix_txtfield = prix_txtfield;
	}

	/**
	 * @return the date_command_txtfield
	 */
	public JFormattedTextField getDate_command_txtfield() {
		return date_command_txtfield;
	}

	/**
	 * @param date_command_txtfield the date_command_txtfield to set
	 */
	public void setDate_command_txtfield(JFormattedTextField date_command_txtfield) {
		this.date_command_txtfield = date_command_txtfield;
	}

	/**
	 * @return the date_arrive_txtfield
	 */
	public JFormattedTextField getDate_arrive_txtfield() {
		return date_arrive_txtfield;
	}

	/**
	 * @param date_arrive_txtfield the date_arrive_txtfield to set
	 */
	public void setDate_arrive_txtfield(JFormattedTextField date_arrive_txtfield) {
		this.date_arrive_txtfield = date_arrive_txtfield;
	}

	/**
	 * @return the date_fin_stock_txtfield
	 */
	public JFormattedTextField getDate_fin_stock_txtfield() {
		return date_fin_stock_txtfield;
	}

	/**
	 * @param date_fin_stock_txtfield the date_fin_stock_txtfield to set
	 */
	public void setDate_fin_stock_txtfield(JFormattedTextField date_fin_stock_txtfield) {
		this.date_fin_stock_txtfield = date_fin_stock_txtfield;
	}

	/**
	 * @return the phrase_champs_oblig
	 */
	public JLabel getPhrase_champs_oblig() {
		return phrase_champs_oblig;
	}

	/**
	 * @param phrase_champs_oblig the phrase_champs_oblig to set
	 */
	public void setPhrase_champs_oblig(JLabel phrase_champs_oblig) {
		this.phrase_champs_oblig = phrase_champs_oblig;
	}

	/**
	 * @return the gbc
	 */
	public GridBagConstraints getGbc() {
		return gbc;
	}

	/**
	 * @param gbc the gbc to set
	 */
	public void setGbc(GridBagConstraints gbc) {
		this.gbc = gbc;
	}

	/**
	 * @return the new_fournisseur
	 */
	public Nouveau_fournisseur getNew_fournisseur() {
		return new_fournisseur;
	}

	/**
	 * @param new_fournisseur the new_fournisseur to set
	 */
	public void setNew_fournisseur(Nouveau_fournisseur new_fournisseur) {
		this.new_fournisseur = new_fournisseur;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private void addComponents(JLabel label, JTextField tf, JPanel p,
                            GridBagConstraints gbc)
 {
     gbc.anchor = GridBagConstraints.EAST;
     gbc.gridwidth = GridBagConstraints.RELATIVE;
     p.add(label, gbc);
     gbc.anchor = GridBagConstraints.WEST;
		gbc.gridwidth = GridBagConstraints.REMAINDER;
     p.add(tf, gbc);
 }

	private void addComponentsComboBox(JLabel label, JComboBox<?> cb, JPanel p,
                            GridBagConstraints gbc)
 {
     gbc.anchor = GridBagConstraints.EAST;
     gbc.gridwidth = GridBagConstraints.RELATIVE;
     p.add(label, gbc);
     gbc.anchor = GridBagConstraints.WEST;
     gbc.gridwidth = GridBagConstraints.REMAINDER;
     p.add(cb, gbc);
 }
	
	public void actionPerformed(ActionEvent event)
	{
		Object source = event.getSource();
		if (source == enregistrer)
		{
			//enresgitrer une commmande
			Commande commande = new Commande();
			//commande.setId(1);
			commande.setDescriptif_produit(this.desc_produit_txtfield.getText());
			commande.setQuantite((double)this.quantite_txtfield.getValue());
			commande.setPrix((double)this.prix_txtfield.getValue());
			commande.setDate_commande((Date)this.date_command_txtfield.getValue());
			commande.setDate_arrivee((Date)this.date_arrive_txtfield.getValue());
			commande.setDate_fin((Date)this.date_fin_stock_txtfield.getValue());
			commande.setFournisseur((String)this.fournisseur_box.getSelectedItem());
			commande.setUnite((String)this.unite_box.getSelectedItem());
					
			CommandeServiceLocator.getService().save(commande);
					
			//clean champs
			desc_produit_txtfield.setText(null);
			quantite_txtfield.setText(null);
			prix_txtfield.setText(null);
			date_command_txtfield.setText(null);
			date_arrive_txtfield.setText(null);
			date_fin_stock_txtfield.setText(null);
					
			
			if (new_dialog_modif_succ == null) {
				new_dialog_modif_succ = new Dialog_Modif_Succes(this, "Confirmation");
			}
			new_dialog_modif_succ.setVisible(true);
			new_dialog_modif_succ.setLocationRelativeTo(getParent());
			//refresh jtable
			((FenetrePrincipale)this.getParent()).refresh(commande);
			
			
		}
		else if(source == ajout_fournisseur)
		{
			if (new_fournisseur == null) {
				new_fournisseur = new Nouveau_fournisseur(this, "Nouveau Fournisseur");
			}
			new_fournisseur.setVisible(true);
			new_fournisseur.setLocationRelativeTo(getParent());
		}
	}	
}