/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.prog4.elitegolfsimulator;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author 1533727
 */
public class Arc extends JComponent{

     private final int HAUTEUR = 600, LARGEUR = 1500;
    
    public Arc() {
        setSize(1500, 600);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.setColor(Color.red);
        g.drawArc(0, 0, LARGEUR, HAUTEUR+400, 30, 120);
    }
    
    
    
}
