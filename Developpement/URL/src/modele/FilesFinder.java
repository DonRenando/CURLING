package modele;

import java.io.File;
import java.util.Vector;

public class FilesFinder {
	
	/**
	 * Cette fonction permet de retourner sous Forme de Vector<String> la liste des fichiers (de type valide (html, docx, txt)) trouv� dans le r�pertoire pass� en param�tre<BR>
	 * @param		pDirectoryPath		le chemin du r�pertoire
	 * @return		retourne un Vector<String> la liste des fichiers pr�sent dans le repertoire
	 */
	public static Vector<String> findFiles(String pDirectoryPath) {
		Vector<String> vFileName= new Vector<String>();
		File directory = new File(pDirectoryPath);
		if(!directory.exists()){
			return null;
		}else if(!directory.isDirectory()){
			return null;
		}else{
			File[] subfiles = directory.listFiles();
			for(int i=0 ; i<subfiles.length; i++){
				if (!subfiles[i].isDirectory() && (testFileType(subfiles[i].getName())))
					vFileName.add(subfiles[i].getPath());
			}
			return vFileName;
		}
	}
	
	
	/**
	 * Cette fonction permet de v�rifier si le nom du fichier pass� en param�tre est de type valide (html, txt, docx)<BR>
	 * @param		pFile		le nom du fichier � traiter
	 */
	private static boolean testFileType(String pFile) {
		if ((pFile.toUpperCase()).endsWith(".TXT") || (pFile.toUpperCase()).endsWith(".HTML") || (pFile.toUpperCase()).endsWith(".DOCX"))
			return true;
		return false;
	}

	// Ceci est un test de la classe FilesFinder
	public static void main(String[] args) {
		Vector<String> cheminF;
		
		// Vous pouvez modifier le chemin du r�pertoire pour tester
		cheminF = FilesFinder.findFiles("C:/Users/Malibu/Documents/DOC/");
		
		int i=0;
		int nbEl = cheminF.size();
		
		while ( i<nbEl ) {
			System.out.println(cheminF.elementAt(i));
			i++;
		}
		
		
	}
}
