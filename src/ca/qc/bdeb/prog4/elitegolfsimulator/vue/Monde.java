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
    private int vitesseX = 50;
    private int vitesseY = -40;
    private int gravity = 1;
    private boolean bougeBalle = false, bougeLigneForce = true;
    private int compteur = 1;
    private Arc arc = new Arc();
    private BarreForce barre = new BarreForce();
    private LigneForce ligneForce = new LigneForce();

    public Monde(ArrayList listKeyCodes) {

        this.listKeyCodes = listKeyCodes;

        this.thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    verifierTouche();
                    if (bougeBalle) {
                        bougeLigneForce = false;
                        if (compteur % 3 == 0) {
                            balle.setLocation(balle.getVelocityX() + balle.getX(), balle.getVelocityY() + balle.getY());

                        }
                        
                        compteur++;
                        balle.VelocityGrave();
                        if (balle.getY() > 426 && balle.getX() > 500) {
                            balle.setVelocityY(0);
                        }

                    }
                    if (bougeLigneForce) {
                        if (compteur % 3 == 0) {
                            bougerLigneForce();
                        }
                    }

                    compteur++;
                    try {
                        Thread.sleep(30);
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

    private void bougerLigneForce() {

        ligneForce.bouger();

        if ((ligneForce.getX() + ligneForce.getWidth()) >= (barre.getX() + barre.getWidth())) {
            ligneForce.setDeltaX(ligneForce.getDeltaX() * -1);
        }
        if (ligneForce.getX() <= barre.getX()) {
            ligneForce.setDeltaX(ligneForce.getDeltaX() * -1);
        }
    }

    private void frapperBall() {
        bougeBalle = true;

    }

    public void afficherPoint(int coups) {
        nbrCoups.setText("Points: " + coups);
        nbrCoups.setSize(100, 60);
        this.add(nbrCoups);
        nbrCoups.setLocation(200, 2 - 0);
    }

    private void verifierTouche() {
        if (listKeyCodes.contains(KeyEvent.VK_SPACE)) {
            ligneForce.setPosX(ligneForce.getX());
            ligneForce.setPosY(ligneForce.getY());
            System.out.println(ligneForce.getPosX() + " - " + ligneForce.getPosY());
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
        add(ligneForce);
        ligneForce.setLocation(5, HAUTEUR - ligneForce.getHeight() - 5);
        add(barre);
        barre.setLocation(5, HAUTEUR - barre.getHeight() - 5);

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
