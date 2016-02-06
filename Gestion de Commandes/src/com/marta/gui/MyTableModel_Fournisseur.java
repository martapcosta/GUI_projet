package com.marta.gui;

import java.util.ArrayList;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableRowSorter;

import com.marta.domain.Fournisseur;

public class MyTableModel_Fournisseur extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7637178458609017553L;
	
	private TableModelListener l;
	private  ArrayList<Fournisseur> fournisseurs = new ArrayList<Fournisseur>();
	private final String[] entetes = {"Nom du Fournisseur",
									 "Adresse",
									 "email",
									 "Téléphone"};
	
	public MyTableModel_Fournisseur (){
		super();
		addTableModelListener(l);
			
	}
		
	@Override
	public int getRowCount() {
		return fournisseurs.size();
	}

	@Override
	public int getColumnCount() {
		return entetes.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {	
		switch (columnIndex) {
		case 0: return fournisseurs.get(rowIndex).getId();
		case 1: return fournisseurs.get(rowIndex).getNom_fournisseur();
		case 2: return fournisseurs.get(rowIndex).getAdresse();
		case 3: return fournisseurs.get(rowIndex).getEmail();
		case 4: return fournisseurs.get(rowIndex).getTelephone();
		}			
	return null;
	}

	public String getColumnName(int columnIndex){
		return entetes[columnIndex];
	}
	
    public boolean isCellEditable(int rowIndex,int columnIndex) {
		return columnIndex>0;
		//TODO
    }
    
//    public Class getColumnClass(int columnIndex) {
//		return getValueAt(0,columnIndex).getClass();
//    }
    
	// set donnees
    public void setValueAt(Object v, int rowIndex, int columnIndex) {
		switch (columnIndex) {
			case 0: fournisseurs.get(rowIndex).setId((Integer)v);
			break;
			case 1: fournisseurs.get(rowIndex).setNom_fournisseur((String)v); 
			break;
			case 2: fournisseurs.get(rowIndex).setAdresse((String)v);
			break;
			case 3: fournisseurs.get(rowIndex).setEmail((String)v); 
			break;
			case 4: fournisseurs.get(rowIndex).setTelephone((String)v);
			break;
		}
		System.out.println("changement de donnees");
		fireTableDataChanged();
    }
    
    public void addFournisseur(Fournisseur f) {
        fournisseurs.add(f);
        /**
    	 * fireTableRowsInserted - Notifies all listeners that rows in the range 
    	 * [firstRow, lastRow], inclusive, have been inserted.
    	 */
        //
        fireTableRowsInserted(fournisseurs.size() -1, fournisseurs.size() -1);
    }
 
    public void removeFournisseur(int rowIndex) {
        fournisseurs.remove(rowIndex);
         
        fireTableRowsDeleted(rowIndex, rowIndex);
    }
}

// trier
class MyTableRowSorterFournisseur extends TableRowSorter<MyTableModel_Fournisseur> {
    public MyTableRowSorterFournisseur(MyTableModel_Fournisseur m) {
		super(m);
    } 
}  