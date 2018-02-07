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
public class Balle extends JComponent{

    public Balle() {
        setSize(10, 10);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
        g.setColor(Color.white);
        g.fillOval(0, 0, 10, 10);
        
    }
    
    
    
}
