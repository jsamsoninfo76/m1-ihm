package vue;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import batonnets.EnsembleBatonnet;

import optimiz.MesCouleurs;

import modele.ColorModel;
import controleur.EnsembleBatonnetController;

/**
 * Sous classe de Batonnet pour le gris
 * 
 * @author Jeremie Samson & Victor Paumier
 * @version 41
 */
public class BatonnetEnGris extends Batonnet{

	
	public BatonnetEnGris(int index, final ColorModel model, EnsembleBatonnet d,
			EnsembleBatonnetController controller) {
		super(index, model, d, controller);
		int niveauGris = (int) (0.3 * model.getRed() + 0.59 * model.getGreen() + 0.11 * model
				.getBlue());
		setBackground(new Color(niveauGris,niveauGris,niveauGris));
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				super.mouseReleased(e);

				if ((e.getButton() == MouseEvent.BUTTON1)) {
					int index = 0;
					for (int i = 0; i < ensembleBatonnet.getComponentCount(); i++) {
						if (ensembleBatonnet.getComponent(i).equals(
								BatonnetEnGris.this)) {
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
					
					int niveauGris=(int) (0.3 * model.getRed() + 0.59 * model.getGreen() + 0.11 * model
							.getBlue());
					List<Color> couleursPourCeNiveau=algorithme(niveauGris);
					ensembleBatonnet.getCsp().addMyChooserPanel(couleursPourCeNiveau);
					
					
					ensembleBatonnet.repaint();
					}
			}
		});
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		super.update(arg0, arg1);
		if (arg0 instanceof ColorModel) {
			int niveauGris = (int) (0.3 * model.getRed() + 0.59 * model.getGreen() + 0.11 * model
					.getBlue());
			setBackground(new Color(niveauGris,niveauGris,niveauGris));
		}
	}
	
	public List<Color> algorithme(int niveauGris){
		List<Color> res=new ArrayList<Color>();
		//Rouge
		for (int red=0;red<=255;red+=2){
			//Vert
			for(int green=0;green<=255;green+=2){
				//Bleu
				for(int blue=0;blue<255;blue+=2){
					if ((0.3*red+0.59*green+0.11*blue)==niveauGris){
						res.add(new Color(red,green,blue));
					}
				}
			}
		}
		return res;
	}
}
