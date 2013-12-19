package controleur;


import java.util.Vector;
import vue.*; 
import modele.*;

public class CtrlListe {
	
	private String nomFichier;
	
	/**
	 * Constructeur param�tr� de CtrlListe, il initialise nomFichier � la valeur de pNomFichier<BR>
	 * @param		pNomFichier		le nom du fichier
	 */
	public CtrlListe(String pNomFichier){
		this.nomFichier=pNomFichier;
	}
	
	/**
	 * Permet d'obtenir le nom du fichier du controlleur<BR>
	 * @return		retourne le nom du fichier
	 */
	public String getNomFichier(){
		return this.nomFichier;
	}

	/**
	 * Permet de creer une nouvelle boite de dialogue, DlgListe<BR>
	 * @return		retourne la boite de dialgue DlgListe avec son Controleur en param�tre
	 */
	public DlgListe newDlgListe(){
		return (new DlgListe(this));
	}
	
	/**
	 * Permet de retourner la liste des Url Defectueuses d'un fichier (pass� en param dans le controleur)<BR>
	 * @return		retourne Vector<String> la liste des Url defectueuses
	 */
	public Vector<String> getListUrlDef() {	
		// Creation de la classe mod�le Url:
		Url monModeleFichier= new Url(this.nomFichier);
		return monModeleFichier.mesUrlDef();
	}
	
}
