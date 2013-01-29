import java.awt.Component;
import java.awt.Container;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
 * Question 1. 
 * En utilisant la classe JFrame, le gestionnaire de placement BoxLayout, les classes JLabel et JButton, réalisez une interface similaire à celle présentée figure 1 
 * 
 */
public class Q1_Incrementer extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int cpt = 0;
	
	public Q1_Incrementer(){
	    this.setTitle("Q1_Incrementer");
	    this.setSize(200, 200);
	    this.setLocationRelativeTo(null);
	    this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
	    initCompo(this.getContentPane());
	    this.setVisible(true);
	}
	
	public void initCompo(Container container){
		JLabel compteur = new JLabel(String.valueOf(cpt));
		compteur.setAlignmentX(Component.CENTER_ALIGNMENT);
		
		JButton inc = new JButton("Incrementer");
		inc.setAlignmentX(Component.CENTER_ALIGNMENT);
		inc.addActionListener(new ReponseAuClic(compteur));
				
		container.add(compteur);
		container.add(inc);
	}
	
	public static void main(String args[]){
		@SuppressWarnings("unused")
		Q1_Incrementer fenetre = new Q1_Incrementer();
	}
}
