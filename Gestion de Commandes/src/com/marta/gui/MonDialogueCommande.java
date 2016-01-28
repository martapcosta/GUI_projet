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


public class MonDialogueCommande  extends JDialog implements ActionListener
//public class MonDialogueCommande extends JFrame implements ActionListener
{
	/*public static void  main(String param[])
	{
		MonDialogueCommande md = new MonDialogueCommande("TEST");
	} // Fin de la méthode de test main()*/
	
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

	//public MonDialogueCommande(String title)
	
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
		date_arrive_txtfield = new JFormattedTextField (new Date());
		date_fin_stock_txtfield = new JFormattedTextField (new Date());
		
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
		
		
		// Création de la boîte de dialogue
		new_fournisseur = new Nouveau_fournisseur(this, "Nouveau Fournisseur");

	
		add(panelCentre,BorderLayout.CENTER);
		add(panelSud,BorderLayout.SOUTH);
		
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setVisible(true);
		//Initialize this dialog to its preferred size.
		pack();
		//setBounds(80, 20, 900, 500);
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
			commande.setDescriptif_produit(this.desc_produit_txtfield.getText());
			
			//TODO a completar com os outros campos
			
			CommandeServiceLocator.getService().save(commande);
			
			//clean champs
			desc_produit_txtfield.setText(null);
			
			//TODO a completar com os outros campos
			
			//refresh jtable
			((FenetrePrincipale)this.getParent()).refresh();
			
		}
		else if(source == ajout_fournisseur)
		{
			if (new_fournisseur == null) {
				new_fournisseur = new Nouveau_fournisseur(this, "Nouveau Fournisseur");
			}
			new_fournisseur.setVisible(true);
		}
	}	
}