package Test;

import java.util.Vector;
import modele.*;


// Ce programme permet de tester la fonction mesUrlDef() 
// qui permet de retourner la liste des liens d�fectueux d'un fichier.
// ansi que getType() (qui retourne le type de fichier appel�) permettant � mesUrlDef() 
// d'orienter son traitement en fonction du type de fichier.
public class UrlTest {
	
	public static void main(String[] args) {
		
		// Vous pouvez d�commenter l'instruction qui vous interesse : 
			String monfichier = "test.docx";
			//String monfichier = "ex2.html";
			//String monfichier = "test.txt";
		
		
		Url monModelUrl= new Url(monfichier);
		Vector<String> vUrlDef= monModelUrl.mesUrlDef();
		
		int i=0;
		int nbEl= vUrlDef.size();
		
		System.out.println("test de "+ monfichier);
		System.out.println();
		
		while (i<nbEl){
			System.out.println(vUrlDef.elementAt(i));
			i++;
		}
		
		
	}

}