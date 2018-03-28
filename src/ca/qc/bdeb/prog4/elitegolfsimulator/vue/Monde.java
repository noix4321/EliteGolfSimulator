/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.prog4.elitegolfsimulator.vue;

import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javafx.scene.control.SplitPane;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author 1533727
 */
class Monde extends JPanel {

    private final int HAUTEUR = 600, LARGEUR = 1500;
    private int coups = 0, trous = 1;
    //private Vue vue = new Vue();
    private Golfeur golfeur = new Golfeur();
    private Trou trou = new Trou();
    private Drapeau drapeau = new Drapeau();
    private Balle balle = new Balle();
    private boolean boolGazon = true;
    private ArrayList<Integer> listKeyCodes = new ArrayList<>();
    private Image img1 = getToolkit().getDefaultToolkit().getImage("gazon1.png");
    private Image img2 = getToolkit().getDefaultToolkit().getImage("gazon2.png");
    private Image img3 = getToolkit().getDefaultToolkit().getImage("ciel.png");
    private JLabel nbrCoups = new JLabel();
    private Thread thread;
    private int vitesseX = 0;
    private int vitesseY = 0;
    private int gravity = 1;
    private boolean bouge = false;
    private int compteur = 1;
    private Arc arc = new Arc();

    public Monde(ArrayList listKeyCodes) {

        this.listKeyCodes = listKeyCodes;

        this.thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    verifierTouche();
                    if (bouge) {
                        //balle.bouger();
                        vitesseX = 4;
                        vitesseY = -8;
                        compteur++;
                    }
                    if (compteur % 0.05 == 0) {
                        vitesseY += gravity;
                    }
                    
                    if (compteur % 3 == 0) {
//                        balle.setDeltaY(balle.getDeltaY() + 1);
//                        if (balle.getDeltaY() == 0) {
//                            if (balle.getY() <= 3) {
//                                balle.setDeltaY(balle.getDeltaY() - 1);
//                            }
//
//                        }
//                        if (balle.getY() <= (3 * HAUTEUR / 4) - trou.getHeight()) {
////                            balle.setDeltaY(0);
//                            balle.setDeltaY(-1);
//                            if (balle.getDeltaY() == 0) {
//                                if (balle.getY() <= 2) {
//                                    balle.setDeltaY(balle.getDeltaY() + 1);
//                                }
//
//                            }
//                        }
//                        if (balle.getX() >= LARGEUR - (5 * trou.getWidth())) {
//                            balle.setDeltaX(0);
//   

                        balle.setLocation(vitesseX + balle.getX(), vitesseY + balle.getY());

                        if (balle.getY() <= 200) {
                            balle.setLocation(balle.getX(), 190);
                            vitesseY = 0;
                        }

                    }

                    try {
                        Thread.sleep(25);
                    } catch (InterruptedException exc) {

                    }
                }
            }
        };

        setLayout(null);

        afficherPoint(0);

        setPreferredSize(new Dimension(LARGEUR, HAUTEUR));
        mettreGolfeurTrouDrapeau();
        thread.start();
        setVisible(true);
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

    private void frapperBall() {
        bouge = true;

    }

    public void afficherPoint(int coups) {
        nbrCoups.setText("Points: " + coups);
        nbrCoups.setSize(100, 60);
        this.add(nbrCoups);
        nbrCoups.setLocation(200, 2 - 0);
    }

    private void verifierTouche() {
        if (listKeyCodes.contains(KeyEvent.VK_SPACE)) {
            frapperBall();

        }
    }

    private void mettreGolfeurTrouDrapeau() {
        add(golfeur);
        golfeur.setLocation(0, 3 * HAUTEUR / 4 - golfeur.getHeight());
        add(trou);
        trou.setLocation(LARGEUR - (5 * trou.getWidth()), (3 * HAUTEUR / 4) - trou.getHeight());
        add(drapeau);
        drapeau.setLocation(trou.getX() + trou.getWidth() / 2, trou.getY() - drapeau.getHeight());
        add(balle);
        balle.setLocation(golfeur.getX() + golfeur.getWidth() / 2, golfeur.getY() + golfeur.getHeight() - balle.getHeight());
        add(arc);
        arc.setLocation(0, 180);
    }

    public int getTrou() {
        return trous;
    }

    public JLabel getnbrCoups() {
        return nbrCoups;
    }

    public int getCoups() {
        return coups;
    }

    public int getLARGEUR() {
        return LARGEUR;
    }

    public int getHAUTEUR() {
        return HAUTEUR;
    }

    public void initialisateur() {
        balle.setHAUTEUR(HAUTEUR);
    }

}
