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
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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

    private JPanel pnlPrincipal = new JPanel();
    private JButton btnNouvellePartie = new JButton("Nouvelle Partie...");
    private JButton btnOptions = new JButton("Options...");
    private JButton btnInfo = new JButton("Regle du Jeu");
    private JButton btnQuitter = new JButton("Quitter");
    private Monde monde;
    Image img = getToolkit().getDefaultToolkit().getImage("golfeur.gif");
    ImageIcon icon = new ImageIcon("ciel.png");

    public Menu() {
        setTitle("Bonjour bienvenue au jeu big boyyyyy");
        setVisible(true);

        pnlPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        pnlPrincipal.add(btnNouvellePartie, gbc);
        pnlPrincipal.add(btnInfo, gbc);
        pnlPrincipal.add(btnOptions, gbc);
        pnlPrincipal.add(btnQuitter, gbc);
        add(pnlPrincipal);
        evenements();

        setPreferredSize(new Dimension(500, 500));

        pack();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void evenements() {
        btnNouvellePartie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choixDifficulte();
            }
        });
        btnInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null, "Francis Guay, date de remise ; 15 octobre 2017", "Regles",
                        JOptionPane.INFORMATION_MESSAGE, icon);
            }
        });
    }

    public void choixDifficulte() {

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
                /*setLayout(null);
                setPreferredSize(new Dimension(1500, 600));
                add(monde);
                
                setVisible(true);*/
                nouvellePartie();
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

    public void nouvellePartie() {
        Fenetre fen = new Fenetre();
        fen.setVisible(true);

        dispose();

    }
}
