package listeners;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.undo.UndoManager;

import batonnets.EnsembleBatonnet;

import optimiz.RandomOptimiseColor;
import vue.Batonnet;

/**
 * Listener sur le bouton Alea
 * 
 * @author Jeremie Samson & Victor Paumier
 * @version 17
 */
public class OptimiseListener implements ActionListener{


	private	EnsembleBatonnet ensembleBatonnetCouleur;
	private UndoManager undoManager;
	private JButton redoButton;
	private JButton undoButton;

		
	public OptimiseListener(EnsembleBatonnet ensembleBatonnetCouleur2,
			UndoManager undoManager2, JButton undoButton2, JButton redoButton2) {
		// TODO Auto-generated constructor stub
		this.ensembleBatonnetCouleur=ensembleBatonnetCouleur2;
		this.undoManager=undoManager2;
		this.redoButton=redoButton2;
		this.undoButton=undoButton2;
	}




	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		RandomOptimiseColor optimize = null;
			optimize = new RandomOptimiseColor(
					ensembleBatonnetCouleur.getNbrBatonnet());

		List<Color> colors = optimize.getOptimizeColors();

		for (int i = 0; i < ensembleBatonnetCouleur.getComponents().length; i++) {
			Batonnet b = ((Batonnet) ensembleBatonnetCouleur
					.getComponent(i));
			b.getColorController().setBlueColorValue(colors.get(i).getBlue());
			b.getColorController().setRedColorValue(colors.get(i).getRed());
			b.getColorController().setGreenColorValue(colors.get(i).getGreen());
		}
		
		this.undoManager.discardAllEdits();
		this.redoButton.setEnabled(false);
		this.undoButton.setEnabled(false);
		
	}

}
