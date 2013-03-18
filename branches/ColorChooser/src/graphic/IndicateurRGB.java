package graphic;

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

import controller.ColorController;
import controller.EnsembleBatonnetController;

import model.ColorModel;
import model.EnsembleBatonnetModel;

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
		rouge=new JTextArea("ROUGE:");
		rouge.setBackground(backgroundcolor);
		vert=new JTextArea("VERT:");
		vert.setBackground(backgroundcolor);
		bleu=new JTextArea("BLEU:");
		bleu.setBackground(backgroundcolor);
		this.setLayout(new BoxLayout(this, BoxLayout.LINE_AXIS));
		this.add(rouge);
		this.add(vert);
		this.add(bleu);
		
	}

	@Override
	public void update(Observable o, Object arg) {
			Integer r=(int) listModel[this.e.getSelectionner()].getRed();
			Integer v=(int) listModel[this.e.getSelectionner()].getGreen();
			Integer b=(int) listModel[this.e.getSelectionner()].getBlue();
			this.rouge.setText("ROUGE: "+r.toString());
			this.vert.setText("VERT: "+v.toString());
			this.bleu.setText("BLEU: "+b.toString());
	}

}
