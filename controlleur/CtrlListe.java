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
	
	// cette m�thode permet de creer la boite de dialgue DlgListe
	public DlgListe newDlgListe(CtrlListe pMonCtrl){
		return (new DlgListe(pMonCtrl));
	}
	
	public Vector<String> mesUrlDef(Vector<String> pMesUrl){
	// Cette M�thode renvoie sous forme de vector tous les url d�fectueux
		
		// TODO � developper
		return null;
	}

	public boolean estDefectueux(String pUrl){
		// Cette m�thode perlet de savoir si l'url pass� en param�tre est ok ou ko
		
		// TODO � developper
		return true;
	}
	
	public Vector<String> mesUrl(){
		// Cette m�thode permet de renvoyer la liste de toutes les url du fichier

		// TODO � developper
		return null;
	}
	
	
}
