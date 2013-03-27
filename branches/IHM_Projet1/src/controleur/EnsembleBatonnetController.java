package controleur;

import modele.EnsembleBatonnetModel;

/**
 * Controleur de couleur de l'ensemble des batonnets
 * 
 * @author Jeremie Samson & Victor Paumier
 * @version 5
 */
public class EnsembleBatonnetController {

	private EnsembleBatonnetModel model;

	public EnsembleBatonnetController(EnsembleBatonnetModel model) {
		this.model = model;
	}

	public void modifyBarreGraphicSelected(int index) {
		model.setIndexBarreSelectionner(index);
	}

}
