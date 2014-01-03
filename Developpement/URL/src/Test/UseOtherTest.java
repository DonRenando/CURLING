package Test;

import java.util.Vector;
import modele.*;


// Ce test nous permet de v�rifier la fonction mesUrl() 
// qui renvoie la liste des liens contenu dans un fichier 
// de type texte ou html, le traitement est le m�me dans les deux cas.
public class UseOtherTest {
	
	
	public static void main(String[] args) {
		
		
		// Vous pouvez d�commenter une ligne et en commenter une autre pour changer de test: 
			//String choix= "ex2.html"; // Pour tester un fichier html
			String choix= "test.txt"; // Pour tester un fichier de type texte
			
		
		UseOther montxt= new UseOther(choix);
		Vector<String> vUrl = (montxt.mesUrl());
		int i=0;
		int nbEl = vUrl.size();
		

		
		System.out.println("Test de "+ choix);
		System.out.println();
		while (i<nbEl){
			System.out.println(vUrl.elementAt(i));
			i++;
		}

		
	}
}
