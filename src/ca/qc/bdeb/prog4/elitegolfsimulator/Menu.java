/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.prog4.elitegolfsimulator;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
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
        evenements();
        pack();
        setResizable(false);
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
                        JOptionPane.INFORMATION_MESSAGE);
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
