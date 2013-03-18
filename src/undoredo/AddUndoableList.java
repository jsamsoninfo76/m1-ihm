package undoredo;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import view.Batonnet;

import model.ColorModel;

import controller.ColorController;

public class AddUndoableList extends AbstractUndoableEdit {

	private ColorController control;
	private ColorModel model;
	private Batonnet batonnetGris;
	private Batonnet batonnetCouleur;
	private ColorController[] listControl;
	private ColorModel[] listModel;
	
	public AddUndoableList(ColorController control, ColorModel model,
			Batonnet bg, Batonnet b,
			ColorController[] listControl, ColorModel[] listModel) {
		this.control = control;
		this.model = model;
		this.batonnetGris = bg;
		this.listControl = listControl;
		this.listModel = listModel;
		this.batonnetCouleur = b;
	}

	@Override
	public void undo() throws CannotUndoException {
		super.undo();
		this.listControl[this.batonnetGris.getIndex()] = null;
		this.listModel[this.batonnetGris.getIndex()] = null;
		this.batonnetGris.getEnsembleBatonnet().remove(batonnetGris);
		this.batonnetCouleur.getEnsembleBatonnet().remove(batonnetCouleur);
		this.batonnetGris.getEnsembleBatonnet().decrementerNbrBatonnet();
		this.batonnetCouleur.getEnsembleBatonnet().decrementerNbrBatonnet();
	}

	@Override
	public void redo() throws CannotRedoException {
		super.redo();
		this.listControl[this.batonnetGris.getIndex()] = this.control;
		this.listModel[this.batonnetGris.getIndex()] = this.model;

		int indexAdded = -1;
		for (int i = 0; i < batonnetGris.getEnsembleBatonnet().getComponents().length; i++) {
			Batonnet barreG = (Batonnet) batonnetGris.getEnsembleBatonnet()
					.getComponent(i);
			if (batonnetGris.getIndex() < barreG.getIndex()) {
				indexAdded = i;
				break;
			}
		}
		this.batonnetGris.getEnsembleBatonnet().add(batonnetGris, indexAdded);
		this.batonnetCouleur.getEnsembleBatonnet().add(batonnetCouleur, indexAdded);
		this.batonnetGris.getEnsembleBatonnet().incrementerNbrBatonnet();
		this.batonnetCouleur.getEnsembleBatonnet().incrementerNbrBatonnet();  

	}
	
}
