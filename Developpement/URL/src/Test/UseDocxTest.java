package Test;

import java.util.Vector;
import modele.*;


// Ce test nous permet de v�rifier � la fois la fonction getZipFileStream qui permet de retourner 
// l'entr� du fichier "document.xml" contenu dans l'archive ".docx" ainsi que de tester la fonction
// mesUrl() qui renvoie la liste des liens contenu dans ce fichier "document.xml"
public class UseDocxTest {
	
	
	public static void main(String[] args) {
		UseDocx mondocx= new UseDocx("test.docx");

		Vector<String> vUrl = (mondocx.mesUrl());
		
		int i=0;
		int nbEl = vUrl.size();
		
		while (i<nbEl){
			System.out.println(vUrl.elementAt(i));
			i++;
		}
	}
}
