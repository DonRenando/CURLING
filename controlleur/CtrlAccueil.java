package controlleur;

import vue.*;

public class CtrlAccueil {
	
	public boolean fichierExiste(String pMonFichier){
		// Cette m�thode v�rifie si le nom du fichier pass� en param�tre existe 
		// en tant que fichier.
		
		// TODO � developper
		
		return true;
	}
	
	public DlgAccueil newDlgAccueil(CtrlAccueil pMonCtrl){
		// Cette m�thode cr�e une boite de dialogue DlgAccueil avec son controlleur 
		// pass� en param�tre
		
		return (new DlgAccueil(pMonCtrl)); 
	}
	
	public int afficherListe(String pNomFichier){
		// On teste si le fichier existe
		// Si il existe, on cr�e la nouvelle fen�tre par l'interm�diaire de CtrlListe;
		
		if (fichierExiste(pNomFichier) == true){
			CtrlListe newCtrl= new CtrlListe(pNomFichier);
			newCtrl.newDlgListe(newCtrl);
			return 0;
		}
		return 1;
	}
	

}
