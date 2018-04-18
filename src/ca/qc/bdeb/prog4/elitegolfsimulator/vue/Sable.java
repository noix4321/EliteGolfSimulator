
package ca.qc.bdeb.prog4.elitegolfsimulator.vue;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;


public class Sable extends JComponent{

    public Sable() {
        
        setSize(200, 100);
        
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
        g.setColor(new Color(224, 185, 120));
        g.fillOval(0, 0, 200, 100);
        
        g.setColor(new Color(236, 235, 163));
        g.fillOval(10, 10, 150,75);
        
        g.setColor(new Color(224, 185, 120));
        g.fillOval(20, 20, 100, 50);
        
        
    
    
    

    
    
          
}

}