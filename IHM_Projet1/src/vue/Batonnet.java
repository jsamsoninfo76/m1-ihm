package vue;


import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import batonnets.EnsembleBatonnet;

import controleur.ColorController;
import controleur.EnsembleBatonnetController;

import modele.ColorModel;
import modele.EnsembleBatonnetModel;

/**
 * Batonnet est la classe permettant l'observer pour les différentes classes qui en hérite 
 * BatonnetEnCouleur et BatonnetEnGris
 * 
 * @author Jeremie Samson & Victor Paumier
 * @version 44
 */
public class Batonnet extends JPanel implements Observer{

	private static final LineBorder BORDER_COLOR = new LineBorder(Color.BLACK,
			3);
	protected ColorModel model;
	protected ColorController colorController;
	protected EnsembleBatonnetModel ensembleBatonnetModel;
	protected EnsembleBatonnetController ensembleBatonnetController;
	protected EnsembleBatonnet ensembleBatonnet;
	protected boolean selectionner;
	protected int index;
	
	/**
	 * Dimensionne un batonnet et l'initialise
	 * @param index
	 * @param model
	 * @param d
	 * @param controller
	 */
	public Batonnet(int index, ColorModel model, EnsembleBatonnet d,
			EnsembleBatonnetController controller) {
		this.index = index;
		this.model = model;
		this.setPreferredSize(new Dimension(20, 110));
		this.ensembleBatonnet = d;
		this.ensembleBatonnetController = controller;
		this.model.addObserver(this);
		this.setBackground(new Color((int) model.getRed(), (int) model
				.getGreen(), (int) model.getBlue()));
	}
	
	/**
	 * Met a jours le batonnet
	 * @param Observable o
	 * @param Object arg 
	 */
	public void update(Observable o, Object arg) {
		if (o instanceof EnsembleBatonnetModel) {
			for (Component c : ensembleBatonnet.getComponents()) {
				Batonnet bg = (Batonnet) c;
				bg.setSelectionner(false);
			}
			((Batonnet) ensembleBatonnet.getComponent(ensembleBatonnetModel
					.getIndexBarreSelectionner())).setSelectionner(true);
				setEnabled(true);
			ensembleBatonnet.repaint();
		}
	}
	
	/**
	 * Modifie la bordure
	 */
	private void displayFixe() {
		this.setBorder(new LineBorder(Color.red,3));
	}

	/**
	 * Return l'etat de selection du batonnet
	 */
	public boolean estSelectionner() {
		return selectionner;
	}

	/**
	 * Modifie la bordure du batonnet pour signaler a 
	 * l'utilisateur si il est selectionné ou non.
	 */
	public void setSelectionner(boolean selected) {
		this.selectionner = selected;
		if (this.selectionner == true) {
				this.setBorder(Batonnet.BORDER_COLOR);

			} else {
				this.setBorder(null);
			}
	}

	/**
	 * Retourne le model
	 */
	public ColorModel getModel() {
		return model;
	}

	/**
	 * Modifie le model
	 * @param model
	 */
	public void setModel(ColorModel model) {
		this.model = model;

	}
	
	/**
	 * Retourne le model de l'ensemble des batonnets
	 */
	public EnsembleBatonnetModel getEnsembleBatonnetModel() {
		return ensembleBatonnetModel;
	}

	/**
	 * Modifie le model de l'ensemble des batonnets et ajoute un observer
	 */
	public void setEnsembleBatonnetModel(EnsembleBatonnetModel ensembleBatonnetModel) {
		this.ensembleBatonnetModel = ensembleBatonnetModel;
		this.ensembleBatonnetModel.addObserver(this);
	}

	/**
	 * Retourne l'ensemble des batonnets
	 * @return ensembleBatonnet
	 */
	public EnsembleBatonnet getEnsembleBatonnet() {
		return ensembleBatonnet;
	}

	/**
	 * Modifie la bordure
	 * @param ensembleBatonnet
	 */
	public void setEnsembleBatonnet(EnsembleBatonnet ensembleBatonnet) {
		this.ensembleBatonnet = ensembleBatonnet;
	}

	/**
	 * Modifie l'ensemble des batonnets et ajoute un observer
	 * @return ensembleBatonnetController 
	 */
	public EnsembleBatonnetController getEnsembleBatonnetController() {
		return ensembleBatonnetController;
	}

	/**
	 * Modifie le controller de l'ensemble des batonnets 
	 * @param ensembleBatonnetController
	 */
	public void setEnsembleBatonnetController(EnsembleBatonnetController ensembleBatonnetController) {
		this.ensembleBatonnetController = ensembleBatonnetController;
	}

	/**
	 * Retourne le Controleur des couleurs
	 * @return colorController
	 */
	public ColorController getColorController() {
		return colorController;
	}

	/**
	 * Modifie le controleur des couleurs
	 * @param colorController
	 */
	public void setColorController(ColorController colorController) {
		this.colorController = colorController;
	}

	/**
	 * Retourn l'index courant
	 * @return index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Modifie l'index courant.
	 * @param index
	 */
	public void setIndex(int index) {
		this.index = index;
	}
}
