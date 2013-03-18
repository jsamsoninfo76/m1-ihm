package optimise;

import java.awt.Color;

public class MesCouleurs extends Color implements Comparable {

	public MesCouleurs(int rouge,int vert,int bleu) {
		super(rouge,vert,bleu);
		// TODO Auto-generated constructor stub
	}

	public MesCouleurs(Color color) {
		super(color.getRed(),color.getGreen(),color.getBlue());
		// TODO Auto-generated constructor stub
	}

	public int compareTo(Object object) {
		MesCouleurs other=(MesCouleurs) object;
		if (this.getBlue()+this.getGreen()+this.getRed()>other.getBlue()+other.getGreen()+other.getRed()) {return -1;}
		else {if(this.getBlue()+this.getGreen()+this.getRed()<other.getBlue()+other.getGreen()+other.getRed()) {return 1;}
		else return 0;

		}
	}

}
