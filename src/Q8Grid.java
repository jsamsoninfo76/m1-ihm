import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Q8Grid extends JFrame {
  public Q8Grid(){
//    this.setTitle("Ma première fenêtre Java");
    this.setSize(400, 500);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    this.setLayout(new GridLayout(4,4));
    initComposant();
    this.setVisible(true);
  }
  
  public void  initComposant(){
	 
	  for (int i=1 ; i<17 ; i++)
		  this.add(new JButton("Button" + i));
  }
  
  public static void main(String args[]){
	  Q8Grid fenetre = new Q8Grid();
  }
}