package listeners;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.undo.UndoManager;

import batonnets.ColorChooser;
import batonnets.EnsembleBatonnet;

import ui.UI;
import undoredo.AddUndoableList;
import vue.Batonnet;
import vue.BatonnetEnCouleur;
import vue.BatonnetEnGris;

import modele.ColorModel;
import modele.EnsembleBatonnetModel;
import controleur.ColorController;
import controleur.EnsembleBatonnetController;

/**
 * Listener sur le bouttons ajout
 * 
 * @author Jeremie Samson & Victor Paumier
 * @version 18
 */
public class AddListener implements ActionListener{
	
	private UI laFenetrePrincipal;
	private ColorController[] listController;
	private	ColorModel[] listModel;
	private int MAX_BATONNET;
	private	EnsembleBatonnet ensembleBatonnetCouleur;
	private EnsembleBatonnet ensembleBatonnetGris;
	private		EnsembleBatonnetController ensembleBatonnetController;
	private		EnsembleBatonnetModel ensembleBatonnetModel;
	private UndoManager undoManager;
	private ColorChooser colorChooser;
	
	public AddListener(UI f,ColorController[] listController,
			ColorModel[] listModel, int mAX_BATONNET,
			EnsembleBatonnet ensembleBatonnetCouleur, EnsembleBatonnet ensembleBatonnetGris,
			EnsembleBatonnetController ensembleBatonnetController,
			EnsembleBatonnetModel ensembleBatonnetModel,
			UndoManager leUndoManager,
			ColorChooser chooser) {
		this.laFenetrePrincipal=f;
		this.listController=listController;
		this.listModel=listModel;
		this.MAX_BATONNET=mAX_BATONNET;
		this.ensembleBatonnetCouleur=ensembleBatonnetCouleur;
		this.ensembleBatonnetGris=ensembleBatonnetGris;
		this.ensembleBatonnetController=ensembleBatonnetController;
		this.ensembleBatonnetModel=ensembleBatonnetModel;
		this.undoManager=leUndoManager;
		this.colorChooser=chooser;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int indexAjout = -1;
		for (int i = 0; i < MAX_BATONNET; i++) {
			if (listController[i] == null) {
				indexAjout = i;
				break;
			}
		}
		if (indexAjout != -1) {

			listModel[indexAjout] = new ColorModel();
			listController[indexAjout] = new ColorController(
					listModel[indexAjout]);

			Batonnet bg = new BatonnetEnCouleur(indexAjout,
					listModel[indexAjout], ensembleBatonnetCouleur,
					ensembleBatonnetController);
			Batonnet bgGris = new BatonnetEnGris(indexAjout,
					listModel[indexAjout], ensembleBatonnetGris,
					ensembleBatonnetController);

			ensembleBatonnetCouleur.addBattonet(bg, listController[indexAjout],ensembleBatonnetModel);
			ensembleBatonnetGris.addBattonet(bgGris, listController[indexAjout],ensembleBatonnetModel);
			
			undoManager.addEdit(new AddUndoableList(
					listController[indexAjout], listModel[indexAjout],
					ensembleBatonnetGris.getBatonnet(indexAjout), ensembleBatonnetCouleur
							.getBatonnet(indexAjout), listController,
					listModel));
			
			
			colorChooser.removeMyChooserPanel();
			laFenetrePrincipal.repaint();
			laFenetrePrincipal.pack();
		}
	}



}
