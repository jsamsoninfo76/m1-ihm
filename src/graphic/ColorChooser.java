package graphic;

import java.awt.Color;
import java.util.List;

import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.ColorController;

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

	private void InitialisationDuColorChooser() {
		colorChooser = new JColorChooser();

		// Modification du ColorChooser pour ajouter fonction gris

		// colorChooser.addChooserPanel(colorGrisChooser);

		colorChooser.setPreviewPanel(new JPanel());

		// Ajout du changeListener personaliser
		colorChooser.getSelectionModel().addChangeListener(
				new ChangeListener() {

					@Override
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
