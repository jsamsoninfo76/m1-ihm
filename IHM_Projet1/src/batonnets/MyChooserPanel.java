package batonnets;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.colorchooser.AbstractColorChooserPanel;

import optimiz.MesCouleurs;

/**
 * Controleur des couleurs
 * 
 * @author Jeremie Samson & Victor Paumier
 * @version 2
 */
public class MyChooserPanel extends AbstractColorChooserPanel {

	private List<Color> lesCouleurs;
	
	public MyChooserPanel(List<Color> lesCouleurs2) {
		this.lesCouleurs=lesCouleurs2;
	}

	@SuppressWarnings("unchecked")
	protected void buildChooser() {
		List<MesCouleurs> CouleursFinals=new ArrayList<MesCouleurs>();
		if (this.lesCouleurs.size()>180) {
			Random r=new Random();
			for (int i=0;i<180;i++){
				int next=r.nextInt(this.lesCouleurs.size());
				CouleursFinals.add(new MesCouleurs(this.lesCouleurs.get(next)));
			}
		}
		else {
			for (int i=0;i<this.lesCouleurs.size();i++){
				CouleursFinals.add(new MesCouleurs(this.lesCouleurs.get(i)));
			}
			
		}
		Collections.sort(CouleursFinals);
		setLayout(new GridLayout(15,12));
		for(MesCouleurs c:CouleursFinals){
			makeAddButton(c);
		}
	}

	public String getDisplayName() { return "CouleurDisponible"; }
	public Icon getLargeDisplayIcon() { return null; }
	public Icon getSmallDisplayIcon() { return null; }
	public void updateChooser() {}

	private void makeAddButton(MesCouleurs color) {
		JButton button = new JButton();
		button.setBackground(new Color(color.getRed(),color.getGreen(),color.getBlue()));
		button.setAction(setColorAction);
		add(button);
	}

	Action setColorAction = new AbstractAction() {
		public void actionPerformed(ActionEvent evt) {
			JButton button = (JButton) evt.getSource();
			getColorSelectionModel().setSelectedColor(button.getBackground());
		}
	};
}
