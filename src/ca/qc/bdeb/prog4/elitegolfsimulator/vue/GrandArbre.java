
package ca.qc.bdeb.prog4.elitegolfsimulator.vue;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JComponent;


public class GrandArbre extends JComponent{
    
    Image imgGrandArbre = Toolkit.getDefaultToolkit().getImage("grandArbre.png");

    public GrandArbre() {
        
        setSize(112, 129);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(imgGrandArbre, 0, 0, this);
    }
    
    
    
    

}
