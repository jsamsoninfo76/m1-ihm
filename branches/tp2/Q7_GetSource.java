import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * Question 7. 
 * Réalisez une interface similaire à celle de la figure 2, 
 * où le clic sur un bouton affiche son nom dans le label supérieur. 
 * Vous utiliserez une seule classe pour gérer les événements des trois boutons 
 * et la méthode getSource() pour identifier le bouton qui a reçu l’événement. 
 * 
 */

public class Q7_GetSource extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lab;
	
	public Q7_GetSource(){
	    this.setTitle("Q1_Incrementer");
	    this.setSize(200, 200);
	    this.setLocationRelativeTo(null);
	    this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
	    initCompo(this.getContentPane());
	    this.setVisible(true);
	}
	
	public void initCompo(Container container){
		lab = new JLabel("Vide");
		lab.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton b1 = new JButton("Bouton 1");
		b1.setAlignmentX(Component.CENTER_ALIGNMENT);
		b1.addActionListener(this);
		
		JButton b2 = new JButton("Bouton 2");
		b2.setAlignmentX(Component.CENTER_ALIGNMENT);
		b2.addActionListener(this);
		
		JButton b3 = new JButton("Bouton 3");
		b3.setAlignmentX(Component.CENTER_ALIGNMENT);
		b3.addActionListener(this);
				
		container.add(lab);
		container.add(b1);
		container.add(b2);
		container.add(b3);
	}
	
	public static void main(String args[]){
		@SuppressWarnings("unused")
		Q7_GetSource fenetre = new Q7_GetSource();
	}


	public void actionPerformed(ActionEvent arg0) {
		lab.setText(((JButton)(arg0.getSource())).getText());
	}
}
