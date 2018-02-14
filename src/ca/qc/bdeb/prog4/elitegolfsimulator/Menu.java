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
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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

    public Menu() throws IOException {

        setContentPane(new JPanel() {

            BufferedImage image = ImageIO.read(new File("allo.png"));

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); 
                g.drawImage(image, 0, 0, null);
            }

        });
        
        
        setTitle("Bonjour bienvenue au jeu big boyyyyy");
        setVisible(true);

        pnlPrincipal.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 0, 8, 0);
        pnlPrincipal.add(btnNouvellePartie, gbc);
        pnlPrincipal.add(btnInfo, gbc);
        pnlPrincipal.add(btnOptions, gbc);
        pnlPrincipal.add(btnQuitter, gbc);

        add(pnlPrincipal);

        setPreferredSize(new Dimension(500, 500));

        pack();
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

}
