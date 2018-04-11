/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.prog4.elitegolfsimulator.vue;

import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author 1533727
 */
public class Trou extends JComponent{

    public Trou() {
        setSize(15, 5);
    }
    
     @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        g.fillOval(0, 0, 15, 5);
    }
    
}
