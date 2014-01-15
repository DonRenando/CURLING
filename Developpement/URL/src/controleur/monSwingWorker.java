																									package controleur;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.concurrent.ExecutionException;
import javax.swing.SwingWorker;
import modele.MyTableModel;
import modele.ProcessBarListener;
import vue.DlgListe;
import vue.DlgTask;

public class monSwingWorker extends SwingWorker<String[][], String> implements ProcessBarListener{
	
	private DlgListe maVue;
	private int nbIterations, nbFiles, nbFilesDone;
	private DlgTask process;
	
	/**
	 * Permet de retourner le listener de la classe<BR>
	 * @return		retourne le listener de la classe (ProcessBarListener)
	 */
	public ProcessBarListener getListener() {
		return this;
	}
	
	/**
	 * Constructeur param�tr� de CtrlListe, il initialise la vue, demarre le SwingWorker<BR>
	 * @param		pVue		la vue DlgListe
	 */
	public monSwingWorker(DlgListe pVue){
		this.maVue=pVue;
		this.process = new DlgTask(this.maVue);
		
		addPropertyChangeListener(new PropertyChangeListener() {
			 
			public void propertyChange(PropertyChangeEvent evt) {
				if ("progress".equals(evt.getPropertyName())) {
					process.getProcessBar().setValue((Integer) evt.getNewValue());
					process.getLabel().setText(" Fichier en cours: "+ (Integer) evt.getNewValue() +" %");
					process.getNbFilesLabel().setText("Fichiers trait�s: "+ nbFilesDone +" / " + nbFiles +"  ");
				}
			}
		});
	}

	
	/**
	 * Execute une tache longue en arri�re plan dans un Thread<BR>
	 * @return		retourne String[][] (nomFichier, et url defectueuse)
	 */
	protected String[][] doInBackground() throws Exception {
		return maVue.listUrlDef(this.getListener());		
	}

	/**
	 * cette fontion s'ex�cute lorsque la fonction doInBackground aura termin�, elle met a jour DlgListe<BR>
	 */
	protected void done(){
		try {
			
			// Nom des colonnes de la JTable
			String nom[]= { "Nom du fichier", "Url" };
			
			// On cr�e un TableModel
			MyTableModel newTable= new MyTableModel(get(), nom);
			
			// On met � jour la JTable
			maVue.getTable().setModel(newTable);

			// Lorsque la tache est termin� on ferme la fen�tre de chargement
			process.setVisible(false);
			
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Cette fonction pr�ciser � la classe le nombre de liens � traiter<BR>
	 * @param		nbI		Nombre de lien � traiter dans un fichier
	 */
	public void nbIterations(int nbI){
		this.nbIterations=nbI;
	}
	
	/**
	 * Cette fonction permet de valider l'avancement en pourcentage du traitement de fichier en cours de traitement<BR>
	 * @param		i	le 'i'�me lien trait�
	 */
	public void taskProcessing(int i) {
        // Calcul de l'avancement en %
        this.setProgress(((i + 1) * 100) / this.nbIterations);
	}

	/**
	 * Cette fonction permet de fournir � l'objet MonSwingWorker le nombre de fichier a traiter<BR>
	 * @param		nb		le nombre de fichier � traiter
	 */
	public void nbFiles(int nb) {
		this.nbFiles= nb;
	}

	/**
	 * Cette fonction permet de fournir � l'objet MonSwingWorker le nombre de fichier qui ont �t� trait�<BR>
	 * @param		nb		le nombre de fichier qui ont �t� trait�
	 */
	public void nbFilesDone(int nb) {
		this.nbFilesDone = nb;		
	}

}
