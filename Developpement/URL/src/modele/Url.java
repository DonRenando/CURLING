package modele;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Vector;

public class Url {
	
	private String nomFichier;
	
	public Url(String pNomFichier) {
		this.nomFichier= pNomFichier;
	}
	
	public String getType() {
		// TODO
		return "txt";
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
	    HttpURLConnection huc =  (HttpURLConnection)  u.openConnection(); 
	    huc.setRequestMethod("GET"); 
	    huc.connect(); 
	    return huc.getResponseCode();
		} catch (IOException ignore){return 404;}
	}
	
	
	/**
	 * Permet de retourner sous forme de vecteur la liste d'url defectueux<BR>
	 * @return		retourne la liste des url defectueux sous forme de vecteur de String
	 */
	public Vector<String> mesUrlDef(){
	// Cette M�thode renvoie sous forme de vector tous les url d�fectueux
		Vector<String> vUrl=null;
		
		if (getType() == "txt") {
			vUrl= (new UseTxt(this.nomFichier)).mesUrl();
		}else if (getType() == "html") {
			vUrl= (new UseHtml(this.nomFichier)).mesUrl();
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
