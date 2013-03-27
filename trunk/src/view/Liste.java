package view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTable;

import model.Playlist;

public class Liste extends JPanel{
	public enum Sport {
	    TENNIS,
	    FOOTBALL,
	    NATATION,
	    RIEN;
	}
	private JTable table;
	public Liste(){
		 Object[][] donnees = {
	                {"Johnathan", "Sykes", Color.red, true, Sport.TENNIS},
	                {"Nicolas", "Van de Kampf", Color.black, true, Sport.FOOTBALL},
	                {"Damien", "Cuthbert", Color.cyan, true, Sport.RIEN},
	                {"Corinne", "Valance", Color.blue, false, Sport.NATATION},
	                {"Emilie", "Schrödinger", Color.magenta, false, Sport.FOOTBALL},
	                {"Delphine", "Duke", Color.yellow, false, Sport.TENNIS},
	                {"Eric", "Trump", Color.pink, true, Sport.FOOTBALL},
	        };
	 
	        String[] entetes = {"Prénom", "Nom", "Couleur favorite", "Homme", "Sport"};
	 
		Playlist playlist = new Playlist();
		table = new JTable(donnees,entetes);
		
		this.add(table);
	}
}
