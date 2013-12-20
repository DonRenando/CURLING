package vue;

import controleur.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;


public class DlgListe extends JFrame{
	
	private CtrlListe monCtrl=null;
	
	public DlgListe(CtrlListe pMonCtrl){
		this.monCtrl=pMonCtrl;
		initComponents();
	}
	
	private void initComponents() {
		label1 = new JLabel();
		label2 = new JLabel();
		scrollPane1 = new JScrollPane();
		list1 = new JList<String>();
		button1 = new JButton();
		
		this.setBounds(20, 20, 300, 200);
		this.setResizable(true);
		this.setVisible(true);

/*		setBorder(new javax.swing.border.CompoundBorder(
			new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
				"JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
				javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
				java.awt.Color.red), getBorder())); addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});
*/
		setLayout(new FormLayout(
			"2*(default, $lcgap), 43dlu, $lcgap, 27dlu, $lcgap, 44dlu, 5*($lcgap, default)",
			"default, $lgap, 25dlu, $lgap, 83dlu, 2*($lgap), 4dlu, default, $lgap, default"));

		//---- label1 ----
		label1.setText("Nom Fichier :");
		add(label1, CC.xywh(5, 3, 2, 1));

		//---- label2 ----
		label2.setText(this.monCtrl.getNomFichier());
		add(label2, CC.xywh(7, 3, 9, 1));

		// Liste
		Vector<String> listeURL = this.listUrlDef();
		list1 = new JList<String>(listeURL);
		{
			scrollPane1.setViewportView(list1);
		}
		add(scrollPane1, CC.xywh(5, 5, 7, 1));

		//---- button1 ----
		button1.setText("Ok");
		add(button1, CC.xy(9, 9));
		button1.addActionListener(new ok());
		this.pack();
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Randy newman
	private JLabel label1;
	private JLabel label2;
	private JScrollPane scrollPane1;
	private JList<String> list1;
	private JButton button1;
	
	class ok implements ActionListener {		

		public void actionPerformed(ActionEvent arg0) {
			setVisible(false);
			
		}
	}

	/**
	 * Permet de retourner la liste des url defectueuses en faisant appel à une méthode de son controleur<BR>
	 * @return		retourne un Vector<String> contenant toute les url defectueuses.
	 */
	public Vector<String> listUrlDef(){
		return monCtrl.getListUrlDef();
	}

}
