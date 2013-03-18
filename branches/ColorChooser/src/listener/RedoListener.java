package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.undo.UndoManager;

import main.UI;

public class RedoListener implements ActionListener {
	
	private UndoManager undoManager;
	private JButton undoButton;
	private JButton redoButton;
	private UI fenetrePrincipal;
	
	public RedoListener(UI f,UndoManager leundoManager,JButton boutonUndo,JButton boutonRedo){
		this.fenetrePrincipal=f;
		this.undoManager=leundoManager;
		this.undoButton=boutonUndo;
		this.redoButton=boutonRedo;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (undoManager.canRedo()) {
			undoManager.redo();
			undoButton.setEnabled(true);
			redoButton.setEnabled(undoManager.canRedo());
		//	undoItem.setEnabled(true);
			//afficherContenuList();
			fenetrePrincipal.repaint();
			fenetrePrincipal.pack();
		} else {
			redoButton.setEnabled(false);
			//redoItem.setEnabled(false);
		}
	}
	


}
