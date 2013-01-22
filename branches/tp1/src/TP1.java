import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JWindow;
  
public class TP1 extends JFrame {
  public TP1(){
//    this.setTitle("Ma première fenêtre Java");
    this.setSize(400, 500);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    initComposant();
    this.setVisible(true);
  }
  
  public void  initComposant(){
	  JLabel hw = new JLabel("Hello World");
	  this.add(hw);
  }
  
  public static void main(String args[]){
	  TP1 fenetre = new TP1();
  }
}