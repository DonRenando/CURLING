package modele;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

public class UseOther {
	
	private String nomFichier;
	private Scanner sc;
	
	/**
	 * Constructeur paramétré de UseOther (classe modele)<BR>
	 * @param		pNomFichier		le nom du fichier à traiter
	 */
	public UseOther(String pNomFichier) {
		nomFichier = pNomFichier;
	}

	/**
	 * Permet de recuperer la liste des liens contenu dans un fichier de type autre que "docx".<BR>
	 * @return		retourne la liste des lien du fichier sous forme de Vector<String>
	 */
	@SuppressWarnings("resource")
	public Vector<String> mesUrl() {
		
		Vector<String> Urls = new Vector<String>();
		
		Scanner scanner= null;
		try {
			scanner = new Scanner(new File(this.nomFichier));
		} catch (FileNotFoundException ignore) {}
		String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
				
		//on parcours le fichier et on fait la lecture
		while (scanner.hasNext()) {
				
			//Toutes les lignes et enregisté dans le scanner
			String l =scanner.next();
					          
			sc = new Scanner(l);
			String l2 =  sc.findInLine(regex);
					       
			if (l2 != null) {
			   	Urls.add(l2);
			}
		}		
		
		return Urls;
	}
	

}
