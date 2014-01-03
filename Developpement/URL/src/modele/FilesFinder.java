package modele;

import java.io.File;
import java.util.Vector;

public class FilesFinder {
	
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
	
	private static boolean testFileType(String pFile) {
		if ((pFile.toUpperCase()).endsWith(".TXT") || (pFile.toUpperCase()).endsWith(".HTML") || (pFile.toUpperCase()).endsWith(".DOCX"))
			return true;
		return false;
	}

	
	public static void main(String[] args) {
		Vector<String> cheminF;
		FilesFinder.findFiles("C:/temp");
		cheminF = FilesFinder.findFiles("C:/Users/Malibu/Documents/DOC/AUTRE/BLAGUES");
		
		int i=0;
		int nbEl = cheminF.size();
		
		while ( i<nbEl ) {
			System.out.println(cheminF.elementAt(i));
			i++;
		}
		
		
	}
}
