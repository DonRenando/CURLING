package Test;

import java.net.URL;
import java.net.HttpURLConnection;
import java.io.IOException;

import javax.net.ssl.HttpsURLConnection;


// Cet executable permet de valider la fonctionnalité de tester un url.
// Vérifier si cet url est valid ou non.

// Ce programme de tester vérifie si les fonctions estDefectueux(String pUrlString)
// et getResponseCode sont valides
public class testUrlValidity {

	
	private boolean estDefectueux(String pUrlString) {
		int result=this.getResponseCode(pUrlString);
		System.out.println(result);
		if (result >= 400)
			return true;
		return false;
	}
	
	
	private int getResponseCode(String urlString) {
		try {
	    URL u = new URL(urlString);
	    if (urlString.contains("https://")) {
	    	HttpsURLConnection huc = (HttpsURLConnection) u.openConnection();
	    	
	    	huc.setRequestMethod("GET"); 
	 	    huc.connect(); 
	 	    return huc.getResponseCode();
	    } else {
	    	HttpURLConnection huc2 =  (HttpURLConnection)  u.openConnection();
	    
	    	huc2.setRequestMethod("GET"); 
	    	huc2.connect(); 
	    	return huc2.getResponseCode();
	    }
	    
		} catch (IOException ignore){return 404;}
	}
	
	
	public static void main(String[] args) {
		testUrlValidity f=new testUrlValidity();

		System.out.println(f.estDefectueux("http://www.eclipse.org/cdo/"));
		System.out.println(f.estDefectueux("https://www.modelica.org"));


	}
}
