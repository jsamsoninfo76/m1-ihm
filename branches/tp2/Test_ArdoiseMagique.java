import java.awt.BorderLayout;

import javax.swing.JFrame;


public class Test_ArdoiseMagique extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArdoiseMagique ardoise;
	
	public Test_ArdoiseMagique() {
		this.setTitle("Ardoise Magique");
	    this.setSize(500, 500);
	    this.setLocationRelativeTo(null);
	    this.setLayout(new BorderLayout());
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
	    initCompo();
	    this.setVisible(true);
	}


	public void initCompo(){
		ardoise = new ArdoiseMagique();
		this.add(BorderLayout.CENTER,ardoise);
	}
	
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Test_ArdoiseMagique ardoiseMagique = new Test_ArdoiseMagique();
	}
	
	

}
