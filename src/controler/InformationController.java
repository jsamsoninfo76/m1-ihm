package controler;

import model.InformationModel;
import view.InformationLecture;

public class InformationController {

	private InformationModel informationmodel;
	private InformationLecture informationlecture;
	
	public InformationController(InformationModel informationmodel){
		this.informationmodel = informationmodel;
	}
	
	public InformationLecture getView(){
		return informationlecture;
	}
	
	public void setView(InformationLecture informationlecture){
		this.informationlecture = informationlecture;
	}
}
