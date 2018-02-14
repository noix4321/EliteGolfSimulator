/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.prog4.elitegolfsimulator;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.CANCEL_OPTION;
import static javax.swing.JOptionPane.NO_OPTION;
import static javax.swing.JOptionPane.YES_OPTION;
import javax.swing.JPanel;

/**
 *
 * @author 1533727
 */
public class Menu extends JFrame {

    //private MondeMenu mondeMenu = new MondeMenu();
    private JPanel pnlPrincipal = new JPanel();
    private JButton btnNouvellePartie = new JButton("Nouvelle Partie...");
    private JButton btnOptions = new JButton("Options...");
    private JButton btnInfo = new JButton("Regle du Jeu");
    private JButton btnQuitter = new JButton("Quitter");
    private Monde monde = new Monde();

    public Menu() {
        setTitle("Bonjour bienvenue au jeu big boyyyyy");
        setVisible(true);
        //setLayout(new FlowLayout());

        btnNouvellePartie.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnOptions.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnInfo.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnQuitter.setAlignmentX(Component.CENTER_ALIGNMENT);

        btnNouvellePartie.setAlignmentY(Component.CENTER_ALIGNMENT);
        btnOptions.setAlignmentY(Component.CENTER_ALIGNMENT);
        btnInfo.setAlignmentY(Component.CENTER_ALIGNMENT);
        btnQuitter.setAlignmentY(Component.CENTER_ALIGNMENT);

        pnlPrincipal.setLayout(new BoxLayout(pnlPrincipal, BoxLayout.Y_AXIS));
        pnlPrincipal.add(btnNouvellePartie);
        pnlPrincipal.add(btnInfo);
        pnlPrincipal.add(btnOptions);
        pnlPrincipal.add(btnQuitter);
        add(pnlPrincipal);

        //add(mondeMenu);
        setPreferredSize(new Dimension(500, 500));
        setLocationRelativeTo(null);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        pack();
        evenements();
        //setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    private void evenements(){
        btnNouvellePartie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choixDifficulte();
            }
        });
    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//       
//        g.drawImage(img1, 0, 0, this);
//
//    }
    protected void choixDifficulte() {

        Object[] options = {"Debutant", "Intermediaire", "Avance", "Expert"};
        int optionPane = JOptionPane.showOptionDialog(null,
                "Choisisser une difficulté?",
                "Menu option",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[3]);

        switch (optionPane) {
            case YES_OPTION: { //option debutant du JOptionPane
                setLayout(null);
                setPreferredSize(new Dimension(1500, 600));
                add(monde);
                setVisible(true);
                System.out.println("hbveby");
            }
            break;
            case NO_OPTION: { //option intermediaire du JOptionPane

            }
            break;
            case CANCEL_OPTION: { //option avance du JOptionPane

            }
            break;
            default: { //option expert JOptionPane

            }
            break;
        }

    }
}
