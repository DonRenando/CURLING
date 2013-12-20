import java.io.File;
import java.io.IOException;

import java.util.Scanner;

	public class TestRegex {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
		Scanner scanner = new Scanner(new File("test.txt"));
		String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		
		//on parcours le fichier et on fait la lecture
		while (scanner.hasNext()) {
		
			//Toutes les lignes et enregist� dans le scanner
		    String l =scanner.next();
		          
		    //on utilise l'expression r�guli�re pour traiter la ligne
		    Scanner sc = new Scanner(l);
		    String l2 =  sc.findInLine(regex);
		       
		    if (l2 != null)
		    	System.out.println(l2);
		}
		
					
		} catch(IOException ignore){}
	}

}