package controleur;

import vue.DlgHistory;

public class CtrlHistory {
	
	/**
	 * Permet de creer une nouvelle boite de dialogue, DlgHistory<BR>
	 * @return		retourne la boite de dialgue DlgHistory avec son Controleur en param�tre
	 */
	public DlgHistory newDlgHistory(){
		return (new DlgHistory(this));
	}

	/**
	 * Premet de retourner la un tableau a deux entr�e contenant le nom des fichiers, leurs chemins, leur date de mise � jour<BR>
	 * @return		retourne un tableau � deux entr�es (String [][])
	 */
	public String[][] getHistory() {
		return modele.History.readHistoryFile();
	}

}
