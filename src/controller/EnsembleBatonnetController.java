package controller;

import model.EnsembleBatonnetModel;

public class EnsembleBatonnetController {

	private EnsembleBatonnetModel model;

	public EnsembleBatonnetController(EnsembleBatonnetModel model) {
		this.model = model;
	}

	public void modifyBarreGraphicSelected(int index) {
		model.setIndexBarreSelectionner(index);
	}

}
