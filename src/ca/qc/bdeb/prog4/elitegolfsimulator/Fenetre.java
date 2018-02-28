/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.prog4.elitegolfsimulator;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

/**
 *
 * @author 1533727
 */
class Fenetre extends JFrame{

    private Monde monde = new Monde();
    //private Menu menu = new Menu();
    private int coups = 0, trou = 1;
    private JPanel pnlNord = new JPanel();
    private JLabel lblCoups = new JLabel("Coups : " + coups);
    private JLabel lblTrou = new JLabel("Trou " + trou);
    private JMenuBar mnuBar = new JMenuBar();
    private JMenu mnuMenu = new JMenu("Menu");
    private JMenuItem mnuDifficulté = new JMenuItem("Difficulté");
    private JMenuItem mnuRegles = new JMenuItem("Regles");
    private JMenuItem mnuNbTrous = new JMenuItem("Nombre de trous");
    private JMenuItem mnuInstructions = new JMenuItem("Instructions");
    private JMenuItem mnuNbJoueurs = new JMenuItem("Nombre de joueurs");
    
    public Fenetre() {
        setTitle("Elite Golf Simulator");
        setVisible(true);
        setLayout(new BorderLayout());
        mettrePanels();
        mettreMenus();
        setResizable(false);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void mettrePanels() {
        pnlNord.setLayout(new BorderLayout());
        add(pnlNord, BorderLayout.NORTH);
        add(monde);
        pnlNord.add(lblCoups, BorderLayout.WEST);
        pnlNord.add(lblTrou, BorderLayout.EAST);
    }

    private void mettreMenus() {
        setJMenuBar(mnuBar);
        mnuBar.add(mnuMenu);
        mnuMenu.add(mnuDifficulté);
        mnuMenu.add(mnuInstructions);
        mnuMenu.add(mnuRegles);
        mnuMenu.addSeparator();
        mnuMenu.add(mnuNbJoueurs);
        mnuMenu.add(mnuNbTrous);
        
    }
    
    
    
}
