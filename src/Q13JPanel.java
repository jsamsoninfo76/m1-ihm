/*
 * Question 13. 
 * En reprenant la question 6 sur le  BorderLayout, remplacez le bouton nord par un JPanel qui contiendra 3 boutons de mani�re � obtenir une interface similaire � celle de la figure 4.
 * 
 */

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Q13JPanel extends JFrame {
  public Q13JPanel(){
//    this.setTitle("Ma premi�re fen�tre Java");
    this.setSize(400, 500);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    this.setLayout(new BorderLayout());
    initComposant();
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
	  Q13JPanel fenetre = new Q13JPanel();
  }
}
