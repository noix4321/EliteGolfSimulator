/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.prog4.elitegolfsimulator.vue;

import java.awt.Color;
import java.awt.Graphics;
import static java.awt.PageAttributes.MediaType.A;
import static javafx.print.Paper.C;
import static javafx.scene.input.KeyCode.B;
import javax.swing.JComponent;

/**
 *
 * @author 1533727
 */
public class Balle extends JComponent {

    private boolean monter = true;
    private int deltaX = 4, deltaY = -4;
    private int posX = deltaX, posY = 0;
    private int velocityX = 30, velocityY = -40;
    private int gravity = 1;
    private int HAUTEUR = 0, LARGEUR = 0;

    public Balle() {
        setSize(10, 10);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.

        g.setColor(Color.white);
        g.fillOval(0, 0, 10, 10);
        g.setColor(Color.red);
        g.drawArc(0, HAUTEUR, LARGEUR, HAUTEUR / 2, 45, 45);

    }

    public void bouger() {

        if (monter) {
            setLocation(getX() + posX, getY() - posY);
        } else if (!monter) {

        }
        if (getY() <= 100) {
            monter = false;
        }
    }

    public void setHAUTEUR(int hauteur) {
        this.HAUTEUR = hauteur;
    }

    public void setLARGEUR(int LARGEUR) {
        this.LARGEUR = LARGEUR;
    }

    public void setDeltaY(int deltaY) {
        this.deltaY = deltaY;
    }

    public double getDeltaY() {
        return deltaY;
    }

    public int getVelocityX() {
        return velocityX;
    }

    public void VelocityGrave() {
        this.velocityY = velocityY + gravity;
    }

    public void setGravity(int grav) {
        this.gravity = grav;
    }

    public void setVelocityY(int velocityY) {
        this.velocityY = velocityY;
    }

    public void setVelocityX(int velocityX) {
        this.velocityX = velocityX;
    }

    public int getVelocityY() {
        return velocityY;
    }

    public int getGravity() {
        return gravity;
    }

    public void resetVelocitys() {
        velocityX = 30;
        velocityY = -40;
    }

    public double getDeltaX() {
        return deltaX;
    }

    public void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    public int getPosX() {
        return posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

}
