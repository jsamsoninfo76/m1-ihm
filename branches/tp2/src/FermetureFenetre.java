import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

/*
 * Question 6. 
 * Ecrivez une classe FermetureFenetre, qui hérite de WindowAdapter, 
 * et qui redéfinit windowClosing pour afficher le message "Fenetre en cours de fermeture" 
 * avant de terminer l’exécution du programme par un System.exit(0). 
 */
public class FermetureFenetre extends WindowAdapter{
	
	public FermetureFenetre(){
		JFrame fenetre = new JFrame();
		fenetre.setTitle("FermetureFenetre");
		fenetre.setSize(200, 200);
		fenetre.setLocationRelativeTo(null);
		
		fenetre.addWindowListener(new WindowAdapter() {
		     public void windowClosing(WindowEvent ev) {
		    	System.out.println("fenetre en cours de fermeture");
		 		System.out.println(0);
		     }            
		});

	    fenetre.setVisible(true);
	}
	
	public static void main(String args[]){
		@SuppressWarnings("unused")
		FermetureFenetre fenetre = new FermetureFenetre();
	}
}
