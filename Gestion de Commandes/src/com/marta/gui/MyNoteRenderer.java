package com.marta.gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

class MyNoteRenderer extends DefaultTableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1150798613318638472L;
	private static Color backColor;
    static {
	backColor = new Color(210,210,255);
    }
    public Component getTableCellRendererComponent(JTable table,Object value,
						   boolean isSelected, 
						   boolean hasFocus,int ligne,
						   int colonne) {
	Component c = super.getTableCellRendererComponent(table,value,
						    isSelected,hasFocus,
						    ligne,colonne);
	c.setForeground(Color.red);
	c.setBackground(backColor);
	((JLabel)c).setHorizontalAlignment(SwingConstants.CENTER);
	return c;
    }
}