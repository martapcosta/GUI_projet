package com.marta.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dialog_Modif_Succes extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7807422801239582932L;

	
	private JLabel label_conf;

	private JButton okButton;
		
	
	public Dialog_Modif_Succes(JDialog _parent, String title) {

		
			super(_parent, title);
			setBounds(10, 60, 300, 180);
			getContentPane().setLayout(null);
			{
				label_conf = new JLabel("Modification enresgistrée!");
				label_conf.setFont(new Font("Dialog", Font.BOLD, 14));
				label_conf.setBounds(50, 10, 200, 30);
				getContentPane().add(label_conf);
			}
			{
				okButton = new JButton("OK");
				okButton.addActionListener(this);
				
				okButton.setForeground(Color.BLACK);
				okButton.setBounds(110, 50, 70, 50);
				getContentPane().add(okButton);
			}
			

	}
	
	public void actionPerformed(ActionEvent event) {
		Object source = event.getSource();
		if (source == okButton) {
			setVisible(false);
			this.getParent().setVisible(false);
			
		}
	}

}
