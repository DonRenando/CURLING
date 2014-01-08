package vue;

import controleur.*;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import modele.ProcessBarListener;



public class DlgListe extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private CtrlListe monCtrl=null;
	
	
	private JScrollPane scrollPane;
	private JTable table;
	private JButton button1;
	private JLabel label1;
		
	public DlgListe(CtrlListe pMonCtrl){
		super("Liste des Url defectueuses");
		this.monCtrl=pMonCtrl;
		initComponents();
		
		monSwingWorker swingWorker = new monSwingWorker(this);
		swingWorker.execute();
	}
	
	public CtrlListe getCtrl(){
		return this.monCtrl;
	}
	
	public JTable getTable() {
		return this.table;
	}
	
	private void initComponents() {
		scrollPane = new JScrollPane();
		button1 = new JButton();
		
		this.setBounds(300, 350, 500, 280);
		this.setResizable(true);
		this.setVisible(true);

		// JTable
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setFillsViewportHeight(true);
		
		label1 = new JLabel();
		label1.setText("<html>Liste des<font color = #FF0000> Url defectueuses</font>: </html>");
		//label1.setBounds(25, 10, 100, 25);
		add(label1);
		//---- button1 ----

		
		
		// Déclaration JPanel : 
		JPanel top= new JPanel();
	//	top.setLayout(new GridLayout(2,1));
		this.add(top,BorderLayout.SOUTH);
		add(top);
		top.add(scrollPane);
		this.add(button1);
		this.add(top);
		
		button1.setText("Ok");
		button1.addActionListener(new ok());
	//	button1.setBounds(170, 170, 100, 25);
		this.add(button1,BorderLayout.SOUTH);
		
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
	}
	
	class ok implements ActionListener {		

		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
		}
	}

	/**
	 * Permet de retourner la liste des url defectueuses en faisant appel à une méthode de son controleur<BR>
	 * @return		retourne un Vector<String> contenant toute les url defectueuses.
	 */
	public String[][] listUrlDef(ProcessBarListener listener){
		return monCtrl.getListUrlDef(listener);
	}

	
	//public static void main(String[] args) {
	//	new DlgListe(null);
	//}


}
