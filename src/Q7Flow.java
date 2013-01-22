import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Q7Flow extends JFrame {
  public Q7Flow(){
//    this.setTitle("Ma première fenêtre Java");
    this.setSize(400, 500);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    this.setLayout(new FlowLayout());
    initComposant();
    this.setVisible(true);
  }
  
  public void  initComposant(){
	 
	  for (int i=1 ; i<=17 ; i++)
		  this.add(new JButton("Button" + i));
  }
  
  public static void main(String args[]){
	  Q7Flow fenetre = new Q7Flow();
  }
}