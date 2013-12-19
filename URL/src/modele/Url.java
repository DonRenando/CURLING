package modele;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Vector;
import javax.net.ssl.HttpsURLConnection;

public class Url {
	
	private String nomFichier;
	
	/**
	 * Constructeur param�tr� de Url (classe modele)<BR>
	 * @param		pNomFichier		le nom du fichier � traiter
	 */
	public Url(String pNomFichier) {
		this.nomFichier= pNomFichier;
	}
	
	/**
	 * Permet de connaitre le type du fichier d�fini dans ce controleur<BR>
	 * @return		retourne sous forme d'une String "docx" si un fichier docx 
	 * sinon "other" pour "txt" et "html"
	 */
	private String getType() {
		if (this.nomFichier.contains(".docx"))
			return "docx";
		return "other";
	}
	

	/**
	 * Permet de savoir si un lien pass� en param�tre est defectueux ou non<BR>
	 * @param		pUrlString		le lien url
	 * @return		retourne true si valide et false si invalide
	 */
	private boolean estDefectueux(String pUrlString) {
		int result=this.getResponseCode(pUrlString);
		if (result >= 400)
			return true;
		return false;
	}
	
	
	/**
	 * Permet de retourner le code de v�rification du lien, ce code permettra 
	 * de dire si oui ou non le lien est valide<BR>
	 * @param		pUrlString		le lien url
	 * @return		retourne le code de v�rification de l'url sous forme d'entier positif
	 */
	private int getResponseCode(String urlString) {
		try {
	    URL u = new URL(urlString);
	    if (urlString.contains("https://")) {
	    	HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
	    	
	    	huc.setRequestMethod("GET"); 
	 	    huc.connect(); 
	 	    return huc.getResponseCode();
	    } else {
	    	HttpURLConnection huc2 =  (HttpURLConnection)  u.openConnection();
	    
	    	huc2.setRequestMethod("GET"); 
	    	huc2.connect(); 
	    	return huc2.getResponseCode();
	    }
	    
		} catch (IOException ignore){return 404;}
	}
	
	
	/**
	 * Permet de retourner sous forme de vecteur la liste d'url defectueux<BR>
	 * @return		retourne la liste des url defectueux sous forme de vecteur de String
	 */
	public Vector<String> mesUrlDef(){
	// Cette M�thode renvoie sous forme de vector tous les url d�fectueux
		Vector<String> vUrl=null;
		
		if (getType() == "other") {
			vUrl= (new UseOther(this.nomFichier)).mesUrl();
		}else 
			vUrl= (new UseDocx(this.nomFichier)).mesUrl();
				
		Vector<String> mesUrlDefV= new Vector<String>();
		int i=0;
		int nbEl= vUrl.size();
		String monLien;
		
		while (i < nbEl){
			monLien = vUrl.elementAt(i);
			
			if (estDefectueux(monLien))
				mesUrlDefV.add(monLien);
			
			i++;
		}
		
		return mesUrlDefV;
	}

}
