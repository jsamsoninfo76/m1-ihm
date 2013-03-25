package ui;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.undo.UndoManager;

import batonnets.ColorChooser;
import batonnets.EnsembleBatonnet;
import batonnets.EnsembleBatonnetEnCouleurs;
import batonnets.EnsembleBatonnetEnGris;
import batonnets.IndicateurRGB;

import listeners.AddListener;
import listeners.DeleteListener;
import listeners.OptimiseListener;
import listeners.RedoListener;
import listeners.UndoListener;
import modele.ColorModel;
import modele.EnsembleBatonnetModel;
import controleur.ColorController;
import controleur.EnsembleBatonnetController;

/**
 * UI est la classe qui initialise l'interface graphique de l'application.
 * 
 * @author Jeremie Samson & Victor Paumier
 * @version 2
 */
public class UI extends JFrame {

	private int MAX_BATONNET = 10;
	private EnsembleBatonnet ensembleBatonnetCouleur;
	private EnsembleBatonnet ensembleBatonnetGris;
	private ColorController[] listController;
	private ColorModel[] listModel;
	private EnsembleBatonnetController ensembleBatonnetController;
	private EnsembleBatonnetModel ensembleBatonnetModel;
	private ColorChooser colorPanel;
	private GridBagConstraints constraints;
	private UndoManager undoManager;
	private JButton undoButton;
	private JButton redoButton;
	private JButton randomButton = new JButton("Random");

	/**
	 * Constructeur de la classe, lance les methodes d'initialisation pour
	 * construire l'interface graphique.
	 */
	public UI() {
		this.setTitle("ColorChooser");
		initUI();
		initMenuBoutons();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		ensembleBatonnetCouleur.repaint();
		this.setVisible(true);
	}

	/**
	 * Initialise l'interface graphique
	 */
	private void initUI() {

		this.getContentPane().setLayout(new GridBagLayout());
		undoManager = new UndoManager();
		this.constraints = new GridBagConstraints();

		ensembleBatonnetModel = new EnsembleBatonnetModel();
		ensembleBatonnetController = new EnsembleBatonnetController(
				ensembleBatonnetModel);

		listController = new ColorController[MAX_BATONNET];
		listModel = new ColorModel[MAX_BATONNET];
		for (int i = 0; i < MAX_BATONNET; i++) {
			ColorModel cm = new ColorModel();
			listModel[i] = cm;
			listController[i] = new ColorController(cm);
		}

		this.colorPanel = new ColorChooser(listController[0]);
		this.ensembleBatonnetCouleur = new EnsembleBatonnetEnCouleurs(
				listModel, listController, ensembleBatonnetModel,
				ensembleBatonnetController, colorPanel);
		this.ensembleBatonnetGris = new EnsembleBatonnetEnGris(listModel,
				listController, ensembleBatonnetModel,
				ensembleBatonnetController, colorPanel);
		constraints.gridx = 0;
		constraints.gridy = 3;
		constraints.gridwidth = 1;
		this.getContentPane().add(ensembleBatonnetCouleur, this.constraints);
		constraints.gridx = 1;
		constraints.gridy = 2;
		constraints.gridheight = 2;
		this.getContentPane().add(colorPanel, constraints);
		constraints.gridheight = 1;
		constraints.gridx = 0;
		constraints.gridy = 2;
		this.getContentPane().add(ensembleBatonnetGris, this.constraints);

	}

	/**
	 * Initialise le menu des boutons
	 */
	private void initMenuBoutons() {
		IndicateurRGB rgbBar = new IndicateurRGB(this.listModel,
				this.listController, this.ensembleBatonnetCouleur);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		this.getContentPane().add(rgbBar, constraints);

		JToolBar toolBar = new JToolBar("Barre d'outils");
		toolBar.setLayout(new BoxLayout(toolBar, BoxLayout.X_AXIS));

		JButton deleteButton = new JButton("-");
		JButton addButton = new JButton("+");
		undoButton = new JButton("UNDO");
		redoButton = new JButton("REDO");
		randomButton = new JButton("ALEA");
		this.undoButton.setEnabled(false);
		this.redoButton.setEnabled(false);
		toolBar.add(addButton);
		toolBar.add(deleteButton);
		toolBar.add(undoButton);
		toolBar.add(redoButton);
		toolBar.add(randomButton);
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 3;

		this.getContentPane().add(toolBar, constraints);
		toolBar.setOrientation(JToolBar.HORIZONTAL);

		deleteButton
				.addActionListener(new DeleteListener(this, listController,
						listModel, MAX_BATONNET, ensembleBatonnetCouleur,
						ensembleBatonnetGris, ensembleBatonnetController,
						ensembleBatonnetModel, undoManager, this.undoButton,
						colorPanel));

		addButton.addActionListener(new AddListener(this, listController,
				listModel, MAX_BATONNET, ensembleBatonnetCouleur,
				ensembleBatonnetGris, ensembleBatonnetController,
				ensembleBatonnetModel, undoManager, colorPanel));

		undoButton.addActionListener(new UndoListener(this, undoManager,
				undoButton, redoButton));
		redoButton.addActionListener(new RedoListener(this, undoManager,
				undoButton, redoButton));
		randomButton.addActionListener(new OptimiseListener(
				ensembleBatonnetCouleur, undoManager, undoButton, redoButton));
	}
}
