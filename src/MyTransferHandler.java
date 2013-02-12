import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.TransferHandler;

public class MyTransferHandler extends TransferHandler{
 
  public boolean canImport(TransferHandler.TransferSupport info) {
    if (!info.isDataFlavorSupported(DataFlavor.stringFlavor)) {
      return false;
    }
    return true;
  }
 
  public boolean importData(TransferHandler.TransferSupport support){
    if(!canImport(support))
      return false;
 
    Transferable data = support.getTransferable();
    String str = "";
       
    try {
      str = (String)data.getTransferData(DataFlavor.stringFlavor);
    } catch (UnsupportedFlavorException e){
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
          
    JLabel lab = (JLabel)support.getComponent();
    lab.setText(str);
 
    return false;
  }
 
  protected void exportDone(JComponent c, Transferable t, int action){
    //Une fois le drop effectué nous effaçons le contenu de notre JLabel
    if(action == MOVE)
      ((JLabel)c).setText("");
  }
 
  protected Transferable createTransferable(JComponent c) {
    //On retourne un nouvel objet implémentant l'interface Transferable
    //StringSelection implémente cette interface,  nous l'utilisons donc
    return new StringSelection(((JLabel)c).getText());
  }
 
  public int getSourceActions(JComponent c) {
    return MOVE;
  }   
}