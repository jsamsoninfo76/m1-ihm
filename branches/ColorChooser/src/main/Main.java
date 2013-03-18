package main;

/**
 * Main lance l'application.
 * 
 * @author Jeremie Samson & Victor Paumier
 * @version 2
 */
public class Main {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new UI();
			}
		});
	}
}
