import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

/*
 * Question 16. 
 * (Facultative) Testez les différents look-and-feel disponibles. (Le look-and-feel Mac OS X n’est pas disponible sous Linux et Windows). 
 * Java 7 propose un nouveau Look-and-Feel: Nimbus
 * 
 */
public class Q16LookAndFeel extends JFrame {
  public Q16LookAndFeel(){
//    this.setTitle("Ma première fenêtre Java");
    this.setSize(400, 500);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    this.setLayout(new BorderLayout());
    initComposant();

	try {
		/*
		 * com.sun.java.swing.plaf.gtk.GTKLookAndFeel
		 * com.sun.java.swing.plaf.motif.MotifLookAndFeel
		 * com.sun.java.swing.plaf.windows.WindowsLookAndFeel
		 */
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
	} catch (Exception e) {}
	
    this.setVisible(true);
  }
  
  public void  initComposant(){
	  this.add(BorderLayout.SOUTH,new JButton("SOUTH"));
	  this.add(BorderLayout.EAST,new JButton("EAST"));
	  this.add(BorderLayout.WEST,new JButton("WEST"));
	  this.add(new JButton("CENTER"));
	  
	  JPanel north = new JPanel();
	  for (int i=1 ; i<4 ; i++)north.add(new JButton("Button"+i));
	  this.add(BorderLayout.NORTH,north);
	  
  }
  
  public static void main(String args[]){
	  Q16LookAndFeel fenetre = new Q16LookAndFeel();
  }
}

