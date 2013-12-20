import java.util.Vector;

import jfilechooserdemo.*;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		 Vector<String> v = new Vector<String>(); 
		v.addElement("www.lienquimarchepas.com"); 
		v.addElement("www.lienquibeug.fr");  
		
		DlgAccueil mv;
		DlgListe l;
		mv = new DlgAccueil();
		l = new DlgListe();
		
		mv.setVisible(true);
		l.setVisible(true);

	}

}




