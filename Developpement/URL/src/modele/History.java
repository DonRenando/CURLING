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
	 * Cette fonction permet de creer le r�pertoire History pour l'historique si il n'existe pas d�j�<BR>
	 * @return		0 si le r�pertoire est cr�e, 1 si erreur de cr�ation et 2 si le r�pertoire existe d�j�
	 */
	public static int createDespositHistory() {
		// On cr�e le r�pertoire s'il n'existe pas
		File f = new File ("./History");
		if (!(f.exists())){
		     // Creation du r�pertoire
		     if (f.mkdir()) {
			        // Le repertoire a �t� cr��
		     		return 0; 
		     } else {
			        // Erreur, Impossible de cr�er ce repertoire
			        return 1;
		     }
		}
		
		// Si le dossier existait d�j�
		return 2;
	}
	
	/**
	 * Cette fonction permet de creer le fichier log correspondant a un fichier donn�e (avec sa location (Path) et son Nom (pNom))<BR>
	 * @param		pNom		le nom du fichier
	 * @param		pPath		Le chemin absolue du fichier
	 */
	public static void createHistoryFile(String pNom, String pPath) {
		
		// On cr�e un fichier dans l'historique s'il n'existe pas d�ja
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
	 * Cette fonction permet d'obtenir le nom, le chemin et la date de dernier visionnage de tout les fichiers d�j� trait� par l'application<BR>
	 * @return		retourne un String[][] (tableau � deux entr�e de String) 
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
