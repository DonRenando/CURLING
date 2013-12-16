package jfilechooserdemo;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.event.*;
import java.util.*;


public class az extends JFrame implements DocumentListener, ActionListener
{
	
	private JButton Parcourir, Valider, Liste;
	private JTextField url; 
	private String nomfichier;
	private JLabel label1;
	//checkUrl, listChecked;


		public az(String pTitle){
			
			super(pTitle);
			setLayout(null);
			setBounds(450,200,600,200);
		
		url = new JTextField(null);
		url.setBounds(25,50,325,25);
		add(url);
			
		Parcourir = new JButton("Parcourir");
		Parcourir.setBounds(355, 50, 100, 25);
		add(Parcourir);

		
		Valider = new JButton("Valider");
		Valider.setBounds(25, 100, 100, 25);
		add(Valider);
		
		Liste = new JButton("Liste");
		Liste.setBounds(140, 100, 100, 25);
		add(Liste);
		
		label1 = new JLabel();
		label1.setText("Testeur d'URL");
		label1.setBounds(25, 10, 100, 25);
		add(label1);
		
		
		url.setEditable(false);
		Valider.setEnabled(false);
		url.getDocument().addDocumentListener(this);
		Parcourir.addActionListener(this);
		Liste.addActionListener(this);
		
}
		//-------------------------------------------------------------------------------
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == this.Parcourir){
				choix frame = new choix();
				url.setText(frame.fileName);
				nomfichier = frame.fileName;
				Valider.setEnabled(true);
			}
			
		}
			
			
			class choix extends JFrame {

				JFileChooser choix;
				String fileName;
				
				public choix() {
					choix = new JFileChooser();
					int recherche = choix.showOpenDialog(new JFrame());
					if (recherche == JFileChooser.APPROVE_OPTION) {
					fileName = choix.getSelectedFile().getPath();
					}
				
			
			}
			
		}


			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				
			}
}

	