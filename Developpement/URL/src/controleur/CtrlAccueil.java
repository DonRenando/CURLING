package controleur;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import vue.*;

public class CtrlAccueil {
	
	/**
	 * Permet de v�rifier si le fichier existe.<BR>
	 * @param		pNomFichier			Le nom du fichier
	 * @return		retourne true si le fichier existe sinon false
	 */
	public boolean fichierExiste(String pNomFichier){
		try{
		    new BufferedReader(new FileReader(pNomFichier));
		    //si le fichier existe
		    return true;
		} catch (FileNotFoundException fnfe) {
		   //si le fichier n'existe pas
			return false;
		}
	}
	
	/**
	 * Permet de creer une nouvelle boite de dialogue, DlgAccueil<BR>
	 * @param		pMonCtrl		le controlleur de son createur
	 * @return		retourne la boite de dialgue DlgAccueil
	 */
	public DlgAccueil newDlgAccueil(CtrlAccueil pMonCtrl){
		return (new DlgAccueil(pMonCtrl)); 
	}
	
	/**
	 * Permet d'afficher la liste des url defectueux (si le fichier existe) en creant un nouveau controlleur. 
	 * Ce nouveau controlleur s'occupe lui m�me de creer la boite de dialogue DlgListe<BR>
	 * @param		pNomFichier			Le nom de l'utilisateur
	 * @return		retourne  1 si le fichier n'existe pas et 0 si tout c'est bien pass�.
	 */
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
