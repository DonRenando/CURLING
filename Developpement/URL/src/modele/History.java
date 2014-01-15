package modele;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class History {

	/**
	 * Cette fonction permet de retourner la date locale<BR>
	 * @return		retourne la date format "yyyy-MM-dd" sous forme de String
	 */
	private static String getDateActuelle() {
		Locale.getDefault();
		Date actuelle = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		return (dateFormat.format(actuelle));
	}
	
	/**
	 * Cette fonction permet de creer le répertoire History pour l'historique si il n'existe pas déjà<BR>
	 * @return		0 si le répertoire est crée, 1 si erreur de création et 2 si le répertoire existe déjà
	 */
	public static int createDespositHistory() {
		// On crée le répertoire s'il n'existe pas
		File f = new File ("./History");
		if (!(f.exists())){
		     // Creation du répertoire
		     if (f.mkdir()) {
			        // Le repertoire a été créé
		     		return 0; 
		     } else {
			        // Erreur, Impossible de créer ce repertoire
			        return 1;
		     }
		}
		
		// Si le dossier existait déjà
		return 2;
	}
	
	/**
	 * Cette fonction permet de creer le fichier log correspondant a un fichier donnée (avec sa location (Path) et son Nom (pNom))<BR>
	 * @param		pNom		le nom du fichier
	 * @param		pPath		Le chemin absolue du fichier
	 */
	public static void createHistoryFile(String pNom, String pPath) {
		
		// On crée un fichier dans l'historique s'il n'existe pas déja
		File f1 = new File ("./History/" + pNom + ".log");
		if (!(f1.exists())) {
		     // Creation du fichier
		     try {
				f1.createNewFile();
			} catch (IOException ignore) {}
		}
		
		// Ecriture dans le fichier (ecrase):
		BufferedWriter out;
		try {
			out = new BufferedWriter(new FileWriter(f1));
			out.write(pNom + "|" + pPath + "|" + History.getDateActuelle());
			out.close();
		} catch (IOException ignore) {}
		
	}

	/**
	 * Cette fonction permet d'obtenir le nom, le chemin et la date de dernier visionnage de tout les fichiers déjà traité par l'application<BR>
	 * @return		retourne un String[][] (tableau à deux entrée de String) 
	 */
	public static String[][] readHistoryFile() {
		
		File f= new File("./History");
		File[] mesF= null;
		int i= 0, nbF, j;
		String[][] histo;
		
		if (f.exists() && f.isDirectory()) {
			mesF= f.listFiles();
			
			nbF= mesF.length;
			histo= new String[nbF][3];
			
			while (i < nbF) {
				
				// Lecture dans le fichier
				Scanner sc;
				try {
					sc = new Scanner(mesF[i]).useDelimiter("\\|");
					
					String chaine= null;
					j=0;
					while (sc.hasNext()) {
						chaine= sc.next();
						if (chaine != "|") {
							//System.out.println(chaine);
							histo[i][j]= chaine;
							j++;
						}
					}
					sc.close();
					
				} catch (FileNotFoundException ignore) {}
				
				i++;
			}
			
			return histo;
		}
		
		// Le repertoire History n'existe pas.
		return null; 
		
	}


}
