package com.marta.gui;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

import com.marta.domain.Commande;

public class MyTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7637178458609017553L;
	
	private TableModelListener l;
	private  ArrayList<Commande> commandes = new ArrayList<Commande>();
	private final String[] entetes = {"ID",
									 "Descriptif",
									 "Quantité",
									 "Unité",						
									 "Fournisseur",
									 "Prix",
									 "Date",
									 "Date arrivé",
									 "Date fin"};
	
	public MyTableModel (){
		super();
		addTableModelListener(l);
			
//		commandes.add(new Commande(1,"Test",12.0,"kg","Test",34.0,
//					  new Date(115,12,30),new Date(115,12,30),new Date(115,12,30)));	
	}
		
	@Override
	public int getRowCount() {
		return commandes.size();
	}

	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {	
		switch (columnIndex) {
		case 0: return commandes.get(rowIndex).getId();
		case 1: return commandes.get(rowIndex).getDescriptif_produit();
		case 2: return commandes.get(rowIndex).getQuantite();
		case 3: return commandes.get(rowIndex).getUnite();
		case 4: return commandes.get(rowIndex).getFournisseur();
		case 5: return commandes.get(rowIndex).getPrix();
		case 6: return commandes.get(rowIndex).getDate_commande();
		case 7: return commandes.get(rowIndex).getDate_arrivee();
		case 8: return commandes.get(rowIndex).getDate_fin();
		}			
	return null;
	}

	public String getColumnName(int columnIndex){
		return entetes[columnIndex];
	}
	
    public boolean isCellEditable(int rowIndex,int columnIndex) {
		return columnIndex>0;
    }
    
//    public Class getColumnClass(int columnIndex) {
//		return getValueAt(0,columnIndex).getClass();
//    }
    
	// set donnees
    public void setValueAt(Object v, int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0: commandes.get(rowIndex).setId((Integer)v);
			break;
			case 1: commandes.get(rowIndex).setDescriptif_produit((String)v); 
			break;
			case 2: commandes.get(rowIndex).setQuantite((Double)v);
			break;
			case 3: commandes.get(rowIndex).setUnite((String)v); 
			break;
			case 4: commandes.get(rowIndex).setFournisseur((String)v);
			break;
			case 5: commandes.get(rowIndex).setPrix((Double)v);
			break;
			case 6: commandes.get(rowIndex).setDate_commande((Date)v);
			break;
			case 7: commandes.get(rowIndex).setDate_arrivee((Date)v);
			break;
			case 8: commandes.get(rowIndex).setDate_fin((Date)v);
			break;
		}
		System.out.println("changement de donnees");
		fireTableDataChanged();
    }
    
    public void addCommande(Commande c) {
        commandes.add(c);
        /**
    	 * fireTableRowsInserted - Notifies all listeners that rows in the range 
    	 * [firstRow, lastRow], inclusive, have been inserted.
    	 */
        //
        fireTableRowsInserted(commandes.size() -1, commandes.size() -1);
    }
 
    public void removeCommande(int rowIndex) {
        commandes.remove(rowIndex);
         
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}

// trier
class MyTableRowSorter extends TableRowSorter<MyTableModel> {
    public MyTableRowSorter(MyTableModel m) {
		super(m);
    } 
}




    