package optimise;

import java.awt.Color;

/**
 * MesCouleurs permet d'optimiser le choix de la couleur pour le niveau de gris.
 * 
 * @author Jeremie Samson & Victor Paumier
 * @version 2
 */
public class MesCouleurs extends Color implements Comparable {

	public MesCouleurs(int rouge,int vert,int bleu) {
		super(rouge,vert,bleu);
	}

	public MesCouleurs(Color color) {
		super(color.getRed(),color.getGreen(),color.getBlue());
	}

	/**
	 * CompareTo Vient permettre l'optimisation du choix en comparant 
	 * la sommes des couleurs de deux objets
	 */
	public int compareTo(Object object) {
		MesCouleurs other=(MesCouleurs) object;
		int sommeCouleurcomparant = this.getBlue()+this.getGreen()+this.getRed();
		int sommeCouleurcompare = other.getBlue()+other.getGreen()+other.getRed();
		
		if (sommeCouleurcomparant > sommeCouleurcompare) {
			return -1;
		}
		else {
			if( sommeCouleurcomparant < sommeCouleurcompare) {
				return 1;
			}
			else return 0;
		}
	}

}
