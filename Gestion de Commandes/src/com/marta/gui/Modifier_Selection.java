package com.marta.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Modifier_Selection extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1561293664330618743L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JButton btnOk;

	/**
	 * Create the frame.
	 */
	public Modifier_Selection(JFrame _parent, String title) {

		super(_parent, title);

		setBounds(100, 100, 450, 100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("S\u00E9lectionnez la ligne \u00E0 modifier svp!");
		lblNewLabel.setBounds(34, 24, 264, 14);
		contentPane.add(lblNewLabel);

		btnOk = new JButton("OK");
		btnOk.setBounds(280, 24, 89, 23);
		btnOk.addActionListener(this);
		contentPane.add(btnOk);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == btnOk) {
			this.setVisible(false);
		}
	}
}