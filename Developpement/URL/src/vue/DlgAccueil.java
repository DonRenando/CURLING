package vue;

import controleur.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFileChooser;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DlgAccueil extends JFrame implements DocumentListener, ActionListener
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton Parcourir, Valider, Liste;
	private JTextField url; 
	private String nomfichier;
	private JLabel label1;
	private CtrlAccueil monCtrl;

	
		public String getNomFichier() {
			return this.nomfichier;
		}

		public DlgAccueil(CtrlAccueil pMonCtrl){
			super("CURLING");
			this.monCtrl= pMonCtrl;
			setLayout(null);
			setBounds(200,200,600,200);
		
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
		//add(Liste);
		
		label1 = new JLabel();
		label1.setText("Testeur d'URL");
		label1.setBounds(25, 10, 100, 25);
		add(label1);
		
		//url.setEditable(false);
		Valider.setEnabled(false);
		url.getDocument().addDocumentListener(this);
		
		Parcourir.addActionListener(this);
		Liste.addActionListener(this);
		Valider.addActionListener(new Valider());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
		
		
		
}
		//-------------------------------------------------------------------------------
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == this.Parcourir){
				choix frame = new choix();
				url.setText(frame.fileName);
				nomfichier = frame.fileName;
			}
			
		}
		
		// Lorsque l'on clique sur le bouton
		class Valider implements ActionListener {		
			public void actionPerformed(ActionEvent arg0) {
				String pNomFichier = url.getText();
				valider(pNomFichier);
			}
		}
		
			
			class choix extends JFrame {

				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;
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
			}


			/**
			 * Permet d'activer le bouton valider que lorsque l'utilisateur � choisi un fichier<BR>
			 * @param		arg0	le fichier choisi
			 */
			public void insertUpdate(DocumentEvent arg0) {
				Valider.setEnabled(true);
			}
			
			@Override
			public void removeUpdate(DocumentEvent arg0) {
				
			}
			
			
			/**
			 * Permet d'afficher la liste des url defectueuses en faisant appel � son controleur<BR>
			 * @param		pNomFichier			Le nom de l'utilisateur
			 */
			public void valider(String pNomFichier){
				this.monCtrl.afficherListe(pNomFichier);
			}
}


