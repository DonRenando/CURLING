package controleur;

import vue.*;

public class CtrlAccueil {
	
	
	/**
	 * Permet de creer une nouvelle boite de dialogue, DlgAccueil<BR>
	 * @return		retourne la boite de dialgue DlgAccueil avec son Controleur en param�tre
	 */
	public DlgAccueil newDlgAccueil(){
		return (new DlgAccueil(this)); 
	}
	
	
	
	/**
	 * Permet d'afficher la liste des url defectueux en creant un nouveau controlleur. 
	 * Ce nouveau controlleur s'occupe lui m�me de creer la boite de dialogue DlgListe<BR>
	 * @param		pNomFichier			Le nom de l'utilisateur
	 */
	public void afficherListe(String pNomFichier){
		// On cr�e la nouvelle fen�tre par l'interm�diaire de CtrlListe;
		CtrlListe newCtrl= new CtrlListe(pNomFichier);
		newCtrl.newDlgListe();
	}
	

}
