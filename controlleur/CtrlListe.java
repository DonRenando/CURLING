package controlleur;

import java.util.Vector;

import vue.*; 

public class CtrlListe {
	
	private String nomFichier;
	
	// Constructeur
	public CtrlListe(String pNomFichier){
		this.nomFichier=pNomFichier;
	}
	
	// Retourne le nom du fichier
	public String getNomFichier(){
		return this.nomFichier;
	}
	
	// cette méthode permet de creer la boite de dialgue DlgListe
	public DlgListe newDlgListe(CtrlListe pMonCtrl){
		return (new DlgListe(pMonCtrl));
	}
	
	public Vector<String> mesUrlDef(Vector<String> pMesUrl){
	// Cette Méthode renvoie sous forme de vector tous les url défectueux
		
		// TODO à developper
		return null;
	}

	public boolean estDefectueux(String pUrl){
		// Cette méthode perlet de savoir si l'url passé en paramètre est ok ou ko
		
		// TODO à developper
		return true;
	}
	
	public Vector<String> mesUrl(){
		// Cette méthode permet de renvoyer la liste de toutes les url du fichier

		// TODO à developper
		return null;
	}
	
	
}
