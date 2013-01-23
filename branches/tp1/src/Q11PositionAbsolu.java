import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;

/*Question 12. 
 * Utilisez le positionnement absolu pour créer une interface similaire à celle de la figure 4 (gauche).
 */

public class Q11PositionAbsolu extends JFrame{
	 public Q11PositionAbsolu(){
//	    this.setTitle("Ma première fenêtre Java");
	    this.setSize(500,500);
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLayout(null);
	    initComposant(this.getContentPane());
	    this.setVisible(true);
	  }
	  
	  public void  initComposant(Container container){
		  for (int i=1 ; i<9 ; i++){
			  JButton b = new JButton("Button"+i);
			  Insets ins = this.getInsets();
			  Dimension d = b.getPreferredSize();
			  b.setBounds(ins.left + (i * 25), ins.top + (i* 25), (int)d.getWidth(), (int)d.getHeight());
			  this.add(b);
		  }
	  }
	  
	  public static void main(String args[]){
		  Q11PositionAbsolu fenetre = new Q11PositionAbsolu();
	  }
}
