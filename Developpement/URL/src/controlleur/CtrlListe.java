package controlleur;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import java.util.Vector;

import vue.*; 

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
	 * @return		retourne lle nom du fichier
	 */
	public String getNomFichier(){
		return this.nomFichier;
	}
	
	/**
	 * Permet de creer une nouvelle boite de dialogue, DlgListe<BR>
	 * @param		pMonCtrl		le controlleur de son createur
	 * @return		retourne la boite de dialgue DlgListe
	 */
	public DlgListe newDlgListe(CtrlListe pMonCtrl){
		return (new DlgListe(pMonCtrl));
	}
	
	/**
	 * Permet de retourner sous forme de vecteur la liste d'url defectueux<BR>
	 * @return		retourne la liste des url defectueux sous forme de vecteur de String
	 */
	public Vector<String> mesUrlDef(){
	// Cette M�thode renvoie sous forme de vector tous les url d�fectueux
		
		Vector<String> vLignes= readLine(this.nomFichier);
		Vector<String> vUrl= mesUrl(vLignes);
				
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
	 * Permet de retourner sous forme de vecteur de String la liste des URL � partir du Vecteur 
	 * de String contenant toute les lignes du fichier<BR>
	 * @param		pLinesFile		Vector<String> lignes du fichier
	 * @return		retourne un Vector<String> d'url
	 */
	private Vector<String> mesUrl(Vector<String> pLinesFile){
		
		Vector<String> url= new Vector<String>();
		int nbEl = pLinesFile.size();
		int i=0;
		String line, portion;
		
		while (i < nbEl){
		// Test si la ligne commence par ':'
			line = pLinesFile.elementAt(i);
			if (line.charAt(0) == ':'){
				// On r�cup�re la portion qui nous interesse
				Scanner s = new Scanner(line).useDelimiter(": ");
			    s.next();
			    portion = s.next();
			    s.close();
			    
			    // S'il correspond � une url, alors on l'ajoute.
			    if (portion.charAt(0) == 'h' && portion.contains("http")){
			    	// on prend la chaine jusqu'au caract�re '['
			    	
			    	Scanner newScan = new Scanner(portion).useDelimiter("\\[");
			    	portion = newScan.next();
			    	newScan.close();
			    	url.add(portion);
			    }
			    	  
			}
	    i++;
		}
		return url;
	}
	
	/**
	 * Permet de renvoyer sous forme de Vector<String> toute les lignes du fichier (une ligne par element du Vector)<BR>
	 * @param		pNomFichier		le nom du fichier
	 * @return		retourne Vector<String> toute les lignes du fichier pass� en param�tre
	 */
	private Vector<String> readLine(String pNomFichier){
	// Cette fonction lit un fichier et retourne un vector<String>
	// avec pour element une ligne du fichier 
	// si erreur de lecture du fichier, retourne null
		Vector<String> lines= new Vector<String>();
		try {
			Scanner s = new Scanner(new File(pNomFichier)).useDelimiter("\n");
		    while (s.hasNext()){
		    	lines.add(s.next());	
		    }
		    s.close();
		    return lines;
		}catch(IOException exception){return null;}
	}

	
}
