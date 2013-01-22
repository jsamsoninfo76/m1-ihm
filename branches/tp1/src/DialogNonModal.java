import javax.swing.JDialog;
import javax.swing.JFrame;
  
public class DialogNonModal extends JFrame {
  public DialogNonModal(){
//    this.setTitle("Ma première fenêtre Java");
    this.setSize(400, 500);
    this.setLocationRelativeTo(null);      
    initComposant();
    this.setVisible(true);
  }
  
  public void  initComposant(){
	  JDialog jd = new JDialog(this,false);
	  jd.show();
  }
  
  public static void main(String args[]){
	  DialogNonModal fenetre = new DialogNonModal();
  }
}