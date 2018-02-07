/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.prog4.elitegolfsimulator;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

/**
 *
 * @author 1533727
 */
public class Menu extends JPanel{

    private Image img1 = getToolkit().getDefaultToolkit().getImage("photoMenu.jpg");
    private Monde monde = new Monde();
    
    public Menu() {
        final int LARGEUR = monde.getLARGEUR();
        final int HAUTEUR = monde.getHAUTEUR();
        setLayout(null);
        setPreferredSize(new Dimension(LARGEUR, HAUTEUR));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
       
        g.drawImage(img1, 0, 0, this);

    }
    
}
