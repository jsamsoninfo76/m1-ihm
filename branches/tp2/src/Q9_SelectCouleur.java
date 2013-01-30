import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/*
 * Question 9. 
 * En utilisant les classes JSlider, JTextField et JPanel, 
 * réalisez une interface similaire à la figure ci-dessous.
 */

public class Q9_SelectCouleur extends JFrame implements ChangeListener{
	
	private JSlider slideR, slideG, slideB;
	private JTextField tfR, tfG, tfB, tfHexa;
	private JPanel panColor;
	
	private static final long serialVersionUID = 1L;
	
	public Q9_SelectCouleur(){
	    this.setTitle("Q1_Incrementer");
	    this.setSize(200, 200);
	    this.setLocationRelativeTo(null);
	    this.setLayout(new GridLayout(1,3));
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
	    initCompo();
	    this.setVisible(true);
	}
	
	public void initCompo(){
		JPanel slides = new JPanel();
			slides.setLayout(new GridLayout(3,1));
			slideR = new JSlider();
			slideR.addChangeListener(this);
			slideG = new JSlider();
			slideG.addChangeListener(this);
			slideB = new JSlider();
			slideB.addChangeListener(this);
			slides.add(slideR);
			slides.add(slideG);
			slides.add(slideB);
		
		JPanel slidesValues = new JPanel();
			slidesValues.setLayout(new GridLayout(3,1));
			tfR = new JTextField();
			tfG = new JTextField();
			tfB = new JTextField();
			slidesValues.add(tfR);
			slidesValues.add(tfG);
			slidesValues.add(tfB);
		
		JPanel hexaColor = new JPanel();
			hexaColor.setLayout(new GridLayout(2,1));
			tfHexa = new JTextField();
			panColor = new JPanel();
			hexaColor.add(tfHexa);
			hexaColor.add(panColor);
			
		this.add(slides);
		this.add(slidesValues);
		this.add(hexaColor);
	}
	
	public void stateChanged(ChangeEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String args[]){
		@SuppressWarnings("unused")
		Q9_SelectCouleur fenetre = new Q9_SelectCouleur();
	}
}
