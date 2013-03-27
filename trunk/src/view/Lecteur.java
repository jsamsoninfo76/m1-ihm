package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Lecteur est la classe correspondant au panel de lecture mp3
 * 
 * @author Jeremie Samson & Victor Paumier
 * @version 1
 */
public class Lecteur extends JPanel{

	private JLabel start, back, forward;
	private String pathIcon = "icon/";
	
	public Lecteur(){
		start = new JLabel(new ImageIcon(pathIcon + "start.png")); 
		//start.addMouseListener(this);
		back = new JLabel(new ImageIcon(pathIcon + "back.png"));
		forward = new JLabel(new ImageIcon(pathIcon + "forward.png"));
	
		this.add(back);
		this.add(start);
		this.add(forward);
	}
}
