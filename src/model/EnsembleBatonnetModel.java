package model;

import java.util.Observable;

public class EnsembleBatonnetModel extends Observable {

	// Index de la barre selectionne
	private int indexBarreSelectionner;

	public EnsembleBatonnetModel() {
		this.indexBarreSelectionner = 0;
	}

	public int getIndexBarreSelectionner() {
		return indexBarreSelectionner;
	}

	public void setIndexBarreSelectionner(int index) {
		this.indexBarreSelectionner = index;
		setChanged();
		notifyObservers();
	}

}
