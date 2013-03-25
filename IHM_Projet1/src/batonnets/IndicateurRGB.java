package batonnets;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JToolBar;

import controleur.ColorController;
import controleur.EnsembleBatonnetController;

import modele.ColorModel;
import modele.EnsembleBatonnetModel;

/**
 * Indicateur de rouge vert bleu
 * 
 * @author Jeremie Samson & Victor Paumier
 * @version 2
 */
public class IndicateurRGB extends JPanel implements Observer{
	
	private JTextArea rouge;
	private JTextArea vert;
	private JTextArea bleu;
	protected ColorModel listModel[];
	protected ColorController listController[];
	protected EnsembleBatonnet e;
	
	public IndicateurRGB(ColorModel[] lm,ColorController[] lc,EnsembleBatonnet ee) {
		this.listModel=lm;
		this.listController=lc;
		this.e=ee;
		for (int i=0;i<listModel.length;i++)
		{
			listModel[i].addObserver(this);
		}
		
		Color backgroundcolor = this.getBackground();
		rouge=new JTextArea("RED:");
		rouge.setBackground(backgroundcolor);
		rouge.setForeground(Color.RED);
		vert=new JTextArea("GREEN:");
		vert.setBackground(backgroundcolor);
		vert.setForeground(Color.GREEN);
		bleu=new JTextArea("BLUE:");
		bleu.setForeground(Color.BLUE);
		bleu.setBackground(backgroundcolor);
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.add(rouge);
		this.add(vert);
		this.add(bleu);
	}

	public void update(Observable o, Object arg) {
			Integer r=(int) listModel[this.e.getSelectionner()].getRed();
			Integer v=(int) listModel[this.e.getSelectionner()].getGreen();
			Integer b=(int) listModel[this.e.getSelectionner()].getBlue();
			this.rouge.setText("RED: "+r.toString());
			this.vert.setText("GREEN: "+v.toString());
			this.bleu.setText("BLUE: "+b.toString());
	}

}
