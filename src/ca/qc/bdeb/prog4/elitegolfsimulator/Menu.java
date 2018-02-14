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
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
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
    private Monde monde = new Monde();

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


        setPreferredSize(new Dimension(500, 500));

        pack();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }
}
