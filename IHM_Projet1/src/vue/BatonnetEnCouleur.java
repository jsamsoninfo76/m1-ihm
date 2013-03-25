package vue;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;

import batonnets.EnsembleBatonnet;

import modele.ColorModel;
import controleur.EnsembleBatonnetController;

/**
 * Sous classe de Batonnet pour les couleurs
 * 
 * @author Jeremie Samson & Victor Paumier
 * @version 41
 */
public class BatonnetEnCouleur extends Batonnet{

	public BatonnetEnCouleur(int index, ColorModel model, EnsembleBatonnet d,
			EnsembleBatonnetController controller) {
		super(index, model, d, controller);
		setBackground(new Color((int) model.getRed(), (int) model.getGreen(),
				(int) model.getBlue()));

		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);
				if ((e.getButton() == MouseEvent.BUTTON1)) {
					int index = 0;
					for (int i = 0; i < ensembleBatonnet.getComponentCount(); i++) {
						if (ensembleBatonnet.getComponent(i).equals(
								BatonnetEnCouleur.this)) {
							index = i;
						}

						Batonnet bg = (Batonnet) ensembleBatonnet
								.getComponent(i);
						bg.setSelectionner(false);

					}
					ensembleBatonnetController.modifyBarreGraphicSelected(index);
					Batonnet bg = (Batonnet) ensembleBatonnet
							.getComponent(index);
					bg.setSelectionner(true);
					ensembleBatonnet.getCsp().setController(
							bg.getColorController());
					ensembleBatonnet.getCsp().removeMyChooserPanel();
					ensembleBatonnet.getCsp().getColorChooser()
					.setColor(getBackground());
					ensembleBatonnet.repaint();
				}
			}
		});

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		super.update(arg0, arg1);
		if (arg0 instanceof ColorModel) {
			setBackground(new Color((int) model.getRed(),
					(int) model.getGreen(), (int) model.getBlue()));
		}
	}

}


