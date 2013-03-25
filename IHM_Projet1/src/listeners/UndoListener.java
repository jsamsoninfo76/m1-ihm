package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.undo.UndoManager;

import ui.UI;

/**
 * Listener sur le bouton Undo
 * 
 * @author Jeremie Samson & Victor Paumier
 * @version 2
 */
public class UndoListener implements ActionListener {
	private UndoManager undoManager;
	private JButton undoButton;
	private JButton redoButton;
	private UI fenetrePrincipal;
	
	public UndoListener(UI f,UndoManager leundoManager,JButton boutonUndo,JButton boutonRedo){
		this.fenetrePrincipal=f;
		this.undoManager=leundoManager;
		this.undoButton=boutonUndo;
		this.redoButton=boutonRedo;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (undoManager.canUndo()) {
			undoManager.undo();
			redoButton.setEnabled(true);
			undoButton.setEnabled(undoManager.canUndo());
			//undoItem.setEnabled(true);
			//afficherContenuList();
			fenetrePrincipal.repaint();
			fenetrePrincipal.pack();
		} else {
			undoButton.setEnabled(false);
			//redoItem.setEnabled(false);
		}
	}
	


	
}
