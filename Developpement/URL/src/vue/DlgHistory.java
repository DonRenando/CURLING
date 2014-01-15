package vue;

import controleur.*;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import modele.MyTableModel;
import modele.ProcessBarListener;

public class DlgHistory extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private CtrlHistory monCtrl=null;
	
	
	private JScrollPane scrollPane;
	private JTable table;
	private JButton button1;
	private JLabel label1;
		
	public DlgHistory(CtrlHistory pMonCtrl){
		super("Historique");
		this.monCtrl=pMonCtrl;
		initComponents();
		
		
		
	}
	
	public CtrlHistory getCtrl(){
		return this.monCtrl;
	}
	
	public JTable getTable() {
		return this.table;
	}
	
	private void initComponents() {
		scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		
		button1 = new JButton();
		this.add(button1);
		
		this.setBounds(300, 350, 500, 280);
		this.setResizable(true);
		this.setVisible(true);

		// JTable
		table = new JTable();
		scrollPane.setViewportView(table);
		//table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		table.setFillsViewportHeight(true);

		label1 = new JLabel();
		label1.setText("<html>Liste des<font color = #FF0000> historique</font>: </html>");
		add(label1);

		
		JPanel top= new JPanel();
		this.add(top,BorderLayout.SOUTH);
		add(top);
		top.add(scrollPane);
	
		this.add(top);
		
		button1.setText("Ok");
		button1.addActionListener(new ok());
		this.add(button1,BorderLayout.SOUTH);
		
		//getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.PAGE_AXIS));
		
		
		// Nom des colonnes de la JTable
		String nom[]= { "Nom du fichier", "Chemin", "Date mis à jour" };
		
		// On crée un TableModel
		MyTableModel newTable= new MyTableModel(this.monCtrl.getHistory(), nom);
		
		// On met à jour la JTable
		table.setModel(newTable);
	}
	
	class ok implements ActionListener {		

		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
		}
	}

	public String[][] listUrlDef(ProcessBarListener listener){
		return monCtrl.getHistory();
	}

	}

