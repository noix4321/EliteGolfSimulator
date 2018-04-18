/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.qc.bdeb.prog4.elitegolfsimulator.vue;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 *
 * @author 1667686
 */
public class Cube extends JComponent{
    
    
    
    public Cube(){
        
        setSize(80,80);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
        g.setColor(Color.MAGENTA);
        g.fillRect(0, 0, 80, 80);
        
        
    }
    
    
    
}
