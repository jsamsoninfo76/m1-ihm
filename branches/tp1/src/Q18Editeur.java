import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

/* Question 17. 
 * Proposez une hiérarchie de composants permettant de représenter l’interface ci-dessous.
 *
 *http://docs.oracle.com/javase/tutorial/uiswing/components/menu.html
 *
 * Question 18.
 *  Implémentez la proposition faite à la question précédente.
 */

public class Q18Editeur extends JFrame {
  public Q18Editeur(){
//    this.setTitle("Ma première fenêtre Java");
    this.setSize(500, 500);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    this.setLayout(new BorderLayout());
    initComposant();
    this.setVisible(true);
  }
  
  public void  initComposant(){
	//Where the GUI is created:
	  JMenuBar menuBar;
	  JMenu menu, submenu;
	  JMenuItem menuItem;
	  JRadioButtonMenuItem rbMenuItem;
	  JCheckBoxMenuItem cbMenuItem;

	  //Create the menu bar.
	  menuBar = new JMenuBar();

	  //Build the first menu.
	  menu = new JMenu("Fichier");
	  menuBar.add(menu);

	  //a group of JMenuItems
	  menuItem = new JMenuItem("Nouveau",
	                           KeyEvent.VK_T);
	  menuItem.setAccelerator(KeyStroke.getKeyStroke(
	          KeyEvent.VK_1, ActionEvent.ALT_MASK));
	  menuItem.getAccessibleContext().setAccessibleDescription(
	          "This doesn't really do anything");
	  menu.add(menuItem);

	  menuItem = new JMenuItem("Ouvrir");
	  menu.add(menuItem);
	  menuItem = new JMenuItem("Enregistrer");
	  menu.add(menuItem);
	  menuItem = new JMenuItem("Enregistrer sous");
	  menu.add(menuItem);

	  menu.addSeparator();
	  menuItem = new JMenuItem("Mise en page");
	  menu.add(menuItem);
	  menuItem = new JMenuItem("Imprimer");
	  menu.add(menuItem);
	  
	  menu.addSeparator();
	  menuItem = new JMenuItem("Quitter");
	  menu.add(menuItem);
	  
	  menu = new JMenu("Edition");
	  menuBar.add(menu);
	  
	  menu = new JMenu("Format");
	  menuBar.add(menu);
	  
	  this.setJMenuBar(menuBar);
	  
	  JPanel p = new JPanel();
	  p.setBackground(Color.GRAY);
	  p.add(new JLabel("Université Lille 1"));
	  this.add(p);
	
	  JPanel search = new JPanel();
	  search.setBackground(Color.CYAN);
	  search.add(new JLabel("Recherche :"));
	  JTextField tf = new JTextField();
	  tf.setText("Rechercher");
	  search.add(tf);
	  search.add(new JButton("<-"));
	  search.add(new JButton("->"));
	  search.add(new JButton("Tout surligner"));
	  this.add(BorderLayout.SOUTH,search);
  }
  
  public static void main(String args[]){
	  Q18Editeur fenetre = new Q18Editeur();
  }
}
