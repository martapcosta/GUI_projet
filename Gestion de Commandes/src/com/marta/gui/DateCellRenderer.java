package com.marta.gui;

import java.text.SimpleDateFormat;

import javax.swing.table.DefaultTableCellRenderer;


public class DateCellRenderer extends DefaultTableCellRenderer {
    /**
	 * 
	 */
	private static final long serialVersionUID = -2501400339223876659L;

	public DateCellRenderer() { super(); }

    @Override
    public void setValue(Object value) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        setText((value == null) ? "" : sdf.format(value));
    }
}