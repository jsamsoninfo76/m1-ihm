package batonnets;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;

import modele.ColorModel;
import modele.EnsembleBatonnetModel;
import vue.Batonnet;
import controleur.ColorController;
import controleur.EnsembleBatonnetController;

/**
 * Classe abstraite pour les deux différents ensemble de batonnet
 * 
 * @author Jeremie Samson & Victor Paumier
 * @version 42
 */
public abstract class EnsembleBatonnet extends JPanel {

	private static final int MAX_BATONNET = 10;
	private int nbrBatonnets;
	protected boolean isSelected;
	protected ColorModel[] listModel;
	protected EnsembleBatonnetModel ensemblebatonnetModel;
	protected ColorController[] listController;
	protected EnsembleBatonnetController ensemblebatonnetController;
	protected ColorChooser cc;

	public EnsembleBatonnet(ColorModel[] listModel,
			ColorController[] listController,
			EnsembleBatonnetModel batonnetModel,
			EnsembleBatonnetController batonnetController, ColorChooser csp) {
		this.setPreferredSize(new Dimension(300, 130));
		this.setBackground(Color.WHITE);
		this.nbrBatonnets = 0;
		this.listModel = listModel;
		this.listController = listController;
		this.ensemblebatonnetModel = batonnetModel;
		this.ensemblebatonnetController = batonnetController;
		this.cc = csp;
	}

	/**
	 * Ajout un battonnet
	 * @param bc battonnet
	 * @param cc colorcontroller
	 * @param ensembleBatonnetModel
	 */
	public void addBattonet(Batonnet bc, ColorController cc,
			EnsembleBatonnetModel ensembleBatonnetModel) {
		if (this.nbrBatonnets < MAX_BATONNET) {
			this.add(bc, bc.getIndex());
			this.listController[bc.getIndex()] = cc;
			bc.setColorController(cc);
			bc.setEnsembleBatonnetModel(ensembleBatonnetModel);
			this.nbrBatonnets++;
		}
	}

	/**
	 * Supprime un battonnet
	 * @param index
	 */
	public void removeBattonet(int index) {
		if (this.nbrBatonnets != 1) {
			Batonnet bg = getBatonnet(index);
			this.remove(bg);
			this.nbrBatonnets--;
			modifierBarreSelectionner(0);
		}
	}
	
	/**
	 * Modification de la barre de selection
	 * @param index
	 */
	public void modifierBarreSelectionner(int index) {
		Batonnet bg;
		ensemblebatonnetController.modifyBarreGraphicSelected(index);
		Component c = this.getComponent(index);
		bg = ((Batonnet) c);
		bg.setSelectionner(true);
		cc.setController(this.listController[bg.getIndex()]);
		ColorModel m = this.listModel[bg.getIndex()];
		cc.getColorChooser().setColor(
				new Color((int) m.getRed(), (int) m.getGreen(), (int) m
						.getBlue()));
	}

	public Batonnet getBatonnet(int index) {
		Batonnet bg = null;
		for (int i = 0; i < this.getComponentCount(); i++) {
			bg = (Batonnet) this.getComponent(i);
			if (index == bg.getIndex()) {
				break;
			}
		}
		return bg;
	}

	public int getSelectionner() {
		Batonnet bg = null;
		for (Component c : this.getComponents()) {
			Batonnet b = (Batonnet) c;
			if (b.estSelectionner()) {
				bg = b;
			}
		}
		for (int i = 0; i < this.getComponentCount(); i++) {
			if (bg.equals(this.getComponent(i))) {
				Batonnet b = (Batonnet) this.getComponent(i);
				return b.getIndex();
			}
		}
		return -1;
	}

	public ColorChooser getCsp() {
		return cc;
	}

	public void setCsp(ColorChooser csp) {
		this.cc = csp;
	}

	public ColorModel[] getListModel() {
		return listModel;
	}

	public void setListModel(ColorModel[] listModel) {
		this.listModel = listModel;
	}

	public ColorController[] getListController() {
		return listController;
	}

	public void setListController(ColorController[] listController) {
		this.listController = listController;
	}

	public int getNbrBatonnet() {
		return nbrBatonnets;
	}

	public void setNbrBatonnet(int nbrBarre) {
		this.nbrBatonnets = nbrBarre;
	}

	public void incrementerNbrBatonnet() {
		this.nbrBatonnets++;
	}

	public void decrementerNbrBatonnet() {
		this.nbrBatonnets--;
	}

}
