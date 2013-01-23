import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

/*
 * Question 14. 
 * Remplissez les méthodes setSizes, preferredLayoutSize, minimumLayoutSize et layoutContainer de la classe VboxLayout.java. 
 * Vous testerez VboxLayout en utilisant demovbox.java de manière à obtenir une interface proche de celle représentée sur la figure 4.
 * 
 */

public class VboxLayout implements LayoutManager {

	@Override
	public void addLayoutComponent(String arg0, Component arg1) {
		addLayoutComponent(arg0, arg1);
	}

	@Override
	public void layoutContainer(Container arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public Dimension minimumLayoutSize(Container arg0) {
		return new Dimension(100,100);
	}

	@Override
	public Dimension preferredLayoutSize(Container arg0) {
		return new Dimension(200,200);
	}

	@Override
	public void removeLayoutComponent(Component arg0) {
		
	}

}
