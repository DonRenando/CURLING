package vue;

import java.awt.GridLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class DlgTask extends JDialog {

	private static final long serialVersionUID = 1L;
	private JProgressBar progressBar;
	private JLabel percent, nbFiles;
	
	/**
	 * Cette fonction permet de retourner le progressBar<BR>
	 * @return		retourne le progress bar
	 */
	public JProgressBar getProcessBar() {
		return this.progressBar;
	}
	
	/**
	 * Cette fonction permet de retourner le pourcentage (JLabel)<BR>
	 * @return		retourne le pourcentage (JLabel)
	 */
	public JLabel getLabel(){
		return this.percent;
	}
	
	/**
	 * Cette fonction permet de retourner le label avec pr�ciser le nombre de fichier trait� et � traiter<BR>
	 * @return		retourne le JLabel correspondant
	 */
	public JLabel getNbFilesLabel(){
		return this.nbFiles;
	}
	
	/**
	 * Constructeur param�tr� de DlgTask, il initialise la vue DlgListe (pass� en param�tre)<BR>
	 * @param		pVue		DlgListe
	 */
	public DlgTask(DlgListe pVue) {
		super(pVue, "Chargement");
		
		// D�finir la fen�tre elle-m�me		
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		
		// D�claration JPanel : 
		JPanel top= new JPanel();
		top.setLayout(new GridLayout(3,1));
		
		// TextField en cours:
		nbFiles = new JLabel("Fichiers trait�s: 0 / 1  ");
		nbFiles.setHorizontalAlignment(JLabel.RIGHT);
		nbFiles.setVerticalAlignment(JLabel.CENTER);
		
		
		// TextField en cours:
		percent = new JLabel(" Fichier en cours: 0 %");
		percent.setHorizontalAlignment(JLabel.LEFT);
		percent.setVerticalAlignment(JLabel.CENTER);
		
		// ProcessBar :
	    progressBar = new JProgressBar(0, 100);
	    progressBar.setValue(0);
	    add(progressBar);
	    
	    // Ajout dans le JPanel :
	    top.add(nbFiles);
	    top.add(percent);
	    top.add(progressBar);
	    
	    // Ajout du JPanel dans la fen�tre :
	    this.add(top);
	    
	    // Ajustement taille fen�tre :
		this.setBounds(310, 360, 300, 80);
		
		// Afficher la fen�tre : 
		this.setVisible(true);
	}

	
}
