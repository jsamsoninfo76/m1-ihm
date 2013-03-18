package undoredo;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import model.ColorModel;
import view.Batonnet;
import controller.ColorController;

public class DelUndoableList extends AbstractUndoableEdit{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ColorController control;
	private ColorModel model;
	private Batonnet bg;
	private Batonnet b;
	private ColorController[] listControl;
	private ColorModel[] listModel;
	
	public DelUndoableList(ColorController control, ColorModel model,
			Batonnet bg, Batonnet b,
			ColorController[] listControl, ColorModel[] listModel) {
		this.control = control;
		this.model = model;
		this.bg = bg;
		this.listControl = listControl;
		this.listModel = listModel;
		this.b = b;
	}
	
	@Override
	public void undo() throws CannotUndoException {
		super.undo();
		this.listControl[this.bg.getIndex()] = this.control;
		this.listModel[this.bg.getIndex()] = this.model;
		int indexAdded = -1;
		for (int i = 0; i < bg.getEnsembleBatonnet().getComponents().length; i++) {
			Batonnet barreG = (Batonnet) bg.getEnsembleBatonnet()
					.getComponent(i);
			if (bg.getIndex() < barreG.getIndex()) {
				indexAdded = i;
				break;
			}
		}
		this.b.setSelectionner(false);
		this.bg.setSelectionner(false);
		this.bg.getEnsembleBatonnet().add(bg, indexAdded);
		this.bg.getEnsembleBatonnet().incrementerNbrBatonnet();
		this.b.getEnsembleBatonnet().add(b, indexAdded);
		this.b.getEnsembleBatonnet().incrementerNbrBatonnet();
	}

	@Override
	public void redo() throws CannotRedoException {
		super.redo();
		this.listControl[this.bg.getIndex()] = null;
		this.listModel[this.bg.getIndex()] = null;
		this.bg.getEnsembleBatonnet().remove(bg);
		this.b.getEnsembleBatonnet().remove(b);
		this.bg.getEnsembleBatonnet().decrementerNbrBatonnet();
		this.b.getEnsembleBatonnet().decrementerNbrBatonnet();  

	}
	
}
