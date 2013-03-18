package view;

import graphic.EnsembleBatonnet;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controller.ColorController;
import controller.EnsembleBatonnetController;

import model.ColorModel;
import model.EnsembleBatonnetModel;

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
	
	@Override
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
	private void displayFixe() {
		this.setBorder(new LineBorder(Color.red,3));
	}

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

	public boolean estSelectionner() {
		return selectionner;
	}

	public void setSelectionner(boolean selected) {
		this.selectionner = selected;
		if (this.selectionner == true) {
				this.setBorder(Batonnet.BORDER_COLOR);

			} else {
				this.setBorder(null);
			}
	}

	public ColorModel getModel() {
		return model;
	}

	public void setModel(ColorModel model) {
		this.model = model;

	}

	public EnsembleBatonnetModel getEnsembleBatonnetModel() {
		return ensembleBatonnetModel;
	}

	public void setEnsembleBatonnetModel(EnsembleBatonnetModel ensembleBatonnetModel) {
		this.ensembleBatonnetModel = ensembleBatonnetModel;
		this.ensembleBatonnetModel.addObserver(this);
	}

	public EnsembleBatonnet getEnsembleBatonnet() {
		return ensembleBatonnet;
	}

	public void setEnsembleBatonnet(EnsembleBatonnet ensembleBatonnet) {
		this.ensembleBatonnet = ensembleBatonnet;
	}

	public EnsembleBatonnetController getEnsembleBatonnetController() {
		return ensembleBatonnetController;
	}

	public void setEnsembleBatonnetController(EnsembleBatonnetController ensembleBatonnetController) {
		this.ensembleBatonnetController = ensembleBatonnetController;
	}

	public ColorController getColorController() {
		return colorController;
	}

	public void setColorController(ColorController colorController) {
		this.colorController = colorController;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	
}
