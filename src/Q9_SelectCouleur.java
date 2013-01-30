import java.awt.Color;
import java.awt.GridLayout;

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
	private Color c;
	private static final long serialVersionUID = 1L;
	
	public Q9_SelectCouleur(){
	    this.setTitle("Q9_SelectCouleur");
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
			slideR = new JSlider(0,255,0);
			slideR.addChangeListener(this);
			slideG = new JSlider(0,255,0);
			slideG.addChangeListener(this);
			slideB = new JSlider(0,255,0);
			slideB.addChangeListener(this);
			slides.add(slideR);
			slides.add(slideG);
			slides.add(slideB);
		
		JPanel slidesValues = new JPanel();
			slidesValues.setLayout(new GridLayout(3,1));
			tfR = new JTextField(String.valueOf(slideR.getValue()));
			tfG = new JTextField(String.valueOf(slideG.getValue()));
			tfB = new JTextField(String.valueOf(slideB.getValue()));
			slidesValues.add(tfR);
			slidesValues.add(tfG);
			slidesValues.add(tfB);
		
		JPanel hexaColor = new JPanel();
			hexaColor.setLayout(new GridLayout(2,1));
			c = new Color(Integer.valueOf(tfR.getText()),Integer.valueOf(tfG.getText()),Integer.valueOf(tfB.getText()));;
			tfHexa = new JTextField(Integer.toHexString( c.getRGB() & 0x00ffffff ));
			panColor = new JPanel();
			panColor.setBackground(c);
			hexaColor.add(tfHexa);
			hexaColor.add(panColor);
			
		this.add(slides);
		this.add(slidesValues);
		this.add(hexaColor);
	}
	
	public void stateChanged(ChangeEvent arg0) {
		JSlider src = (JSlider)arg0.getSource();
		JTextField tf;
		
		if (src  == slideR) tf = tfR;
		else if (src == slideG) tf = tfG;
		else tf = tfB;
			
		tf.setText(String.valueOf(src.getValue()));
		
		Color c = new Color(Integer.valueOf(tfR.getText()),Integer.valueOf(tfG.getText()),Integer.valueOf(tfB.getText()));;
	    tfHexa.setText(Integer.toHexString( c.getRGB() & 0x00ffffff ));
	    panColor.setBackground(c);
	}
	
	public static void main(String args[]){
		@SuppressWarnings("unused")
		Q9_SelectCouleur fenetre = new Q9_SelectCouleur();
	}
}
