
package ca.qc.bdeb.prog4.elitegolfsimulator.vue;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JComponent;


public class Buisson extends JComponent{
    
        Image buisson = Toolkit.getDefaultToolkit().getImage("buisson.png");

    public Buisson() {
        
        setSize(40, 40);
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(buisson, 0, 0, this);
    }

        

}
