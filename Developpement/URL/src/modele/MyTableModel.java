package modele;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
	private String donnees[][];
	private String titres[];
	
	/**
	 * Constructeur param�tr� de MyTableModel, il initialise le tableau de donn�e et le tableau titre<BR>
	 * @param		pVue		la vue DlgListe
	 */
	public MyTableModel(String pDonnees[][], String pTitres[]) { 
	      this.donnees= pDonnees; 
	      this.titres= pTitres; 
	   } 

	/**
	 * Cette fonction permet de retourner le nombre de colonne du model<BR>
	 * @return		retourne le nombre de colonne du model
	 */
	public int getColumnCount() {
		return titres.length;
	}

	/**
	 * Cette fonction permet de retourner le nombre de ligne du model<BR>
	 * @return		retourne le nombre de ligne du model
	 */
	public int getRowCount() {
		return donnees.length; 
	}

	/**
	 * Cette fonction permet de retourner la valeur a une coordonn�e donn� du model<BR>
	 * @param		parm1		coordonn�e_x
	 * @param		parm2		coordonn�e_y
	 * @return		retourne la valeur de l'�l�ment de coordonn�e (x,y)
	 */
	public Object getValueAt(int parm1, int parm2) { 
	    return donnees[parm1][parm2]; 
	}

	/**
	 * Cette fonction permet de retourner le nom de la colonne num�ro (col pass� en param�tre) du model<BR>
	 * @param		col		Le num�ro de la colonne
	 * @return		retourne le nom de la colonne du model
	 */
	public String getColumnName(int col) {
        return titres[col];
    }


}
