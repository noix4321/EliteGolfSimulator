/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.prog4.elitegolfsimulator;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javafx.scene.control.SplitPane;
import javax.swing.JPanel;

/**
 *
 * @author 1533727
 */
class Monde extends JPanel {

    private final int HAUTEUR = 600, LARGEUR = 1500;
    private Golfeur golfeur = new Golfeur();
    private Trou trou = new Trou();
    private boolean boolGazon = true;
    private Image img1 = getToolkit().getDefaultToolkit().getImage("gazon1.png");
    private Image img2 = getToolkit().getDefaultToolkit().getImage("gazon2.png");
    private Image img3 = getToolkit().getDefaultToolkit().getImage("ciel.png");

    public Monde() {
        setLayout(null);
        setPreferredSize(new Dimension(LARGEUR, HAUTEUR));
        add(golfeur);
        golfeur.setLocation(0, 3 * HAUTEUR / 4 - golfeur.getHeight());
        add(trou);
        trou.setLocation(LARGEUR - (5 * trou.getWidth()), (3 * HAUTEUR / 4) - trou.getHeight());;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img3, LARGEUR - 1920, HAUTEUR - 1200, this);
        for (int i = 0; i < LARGEUR; i += 16) {
            for (int j = HAUTEUR - HAUTEUR / 3; j < HAUTEUR; j += 16) {

                if (boolGazon) {
                    g.drawImage(img1, i, j, this);
                } else {
                    g.drawImage(img2, i, j, this);
                }

                if (boolGazon) {
                    boolGazon = false;
                } else {
                    boolGazon = true;
                }

            }
        }

    }

}
