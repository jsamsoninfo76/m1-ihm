import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

/*
 * Question 2. 
 * Ecrivez une classe ReponseAuClic qui implémente la méthode actionPerformed de l’interface ActionListener pour afficher "Clic sur le bouton" 
 * sur la console quand la méthode est appelée. Abonnez votre bouton à cette classe et vérifiez que le message s’affiche bien à l’écran 
 * à chaque fois que vous cliquez sur le bouton.
 * 
 */
public class ReponseAuClic implements ActionListener {
	private JLabel lab;
	
	public ReponseAuClic(JLabel lab){
		this.lab = lab;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		int val = Integer.parseInt(lab.getText());
		val++;
		lab.setText(String.valueOf(val));
		System.out.println("Clic sur le bouton");	
	}
}
