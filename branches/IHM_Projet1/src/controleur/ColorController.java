package controleur;

import modele.ColorModel;

/**
 * Controleur des couleurs
 * 
 * @author Jeremie Samson & Victor Paumier
 * @version 8
 */
public class ColorController {

	private ColorModel model;

	public ColorController(ColorModel model) {
		this.model = model;
	}

	public void setRedColorValue(int red) {
		this.model.setRed(red);
	}

	public void setBlueColorValue(int blue) {
		this.model.setBlue(blue);
	}

	public void setGreenColorValue(int green) {
		this.model.setGreen(green);
	}

}