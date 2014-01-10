package modele;


public interface ProcessBarListener {
	
	void nbIterations(int nbI);
	void taskProcessing(int i);
	void nbFiles(int nb);
	void nbFilesDone(int nb);

}
