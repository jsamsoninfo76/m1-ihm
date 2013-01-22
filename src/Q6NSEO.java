import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Q6NSEO extends JFrame {
  public Q6NSEO(){
//    this.setTitle("Ma première fenêtre Java");
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
	  this.add(BorderLayout.NORTH,new JButton("NORTH"));
	  this.add(new JButton("CENTER"));
  }
  
  public static void main(String args[]){
	  Q6NSEO fenetre = new Q6NSEO();
  }
}