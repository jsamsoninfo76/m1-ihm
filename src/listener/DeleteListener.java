package listener;

import graphic.ColorChooser;
import graphic.EnsembleBatonnet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.undo.UndoManager;

import undoredo.DelUndoableList;
import main.UI;
import model.ColorModel;
import model.EnsembleBatonnetModel;
import controller.ColorController;
import controller.EnsembleBatonnetController;

public class DeleteListener implements ActionListener {

	private UI laFenetrePrincipal;
	private ColorController[] listController;
	private	ColorModel[] listModel;
	private int MAX_BATONNET;
	private	EnsembleBatonnet ensembleBatonnetCouleur;
	private EnsembleBatonnet ensembleBatonnetGris;
	private		EnsembleBatonnetController ensembleBatonnetController;
	private		EnsembleBatonnetModel ensembleBatonnetModel;
	private UndoManager undoManager;
	private JButton undoBoutton;
	private ColorChooser colorChooser;

	public DeleteListener(UI fenetrePrincipal,
			ColorController[] listController, ColorModel[] listModel,
			int mAX_BATONNET, EnsembleBatonnet ensembleBatonnetCouleur,
			EnsembleBatonnet ensembleBatonnetGris,
			EnsembleBatonnetController ensembleBatonnetController,
			EnsembleBatonnetModel ensembleBatonnetModel,
			UndoManager leUndoManager,
			JButton undoBouton,
			ColorChooser chooser){
		this.laFenetrePrincipal=fenetrePrincipal;
		this.listController=listController;
		this.listModel=listModel;
		this.MAX_BATONNET=mAX_BATONNET;
		this.ensembleBatonnetCouleur=ensembleBatonnetCouleur;
		this.ensembleBatonnetGris=ensembleBatonnetGris;
		this.ensembleBatonnetController=ensembleBatonnetController;
		this.ensembleBatonnetModel=ensembleBatonnetModel;
		this.undoManager=leUndoManager;
		this.undoBoutton=undoBouton;
		this.colorChooser=chooser;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int indexSelected = ensembleBatonnetCouleur.getSelectionner();
		if ((indexSelected != -1) && (ensembleBatonnetCouleur.getNbrBatonnet() > 1)) {

			ensembleBatonnetCouleur.getBatonnet(indexSelected).setSelectionner(false);
			ensembleBatonnetGris.getBatonnet(indexSelected).setSelectionner(false);

			undoManager.addEdit(new DelUndoableList(
					listController[indexSelected],
					listModel[indexSelected], ensembleBatonnetGris
							.getBatonnet(indexSelected), ensembleBatonnetCouleur
							.getBatonnet(indexSelected), listController,
					listModel));
			undoBoutton.setEnabled(true);

			ensembleBatonnetCouleur.removeBattonet(indexSelected);
			ensembleBatonnetGris.removeBattonet(indexSelected);			
			listModel[indexSelected] = null;
			listController[indexSelected] = null;
			colorChooser.removeMyChooserPanel();
			laFenetrePrincipal.repaint();
			laFenetrePrincipal.pack();
		}
	}

}
