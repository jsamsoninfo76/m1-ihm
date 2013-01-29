import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * Question 4. 
 * Ecrivez une classe FenetreIncrementer avec le JLabel 
 * déclaré comme membre privé. Reprenez et modifiez la classe ReponseAuClic 
 * écrite à la question précédente en l’incluant dans la classe FenetreIncrementer 
 * (vous la définirez comme classe privée).
 */
public class FenetreIncrementer extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel compteur;
	
	public FenetreIncrementer(){
	    this.setTitle("FenetreIncrementer");
	    this.setSize(200, 200);
	    this.setLocationRelativeTo(null);
	    this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
	    initCompo(this.getContentPane());
	    this.setVisible(true);
	}
	
	public void initCompo(Container container){
		compteur = new JLabel(String.valueOf("0"));
		compteur.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton inc = new JButton("Incrementer");
		inc.setAlignmentX(Component.CENTER_ALIGNMENT);
		inc.addActionListener(new ReponseAuClic());
				
		container.add(compteur);
		container.add(inc);
	}
	
	private class ReponseAuClic implements ActionListener {
		
		public void actionPerformed(ActionEvent arg0) {
			int val = Integer.parseInt(compteur.getText());
			val++;
			compteur.setText(String.valueOf(val));
			System.out.println("Clic sur le bouton");	
		}
	}
	
	public static void main(String args[]){
		@SuppressWarnings("unused")
		FenetreIncrementer fenetre = new FenetreIncrementer();
	}
}
