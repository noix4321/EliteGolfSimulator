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
public class Drapeau extends JComponent{

    public Drapeau() {
        setSize(20, 65);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
        g.drawLine(0, 0, 0, 65);
        g.setColor(Color.red);
        g.fillRect(0, 0, 20, 15);
        
    }
    
    
    
}
