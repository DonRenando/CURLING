package vue;

import controlleur.*;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

public class DlgAccueil extends JFrame {
	
	private CtrlAccueil monCtrl=null;
	
	public DlgAccueil(CtrlAccueil pMonCtrl){
		this.monCtrl=pMonCtrl;
		initComponents();
	}
	
	public int valider(String pNomFichier){
		return (monCtrl.afficherListe(pNomFichier));
	}
	
	private void initComponents() {

		label2 = new JLabel();
		label1 = new JLabel();
		textField1 = new JTextField();
		button1 = new JButton();
		
		//super("Acceuil CURLING");

		this.setResizable(true);
		this.setVisible(true);


		setLayout(new FormLayout(
			"2*(default, $lcgap), 31dlu, 8*($lcgap, default)",
			"default, $lgap, 27dlu, 9*($lgap, default)"));

		//---- label2 ----
		label2.setText("Test des URLs dans le fichier");
		add(label2, CC.xywh(5, 3, 12, 1));

		//---- label1 ----
		label1.setText("Fichier :");
		add(label1, CC.xy(5, 5, CC.RIGHT, CC.DEFAULT));

		//---- textField1 ----
		textField1.setText("Nom du fichier");
		add(textField1, CC.xywh(7, 5, 15, 1));

		//---- button1 ----
		button1.setText("Valider");
		add(button1, CC.xy(7, 9));
		button1.addActionListener(new valider());
		
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	private JLabel label2;
	private JLabel label1;
	private JTextField textField1;
	private JButton button1;
	
	// Lorsque l'on clique sur le bouton
	class valider implements ActionListener {		
		public void actionPerformed(ActionEvent arg0) {
			
			String pNomFichier = textField1.getText();
			if (valider(pNomFichier) == 1) // Si fichier inexistant
			{
				// Modifier le texte de l'entrée standart
				// ajouter: "fichier inexistant" et le mettre en rouge.
				Color redColor = new Color(255 , 0 , 0);
				textField1.setForeground(redColor);
				textField1.setText("Fichier inexistant");
			}
		}
	}


}
