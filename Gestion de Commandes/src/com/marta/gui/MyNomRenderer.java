package com.marta.gui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

//definir le type - views
class MyNomRenderer extends DefaultTableCellRenderer {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2014453315336768232L;
private static Color backColor;
 static {
	backColor = new Color(210,255,210);
 }
 public Component getTableCellRendererComponent(JTable table,Object value,
						   boolean isSelected, 
						   boolean hasFocus,int ligne,
						   int colonne) {
	Component c = super.getTableCellRendererComponent(table,value,
						    isSelected,hasFocus,
						    ligne,colonne);
	c.setForeground(Color.black);
	c.setBackground(backColor);
	((JLabel)c).setHorizontalAlignment(SwingConstants.LEFT);
	return c;
 }
}