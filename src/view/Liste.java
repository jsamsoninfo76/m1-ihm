package view;

import javax.swing.JPanel;
import javax.swing.JTable;

import model.Playlist;

public class Liste extends JPanel{

	private JTable table;
	public Liste(){
		Playlist playlist = new Playlist();
		table = new JTable(playlist);
		
		this.add(table);
	}
}
