/**
 * @author <a href="mailto:gery.casiez@lifl.fr">Gery Casiez</a>
 */

import model.*;
import view.*;
import controller.*;

public class TemperatureMVC {
	public TemperatureMVC() {
		TemperatureModel tempmod = new TemperatureModel();
		TemperatureController tempcontrolC = new TemperatureController(tempmod);
		TemperatureController tempcontrolF = new TemperatureController(tempmod);
		TemperatureControllerSlider tempcontrolSliderC = new TemperatureControllerSlider(tempmod);
		
		TemperatureVueCelsuis pvc = new TemperatureVueCelsuis(tempmod, tempcontrolC, 100, 200);
		TemperatureVueFarenheit tvf = new TemperatureVueFarenheit(tempmod, tempcontrolF, 100, 350);
		TemperatureVueSliderCelsuis pvsc = new TemperatureVueSliderCelsuis(tempmod, tempcontrolSliderC, 350, 200);
		
		tempcontrolC.addView(pvc);
		tempcontrolF.addView(tvf);	
		tempcontrolSliderC.addView(pvsc);
	}
	
	public static void main(String args[]) {
		//Schedule a job for the event-dispatching thread:
    //creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new TemperatureMVC();
      }
    });
	}
}
