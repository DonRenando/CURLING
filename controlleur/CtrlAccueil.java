package controlleur;

import vue.*;

public class CtrlAccueil {
	
	public boolean fichierExiste(String pMonFichier){
		// Cette méthode vérifie si le nom du fichier passé en paramètre existe 
		// en tant que fichier.
		
		// TODO à developper
		
		return true;
	}
	
	public DlgAccueil newDlgAccueil(CtrlAccueil pMonCtrl){
		// Cette méthode crée une boite de dialogue DlgAccueil avec son controlleur 
		// passé en paramètre
		
		return (new DlgAccueil(pMonCtrl)); 
	}
	
	public int afficherListe(String pNomFichier){
		// On teste si le fichier existe
		// Si il existe, on crée la nouvelle fenêtre par l'intermédiaire de CtrlListe;
		
		if (fichierExiste(pNomFichier) == true){
			CtrlListe newCtrl= new CtrlListe(pNomFichier);
			newCtrl.newDlgListe(newCtrl);
			return 0;
		}
		return 1;
	}
	

}
