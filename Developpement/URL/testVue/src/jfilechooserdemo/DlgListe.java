package jfilechooserdemo;

import java.util.Vector;

import javax.swing.*;

import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author Randy newman
 */
public class DlgListe extends JFrame {
	public DlgListe() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		// Generated using JFormDesigner Evaluation license - Randy newman
		label1 = new JLabel();
		label2 = new JLabel();
		scrollPane1 = new JScrollPane();
		list1 = new JList();
		button1 = new JButton();
		
		this.setBounds(20, 20, 300, 300);
		//this.setResizable(true);
		this.setVisible(true);

		//======== this ========

		// JFormDesigner evaluation mark
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
		label2.setText("Fichier");
		add(label2, CC.xywh(7, 3, 9, 1));

		//======== scrollPane1 ========
		 Vector<String> ListeURL = new Vector<String>(); 
		 ListeURL.addElement("www.lienquimarchepas.com"); 
		 ListeURL.addElement("www.lienquibeug.fr");  
			
		list1 = new JList<String>(ListeURL);
		{
			scrollPane1.setViewportView(list1);
			
		}
		add(scrollPane1, CC.xywh(5, 5, 7, 1));

		//---- button1 ----
		button1.setText("Ok");
		add(button1, CC.xy(9, 9));
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	// Generated using JFormDesigner Evaluation license - Randy newman
	private JLabel label1;
	private JLabel label2;
	private JScrollPane scrollPane1;
	private JList list1;
	private JButton button1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
