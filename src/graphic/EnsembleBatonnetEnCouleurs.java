package graphic;

import view.Batonnet;
import view.BatonnetEnCouleur;
import model.ColorModel;
import model.EnsembleBatonnetModel;
import controller.ColorController;
import controller.EnsembleBatonnetController;

public class EnsembleBatonnetEnCouleurs extends EnsembleBatonnet {

	public EnsembleBatonnetEnCouleurs(ColorModel[]listModel,ColorController[] listController,EnsembleBatonnetModel ensembleBatonnetModel,EnsembleBatonnetController ensembleBatonnetController, ColorChooser csp) {
		super(listModel, listController, ensembleBatonnetModel, ensembleBatonnetController, csp);
		for (int i = 0; i < 10; i++) {
			Batonnet bgColor = new BatonnetEnCouleur(i,this.listModel[i], this, this.ensemblebatonnetController);
			bgColor.setEnsembleBatonnetModel(this.ensemblebatonnetModel);
			if (i == 0) {
				bgColor.setSelectionner(true);
			}
			this.addBattonet(bgColor,listController[i],this.ensemblebatonnetModel);
		}
	}
	
	

}
