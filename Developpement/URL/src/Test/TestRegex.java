package Test;
import java.io.File;
import java.io.IOException;

import java.util.Scanner;

	public class TestRegex {

	private static Scanner scanner;
	private static Scanner sc;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		
		// Ce main permet de savoir si le regex qui sert à relever les liens est bien fonctionnel
		// Les liens relevés sont affichés à l'écran.
		
		// Nous utilisons la classe Scanner pour utiliser de notre regex.
		try {
		scanner = new Scanner(new File("test.txt"));
		String regex = "\\b(https?|ftp|file)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|]";
		
		while (scanner.hasNext()) {
		
		    String l =scanner.next();
		          
		    sc = new Scanner(l);
		    String l2 =  sc.findInLine(regex);
		       
		    if (l2 != null)
		    	System.out.println(l2);
		}
		
					
		} catch(IOException ignore){}
	}

}
