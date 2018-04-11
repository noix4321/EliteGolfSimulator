/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.prog4.elitegolfsimulator.vue;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JComponent;

/**
 *
 * @author 1533727
 */
public class BarreForce extends JComponent {

    Image imgD = getToolkit().getDefaultToolkit().getImage("BarreForceVersDroite.PNG");

    public BarreForce() {
        setSize(105, 38);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imgD, 0, 0, this);

    }
}
