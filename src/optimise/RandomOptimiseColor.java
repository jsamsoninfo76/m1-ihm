package optimise;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;


public class RandomOptimiseColor {
	
	private int nbrColor;
	private static final int MAX_VALUE = 255;
	
	public RandomOptimiseColor(int nbrColor) {
		this.nbrColor = nbrColor;
	}


	public List<Color> getOptimizeColors() {
		List<Color> res = new ArrayList<Color>();
			
			int intervalle = 255 / this.nbrColor;
			for (int i = 0; i < this.nbrColor; i++) {
				int red = 0;
				int green = 0;
				int blue = 0;
				int cpt = 0;
				while (cpt <= ((i + 1) * intervalle)) {
					double colorSelected = (Math.random() * 3);;
					if ((0 <= colorSelected) && (colorSelected < 0.3)) {
						int tempBlue = (int) Math.round(1 / 0.11);
						if (blue + tempBlue < MAX_VALUE) {
							blue += tempBlue;
						}
					} else {
						if ((0.3 <= colorSelected) && (colorSelected < 1.5)) {
							int tempRed = (int) Math.round(1 / 0.3);
							if (red + tempRed < MAX_VALUE) {
								red += tempRed;
							}
						} else {
							int tempGreen = (int) Math.round(1 / 0.59);

							if (green + tempGreen < MAX_VALUE) {
								green += tempGreen;
							}
						}
					}
					cpt++;
				}
				res.add(new Color(red, green, blue));
			}

		return res;
	}
	
	
}
