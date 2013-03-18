package graphic;

import model.ColorModel;
import model.EnsembleBatonnetModel;
import controller.ColorController;
import controller.EnsembleBatonnetController;
import view.Batonnet;
import view.BatonnetEnGris;

public class EnsembleBatonnetEnGris extends EnsembleBatonnet {
	public EnsembleBatonnetEnGris(ColorModel[] listModel,
			ColorController[] listController,
			EnsembleBatonnetModel ensembleBatonnetModel,
			EnsembleBatonnetController ensembleBatonnetController, ColorChooser csp) {
		super(listModel, listController, ensembleBatonnetModel, ensembleBatonnetController, csp);
		for (int i = 0; i < 10; i++) {
			Batonnet bgGris = new BatonnetEnGris(i,
					this.listModel[i], this, this.ensemblebatonnetController);
			if (i == 0) {
				bgGris.setSelectionner(true);
			}

			this.addBattonet(bgGris,listController[i],this.ensemblebatonnetModel);
		}
	}
}
