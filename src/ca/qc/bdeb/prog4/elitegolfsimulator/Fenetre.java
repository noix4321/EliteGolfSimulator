/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.prog4.elitegolfsimulator;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.CANCEL_OPTION;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import javax.swing.JPanel;

/**
 *
 * @author 1533727
 */
class Fenetre extends JFrame {

    private Monde monde = new Monde();
    private Menu menu = new Menu();
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
        evenements();
        setResizable(false);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void mettrePanels() {
        pnlNord.setLayout(new BorderLayout());
        add(pnlNord, BorderLayout.NORTH);
        add(menu);
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

    private void evenements() {
        mnuDifficulté.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menu.choixDifficulte();
//                Object[] options = {"Débutant", "Intermédiaire", "Expert", "Hard en tabarnack"};
//                int optionPane = JOptionPane.showOptionDialog(null,
//                        "Choisisser une difficulté?",
//                        "Menu option",
//                        JOptionPane.YES_NO_CANCEL_OPTION,
//                        JOptionPane.QUESTION_MESSAGE,
//                        null,
//                        options,
//                        options[3]);
//
//                switch (optionPane) {
//                    case YES_OPTION: { //option 7x7 du JOptionPane
//
//                    }
//                    break;
//                    case NO_OPTION: { //option 6x6 du JOptionPane
//
//                    }
//                    break;
//                    case CANCEL_OPTION: { //option 5x5 du JOptionPane
//
//                    }
//                    break;
//                    default: { //option 4x4 du JOptionPane
//
//                    }
//                    break;
//                }
//                invalidate();
//                repaint();
            }
        });
    }

}
