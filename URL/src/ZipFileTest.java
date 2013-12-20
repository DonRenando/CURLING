import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import java.util.Scanner;


public class ZipFileTest {

	public InputStream getZipFileStream(String pChemin){
		
		ZipFile zipFile;
		try {
			zipFile = new ZipFile(new File(pChemin));
			
			Enumeration<? extends ZipEntry> entries = zipFile.entries();

			while (entries.hasMoreElements()) {
				ZipEntry entry = entries.nextElement();
				
				if (entry.getName().equals("word/document.xml")) {
					return zipFile.getInputStream(entry);
				}
			}
			
		} catch (IOException ignore) {}
		
		return null;
	}
	
	public Vector<String> mesUrl(String pChemin) {
		
		Vector<String> Urls = new Vector<String>();
		Scanner scanner = new Scanner(getZipFileStream(pChemin));
		String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
				
		//on parcours le fichier et on fait la lecture
		while (scanner.hasNext()) {
				
			//Toutes les lignes et enregist� dans le scanner
			String l =scanner.next();
					          
			//on utilise l'expression r�guli�re pour traiter la ligne
			Scanner sc = new Scanner(l);
			String l2 =  sc.findInLine(regex);
					       
			if ((l2 != null) && (!l2.contains("http://schemas."))) {
			   	Urls.add(l2);
			}
		}		
		
		return Urls;
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		String monChemin = "C:\\Users\\Penchenat Matthieu\\Desktop\\test.docx";

		Vector<String> vUrl = (new ZipFileTest()).mesUrl(monChemin);
		
		int i=0;
		int nbEl = vUrl.size();
		
		while (i<nbEl){
			System.out.println(vUrl.elementAt(i));
			i++;
		}
	}
}