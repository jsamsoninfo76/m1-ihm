import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

/*Question 10. 
 * (Facultative) Réalisez une interface similaire à celle de la figure 3, en utilisant le gestionnaire de placement GridBag.
 * Tutoriel sur l’utilisation de GridBagLayout: http://java.sun.com/docs/books/tutorial/uiswing/layout/gridbag.html
 */

public class Q10GridBag extends JFrame {
	  public Q10GridBag(){
	    this.setSize(400, 500);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
	    this.setLayout(new GridBagLayout());
	    initComposant();
	    this.setVisible(true);
	  }
	  
	  public void  initComposant(){
		  GridBagConstraints c = new GridBagConstraints();
		  c.fill = GridBagConstraints.HORIZONTAL;
		  
		  c.gridx = 0;
		  c.gridy = 0;
		  this.add(new JButton("Button1"),c);
		  
		  c.gridx = 1;
		  c.gridy = 0;
		  this.add(new JButton("Button2"),c);
		  
		  c.gridx = 2;
		  c.gridy = 0;
		  this.add(new JButton("Button3"),c);
		  
		  c.gridx = 3;
		  c.gridy = 0;
		  this.add(new JButton("Button4"),c);
		  
		  c.gridwidth = 4;
		  c.gridx = 0;
		  c.gridy = 1;
		  this.add(new JButton("Button5"),c);
		  
		  c.gridwidth = 3;
		  c.gridx = 0;
		  c.gridy = 2;
		  this.add(new JButton("Button6"),c);
		  
		  c.gridwidth = 1;
		  c.gridx = 3;
		  c.gridy = 2;
		  this.add(new JButton("Button7"),c);
		  
		  c.fill = GridBagConstraints.VERTICAL;
		  c.gridheight = 2;
		  c.gridx = 0;
		  c.gridy = 3;
		  this.add(new JButton("Button8"),c);
		  
		  c.fill = GridBagConstraints.HORIZONTAL;
		  c.gridwidth = 3;
		  c.gridx = 1;
		  c.gridy = 4;
		  this.add(new JButton("Button9"),c);
		  
		  c.gridwidth = 3;
		  c.gridx = 1;
		  c.gridy = 5;
		  this.add(new JButton("Button10"),c);
		  
	  
	  }
	  
	  public static void main(String args[]){
		  Q10GridBag fenetre = new Q10GridBag();
	  }
	}
