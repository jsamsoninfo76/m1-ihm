package controler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

import javax.swing.table.DefaultTableModel;

import model.JTableModel;
import view.Liste;

/**
 * Controleur de la base de donnée
 * 
 * @author Jeremie Samson
 * @author Victor Paumier
 * @version 1
 */
public class JTableController {
	public JTableModel tablemodel;
	private Liste view;
	private final String pathToDatabase = "db/mp3database.sqlite";

	public JTableController(JTableModel tablemodel) {
		this.tablemodel = tablemodel;
		loadDatabase();
	}

	public void setView(Liste liste) {
		this.view = view;
	}

	public Liste getView(){
		return view;
	}
	
	/**
	 * On vient charger la base de donnée pour remplir le model du tableau
	 */
	private void loadDatabase() {
		Connection connection = null;
		
		//Connection a la db
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// On vient se connecter a la db local
		try {

			// On recupère la connection et le
			connection = DriverManager.getConnection("jdbc:sqlite:"
					+ pathToDatabase);
			Statement statement = connection.createStatement();
			statement.setQueryTimeout(30);

			int ligne = 0;
			// On execute la requête pour récupérer les musiques
			ResultSet rs = statement.executeQuery("SELECT * FROM songs");
			while (rs.next()) {
				// On vient peupler le model pour le tableau
				tablemodel.addRow(Arrays.asList(String.valueOf(ligne+1),rs.getString("album"),rs.getString("artist"),rs.getString("title"),rs.getString("genre"),rs.getString("year"),rs.getString("duration")));
				ligne++;
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				// On ferme la connection si elle est active
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}
}
