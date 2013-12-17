package modele;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Vector;

public class UseTxt {
	
	private String nomFichier;
	
	public UseTxt(String pNomFichier) {
		nomFichier = pNomFichier;
	}

	/**
	 * Permet de renvoyer sous forme de Vector<String> toute les lignes du fichier (une ligne par element du Vector)<BR>
	 * @param		pNomFichier		le nom du fichier
	 * @return		retourne Vector<String> toute les lignes du fichier pass� en param�tre
	 */
	private Vector<String> readLine(){
	// Cette fonction lit un fichier et retourne un vector<String>
	// avec pour element une ligne du fichier 
	// si erreur de lecture du fichier, retourne null
		Vector<String> lines= new Vector<String>();
		try {
			Scanner s = new Scanner(new File(this.nomFichier)).useDelimiter("\n");
		    while (s.hasNext()){
		    	lines.add(s.next());	
		    }
		    s.close();
		    return lines;
		}catch(IOException exception){return null;}
	}
	
	
	/**
	 * Permet de retourner sous forme de vecteur de String la liste des URL � partir du Vecteur 
	 * de String contenant toute les lignes du fichier<BR>
	 * @return		retourne un Vector<String> d'url
	 */
	public Vector<String> mesUrl(){
		Vector<String> LinesFile= readLine();
		 
		Vector<String> url= new Vector<String>();
		int nbEl = LinesFile.size();
		int i=0;
		String line, portion;
		
		while (i < nbEl){
		// Test si la ligne commence par ':'
			line = LinesFile.elementAt(i);
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
	
	

}
