import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

/*Question 9. 
 * En utilisant la classe JFrame dont vous aurez modifié le gestionnaire de placement pour utiliser BoxLayout, réalisez une interface similaire à celle présentée figure 3. Pour obtenir l’espace entre les boutons 2 et 3 vous ajouterez un composant invisible en utilisant la classe interne Filler. Vous testerez les différents types de Filler disponibles (rigid area, glue et custom). Etudiez le tutoriel correspondant pour plus d’explications.
 * Notez que le constructeur de BoxLayout prend un objet de type Container en premier argument. Pour les conteneurs de haut niveau, la méthode getContentPane() permet d’accéder à cet objet.
 * Tutoriel sur l’utilisation de BoxLayout: http://java.sun.com/docs/books/tutorial/uiswing/layout/box.html
 */

public class Q9Box extends JFrame {
  public Q9Box(){
//    this.setTitle("Ma première fenêtre Java");
    this.setSize(100,200);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
    initComposant(this.getContentPane());
    this.setVisible(true);
  }
  
  public void  initComposant(Container container){
	  this.add(new JButton("Button 1"));
	  this.add(new JButton("Button 2"));
	  this.add(Box.createHorizontalStrut(10));
	  this.add(new JButton("Button 3"));
  }
  
  public static void main(String args[]){
	  Q9Box fenetre = new Q9Box();
  }
}