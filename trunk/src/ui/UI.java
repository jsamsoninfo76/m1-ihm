package ui;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import view.Liste;

/**
 * UI est la classe qui initialise l'interface graphique de l'application.
 * 
 * @author Jeremie Samson & Victor Paumier
 * @version 1
 */
public class UI extends JFrame {

	/**
	 * Constructeur de la classe, lance les methodes d'initialisation pour
	 * construire l'interface graphique.
	 */
	public UI() {
		this.setTitle("JTunes");
		initUI();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
		this.setVisible(true);
	}

	/**
	 * Initialise l'interface graphique
	 */
	private void initUI() {

		this.getContentPane().setLayout(new GridBagLayout());
		
		GridBagConstraints constraints = new GridBagConstraints();
		
		Liste liste = new Liste();
		constraints.gridx = 0;
		constraints.gridy = 1;
		constraints.gridwidth = 3;
		constraints.gridheight = 1;
		this.getContentPane().add(liste, constraints);
		
		JPanel lecteur = new JPanel();
		lecteur.setBackground(Color.GRAY);
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridwidth = 1;
		lecteur.add(new JButton("lecteur"));
		this.getContentPane().add(lecteur, constraints);
		
		JPanel resume = new JPanel();
		resume.setBackground(Color.BLUE);
		constraints.gridx = 1;
		constraints.gridy = 0;
		resume.add(new JButton("resume"));
		this.getContentPane().add(resume, constraints);
		
		JPanel recherche = new JPanel();
		recherche.setBackground(Color.GREEN);
		constraints.gridx = 2;
		constraints.gridy = 0;
		recherche.add(new JButton("recherche"));
		this.getContentPane().add(recherche, constraints);
		
		
	}
}
