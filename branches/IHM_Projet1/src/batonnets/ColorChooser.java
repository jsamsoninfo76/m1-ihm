package batonnets;

import java.awt.Color;
import java.util.List;

import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controleur.ColorController;

/**
 * Choix des couleurs
 * 
 * @author Jeremie Samson & Victor Paumier
 * @version 13
 */
public class ColorChooser extends JPanel {

	private ColorController controller;
	private JColorChooser colorChooser;
	private MyChooserPanel colorGrisChooser;

	public ColorChooser(ColorController controller) {
		this.controller = controller;
		this.InitialisationDuColorChooser();
	}

	public void addMyChooserPanel(List<Color> lesCouleurs) {
		if (colorGrisChooser != null) {
			this.removeMyChooserPanel();
		}
		colorGrisChooser = new MyChooserPanel(lesCouleurs);
		colorChooser.addChooserPanel(colorGrisChooser);
	}

	public void removeMyChooserPanel() {
		if (colorGrisChooser != null) {
			colorChooser.removeChooserPanel(colorGrisChooser);
			colorGrisChooser = null;
		}
	}

	/**
	 * Initialise le colorchooser personnalisé
	 */
	private void InitialisationDuColorChooser() {
		colorChooser = new JColorChooser();
		colorChooser.setPreviewPanel(new JPanel());
		colorChooser.getSelectionModel().addChangeListener(
				new ChangeListener() {
					public void stateChanged(ChangeEvent arg0) {
						ColorChooser.this.controller
								.setRedColorValue(colorChooser
										.getSelectionModel().getSelectedColor()
										.getRed());
						ColorChooser.this.controller
								.setBlueColorValue(colorChooser
										.getSelectionModel().getSelectedColor()
										.getBlue());
						ColorChooser.this.controller
								.setGreenColorValue(colorChooser
										.getSelectionModel().getSelectedColor()
										.getGreen());
					}
				});
		this.add(colorChooser);
	}

	public JColorChooser getColorChooser() {
		return colorChooser;
	}

	public void setColorChooser(JColorChooser colorChooser) {
		this.colorChooser = colorChooser;
	}

	public ColorController getController() {
		return controller;
	}

	public void setController(ColorController controller) {
		this.controller = controller;
	}

	public MyChooserPanel getColorGrisChooser() {
		return colorGrisChooser;
	}

	public void setColorGrisChooser(MyChooserPanel colorGrisChooser) {
		this.colorGrisChooser = colorGrisChooser;
	}

}
