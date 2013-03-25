package modele;

import java.util.Observable;

/**
 * Model permettant de gérer l'index de l'ensemble des batonnets
 * 
 * @author Jeremie Samson & Victor Paumier
 * @version 26
 */
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
